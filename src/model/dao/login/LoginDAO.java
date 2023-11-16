package model.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginModel;
import model.dao.ConexãoBD;

public class LoginDAO {
	private static Connection conex;

	public LoginDAO(Connection conex) {
		LoginDAO.conex = conex;

	}

	//metodo para verificar se o login do usuario é valido

	public Boolean ValidaLogin(String email, String senha) throws SQLException {

		conex = ConexãoBD.Conexao();

		String ComandoSql = "select *from funcionario where email=? and senha=?";

		PreparedStatement stmt = conex.prepareStatement(ComandoSql);

		stmt.setString(1, email);
		stmt.setString(2, senha);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			String ComandoSql2 = "SELECT id FROM funcionario WHERE email=? AND senha=?";
			String ComandoSql3 = "SELECT idFuncionario FROM sessao WHERE id=1";
			
			
			PreparedStatement stmt2 = conex.prepareStatement(ComandoSql2);
			PreparedStatement stmt3 = conex.prepareStatement(ComandoSql3);
			stmt2.setString(1, email);
			stmt2.setString(2, senha);
			ResultSet rs2 = stmt2.executeQuery();
			ResultSet rs3 = stmt3.executeQuery();

			int idFuncionario = rs.getInt("id");

			String updateSql = "UPDATE sessao SET sessao = ?, idFuncionario = ? WHERE id = 1;";
			PreparedStatement updatePs = conex.prepareStatement(updateSql);
			updatePs.setInt(1, 1);
			updatePs.setInt(2, idFuncionario);
			int lf = updatePs.executeUpdate();

			updatePs.close();
			stmt.close();
			rs2.close();
			stmt2.close();
			conex.close();
			return true;

		} else {

			stmt.close();
			conex.close();

			return false;
		}

	}
	
	
	
	//metodo para retornar o cargo do usuario

	public  String getCargo(String email, String senha) throws SQLException {
		conex = ConexãoBD.Conexao();

		String ComandoSql = "SELECT cargo FROM funcionario WHERE email=? AND senha=?";
		PreparedStatement stmt = conex.prepareStatement(ComandoSql);

		stmt.setString(1, email);
		stmt.setString(2, senha);

		System.out.println(email);
		System.out.println(senha);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			String cargo = rs.getString("cargo");
			stmt.close();
			conex.close();
			System.out.println(cargo);
			return cargo;
		} else {
			stmt.close();
			conex.close();

			return "";
		}
	}
	
	
	public boolean fazerLogin(LoginModel lm) {

		try {
			conex = new ConexãoBD().Conexao();
			String sql = "SELECT * FROM funcionario WHERE (nome_completo=? or email=?) AND senha=?";
			PreparedStatement ps = conex.prepareStatement(sql);
			
			ps.setString(1, lm.getNomeEmail());
			ps.setString(2, lm.getNomeEmail());
			ps.setString(3, lm.getSenha());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			    // Um registro correspondente foi encontrado, login bem-sucedido
			    rs.close();
			    ps.close();
			    conex.close();
			    return true;
			} else {
			    // Nenhum registro correspondente encontrado, login falhou
			    rs.close();
			    ps.close();
			    conex.close();
			    return false;
			}

		} catch (SQLException e) {
			e.getStackTrace();
			}
		return true;

		
	}
	public int obterIdFuncionario(String nomeEmail, String senha) {
	    try {
			conex = new ConexãoBD().Conexao();
	        String sql = "SELECT id FROM funcionario WHERE (nome_completo = ? OR email = ?) AND senha = ?";
	        PreparedStatement ps = conex.prepareStatement(sql);
	        ps.setString(1, nomeEmail);
	        ps.setString(2, nomeEmail);
	        ps.setString(3, senha);

	        ResultSet rs = ps.executeQuery();

	        int idFuncionario = -1; // Valor padrão se não for encontrado nenhum funcionário

	        if (rs.next()) {
	            idFuncionario = rs.getInt("id");
	        }

	        rs.close();
	        ps.close();

	        return idFuncionario;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return -1; // Retorne -1 em caso de erro ou se não for encontrado nenhum funcionário
	    }
	}

}
