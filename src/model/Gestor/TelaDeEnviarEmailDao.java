package model.Gestor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;
import model.dao.ConexãoBD;

public class TelaDeEnviarEmailDao {
	
	public static  List<Funcionario> inicializatabela() throws SQLException {
		
		  try (
		        	Connection connection = ConexãoBD.Conexao();
		             Statement statement = connection.createStatement()) {
		            String query = "SELECT nome_completo, cpf, data_nasc, telefone, email, cargo, salario FROM funcionario";
		            ResultSet resultSet = statement.executeQuery(query);

		            List<Funcionario> funcionarios = new ArrayList<>();
		            while (resultSet.next()) {
		                Funcionario funcionario = new Funcionario();
		                funcionario.setNomeCompleto(resultSet.getString("nome_completo"));
		                funcionario.setEmail(resultSet.getString("email"));
		                funcionario.setCargo(resultSet.getString("cargo"));
		          



		                funcionarios.add(funcionario);
		            }

		        	statement.close();
		        	connection.close();
		        	return funcionarios;
		  }
		
	}
	
	
	public static  List<Funcionario> PesquisaFuncionario(String pesquisa) throws SQLException {
		
		
		  try (
		         	Connection connection = ConexãoBD.Conexao();
		              Statement statement = connection.createStatement()) {
		             String query = "SELECT nome_completo, cpf, data_nasc, telefone, email, cargo, salario FROM funcionario where nome_completo = '"+
		              pesquisa+"'";
		             
		             ResultSet resultSet = statement.executeQuery(query);

		             List<Funcionario> funcionarios = new ArrayList<>();
		             while (resultSet.next()) {
		                 Funcionario funcionario = new Funcionario();
		                 funcionario.setNomeCompleto(resultSet.getString("nome_completo"));

		                 funcionario.setEmail(resultSet.getString("email"));
		                 funcionario.setCargo(resultSet.getString("cargo"));
		               


		                 funcionarios.add(funcionario);
		             }

		         	statement.close();
		         	connection.close();
		         	
		         	return funcionarios;
		       
		         } catch (SQLException e) {
		             e.printStackTrace();
		             return null;
		         }
		
			
	}
	
	

    public static String obterEmailFuncionarioConectado() throws SQLException {
        try (Connection connection = ConexãoBD.Conexao();
             Statement statement = connection.createStatement()) {

            // Consulta para obter o email do funcionário conectado usando a tabela de sessão
            String query = "SELECT f.EmailDeTrabalho FROM funcionario f " +
                           "JOIN sessao s ON f.id = s.idFuncionario " +
                           "WHERE s.idFuncionario = " + obterIdFuncionarioConectado();
            
            

            ResultSet resultSet = statement.executeQuery(query);

          
            
            if (resultSet.next()) {
                
            	
            	// Retorna o email do funcionário conectado
                return resultSet.getString("EmailDeTrabalho");
                
            }

            statement.close();
            connection.close();
            return null; // Retorna null se nenhum funcionário for encontrado
        }
    }
	
	 public static int obterIdFuncionarioConectado() throws SQLException {
	        try (Connection connection = ConexãoBD.Conexao();
	             Statement statement = connection.createStatement()) {

	            // Consulta para obter o ID do funcionário conectado usando a tabela de sessão
	            String query = "SELECT idFuncionario FROM sessao WHERE id = 1";

	            ResultSet resultSet = statement.executeQuery(query);

	            if (resultSet.next()) {
	                // Retorna o ID do funcionário conectado
	                return resultSet.getInt("idFuncionario");
	            }

	            statement.close();
	            connection.close();
	            return -1; // Retorna -1 se nenhum funcionário for encontrado
	        }
	    }
	
		
	}
	
	
	


