package Principal.Telas;

import javax.swing.JOptionPane;

import Ferramentas.EfeitoBtn;
import Principal.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TelaDeCadastro2Controller {

	EfeitoBtn efeito = new EfeitoBtn();
	
    @FXML
    private TextField TxtBairro;
    
    @FXML
    private ImageView Btnfinal;

    @FXML
    private TextField TxtCep;

    @FXML
    private TextField TxtCidade;

    @FXML
    private TextField TxtCpf;

    @FXML
    private TextField TxtDataDeNascimento;

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtRuaCasaComplemento;

    @FXML
    private TextField TxtTelefone;

    @FXML
    void BtnFinalizar(MouseEvent event) throws Exception {
    	
    	if(TxtBairro.getText() != "" && TxtCep.getText() != "" && 
    			TxtCidade.getText() != "" && TxtCpf.getText() != "" &&
    			TxtDataDeNascimento.getText() != "" && TxtNome.getText() != "" &&
    			TxtRuaCasaComplemento.getText() != "" && TxtTelefone.getText() != "") {
    		
    		Main.Cena("Login");
    		
    		
    	}else JOptionPane.showMessageDialog(null, "Prencha todos os campos");
    	

    }

    

    @FXML
    void vol1(MouseEvent event) throws Exception {

    	Main.Cena("Cadastro");
    	
    }

    @FXML
    void Entrar1(MouseEvent event) {

    	Btnfinal.setEffect(efeito.Efeito());
    	
    }

    @FXML
    void Sair1(MouseEvent event) {

    	Btnfinal.setEffect(null);
    	
    }
 
}
