	package model.dao.Gerente;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;
import model.Funcionario;
import model.PerfilGeralModel;
import model.dao.ConexãoBD;

	public class TelaDePerfilDao {

	
	    private Connection conex;
		private PerfilGeralModel pgm;


		public TelaDePerfilDao(Connection conex, PerfilGeralModel pgm  ) {
	        this.conex = conex;
	        this.pgm =new PerfilGeralModel();
	    }
	  
		
		
	    public static List<Funcionario> getFuncionarioComEndereco(int idFuncionario) {
	        List<Funcionario> funcionarios = new ArrayList<>();
	        
	        try (Connection connection = ConexãoBD.Conexao()) {
	            String query = "SELECT f.nome_completo, f.cpf,f.senha, f.data_nasc, f.telefone, f.email, f.cargo, f.salario, e.logradouro, e.bairro, e.cep, e.cidade " +
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
	    
	    
	    public static boolean atualizarFuncionario(Funcionario funcionario) {
	        try (Connection connection = ConexãoBD.Conexao()) {
	            // Atualize as informações do funcionário na tabela funcionario
	            String updateQuery = "UPDATE funcionario SET nome_completo=?, cpf=?, senha=?, data_nasc=?, telefone=?, email=?, cargo=?, salario=? WHERE id=?";
	            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
	            updateStatement.setString(1, funcionario.getNomeCompleto());
	            updateStatement.setString(2, funcionario.getCpf());
	            updateStatement.setString(3, funcionario.getSenha());
	            updateStatement.setDate(4, java.sql.Date.valueOf(funcionario.getDataNascimento()));
	            updateStatement.setString(5, funcionario.getTelefone());
	            updateStatement.setString(6, funcionario.getEmail());
	            updateStatement.setString(7, funcionario.getCargo());
	            updateStatement.setDouble(8, funcionario.getSalario());
	            updateStatement.setInt(9, funcionario.getId()); // Certifique-se de ter um método getId() em Funcionario

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

	                return enderecoRowsUpdated > 0;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	    
	    public byte[] carregarFoto(int idFuncionario) {
	        try {
	            conex = new ConexãoBD().Conexao();
	            // Consulta para obter a imagem do usuário com base no ID
	            String sql = "SELECT foto_perfil FROM funcionario WHERE id = ?";
	            PreparedStatement statement = conex.prepareStatement(sql);
	            statement.setInt(1, idFuncionario);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                // Obtém os dados da imagem da coluna "foto_perfil"
	                Blob blob = resultSet.getBlob("foto_perfil");

	                if (blob != null) {
	                    // Lê os dados da imagem como um array de bytes
	                    byte[] imageData = blob.getBytes(1, (int) blob.length());
	                    return imageData;
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Trate as exceções aqui, se necessário.
	        } finally {
	            try {
	                if (conex != null) {
	                    conex.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	                // Trate as exceções aqui, se necessário.
	            }
	        }

	        return null; // Retorna null se a imagem não for encontrada ou se ocorrer um erro
	    }
	    
	    public boolean salvarFotoPerfil(PerfilGeralModel perfilGeral) {
	        try {
	            conex = new ConexãoBD().Conexao();

	            // Execute uma instrução SQL para salvar a imagem no banco de dados
	            String sql = "UPDATE funcionario SET foto_perfil = ? WHERE id = ?";
	            PreparedStatement ps = conex.prepareStatement(sql);
	            ps.setBytes(1, perfilGeral.getFotoPerfil());
	            ps.setInt(2, perfilGeral.getId());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Trate as exceções aqui, se necessário.
	        }
			return true;
	    }



		public void salvarFotoPerfil(int idFuncionario, byte[] imageData) {
			// TODO Auto-generated method stub
			
		}






	  
	}
	
	

