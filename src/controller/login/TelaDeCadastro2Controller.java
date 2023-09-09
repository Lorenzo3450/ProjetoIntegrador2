package controller.login;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import model.dao.ConexãoBD;
import model.dao.login.CadastroModel;
import controller.Ferramentas.EfeitoBtn;
import controller.Ferramentas.TrocaData;
import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
    		
    		
    		//metodo da classe cadastro model que realiza o cadastro
    
    			CadastroModel.RealizaCadastro(TxtNome.getText(), TxtCpf.getText(), TxtDataDeNascimento.getText(), TxtTelefone.getText(),
    					TelaDeCadastroController.email, TelaDeCadastroController.senha,  TxtRuaCasaComplemento.getText(), 
    					TxtBairro.getText(),  TxtCep.getText(), TxtCidade.getText(),TelaDeCadastroController.txtr1,
    					TelaDeCadastroController.txtr2,TelaDeCadastroController.txtr3);
    		
    		
    			TxtNome.setText("");
    			TxtCpf.setText("");
    			TxtDataDeNascimento.setText("");
    			TxtTelefone.setText("");
				TxtRuaCasaComplemento.setText("");
				TxtBairro.setText("");  
				TxtCep.setText(""); 
				TxtCidade.setText("");
    			
    			JOptionPane.showMessageDialog(null, "dados cadastrados com sucesso");

    			
    	
    				
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
    
  
    @FXML
    void Formataçãodata(KeyEvent event) {

    	if(TxtDataDeNascimento.getText().length()==2) {
      		
    		TxtDataDeNascimento.setText(TxtDataDeNascimento.getText()+"/");
    		TxtDataDeNascimento.positionCaret(4);
    		
    	}
    	
    	if(TxtDataDeNascimento.getText().length()==5) {
      		
    		TxtDataDeNascimento.setText(TxtDataDeNascimento.getText()+"/");
    		TxtDataDeNascimento.positionCaret(6);
    		
    	}
    	
    }

    @FXML
    void FortmataçaoTelefone(KeyEvent event) {

    	if(TxtTelefone.getText().length()==2) {
      		
    		TxtTelefone.setText("("+TxtTelefone.getText()+")");
    		TxtTelefone.positionCaret(4);
  		
    	}
    	
    	if(TxtTelefone.getText().length()==9) {
      		
    		TxtTelefone.setText(TxtTelefone.getText()+"-");
    		TxtTelefone.positionCaret(10);
  		
    	}
    	
    }

    
 
}
