package controller.login;

import javax.swing.JOptionPane;




import controller.Ferramentas.EfeitoBtn;
import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class TelaDeCadastro2Controller {
	
	
	public static String email,Senha,txtr1,txtr2,txtr3;
	
	EfeitoBtn efeito = new EfeitoBtn();

	 @FXML
	    private Line LinhaHorizontal;

	    @FXML
	    private Line LinhaVertical;

	    @FXML
	    private ImageView Logo;

	    @FXML
	    private Button buttonFinalizar;

	    @FXML
	    private ImageView imagemTijolos;

	    @FXML
	    private Pane painelPrincipal;

	    @FXML
	    private Pane pane1;

	    @FXML
	    private Pane pane2;

	    @FXML
	    private PasswordField senha;

	    @FXML
	    private TextField txfApelido;

	    @FXML
	    private PasswordField ConfirmarSen;

	    @FXML
	    private TextField txfEmail;

	    @FXML
	    private TextField txfNomeMae;

	    @FXML
	    private TextField txfPrimeiraEscola;

	    @FXML
	    private Text txtApelido;

	    @FXML
	    private Label txtAviso;

	    @FXML
	    private Label txtCadastro;

	    @FXML
	    private Text txtConfirmarSen;

	    @FXML
	    private Text txtEmail;

	    @FXML
	    private Text txtNomeMae;

	    @FXML
	    private Text txtPrimeiraEscola;

	    @FXML
	    private Text txtSenha;

	    @FXML
	    private ImageView MostraSenha;
	    
	    @FXML
	    private ImageView EscondeSenha;
	    
	    @FXML
	    private ImageView MostraSenha2;
	    
	    @FXML
	    private ImageView EscondeSenha2;
    
   
    @FXML
    void Continuar1(MouseEvent event) throws Exception {
    	//verifica se todos os campos estão prenchidos
    	if(senha.getText() != "" && txtEmail.getText() != "" && ConfirmarSen.getText() != "" 
    			&& txfPrimeiraEscola.getText() !=""&& txfNomeMae.getText() !=""
    			&& txfApelido.getText() !="") {
    		
    		//verifica se a senha digitada no campo de senha é igual ao campo confirma senha
    		
    		if(senha.getText().equals( ConfirmarSen.getText())) {
    			
    			email=txtEmail.getText();
    			Senha=senha.getText();
    			txtr1=txfPrimeiraEscola.getText();
    			txtr2=txfNomeMae.getText();
    			txtr3=txfApelido.getText();
    			
    			senha.setText("");
    			txtEmail.setText("");
    			ConfirmarSen.setText("");
    			txfPrimeiraEscola.setText("");
    			txfNomeMae.setText("");
    			txfApelido.setText("");
    			
    			Main.Cena("Cadastro2");
    		
    		
    		}else JOptionPane.showMessageDialog(null, "senha digitada no campo de confirmação não é igual a senha digitada no campo senha ");
    	
    	}else JOptionPane.showMessageDialog(null, "Preencha todos os campos");
    	

    }


    @FXML
    void clique(MouseEvent event) throws Exception{

    	Main.Cena("Login");
    	
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
    void EscondeSenhaSenha2(MouseEvent event) {

    	 txtConfirmarSen.setVisible(false);
       	 String Senha = String.valueOf(senha.getText());
       	MostraSenha2.setVisible(true);
        MostraSenha2.setDisable(false);
        
        EscondeSenha2.setVisible(false);
        EscondeSenha2.setDisable(true);
       	 txtSenha.setText(Senha);
           ConfirmarSen.setVisible(true);
    	
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

    @FXML
    void MostrarSenha2(MouseEvent event) {
    

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


}


	
	

