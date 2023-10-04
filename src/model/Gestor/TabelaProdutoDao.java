package model.Gestor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import model.dao.ConexãoBD;
import controller.Ferramentas.EditButtonCell;


public class TabelaProdutoDao {

    public static List<Produto> inicializarTabela() throws SQLException {
        try (Connection connection = ConexãoBD.Conexao();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM produtos");
             ResultSet resultSet = statement.executeQuery()) {

            List<Produto> produtos = new ArrayList<>();
            while (resultSet.next()) {
            	Produto produto = new Produto("", LocalDate.now(), 0, 0.0, 0.0, "", "", 0, 0, 0.0,0);
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setDataCompra(resultSet.getDate("data_compra"));
                produto.setValidade(resultSet.getDate("validade"));
                produto.setQuantidade(resultSet.getInt("quantidade"));
                produto.setValorCompradoUnidade(resultSet.getFloat("valor_comprado_unidade"));
                produto.setValorVendidoUnidade(resultSet.getFloat("valor_vendido_unidade"));
                produto.setMarcaProduto(resultSet.getString("marca_produto"));
                produto.setCodigoProduto(resultSet.getString("codigo_produto"));
                produto.setIdFornecedor(resultSet.getInt("id_fornecedor"));
                produto.setIdSecao(resultSet.getInt("id_secao"));
                produto.setQuantidadeVendida(resultSet.getInt("quantidade_vendida"));
                produto.setEstoqueMinimo(resultSet.getInt("Estoque_Minimo"));

                produtos.add(produto);
            }

            return produtos;
        }
    }

    public static List<Produto> pesquisarProduto(String pesquisa) throws SQLException {
        try (Connection connection = ConexãoBD.Conexao();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT * FROM produtos WHERE descricao LIKE ?")) {

            statement.setString(1, "%" + pesquisa + "%");
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Produto> produtos = new ArrayList<>();
                while (resultSet.next()) {
                	Produto produto = new Produto("", LocalDate.now(), 0, 0.0, 0.0, "", "", 0, 0, 0.0,0);
                    produto.setDescricao(resultSet.getString("descricao"));
                    produto.setDataCompra(resultSet.getDate("data_compra"));
                    produto.setValidade(resultSet.getDate("validade"));
                    produto.setQuantidade(resultSet.getInt("quantidade"));
                    produto.setValorCompradoUnidade(resultSet.getFloat("valor_comprado_unidade"));
                    produto.setValorVendidoUnidade(resultSet.getFloat("valor_vendido_unidade"));
                    produto.setMarcaProduto(resultSet.getString("marca_produto"));
                    produto.setCodigoProduto(resultSet.getString("codigo_produto"));
                    produto.setIdFornecedor(resultSet.getInt("id_fornecedor"));
                    produto.setIdSecao(resultSet.getInt("id_secao"));
                    produto.setQuantidadeVendida(resultSet.getInt("quantidade_vendida"));
                    produto.setEstoqueMinimo(resultSet.getInt("Estoque_Minimo"));

                    produtos.add(produto);
                }

                return produtos;
            }
        }
    }

    // Outros métodos (como aplicarFiltro, inserirProduto, atualizarProduto, etc.) podem ser adicionados aqui conforme necessário.
}
