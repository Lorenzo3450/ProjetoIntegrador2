package model.dao.Gerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DesignSistema;
import model.dao.ConexãoBD;

public class PersonalizaSistemaDao {

    public static DesignSistema buscaDesign() throws SQLException {
        Connection connection = ConexãoBD.Conexao();

        // Consulta SQL para buscar os dados da tabela DesignSistema
        String sql = "SELECT cor_principal, cor_secundaria, fundo_imagem, cor_terciaria, tipo_fonte, logo_imagem FROM DesignSistema";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String corPrincipal = resultSet.getString("cor_principal");
                String corSecundaria = resultSet.getString("cor_secundaria");
                String fundoImagem = resultSet.getString("fundo_imagem");
                String corTerciaria = resultSet.getString("cor_terciaria");
             
                String tipoFonte = resultSet.getString("tipo_fonte");
                String logoImagem = resultSet.getString("logo_imagem");

                return new DesignSistema(corPrincipal, corSecundaria, fundoImagem, corTerciaria, tipoFonte, logoImagem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Você pode tratar erros de consulta aqui
        }

        return null;
    }
    
    public static void atualizaDesign(DesignSistema design) throws SQLException {
        Connection connection = ConexãoBD.Conexao();

        // Consulta SQL para atualizar os dados na tabela DesignSistema
        String sqlUpdate = "UPDATE DesignSistema SET cor_principal = ?, cor_secundaria = ?, fundo_imagem = ?, cor_terciaria = ?, tipo_fonte = ?, logo_imagem = ?";

        // Consulta SQL para inserir dados iniciais se a tabela estiver vazia
        String sqlInsert = "INSERT INTO DesignSistema (cor_principal, cor_secundaria, fundo_imagem, cor_terciaria,  tipo_fonte, logo_imagem) " +
        		"VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate);
             PreparedStatement insertStatement = connection.prepareStatement(sqlInsert)) {
            updateStatement.setString(1, design.getCorPrincipal());
            updateStatement.setString(2, design.getCorSecundaria());
            updateStatement.setString(3, design.getFundoImagem());
            updateStatement.setString(4, design.getCorTerciaria());
          
            updateStatement.setString(5, design.getTipoFonte());
            updateStatement.setString(6, design.getLogoImagem());

            // Tente executar a atualização
            int rowsUpdated = updateStatement.executeUpdate();

            if (rowsUpdated == 0) {
                // Se a atualização não afetou nenhuma linha, a tabela está vazia, então insira os dados iniciais
                insertStatement.setString(1, design.getCorPrincipal());
                insertStatement.setString(2, design.getCorSecundaria());
                insertStatement.setString(3, design.getFundoImagem());
                insertStatement.setString(4, design.getCorTerciaria());
                
                insertStatement.setString(5, design.getTipoFonte());
                insertStatement.setString(6, design.getLogoImagem());
                insertStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Você pode tratar erros de atualização/inserção aqui
        }
    }

    
}
