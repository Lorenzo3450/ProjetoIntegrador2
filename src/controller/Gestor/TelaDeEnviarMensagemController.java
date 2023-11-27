package controller.Gestor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import controller.Ferramentas.EditButtonCell;
import controller.Ferramentas.EfeitoImage;
import controller.Ferramentas.EnviaEmail;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Funcionario;
import model.Gestor.TelaDeEnviarEmailDao;
import model.dao.Gerente.TabelaFuncionarioDao;
import model.dao.Gerente.TelaDePerfilDao;
import model.dao.login.MainModel;



public class TelaDeEnviarMensagemController {

    @FXML
    private ImageView BtnPesquisar;

    @FXML
    private ImageView ImagemDeFundo;

    @FXML
    private ImageView Logo;

    @FXML
    private TextArea Mensagem;

    @FXML
    private AnchorPane PainelDeCima;

    @FXML
    private Label TextoDoPainelDeCima;

    @FXML
    private TextField TxtPesquisa;

	@FXML
	private TableColumn<Funcionario, String> cargoColumn;
	@FXML
	private TableColumn<Funcionario, String> emailColumn;

	@FXML
	private TableColumn<Funcionario, String> nomeCompletoColumn;

    @FXML
    private ScrollPane tableScrollPane;

	@FXML
	private TableView<Funcionario> tableView;

    @FXML
    private TextField txtAssunto;

    @FXML
    private TextField txtDestinatario;

    @FXML
    private TextField txtRemetente;
    
    
	@FXML
	private void initialize() throws SQLException {
		
	
	
		txtRemetente.setText("De : "+TelaDeEnviarEmailDao.obterEmailFuncionarioConectado());
		
		
		tableView.getItems().clear();
		nomeCompletoColumn.setCellValueFactory(cellData -> cellData.getValue().nomeCompletoProperty());
		
		emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		cargoColumn.setCellValueFactory(cellData -> cellData.getValue().cargoProperty());
		
		try {
			tableView.getItems().addAll(TelaDeEnviarEmailDao.inicializatabela());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}
    

	 @FXML
	    void AbrirSideBar(MouseEvent event) {

	    	 try {
	    	        // Carregue a cena da barra lateral a partir do arquivo FXML
	    	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/gerente/SideBarGerente.fxml"));
	    	        AnchorPane sideBarRoot = loader.load();

	    	        // Crie uma nova janela para exibir a cena da barra lateral
	    	        Stage sideBarStage = new Stage();
	    	        sideBarStage.initStyle(StageStyle.UNDECORATED);
	    	        Scene sideBarScene = new Scene(sideBarRoot);
	    	        sideBarStage.setScene(sideBarScene);

	    	        sideBarStage.setX(0);
	    	        sideBarStage.setY(0);
	    	        // Exiba a janela da barra lateral
	    	        sideBarStage.show();
	    	    } catch (IOException e) {
	    	        e.printStackTrace();
	    	    }
	    	
	    	
	    }
	    

		@FXML
		void PressionarEnter(KeyEvent event) throws SQLException {
			if (event.getCode() == KeyCode.ENTER) {

				Pesquisar(null);

			}

		}
		
		@FXML
		void Pesquisar(MouseEvent event) throws SQLException {

			if (TxtPesquisa.getText() != "") {
				tableView.getItems().clear();
				nomeCompletoColumn.setCellValueFactory(cellData -> cellData.getValue().nomeCompletoProperty());
				

				
				emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
				cargoColumn.setCellValueFactory(cellData -> cellData.getValue().cargoProperty());
				

				try {
					tableView.getItems().addAll(TelaDeEnviarEmailDao.PesquisaFuncionario(TxtPesquisa.getText()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				initialize();
			}

		}
		
		   @FXML
		    void EnviarEmail(MouseEvent event) throws SQLException {

			   int idFuncionario = MainModel.verificaID();
		        List<Funcionario> funcionarios = TelaDePerfilDao.getFuncionarioComEndereco(idFuncionario);

		        Funcionario funcionario = funcionarios.get(0); 
			   
		
		        
			   EnviaEmail.EnviarEmail(funcionario.getEmailDeTrabalho(),funcionario.getSenhaEmail(),
				   txtAssunto.getText().substring(8),Mensagem.getText(),txtDestinatario.getText().substring(6));
			   
			   
		    }
		
}
