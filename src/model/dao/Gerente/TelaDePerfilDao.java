	package model.dao.Gerente;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;
	import model.Endereco;
	import model.Funcionario;
import model.InformacoesDoSuperMercado;
import model.dao.ConexãoBD;

	public class TelaDePerfilDao {

	
	    public static List<Funcionario> getFuncionarioComEndereco(int idFuncionario) {
	        List<Funcionario> funcionarios = new ArrayList<>();
	        
	        try (Connection connection = ConexãoBD.Conexao()) {
	            String query = "SELECT f.nome_completo, f.cpf,f.senha, f.data_nasc, f.telefone, f.email, f.cargo, f.salario,f.EmailDeTrabalho,f.senhaEmail, e.logradouro, e.bairro, e.cep, e.cidade " +
	                           "FROM funcionario f " +
	                           "JOIN endereco e ON f.id = e.id_funci " +
	                           "WHERE f.id = ?";
	            
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, idFuncionario);
	            
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Funcionario funcionario = new Funcionario();
	                funcionario.setNomeCompleto(resultSet.getString("nome_completo"));
	                funcionario.setCpf(resultSet.getString("cpf"));
	                funcionario.setDataNascimento(resultSet.getDate("data_nasc").toLocalDate());
	                funcionario.setTelefone(resultSet.getString("telefone"));
	                funcionario.setEmail(resultSet.getString("email"));
	                funcionario.setCargo(resultSet.getString("cargo"));
	                funcionario.setSalario(resultSet.getDouble("salario"));
	                funcionario.setSenha(resultSet.getString("senha"));
	                funcionario.setEmailDeTrabalho(resultSet.getString("EmailDeTrabalho"));
	                funcionario.setSenhaEmail(resultSet.getString("senhaEmail"));
	                
	                Endereco endereco = new Endereco();
	                endereco.setLogradouro(resultSet.getString("logradouro"));
	                endereco.setBairro(resultSet.getString("bairro"));
	                endereco.setCep(resultSet.getString("cep"));
	                endereco.setCidade(resultSet.getString("cidade"));

	                funcionario.setEndereco(endereco); // Defina um método setEndereco em Funcionario

	                funcionarios.add(funcionario);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return funcionarios;
	    }
	    
	    
	    public static List<InformacoesDoSuperMercado> getSM() {
	        List<InformacoesDoSuperMercado> Spms = new ArrayList<>();
	        
	        try (Connection connection = ConexãoBD.Conexao()) {
	            String query = "SELECT *from informacoesDoSuperMercado";
	            
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	           
	            
	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                InformacoesDoSuperMercado Spm = new InformacoesDoSuperMercado(resultSet.getString("EmailComercial"),resultSet.getString("senha"),resultSet.getString("Nome"));
	               
	                Spms.add(Spm);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return Spms;
	    }
	    
	    
	    
	    
	    
	    public static boolean atualizarFuncionario(Funcionario funcionario,InformacoesDoSuperMercado informacoesDoSuperMercado) {
	        try (Connection connection = ConexãoBD.Conexao()) {
	            // Atualize as informações do funcionário na tabela funcionario
	            String updateQuery = "UPDATE funcionario SET nome_completo=?, cpf=?, senha=?, data_nasc=?, telefone=?, email=?, cargo=?, "
	            		+ "salario=?,EmailDeTrabalho=?,senhaEmail=? WHERE id=?";
	            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	            updateStatement.setString(1, funcionario.getNomeCompleto());
	            updateStatement.setString(2, funcionario.getCpf());
	            updateStatement.setString(3, funcionario.getSenha());
	            updateStatement.setDate(4, java.sql.Date.valueOf(funcionario.getDataNascimento()));
	            updateStatement.setString(5, funcionario.getTelefone());
	            updateStatement.setString(6, funcionario.getEmail());
	            updateStatement.setString(7, funcionario.getCargo());
	            updateStatement.setDouble(8, funcionario.getSalario());
	            updateStatement.setString(9, funcionario.getEmailDeTrabalho());
	            updateStatement.setString(10, funcionario.getSenhaEmail());
	            updateStatement.setInt(11, funcionario.getId()); // Certifique-se de ter um método getId() em Funcionario

	            int rowsUpdated = updateStatement.executeUpdate();

	            if (rowsUpdated > 0) {
	                // Atualize as informações do endereço na tabela endereco
	                String updateEnderecoQuery = "UPDATE endereco SET logradouro=?, bairro=?, cep=?, cidade=? WHERE id_funci=?";
	                PreparedStatement updateEnderecoStatement = connection.prepareStatement(updateEnderecoQuery);
	                updateEnderecoStatement.setString(1, funcionario.getEndereco().getLogradouro());
	                updateEnderecoStatement.setString(2, funcionario.getEndereco().getBairro());
	                updateEnderecoStatement.setString(3, funcionario.getEndereco().getCep());
	                updateEnderecoStatement.setString(4, funcionario.getEndereco().getCidade());
	                updateEnderecoStatement.setInt(5, funcionario.getId());
	                
	                String InformacoesMercado = "UPDATE informacoesDoSuperMercado SET Nome=?, EmailComercial=?, senha=? WHERE id=1";
	                PreparedStatement updateMercadoStatement = connection.prepareStatement(InformacoesMercado);
	                updateMercadoStatement.setString(1, informacoesDoSuperMercado.getNome());
	                updateMercadoStatement.setString(2, informacoesDoSuperMercado.getEmail());
	                updateMercadoStatement.setString(3, informacoesDoSuperMercado.getSenha());
	                
	                
	                int enderecoRowsUpdated = updateEnderecoStatement.executeUpdate();
	                int MercadoRowsUpdated = updateMercadoStatement.executeUpdate();
	                System.out.println(enderecoRowsUpdated > 0 );
	                return enderecoRowsUpdated > 0 && MercadoRowsUpdated > 0;
	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    

	    public static boolean atualizarPadrao(Funcionario funcionario) {
	        try (Connection connection = ConexãoBD.Conexao()) {
	            // Atualize as informações do funcionário na tabela funcionario
	            String updateQuery = "UPDATE funcionario SET nome_completo=?, cpf=?, senha=?, data_nasc=?, telefone=?, email=?, cargo=?, "
	            		+ "salario=?,EmailDeTrabalho=?,senhaEmail=? WHERE id=?";
	            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	            updateStatement.setString(1, funcionario.getNomeCompleto());
	            updateStatement.setString(2, funcionario.getCpf());
	            updateStatement.setString(3, funcionario.getSenha());
	            updateStatement.setDate(4, java.sql.Date.valueOf(funcionario.getDataNascimento()));
	            updateStatement.setString(5, funcionario.getTelefone());
	            updateStatement.setString(6, funcionario.getEmail());
	            updateStatement.setString(7, funcionario.getCargo());
	            updateStatement.setDouble(8, funcionario.getSalario());
	            updateStatement.setString(9, funcionario.getEmailDeTrabalho());
	            updateStatement.setString(10, funcionario.getSenhaEmail());
	            updateStatement.setInt(11, funcionario.getId()); // Certifique-se de ter um método getId() em Funcionario

	            int rowsUpdated = updateStatement.executeUpdate();

	            if (rowsUpdated > 0) {
	                // Atualize as informações do endereço na tabela endereco
	                String updateEnderecoQuery = "UPDATE endereco SET logradouro=?, bairro=?, cep=?, cidade=? WHERE id_funci=?";
	                PreparedStatement updateEnderecoStatement = connection.prepareStatement(updateEnderecoQuery);
	                updateEnderecoStatement.setString(1, funcionario.getEndereco().getLogradouro());
	                updateEnderecoStatement.setString(2, funcionario.getEndereco().getBairro());
	                updateEnderecoStatement.setString(3, funcionario.getEndereco().getCep());
	                updateEnderecoStatement.setString(4, funcionario.getEndereco().getCidade());
	                updateEnderecoStatement.setInt(5, funcionario.getId());
	                
	            
	                
	                
	                int enderecoRowsUpdated = updateEnderecoStatement.executeUpdate();
	           
	                System.out.println(enderecoRowsUpdated > 0 );
	                return enderecoRowsUpdated > 0;
	               
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    
	    
	  
	}
	
	

