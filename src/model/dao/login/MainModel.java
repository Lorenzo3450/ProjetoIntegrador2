package model.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.ConexãoBD;

public class MainModel {

	public static boolean VerificaSessao() throws SQLException {

		Connection conecao = ConexãoBD.Conexao();

		String ComandoSql = "select *from sessao where id=1 and sessao=1";

		PreparedStatement stmt = conecao.prepareStatement(ComandoSql);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {

			return true;

		} else {

			return false;

		}

	}

	public static String verificaCargo() throws SQLException {

		Connection conecao = ConexãoBD.Conexao();

	    String ComandoSql = "SELECT idFuncionario FROM sessao where id=1 and sessao=1";
	    PreparedStatement stmt = conecao.prepareStatement(ComandoSql);

	    ResultSet rs = stmt.executeQuery();

	    int id = 0;

	    if (rs.next()) {
	        id = rs.getInt("idFuncionario");
	    } else {
	        stmt.close();
	        conecao.close();
	        return "";
	    }

	    String ComandoSql2 = "SELECT cargo FROM funcionario WHERE id=?";
	    PreparedStatement stmt2 = conecao.prepareStatement(ComandoSql2);
	    stmt2.setInt(1, id);

	    ResultSet rs2 = stmt2.executeQuery();

	    if (rs2.next()) {
	        String cargo = rs2.getString("cargo");
	        stmt2.close();
	        conecao.close();

	        System.out.println(cargo);

	        return cargo;
	    } else {
	        stmt2.close();
	        conecao.close();

	        return "";
	    }
	    
	    
	    
	    
	}
	
	public static int verificaID() throws SQLException {

		Connection conecao = ConexãoBD.Conexao();

	    String ComandoSql = "SELECT idFuncionario FROM sessao where id=1 and sessao=1";
	    PreparedStatement stmt = conecao.prepareStatement(ComandoSql);

	    ResultSet rs = stmt.executeQuery();

	    int id = 0;

	    if (rs.next()) {
	        id = rs.getInt("idFuncionario");
	        return id;
	    } else {
	        stmt.close();
	        conecao.close();
	        return 0;
	    }
	    
	    

	  
	}	
	
}
