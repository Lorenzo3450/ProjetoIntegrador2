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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class TelaDeCadastroController {

	EfeitoBtn efeito = new EfeitoBtn();
	
	  @FXML
	    private Line Linha1;

	    @FXML
	    private Line Linha2;

	    @FXML
	    private ImageView Logo;

	    @FXML
	    private Pane Pane1;

	    @FXML
	    private Pane Pane2;

	    @FXML
	    private Pane PanePrincipal;

	    @FXML
	    private Button buttonContinuar;

	    @FXML
	    private ImageView imagemTijolos;
	    
	    @FXML
	    private ImageView txfDataNascimento;

	    @FXML
	    private TextField txfApelido;

	    @FXML
	    private TextField txfBairro;

	    @FXML
	    private TextField txfCEP;

	    @FXML
	    private TextField txfCPF;

	    @FXML
	    private TextField txfCidade;

	    @FXML
	    private TextField txfLogradouro;

	    @FXML
	    private TextField txfNome;

	    @FXML
	    private TextField txfTelefone;
	    
	    @FXML
	    private Text txtDataNascimento;

	    @FXML
	    private Text txtBairro;

	    @FXML
	    private Text txtCEP;

	    @FXML
	    private Text txtCPF;

	    @FXML
	    private Label txtCadastro;

	    @FXML
	    private Text txtCidade;

	    @FXML
	    private Text txtLogradouro;

	    @FXML
	    private Text txtTelefone;

	    @FXML
	    private Text txtNome;
    @FXML
    void BtnFinalizar(MouseEvent event) throws Exception {
    	
    	if(txtBairro.getText() != "" && txtCEP.getText() != "" && 
    			txtCidade.getText() != "" && txtCPF.getText() != "" &&
    			txtDataNascimento.getText() != "" && txtNome.getText() != "" &&
    			txtLogradouro.getText() != "" && txtTelefone.getText() != "") {
    		
    		
    		//metodo da classe cadastro model que realiza o cadastro
    
    			CadastroModel.RealizaCadastro(txtNome.getText(), txtCPF.getText(), txtDataNascimento.getText(), txtTelefone.getText(),
    					TelaDeCadastro2Controller.email, TelaDeCadastro2Controller.Senha,  txtLogradouro.getText(), 
    					txtBairro.getText(),  txtCEP.getText(), txtCidade.getText(),TelaDeCadastro2Controller.txtr1,
    					TelaDeCadastro2Controller.txtr2,TelaDeCadastro2Controller.txtr3);
    		
    		
    			txtNome.setText("");
    			txtCPF.setText("");
    			txtDataNascimento.setText("");
    			txtTelefone.setText("");
				txtLogradouro.setText("");
				txtBairro.setText("");  
				txtCEP.setText(""); 
				txtCidade.setText("");
    			
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

    	buttonContinuar.setEffect(efeito.Efeito());
    	
    }

    @FXML
    void Sair1(MouseEvent event) {

    	buttonContinuar.setEffect(null);
    	
    }
    
  
    @FXML
    void Formataçãodata(KeyEvent event) {

    	if(txtDataNascimento.getText().length()==2) {
      		
    		txtDataNascimento.setText(txtDataNascimento.getText()+"/");
    		txtDataNascimento.setCaretPosition(4);
    		
    	}
    	
    	if(txtDataNascimento.getText().length()==5) {
      		
    		txtDataNascimento.setText(txtDataNascimento.getText()+"/");
    		txtDataNascimento.setCaretPosition(6);
    		
    	}
    	
    }

    @FXML
    void FortmataçaoTelefone(KeyEvent event) {

    	if(txtTelefone.getText().length()==2) {
      		
    		txtTelefone.setText("("+txtTelefone.getText()+")");
    		txtTelefone.setCaretPosition(4);;
  		
    	}
    	
    	if(txtTelefone.getText().length()==9) {
      		
    		txtTelefone.setText(txtTelefone.getText()+"-");
    		txtTelefone.setCaretPosition(10);;
  		
    	}
    	
    }

    
 
}
