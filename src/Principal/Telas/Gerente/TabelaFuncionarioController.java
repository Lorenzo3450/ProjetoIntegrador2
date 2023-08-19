package Principal.Telas.Gerente;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import BancoDeDados.ConexãoBD;
import Ferramentas.model.Funcionario;
import Principal.Main;

public class TabelaFuncionarioController {
    @FXML
    private TableView<Funcionario> tableView;
    @FXML
    private TableColumn<Funcionario, String> nomeCompletoColumn;
    @FXML
    private TableColumn<Funcionario, String> cpfColumn;
    @FXML
    private TableColumn<Funcionario, Integer> idadeColumn;
    @FXML
    private TableColumn<Funcionario, String> telefoneColumn;
    @FXML
    private TableColumn<Funcionario, String> emailColumn;
    @FXML
    private TableColumn<Funcionario, String> cargoColumn;
    @FXML
    private TableColumn<Funcionario, Double> salarioColumn;

    
    
    //inicializa a tabelafuncionario
    @FXML
    private void initialize() {
        nomeCompletoColumn.setCellValueFactory(cellData -> cellData.getValue().nomeCompletoProperty());
        cpfColumn.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
        idadeColumn.setCellValueFactory(cellData -> {
            IntegerProperty idadeProperty = cellData.getValue().idadeProperty();
            if (idadeProperty != null) {
                return idadeProperty.asObject();
            } else {
                return new SimpleIntegerProperty(0).asObject();
            }
        });
        
        telefoneColumn.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        cargoColumn.setCellValueFactory(cellData -> cellData.getValue().cargoProperty());
        salarioColumn.setCellValueFactory(cellData -> cellData.getValue().salarioProperty().asObject());

        // Carregar dados do banco de dados e preencher a TableView
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
        	
            tableView.getItems().addAll(funcionarios);
      
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    
    @FXML
    void Filtro(MouseEvent event) {

    }

    @FXML
    void RemoverFuncionario(MouseEvent event) {

    }
    
    
    }
