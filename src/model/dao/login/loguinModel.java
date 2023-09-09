package model.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.ConexãoBD;

public class loguinModel {
	
	
	//metodo para verificar se o login do usuario é valido

	public static Boolean ValidaLogin(String email, String senha) throws SQLException {

		Connection conecao = ConexãoBD.Conexao();

		String ComandoSql = "select *from funcionario where email=? and senha=?";

		PreparedStatement stmt = conecao.prepareStatement(ComandoSql);

		stmt.setString(1, email);
		stmt.setString(2, senha);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			String ComandoSql2 = "SELECT id FROM funcionario WHERE email=? AND senha=?";

			PreparedStatement stmt2 = conecao.prepareStatement(ComandoSql2);
			stmt2.setString(1, email);
			stmt2.setString(2, senha);
			ResultSet rs2 = stmt2.executeQuery();

			int idFuncionario = rs.getInt("id");

			String updateSql = "UPDATE sessao SET sessao = ?, idFuncionario = ? WHERE id = 1;";
			PreparedStatement updatePs = conecao.prepareStatement(updateSql);
			updatePs.setInt(1, 1);
			updatePs.setInt(2, idFuncionario);
			int lf = updatePs.executeUpdate();

			updatePs.close();
			stmt.close();
			rs2.close();
			stmt2.close();
			conecao.close();
			return true;

		} else {

			stmt.close();
			conecao.close();

			return false;
		}

	}
	
	//metodo para retornar o cargo do usuario

	public static String getCargo(String email, String senha) throws SQLException {
		Connection conecao = ConexãoBD.Conexao();

		String ComandoSql = "SELECT cargo FROM funcionario WHERE email=? AND senha=?";
		PreparedStatement stmt = conecao.prepareStatement(ComandoSql);

		stmt.setString(1, email);
		stmt.setString(2, senha);

		System.out.println(email);
		System.out.println(senha);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			String cargo = rs.getString("cargo");
			stmt.close();
			conecao.close();
			System.out.println(cargo);
			return cargo;
		} else {
			stmt.close();
			conecao.close();

			return "";
		}
	}

}
