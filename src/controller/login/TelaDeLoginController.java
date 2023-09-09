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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
				txtsenha.setText("");
			
				
				
				
                 
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

    

    

    
}