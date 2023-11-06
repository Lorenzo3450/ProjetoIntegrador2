package controller.login;

	import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.dao.ConexãoBD;
import model.dao.login.RecuperSenhaModel;
import controller.Ferramentas.EfeitoBtn;
import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
	import javafx.scene.image.ImageView;
	import javafx.scene.input.KeyEvent;
	import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

	public class TelaRecuperaSenhaController {

		EfeitoBtn efeito = new EfeitoBtn();
		
		 @FXML
		    private PasswordField ConfirmarSen;

		    @FXML
		    private ImageView EscondeSenha;

		    @FXML
		    private ImageView EscondeSenha2;

		    @FXML
		    private ImageView MostraSenha;

		    @FXML
		    private ImageView MostraSenha2;

		    @FXML
		    private Line linha1;

		    @FXML
		    private Line linha2;

		    @FXML
		    private ImageView logo;

		    @FXML
		    private Pane paneColuna;

		    @FXML
		    private Pane panePrincipal;

		    @FXML
		    private Pane paneTeto;

		    @FXML
		    private Label redefinirSenha;

		    @FXML
		    private PasswordField senha;

		    @FXML
		    private TextField txfApelido;

		    @FXML
		    private TextField txfCPF;

		    @FXML
		    private TextField txfNomeMae;

		    @FXML
		    private TextField txfPrimeiraEscola;

		    @FXML
		    private Text txtApelido;

		    @FXML
		    private Text txtCPF;

		    @FXML
		    private Text txtConfirmarSen;

		    @FXML
		    private Text txtNomeMae;

		    @FXML
		    private Text txtNovaSenha;

		    @FXML
		    private Text txtPrimeiraEscola;
		    
		    @FXML
		    private Button buttonFinalizar;
		    
	    @FXML
	    void BtnFinalizar(MouseEvent event) throws SQLException {
	    	
	    	if(txtPrimeiraEscola.getText() !=""&& txtNomeMae.getText() !=""
    			&& txtApelido.getText() !=""&& txtCPF.getText() != "" &&
    			ConfirmarSen.getText() != "" && senha.getText() != ""){
	    		
	    		if(senha.getText().equals(ConfirmarSen.getText())) {
	    			
	    			
	    			RecuperSenhaModel.AlteraSenha(senha.getText(), txtPrimeiraEscola.getText()
	    					, txtNomeMae.getText(), txtApelido.getText());
	    			
	    			

	            } else JOptionPane.showMessageDialog(null, "senha digitada no campo de confirmação não é igual a senha digitada no campo senha");
	    			
	    			
	    			
	    		} else JOptionPane.showMessageDialog(null, "prencha todos os campos");
	    		
	    		
	    		
	    	}
	    	
	    @FXML
	    void EscondeSenhaSenha(MouseEvent event) {

	    	txtNovaSenha.setVisible(false);
	       	 String Senha = String.valueOf(senha.getText());
	       	MostraSenha.setVisible(true);
	        MostraSenha.setDisable(false);
	        
	        EscondeSenha.setVisible(false);
	        EscondeSenha.setDisable(true);
	       	 txtNovaSenha.setText(Senha);
	           senha.setVisible(true);
	    	
	    }

	    @FXML
	    void EscondeSenhaSenha1(MouseEvent event) {

	    	txtConfirmarSen.setVisible(false);
	       	 String Senha = String.valueOf(senha.getText());
	       	MostraSenha2.setVisible(true);
	       	MostraSenha2.setDisable(false);
	        
	       	EscondeSenha2.setVisible(false);
	       	EscondeSenha2.setDisable(true);
	       	txtConfirmarSen.setText(Senha);
	        ConfirmarSen.setVisible(true);
	    	
	    }

	    @FXML
	    void MostrarSenha(MouseEvent event) {

	    	String Senha = String.valueOf(senha.getText());

	    	txtNovaSenha.setText(Senha);
	    	txtNovaSenha.setVisible(true);
	        MostraSenha.setVisible(false);
	        MostraSenha.setDisable(true);
	        
	        EscondeSenha.setVisible(true);
	        EscondeSenha.setDisable(false);
	        
	        senha.setVisible(false);
	    	
	    }

	    @FXML
	    void MostrarSenha1(MouseEvent event) {

	    	String Senha = String.valueOf(senha.getText());

	    	txtConfirmarSen.setText(Senha);
	    	txtConfirmarSen.setVisible(true);
	        MostraSenha2.setVisible(false);
	        MostraSenha2.setDisable(true);
	        
	        EscondeSenha2.setVisible(true);
	        EscondeSenha2.setDisable(false);
	        
	        ConfirmarSen.setVisible(false);
	    	
	    	
	    }

	    

	    @FXML
	    void Entrar1(MouseEvent event) {

	    	buttonFinalizar.setEffect(efeito.Efeito());
	    	
	    }


	    @FXML
	    void Sair1(MouseEvent event) {

	    	buttonFinalizar.setEffect(null);
	    	
	    }

	    @FXML
	    void vol1(MouseEvent event) throws Exception {
	    	
	    	Main.Cena("Login");
	    	
	    }

	}

	
	

