package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class ConexãoBD {

	//classe de conexão com o Banco de Dados
	
	
	public static Connection Conexao() throws SQLException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
				
			return DriverManager.getConnection("jdbc:mysql://localhost/projetopi","root","ga01briel02");
			
		
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new SQLException(e.getException());
			
		}
	}

}
