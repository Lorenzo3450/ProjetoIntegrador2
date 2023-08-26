package controller.gerente;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import model.dao.ConexãoBD;
import controller.Ferramentas.EfeitoBtn;
import controller.Ferramentas.Funcionario;
import controller.Main;

public class TabelaFuncionarioController {
	
	private static Scene filtrofuncionario;
	
	EfeitoBtn efeito = new EfeitoBtn();
	
	@FXML
    private TextField TxtPesquisa;
    
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
    	tableView.getItems().clear();
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
    
    
    
    //filtra os funcionarios
    @FXML
    void Filtro(MouseEvent event) { 	

    	    try {
    	     

    	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/gerente/TabelaFuncionario_Filtro.fxml"));
                Parent root = loader.load();

                TabelaFuncionario_FiltroController filtroController = loader.getController();
                filtroController.setTabelaFuncionarioController(this); // Passa a instância atual
    	        
    	        
    	        // Configuração do novo Stage
    	        Stage newStage = new Stage();
    	        newStage.setTitle("Filtro");
    	        newStage.initModality(Modality.APPLICATION_MODAL); 
    	        newStage.setScene(new Scene(root));

    	        // Exibe a nova cena em um novo Stage
    	        newStage.showAndWait(); // Ou newStage.show(), dependendo se você deseja esperar a nova cena fechar ou não

    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	

    	
    	
    	
    	
    	
    	
    	
    }

    //remove um funcionario da tabela 
    @FXML
    void RemoverFuncionario(MouseEvent event) {

    }
    
    
    @FXML
    void Pesquisar(MouseEvent event) {

    	if(TxtPesquisa.getText()!="") {
    	tableView.getItems().clear();
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
             String query = "SELECT nome_completo, cpf, data_nasc, telefone, email, cargo, salario FROM funcionario where nome_completo = '"+
              TxtPesquisa.getText()+"'";
             
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
         } }else {
        	 initialize();
         }
    	

    }
    
    
    @FXML
    void vol1(MouseEvent event) throws Exception {

    	Main.Cena("TelaPrincipalGerente");
    	
    }
    

    @FXML
    void PressionarEnter(KeyEvent event) {
    	if (event.getCode() == KeyCode.ENTER) {

    	Pesquisar(null);

    }

    
    
    }
    
    public void AplicaFiltro(String comando) {
    	tableView.getItems().clear();
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
        	
            tableView.getItems().addAll(funcionarios);
      
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    

    
    @FXML
    void imprimir(MouseEvent event) {

        PrinterJob printerJob = PrinterJob.createPrinterJob();
        if (printerJob != null && printerJob.showPrintDialog(tableView.getScene().getWindow())) {
            printerJob.printPage(tableView);
            printerJob.endJob();
        }
    	
    }

    

}
