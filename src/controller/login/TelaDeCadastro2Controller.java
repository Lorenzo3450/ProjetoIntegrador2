package controller.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.DesignSistema;
import model.dao.ConexãoBD;
import model.dao.Gerente.PersonalizaSistemaDao;
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
	private void initialize() {
    	
    	 DesignSistema design = null;
         try {
             design = PersonalizaSistemaDao.buscaDesign();
         } catch (SQLException e) {
             e.printStackTrace();
             // Lidere com erros de consulta aqui, se necessário
         }
         if(design!=null) {

         
         Image Fundo = new Image(design.getFundoImagem());
         Image Logo = new Image(design.getLogoImagem());
         
    	AlterarComponentes(Fundo, Logo, design.getCorSecundaria(), design.getTipoFonte(),design.getCorSecundaria() , design.getTipoFonte(), design.getCorPrincipal()
    			, design.getCorSecundaria(), design.getCorTerciaria());
         }
    }
   

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
    
    public void AlterarComponentes(Image fundo, Image logo, String txtf, String letraTxtf, String btn, String letraBtn,
            String corPrincipal, String corSecundaria, String corTercearia) {

        Btnfinal.setStyle( Btnfinal.getStyle()+"-fx-background-color:" + btn + ";");
        Btnfinal.setStyle( Btnfinal.getStyle()+"-fx-text-fill:" + letraBtn + ";");

        Logo.setImage(logo);

        PainelPrincipal.setStyle("-fx-background-color:" + corPrincipal);

        TxtBairo.setStyle(TxtBairo.getStyle() + "-fx-background-color:" + txtf + ";");
        TxtCep.setStyle(TxtCep.getStyle() + "-fx-background-color:" + txtf + ";");
        TxtCidade.setStyle(TxtCidade.getStyle() + "-fx-background-color:" + txtf + ";");
        TxtDataDeNascimento.setStyle(TxtDataDeNascimento.getStyle() + "-fx-background-color:" + txtf + ";");
        TxtNome.setStyle(TxtNome.getStyle() + "-fx-background-color:" + txtf + ";");
        TxtRuaCasaComplemeto.setStyle(TxtRuaCasaComplemeto.getStyle() + "-fx-background-color:" + txtf + ";");
        TxtTelefone.setStyle(TxtTelefone.getStyle() + "-fx-background-color:" + txtf + ";");

        TxtBairo.setStyle(TxtBairo.getStyle() + "-fx-text-fill:" + letraTxtf + ";");
        TxtCep.setStyle(TxtCep.getStyle() + "-fx-text-fill:" + letraTxtf + ";");
        TxtCidade.setStyle(TxtCidade.getStyle() + "-fx-text-fill:" + letraTxtf + ";");
        TxtDataDeNascimento.setStyle(TxtDataDeNascimento.getStyle() + "-fx-text-fill:" + letraTxtf + ";");
        TxtNome.setStyle(TxtNome.getStyle() + "-fx-text-fill:" + letraTxtf + ";");
        TxtRuaCasaComplemeto.setStyle(TxtRuaCasaComplemeto.getStyle() + "-fx-text-fill:" + letraTxtf + ";");
        TxtTelefone.setStyle(TxtTelefone.getStyle() + "-fx-text-fill:" + letraTxtf + ";");

        barraDeCima.setStyle(barraDeCima.getStyle() + "-fx-background-color:" + corPrincipal);
        divisor.setStyle(divisor.getStyle() + "-fx-background-color:" + corSecundaria);
        divisor2.setStyle(divisor2.getStyle() + "-fx-background-color:" + corSecundaria);

        this.fundo.setImage(fundo);

        lbl1.setStyle(lbl1.getStyle() + "-fx-background-color:" + corSecundaria + ";");
        lbl1.setStyle(lbl1.getStyle() + "-fx-text-fill:" + letraTxtf + ";");
    }


    
 
}
