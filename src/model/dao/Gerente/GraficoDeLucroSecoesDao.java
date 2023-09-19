package model.dao.Gerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LucroMensal;
import model.Secao; // Certifique-se de importar a classe secao corretamente


public class GraficoDeLucroSecoesDao {

	  private Connection conexao;

	    public GraficoDeLucroSecoesDao(Connection conexao) {
	        this.conexao = conexao;
	    }

	    // Método para obter os dados das secoes para o gráfico de pizza
	    public List<Secao> obterDadosSecoesParaGrafico() throws SQLException {
	        List<Secao> dadosSecoes = new ArrayList<>();

	        String query = "SELECT nome_secao, lucro FROM secoes";

	        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
	            ResultSet resultSet = stmt.executeQuery();

	            while (resultSet.next()) {
	                String nomeSecao = resultSet.getString("nome_secao");
	                double lucro = resultSet.getDouble("lucro");
	                Secao secao = new Secao(nomeSecao, lucro);
	                dadosSecoes.add(secao);
	            }
	        }

	        return dadosSecoes;
	    }
	
}
