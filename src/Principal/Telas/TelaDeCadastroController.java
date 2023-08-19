package Principal.Telas;

import javax.swing.JOptionPane;

import Ferramentas.EfeitoBtn;
import Principal.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TelaDeCadastroController {
	
	
	public static String email,senha;
	
	EfeitoBtn efeito = new EfeitoBtn();

    @FXML
    private Label Logar;
    
    

    @FXML
    private TextField TxtEmail;

    @FXML
     private ImageView imContinuar;

    @FXML
    private ImageView imSeta;

    @FXML
    private ImageView imbtn;

    @FXML
    private PasswordField psfConfirma;

    @FXML
    private PasswordField psfsenha;
    
   
    @FXML
    void Continuar1(MouseEvent event) throws Exception {
    	
    	if(psfsenha.getText() != "" && TxtEmail.getText() != "" && psfConfirma.getText() != "") {
    		if(psfsenha.getText().equals( psfConfirma.getText())) {
    			
    			email=TxtEmail.getText();
    			senha=psfsenha.getText();
    				Main.Cena("Cadastro2");
    		
    		
    		}else JOptionPane.showMessageDialog(null, "senha digitada no campo de confirmação não é igual a senha digitada no campo senha ");
    	
    	}else JOptionPane.showMessageDialog(null, "Preencha todos os campos");
    	

    }


    @FXML
    void clique(MouseEvent event) throws Exception{

    	Main.Cena("Login");
    	
    }
    
    

  
    
    @FXML
    void Entrar1(MouseEvent event) {
    	
    	imbtn.setEffect(efeito.Efeito());
    	
    }

    @FXML
    void Sair1(MouseEvent event) {
    	
    	imbtn.setEffect(null);
    }


}
