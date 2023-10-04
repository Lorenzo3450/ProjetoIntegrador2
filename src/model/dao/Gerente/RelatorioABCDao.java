package model.dao.Gerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import model.dao.ConexãoBD;

public class RelatorioABCDao {
    private Connection conexao;

    public RelatorioABCDao(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Produto> obterProdutosDoBanco() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String query = "SELECT descricao, validade, quantidade, valor_comprado_unidade, valor_vendido_unidade, marca_produto, codigo_produto, quantidade_vendida FROM produtos"; // Substitua com sua consulta SQL

        try (PreparedStatement stmt = conexao.prepareStatement(query);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                String descricao = resultSet.getString("descricao");
                LocalDate validade = resultSet.getDate("validade").toLocalDate();
                int quantidade = resultSet.getInt("quantidade");
                double valorCompraUnidade = resultSet.getDouble("valor_comprado_unidade");
                double valorVendaUnidade = resultSet.getDouble("valor_vendido_unidade");
                String marca = resultSet.getString("marca_produto");
                String codigo = resultSet.getString("codigo_produto");
                int quantidadeVendida = resultSet.getInt("quantidade_vendida");

                double faturamento = valorVendaUnidade * quantidadeVendida;

                Produto produto = new Produto(descricao, validade, quantidade, valorCompraUnidade, valorVendaUnidade, marca, codigo, 0, quantidadeVendida, faturamento,0);
                
                produtos.add(produto);
            }
        }

        return produtos;
    }

    // Outros métodos do DAO
}