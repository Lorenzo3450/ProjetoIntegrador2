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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
        private ImageView TxtSenha;

    	 @FXML
    	    private TextField txtsenha;
    	
	 	@FXML
	    private Label cadastro;

	    @FXML
	    private ImageView imbtn;

	    
	    @FXML
	    private ImageView imlogar;

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
    	imlogar.requestFocus();
    	
    }

    
    @FXML
    void entrar1(MouseEvent event) {
    	
    	
    	imbtn.setEffect(efeito.Efeito());
    	
    }
    

    
    @FXML
    void sair1(MouseEvent event) {
    	
    	imbtn.setEffect(null);

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
	

    

    
}