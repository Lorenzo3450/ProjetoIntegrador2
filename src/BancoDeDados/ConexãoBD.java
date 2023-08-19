package BancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

public class ConexãoBD {

	//classe de conexão com o Banco de Dados
	
	
	public static Connection Conexao() throws SQLException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
				
			return DriverManager.getConnection("jdbc:mysql://localhost/projetopi","root","12343050lo");
			
		
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new SQLException(e.getException());
			
		}
	}

}
