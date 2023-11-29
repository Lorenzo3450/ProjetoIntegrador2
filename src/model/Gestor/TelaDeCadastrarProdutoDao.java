package model.Gestor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Fornecedor;
import model.Produto;
import model.Produto2;
import model.dao.ConexãoBD;

public class TelaDeCadastrarProdutoDao {

	   public static void cadastrarProduto(
	            String descricao, 
	            String dataCompra, 
	            String validade, 
	            int quantidade, 
	            float valorCompradoUnidade, 
	            float valorVendidoUnidade, 
	            String marcaProduto, 
	            String codigoProduto, 
	            int idFornecedor, 
	            int idSecao,  
	            int estoqueMinimo,
	            int quantidadeDaCompra) throws SQLException {

	        try (
	            Connection connection = ConexãoBD.Conexao();
	            PreparedStatement statement = connection.prepareStatement(
	                    "INSERT INTO produtos (descricao, data_compra, validade, quantidade, valor_comprado_unidade, " +
	                    "valor_vendido_unidade, marca_produto, codigo_produto, id_fornecedor, id_secao, " +
	                    "Estoque_Minimo, quantidade_da_compra) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
	        ) {
	            // Inverter as datas antes de salvar no banco de dados
	            statement.setString(1, descricao);
	            statement.setString(2, inverterData(inverterData(dataCompra)));
	            statement.setString(3, inverterData(inverterData(validade)));
	            statement.setInt(4, quantidade);
	            statement.setFloat(5, valorCompradoUnidade);
	            statement.setFloat(6, valorVendidoUnidade);
	            statement.setString(7, marcaProduto);
	            statement.setString(8, codigoProduto);
	            statement.setInt(9, idFornecedor);
	            statement.setInt(10, idSecao);
	            statement.setInt(11, estoqueMinimo);
	            statement.setInt(12, quantidadeDaCompra);

	            statement.executeUpdate();
	        }
	    }

	    private static String inverterData(String data) {
	        try {
	            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
	            SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");
	            Date date = formatoEntrada.parse(data);
	            return formatoSaida.format(date);
	        } catch (ParseException e) {
	            // Lidar com exceção de análise de data
	            e.printStackTrace();
	            return null;
	        }
	    }
	    

	  
	    
	    public static List<Produto2> obterProdutosAbaixoEstoqueMinimo() throws SQLException {
	        List<Produto2> produtosAbaixoEstoqueMinimo = new ArrayList<>();

	        try (
	            Connection connection = ConexãoBD.Conexao();
	            PreparedStatement statement = connection.prepareStatement(
	                    "SELECT * FROM produtos WHERE quantidade < Estoque_Minimo")
	        ) {
	            try (ResultSet resultSet = statement.executeQuery()) {
	                while (resultSet.next()) {
	                    Produto2 produto = new Produto2();
	                    produto.setDescricao(resultSet.getString("descricao"));
	                    produto.setDataCompra(resultSet.getString("data_compra"));
	                    produto.setValidade(inverterData(resultSet.getString("validade")));
	                    produto.setQuantidade(resultSet.getInt("quantidade"));
	                    produto.setValorCompradoUnidade(resultSet.getFloat("valor_comprado_unidade"));
	                    produto.setValorUnidade(resultSet.getDouble("valor_vendido_unidade"));
	                    produto.setMarcaProduto(resultSet.getString("marca_produto"));
	                    produto.setCodigo(resultSet.getString("codigo_produto"));
	                    produto.setIdFornecedor(resultSet.getInt("id_fornecedor"));
	                    produto.setIdSecao(resultSet.getInt("id_secao"));
	                    produto.setEstoqueMinimo(resultSet.getInt("Estoque_Minimo"));
	                    produto.setQuatidadeComprautomatica(resultSet.getInt("quantidade_da_compra"));

	                    produtosAbaixoEstoqueMinimo.add(produto);
	                }
	            }
	        }

	        return produtosAbaixoEstoqueMinimo;
	    }
	    	
	    
	    public static List<Fornecedor> obterFornecedoresPorProdutos(List<Produto2> produtos) throws SQLException {
	        List<Fornecedor> fornecedores = new ArrayList<>();

	        try (Connection connection = ConexãoBD.Conexao()) {
	            for (Produto2 produto : produtos) {
	                try (PreparedStatement statement = connection.prepareStatement(
	                    "SELECT * FROM fornecedor WHERE id = ?")
	                ) {
	                    statement.setInt(1, produto.getIdFornecedor());

	                    try (ResultSet resultSet = statement.executeQuery()) {
	                        if (resultSet.next()) {
	                            Fornecedor fornecedor = new Fornecedor();
	                            fornecedor.setId(resultSet.getInt("id"));
	                            fornecedor.setNome(resultSet.getString("nome"));
	                            fornecedor.setEmail(resultSet.getString("email"));
	                            fornecedor.setTelefone(resultSet.getString("telefone"));
	                            fornecedor.setEndereco(resultSet.getString("endereco"));

	                            fornecedores.add(fornecedor);
	                        }
	                    }
	                }
	            }
	        }

	        return fornecedores;
	    }


	    

	    

}



