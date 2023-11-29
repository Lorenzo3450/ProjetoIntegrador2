package model.Gestor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.dao.ConexãoBD;

public class TelaDeCadastrarFornecedoDao {
	
	
	 public static void cadastrarFornecedor(String nome, String email, String telefone, String endereco) throws SQLException {
	        try (
	        		Connection connection = ConexãoBD.Conexao();
	             PreparedStatement statement = connection.prepareStatement(
	                     "INSERT INTO fornecedor (nome, email, telefone, endereco) VALUES (?, ?, ?, ?)")
	            		 ) {

	            statement.setString(1, nome);
	            statement.setString(2, email);
	            statement.setString(3, telefone);
	            statement.setString(4, endereco);

	            statement.executeUpdate();
	        }
	    }

}
