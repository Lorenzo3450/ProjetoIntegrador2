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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class TelaDeCadastro2Controller {

	EfeitoBtn efeito = new EfeitoBtn();
	

    @FXML
    private Button Btnfinal;

    @FXML
    private ImageView Logo;

    @FXML
    private Pane PainelPrincipal;

    @FXML
    private TextField TxtBairo;


    @FXML
    private TextField TxtRuaCasaComplemeto;

  

    @FXML
    private Pane barraDeCima;

    @FXML
    private Separator divisor;

    @FXML
    private Separator divisor2;

    @FXML
    private ImageView fundo;

    @FXML
    private Label lbl1;
	
	
    @FXML
    private TextField TxtBairro;
    


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
    
    
    public void AlterarComponentes(Image fundo,Image logo,String txtf,String letraTxtf,String btn,String letraBtn,
			String corPrincipal,String corSecundaria,String corTercearia) {
    	
    	

    	Btnfinal.setStyle("-fx-background-color:"+btn);;
    	Btnfinal.setStyle("-fx-text-fill:"+letraBtn);;
    	
    	Logo.setImage(logo);

    	PainelPrincipal.setStyle("-fx-background-color:"+corPrincipal);

        TxtBairo.setStyle("-fx-background-color:"+txtf);

        TxtCep.setStyle("-fx-background-color:"+txtf);

        TxtCidade.setStyle("-fx-background-color:"+txtf);

        TxtDataDeNascimento.setStyle("-fx-background-color:"+txtf);

        TxtNome.setStyle("-fx-background-color:"+txtf);

        TxtRuaCasaComplemeto.setStyle("-fx-background-color:"+txtf);

        TxtTelefone.setStyle("-fx-background-color:"+txtf);
        
        
        TxtBairo.setStyle("-fx-text-fill:"+letraTxtf);

        TxtCep.setStyle("-fx-text-fill:"+letraTxtf);

        TxtCidade.setStyle("-fx-text-fill:"+letraTxtf);

        TxtDataDeNascimento.setStyle("-fx-text-fill:"+letraTxtf);

        TxtNome.setStyle("-fx-text-fill:"+letraTxtf);

        TxtRuaCasaComplemeto.setStyle("-fx-text-fill:"+letraTxtf);

        TxtTelefone.setStyle("-fx-text-fill:"+letraTxtf);
        

        barraDeCima.setStyle("-fx-background-color:"+corPrincipal);

        divisor.setStyle("-fx-background-color:"+corSecundaria);

        divisor2.setStyle("-fx-background-color:"+corSecundaria);

        this.fundo.setImage(fundo);

        lbl1.setStyle("-fx-background-color:"+corSecundaria);
        lbl1.setStyle("-fx-text-fill:"+letraTxtf);
    	
    }

    
 
}
