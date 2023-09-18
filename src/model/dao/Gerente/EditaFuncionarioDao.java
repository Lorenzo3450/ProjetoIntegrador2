package model.dao.Gerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.dao.ConexãoBD;

public class EditaFuncionarioDao {
	
	
	public static boolean AlterarDados(String cpf ,String Campo,String NovoValor) throws SQLException {
		
		Connection connection = ConexãoBD.Conexao();
		
		try {
	        
	        String sql = "UPDATE funcionario SET " + Campo + " = ? WHERE cpf = ?";
	        
	       
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        
	       
	        preparedStatement.setString(1, NovoValor);
	        preparedStatement.setString(2, cpf);
	        
	       
	        int rowsAfetadas = preparedStatement.executeUpdate();
	        
	       
	        if (rowsAfetadas > 0) {
	        	 JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso !");
	            return true; 
	           
	            
	        } else {
	            JOptionPane.showMessageDialog(null, "Ops ocorreu algum problema veja se digitou as informações corretamente");

	            return false; 
	            
	     
	            
	        }
	    } finally {
	       
	        if (connection != null) {
	            connection.close();
	        }
	    }
	}
		
		
		
		
	}
	
	
	


