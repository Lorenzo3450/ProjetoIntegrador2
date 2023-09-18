package model.dao.Gerente;

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

public class TabelaFuncionarioDao {

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
		                funcionario.setCpf(resultSet.getString("cpf"));
		                funcionario.setDataNascimento(resultSet.getDate("data_nasc").toLocalDate());
		                funcionario.setTelefone(resultSet.getString("telefone"));
		                funcionario.setEmail(resultSet.getString("email"));
		                funcionario.setCargo(resultSet.getString("cargo"));
		                funcionario.setSalario(resultSet.getDouble("salario"));

		                // Calcular idade com base na data de nascimento
		                int idade = Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();
		                funcionario.setIdade(idade);

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
		                 funcionario.setCpf(resultSet.getString("cpf"));
		                 funcionario.setDataNascimento(resultSet.getDate("data_nasc").toLocalDate());
		                 funcionario.setTelefone(resultSet.getString("telefone"));
		                 funcionario.setEmail(resultSet.getString("email"));
		                 funcionario.setCargo(resultSet.getString("cargo"));
		                 funcionario.setSalario(resultSet.getDouble("salario"));

		                 // Calcular idade com base na data de nascimento
		                 int idade = Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();
		                 funcionario.setIdade(idade);

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
	
	
	public static  List<Funcionario> aplicarFiltro(String comando) throws SQLException {
		
		 try (
		        	Connection connection = ConexãoBD.Conexao();
		             Statement statement = connection.createStatement()) {
		            String query = "SELECT nome_completo, cpf, data_nasc, telefone, email, cargo, salario FROM funcionario where "+comando;
		            ResultSet resultSet = statement.executeQuery(query);

		            List<Funcionario> funcionarios = new ArrayList<>();
		            while (resultSet.next()) {
		                Funcionario funcionario = new Funcionario();
		                funcionario.setNomeCompleto(resultSet.getString("nome_completo"));
		                funcionario.setCpf(resultSet.getString("cpf"));
		                funcionario.setDataNascimento(resultSet.getDate("data_nasc").toLocalDate());
		                funcionario.setTelefone(resultSet.getString("telefone"));
		                funcionario.setEmail(resultSet.getString("email"));
		                funcionario.setCargo(resultSet.getString("cargo"));
		                funcionario.setSalario(resultSet.getDouble("salario"));

		                // Calcular idade com base na data de nascimento
		                int idade = Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();
		                funcionario.setIdade(idade);

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
	
	
	
	
	
	
	
}
