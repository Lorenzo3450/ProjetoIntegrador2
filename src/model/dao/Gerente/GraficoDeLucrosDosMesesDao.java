package model.dao.Gerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.LucroMensal;
import model.Produto;

public class GraficoDeLucrosDosMesesDao {

    private Connection conexao;

	public GraficoDeLucrosDosMesesDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	 
	

    public List<LucroMensal> obterLucrosMensaisDoBanco(int ano) throws SQLException {
        List<LucroMensal> lucrosMensais = new ArrayList<>();

        String query = "SELECT MesDoAno, LucroDoMes FROM lucros_meses_do_ano WHERE Ano = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, ano);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                String mes = resultSet.getString("MesDoAno");
                double lucro = resultSet.getDouble("LucroDoMes");
                LucroMensal lucroMensal = new LucroMensal(mes, ano, lucro);
                lucrosMensais.add(lucroMensal);
            }
        }

        return lucrosMensais;
    }
}
