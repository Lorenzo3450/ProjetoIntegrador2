package controller.login;

import java.sql.Connection;




import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.dao.ConexãoBD;
import model.dao.login.loguinModel;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import controller.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import controller.Ferramentas.EfeitoBtn;

public class TelaDeLoginController {

    @FXML
    private Button ButtonEntrar;

    @FXML
    private Line Linha1;

    @FXML
    private ImageView Logo;

    @FXML
    private Rectangle Pane1;

    @FXML
    private Rectangle Pane2;

    @FXML
    private Pane PanePrincipal;

    @FXML
    private Label cadastreSe;

    @FXML
    private Label cliqueRecuperarSenha;

    @FXML
    private ImageView imagemTijolos;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField txfEmail;

    @FXML
    private Text txtEmail;

    @FXML
    private Text txtEsqueceuSenha;

    @FXML
    private Text txtLogin;

    @FXML
    private Text txtNaoPossuiLogin;

    @FXML
    private Text txtSenha;	
    

    @FXML
    private ImageView MostraSenha;
    
    @FXML
    private ImageView EscondeSenha;
    
    EfeitoBtn efeito = new EfeitoBtn();
    
	
	  
	    public class DelayedTask extends Task<Void> {
	        @Override
	        protected Void call() throws Exception {
	            Thread.sleep(5000);
	            return null;
	        }
	    }
	    
	    
	    @FXML
	    void Log1(MouseEvent event) throws Exception{

	    	TextField textField = new TextField();

	    	// Adicione um ouvinte para lidar com o foco do campo de entrada
	    	textField.focusedProperty().addListener((observable, oldValue, newValue) -> {
	    	    if (newValue) {
	    	        // O campo de entrada está focado, aplique a animação CSS
	    	        textField.getStyleClass().add("focused");
	    	    } else {
	    	        // O campo de entrada não está focado, remova a animação CSS
	    	        textField.getStyleClass().remove("focused");
	    	    }
	    	});

	    	
			if(loguinModel.ValidaLogin(txfEmail.getText(), senha.getText())) {
				
				if(loguinModel.getCargo(txfEmail.getText(), senha.getText()).equalsIgnoreCase("gerente")) {
	            txfEmail.setText("");
	            senha.setText("");
				txtSenha.setText("");
			
				
				
				
                 
				Main.Cena("loading");

		        Service<Void> service = new Service<>() {
		            @Override
		            protected Task<Void> createTask() {
		                return new DelayedTask();
		            }
		        };
		        
		        service.setOnSucceeded(e -> {
					try {
						Main.Cena("TelaPrincipalGerente");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
		        service.start();
		        
				}if(loguinModel.getCargo(txfEmail.getText(), senha.getText()).equalsIgnoreCase("Não definido")) {
					
					
					

					try {

						   FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/login/FuncionarioNaoDefinidoView.fxml"));
					        Parent root = loader.load();
					      
					        // Configuração do novo Stage
					        Stage newStage = new Stage();
					        newStage.initStyle(StageStyle.UNDECORATED); // Remove a barra de título
					        newStage.setTitle("");
					        newStage.initModality(Modality.APPLICATION_MODAL);
					        newStage.setScene(new Scene(root));

					        // Torna a janela arrastável (draggable)
					        makeStageDraggable(newStage, root);

					        // Exibe a nova cena em um novo Stage
					        newStage.showAndWait();

					    } catch (Exception e) {
					        e.printStackTrace();
					    }
					
					
					
					
				}
				
			}else JOptionPane.showMessageDialog(null, "erro, Senha ou email incorreto !");
			
			//encerrando a conexão  com o banco;
			
			
	    }

	    @FXML
	    void cliqueRecuperarSenha(MouseEvent event) throws Exception {

	    	Main.Cena("RecuperaSenha");
	    	
	    }
	    
	    
    

    @FXML
    void clique(MouseEvent event) throws Exception {

    	
    	Main.Cena("Cadastro");
    	senha.setText("");
    	txfEmail.setText("");
    	ButtonEntrar.requestFocus();
    	
    }

    @FXML
    void entrar1(MouseEvent event) {
  
    	ButtonEntrar.setEffect(efeito.Efeito());
    	
    }
    

    
    @FXML
    void sair1(MouseEvent event) {
    	
    	ButtonEntrar.setEffect(null);

    }
    
    @FXML
    void EscondeSenhaSenha(MouseEvent event) {

    txtSenha.setVisible(false);
   	 String Senha = String.valueOf(senha.getText());
   	MostraSenha.setVisible(true);
    MostraSenha.setDisable(false);
    
    EscondeSenha.setVisible(false);
    EscondeSenha.setDisable(true);
   	 txtSenha.setText(Senha);
       senha.setVisible(true);
    	
    }
    
    @FXML
    void MostrarSenha(MouseEvent event) {

    	String Senha = String.valueOf(senha.getText());

    	txtSenha.setText(Senha);
    	txtSenha.setVisible(true);
        MostraSenha.setVisible(false);
        MostraSenha.setDisable(true);
        
        EscondeSenha.setVisible(true);
        EscondeSenha.setDisable(false);
        
        senha.setVisible(false);
    	
    }

    private void makeStageDraggable(Stage stage, Parent root) {
	    final Delta dragDelta = new Delta();

	    root.setOnMousePressed(event -> {
	        // Quando o mouse é pressionado, calcula a diferença entre a posição atual do mouse
	        // e a posição da janela
	        dragDelta.x = stage.getX() - event.getScreenX();
	        dragDelta.y = stage.getY() - event.getScreenY();
	    });

	    root.setOnMouseDragged(event -> {
	        // Quando o mouse é arrastado, move a janela para a nova posição
	        stage.setX(event.getScreenX() + dragDelta.x);
	        stage.setY(event.getScreenY() + dragDelta.y);
	    });
	}

	// Classe auxiliar para armazenar a diferença entre as coordenadas do mouse e da janela
	class Delta {
	    double x, y;
	}
    
}
