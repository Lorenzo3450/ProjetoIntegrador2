package controller.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.dao.ConexãoBD;
import model.dao.login.loguinModel;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import controller.Ferramentas.EfeitoBtn;

public class TelaDeLoginController {

	  @FXML
	    private ImageView ImEsconde;
	  
	  	
	  
	    @FXML
	    private ImageView ImMostra;
		
    	EfeitoBtn efeito = new EfeitoBtn();
	

    	 @FXML
 	    private TextField txtsenha;
 	
        @FXML
        private ImageView Logo;

        @FXML
        private Pane PainelPrincipal;

        @FXML
        private AnchorPane barraDeCima;

        @FXML
        private Button btnEntrar;

        @FXML
        private Line divisor;

        @FXML
        private ImageView fundo;

        @FXML
        private Text lbl1;

        @FXML
        private Text lbl2;

        @FXML
        private Text lbl3;

        @FXML
        private Label lblCadastreSe;

        @FXML
        private Label lblRecuperaSenha;

        @FXML
        private PasswordField psfsenha;

        @FXML
        private TextField txflogin;
	   
	  
	    public class DelayedTask extends Task<Void> {
	        @Override
	        protected Void call() throws Exception {
	            Thread.sleep(5000);
	            return null;
	        }
	    }
	    
	    
	    @FXML
	    void Log1(MouseEvent event) throws Exception{

	    	
	    	
			if(loguinModel.ValidaLogin(txflogin.getText(), psfsenha.getText())) {
				
				if(loguinModel.getCargo(txflogin.getText(), psfsenha.getText()).equalsIgnoreCase("gerente")) {
	            txflogin.setText("");
	            psfsenha.setText("");
				
			
	            Main.Cena("TelaPrincipalGerente");

				
				
				}if(loguinModel.getCargo(txflogin.getText(), psfsenha.getText()).equalsIgnoreCase("Não definido")) {
					
					
					

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
					
					
					
					
				}if(loguinModel.getCargo(txflogin.getText(), psfsenha.getText()).equalsIgnoreCase("Atendente de caixa")) {
					
					Main.Cena("TelaDeVenda");
					

					
					
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
    	psfsenha.setText("");
    	txflogin.setText("");
    	 btnEntrar.requestFocus();
    	
    }

    
    @FXML
    void entrar1(MouseEvent event) {
    	
    	
    	 btnEntrar.setEffect(efeito.Efeito());
    	
    }
    

    
    @FXML
    void sair1(MouseEvent event) {
    	
    	 btnEntrar.setEffect(null);

    }
    
    @FXML
    void EscondeSenhaSenha(MouseEvent event) {

    txtsenha.setVisible(false);
   	 String senha = String.valueOf(psfsenha.getText());
   	ImMostra.setVisible(true);
    ImMostra.setDisable(false);
    
    ImEsconde.setVisible(false);
    ImEsconde.setDisable(true);
   	 txtsenha.setText(senha);
       psfsenha.setVisible(true);
    	
    }
    
    @FXML
    void MostrarSenha(MouseEvent event) {

    	String senha = String.valueOf(psfsenha.getText());

    	txtsenha.setText(senha);
    	txtsenha.setVisible(true);
        ImMostra.setVisible(false);
        ImMostra.setDisable(true);
        
        ImEsconde.setVisible(true);
        ImEsconde.setDisable(false);
        
        psfsenha.setVisible(false);
    	
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
	

	public void AlterarComponentes(Image fundo,Image logo,String txtf,String letraTxtf,String btn,String letraBtn,
			String corPrincipal,String corSecundaria,String corTercearia) {
		
		

		txtsenha.setStyle("-fx-background-color:"+txtf);
		txtsenha.setStyle("-fx-text-fill:"+letraTxtf);
		
		Logo.setImage(logo);

		PainelPrincipal.setStyle("-fx-background-color:"+corPrincipal);

		barraDeCima.setStyle("-fx-background-color:"+corPrincipal);

		btnEntrar.setStyle("-fx-background-color:"+btn);
		btnEntrar.setStyle("-fx-text-fill:"+letraBtn);

		divisor.setStyle("-fx-background-color:"+corSecundaria);

		this.fundo.setImage(fundo);

		lbl1.setStyle("-fx-background-color:"+corSecundaria);

		lbl2.setStyle("-fx-background-color:"+corSecundaria);

		lbl3.setStyle("-fx-background-color:"+corSecundaria);

		lblCadastreSe.setStyle("-fx-background-color:"+corTercearia);

		lblRecuperaSenha.setStyle("-fx-background-color:"+corTercearia);

		psfsenha.setStyle("-fx-background-color:"+txtf);
		psfsenha.setStyle("-fx-text-fill:"+letraTxtf);

		txflogin.setStyle("-fx-background-color:"+txtf);
		txflogin.setStyle("-fx-text-fill:"+letraTxtf);
		
		
		
		
	}
    

    
}