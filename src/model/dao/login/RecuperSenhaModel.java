package model.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.dao.ConexãoBD;

public class RecuperSenhaModel {

	public static void AlteraSenha(String senha, String plv1,String plv2,String plv3) throws SQLException {
	
	  	Connection conecao = ConexãoBD.Conexao();
		
    	String selectSql = "SELECT id_senha FROM perguntas WHERE nome_meio_mae = ? AND primeira_escola = ? AND apelido_infancia = ?";
        PreparedStatement selectPs = conecao.prepareStatement(selectSql);
        selectPs.setString(1,plv1 );
        selectPs.setString(2, plv2);
        selectPs.setString(3,plv3);

        ResultSet resultSet = selectPs.executeQuery();

        if (resultSet.next()) {
        
            int idSenha = resultSet.getInt("id_senha");
            String updateSql = "UPDATE funcionario SET senha = ? WHERE id = ?";
            PreparedStatement updatePs = conecao.prepareStatement(updateSql);
            updatePs.setString(1,senha );
            updatePs.setInt(2, idSenha);

            int lf = updatePs.executeUpdate();
            if (lf > 0) {
                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Senha não alterada");
            }

            updatePs.close();
        } else {
            JOptionPane.showMessageDialog(null, "As respostas não correspondem ou ocorreu um erro");
        }

        selectPs.close();
        conecao.close();
        	
		
		
	}
	
	
}
