package model.dao.Caixa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Produto2;
import model.dao.ConexãoBD;

public class PagamentoDao {

	
	public static void FinalizaCompra(List<Produto2> produtos) throws SQLException {
	    Connection connection = ConexãoBD.Conexao();
	    String query = "SELECT * FROM produtos WHERE codigo_produto = ?";
	    
	    for (Produto2 produto : produtos) {
	        try (PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, produto.getCodigo());

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                	
	                	String updateQuery = "UPDATE produtos SET quantidade = quantidade - ? WHERE codigo_produto = ?";
	                    String insertLucroQuery = "INSERT INTO detalhes_relatorio_de_lucros (nome_produto, quantidade_adquirida, quantidade_vendida, valor_comprado_unidade, valor_vendido_unidade) VALUES ( ?, ?, ?, ?, ?)";

	                    try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	                         PreparedStatement insertLucroStatement = connection.prepareStatement(insertLucroQuery)) {
	                    
	                    	updateStatement.setInt(1,1);
	                        updateStatement.setString(2, resultSet.getString("codigo_produto"));
	                        updateStatement.executeUpdate();

	                        // Registrar o lucro na tabela de detalhes_relatorio_de_lucros
	                          // ID do relatório (assumindo 1 por enquanto)
	                        insertLucroStatement.setString(1, resultSet.getString("descricao"));
	                        insertLucroStatement.setInt(2,resultSet.getInt("quantidade"));
	                        insertLucroStatement.setInt(3, resultSet.getInt("quantidade_vendida"));
	                        insertLucroStatement.setDouble(4, resultSet.getDouble("valor_comprado_unidade"));
	                        insertLucroStatement.setDouble(5, resultSet.getDouble("valor_vendido_unidade"));
	                        insertLucroStatement.executeUpdate();
	                    		
	                    
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
}
