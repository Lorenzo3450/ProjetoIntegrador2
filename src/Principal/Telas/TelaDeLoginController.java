package Principal.Telas;

import javax.swing.JOptionPane;

import Principal.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import Ferramentas.EfeitoBtn;

public class TelaDeLoginController {

		int index;
		
    	EfeitoBtn efeito = new EfeitoBtn();
	
    	
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
	    
	    
	  
	    @FXML
	    void Log1(MouseEvent event) throws Exception{


	    	for(int i=0;i<=TelaDeCadastroController.index;i++) {
	    		if(Main.email[i]==txflogin.getText()&&Main.senha[i]== psfsenha.getText()) {
	    			JOptionPane.showMessageDialog(null, "bem vindo ao sistema");
	    			break;
	    			
	    		}else JOptionPane.showMessageDialog(null, "senha ou login errados");
	    		
	    		
	    	}
	    	
	    }


	
 

	    @FXML
	    void vol1(MouseEvent event) throws Exception {
	    	

	    	Main.Cena("Inicio");
	    	psfsenha.setText("");
	    	txflogin.setText("");
	    	imlogar.requestFocus();
	    	
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

    

    

    
}