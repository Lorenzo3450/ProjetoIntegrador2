package model.Gestor;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import model.dao.ConexãoBD;

public class TelaDeCadastrarProdutoDao {

	public void cadastraProduto(String codigoDeBarras, String dataCompraFormatada, String descricao,
	        String precoUnidade, String quantidadeTotal, String validade, String vendidoUnidade, String Estoque_Minimo) throws SQLException {

	    // Conexão com o banco de dados
	    Connection conexão = ConexãoBD.Conexao();

	    // Comando SQL para inserir um novo produto
	    String comandoSQL = "INSERT INTO produtos (codigo_produto, data_compra, descricao, valor_comprado_unidade, quantidade, validade, valor_vendido_unidade, Estoque_Minimo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	    PreparedStatement stmt = conexão.prepareStatement(comandoSQL);

	    // Define os valores dos parâmetros
	    stmt.setString(1, codigoDeBarras);
	    stmt.setString(2, dataCompraFormatada);
	    stmt.setString(3, descricao);
	    stmt.setFloat(4, Float.parseFloat(precoUnidade));
	    stmt.setInt(5, Integer.parseInt(quantidadeTotal));
	    stmt.setString(6, validade);
	    stmt.setFloat(7, Float.parseFloat(vendidoUnidade));
	    stmt.setInt(8, Integer.parseInt(Estoque_Minimo));

	    // Executa o comando SQL
	    stmt.execute();

	    // Fecha a conexão e o statement
	    stmt.close();
	    conexão.close();
	}

}
