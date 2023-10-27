package model.dao.Caixa;

import model.Produto;
import model.Produto2;
import model.dao.ConexãoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaDeVendaDao {

    public static Produto2 getProdutoByCodigoDeBarras(String codigoDeBarras) throws SQLException {
    	Connection connection = ConexãoBD.Conexao();
        String query = "SELECT * FROM produtos WHERE codigo_produto = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, codigoDeBarras);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Recupere os dados do produto do ResultSet
                    String descricao = resultSet.getString("descricao");
                    Double valorUnidade = resultSet.getDouble("valor_vendido_unidade");
                    // Outros campos...
                    
                    // Crie uma instância do Produto com os dados recuperados
                    Produto2 produto = new Produto2(descricao, valorUnidade,codigoDeBarras);
                    
                    return produto;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
}
