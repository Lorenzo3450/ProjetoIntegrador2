package model.dao.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.Ferramentas.TrocaData;
import controller.login.TelaDeCadastroController;
import model.dao.ConexãoBD;

public class CadastroModel {
	
	public static void RealizaCadastro(String nome,String CPF,String DataNascimento,String Telefone,
			String email, String senha, String longradouro, String Bairro, String Cep, 
			String Cidade, String plv1, String plv2, String plv3) throws SQLException {
		
		//cadastro no banco de dados os dados;
		
		Connection conecao = ConexãoBD.Conexao();
		
		String ComandoSql1 = " insert into funcionario (nome_completo,cpf,data_nasc,"
				+ "telefone, email, senha,cargo) values (?, ?, ?, ?, ?, ?,?)";
		
		String ComandoSql2 = "insert into endereco(logradouro,bairro,cep,cidade) values (?, ?, ?, ?)";
		
		String ComandoSql3 = "insert into perguntas(nome_meio_mae,primeira_escola,apelido_infancia) values (? , ?, ?)";
		
		
		
		PreparedStatement stmt1 = conecao.prepareStatement(ComandoSql1);
		PreparedStatement stmt2 = conecao.prepareStatement(ComandoSql2);
		PreparedStatement stmt3 = conecao.prepareStatement(ComandoSql3);
		
		stmt1.setString(1, nome);
		stmt1.setString(2, CPF);
		stmt1.setString(3, TrocaData.trocaData(DataNascimento));
		stmt1.setString(4,Telefone);
		stmt1.setString(5, email);
		stmt1.setString(6, senha);
		stmt1.setString(7, "Não definido");
	
		
		stmt2.setString(1, longradouro);
		stmt2.setString(2, Bairro);
		stmt2.setString(3, Cep);
		stmt2.setString(4, Cidade);
		
		stmt3.setNString(1, plv1);
		stmt3.setNString(2, plv2);
		stmt3.setNString(3, plv3);

		stmt1.execute();
		stmt2.execute();
		stmt3.execute();
		
		stmt1.close();
		stmt2.close();
		stmt3.close();
		conecao.close();
		
		
	}
	
	

}
