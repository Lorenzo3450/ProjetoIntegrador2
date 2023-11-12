package controller.login;



import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Ferramentas.EfeitoBtn;
import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.DesignSistema;
import model.dao.Gerente.PersonalizaSistemaDao;
import javafx.scene.control.Button;

public class TelaDeCadastroController {
	
	
	public static String email,senha,txtr1,txtr2,txtr3;
	
	EfeitoBtn efeito = new EfeitoBtn();

    @FXML
    private Label Logar;
    
    @FXML
    private ImageView ImEsconde;

    @FXML
    private ImageView ImEsconde1;

    @FXML
    private ImageView ImMostra;

    @FXML
    private ImageView ImMostra1;
    
   
    @FXML
    private ImageView Logo;

    @FXML
    private Pane PainelPrincipal;

   
    @FXML
    private Pane barraDeCima;

    @FXML
    private Separator divisor;

    @FXML
    private Separator divisor2;

    @FXML
    private ImageView fundo;

  
    @FXML
    private Label lbl;

    @FXML
    private Label lbl2;

    @FXML
    private TextField txtsenha;

    @FXML
    private TextField txtsenha2;
    
    
    @FXML
    private TextField TxtPalavrasDeRecuperacao1;

    @FXML
    private TextField TxtPalavrasDeRecuperacao2;

    @FXML
    private TextField TxtPalavrasDeRecuperacao3;


    @FXML
    private TextField TxtEmail;

    @FXML
     private ImageView imContinuar;

    @FXML
    private ImageView imSeta;

    @FXML
    private Button  imbtn;

    @FXML
    private PasswordField psfConfirma;

    @FXML
    private PasswordField psfsenha;
    
    
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
    void Continuar1(MouseEvent event) throws Exception {
    	//verifica se todos os campos estão prenchidos
    	if(psfsenha.getText() != "" && TxtEmail.getText() != "" && psfConfirma.getText() != "" 
    			&& TxtPalavrasDeRecuperacao1.getText() !=""&& TxtPalavrasDeRecuperacao2.getText() !=""
    			&& TxtPalavrasDeRecuperacao3.getText() !="") {
    		
    		//verifica se a senha digitada no campo de senha é igual ao campo confirma senha
    		
    		if(psfsenha.getText().equals( psfConfirma.getText())) {
    			
    			email=TxtEmail.getText();
    			senha=psfsenha.getText();
    			txtr1= TxtPalavrasDeRecuperacao1.getText();
    			txtr2=  TxtPalavrasDeRecuperacao2.getText();
    			txtr3=  TxtPalavrasDeRecuperacao3.getText();
    			
    			psfsenha.setText("");
    			TxtEmail.setText("");
    			psfConfirma.setText("");
    			TxtPalavrasDeRecuperacao1.setText("");
    			TxtPalavrasDeRecuperacao2.setText("");
    			TxtPalavrasDeRecuperacao3.setText("");
    			
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
    void EscondeSenhaSenha2(MouseEvent event) {

    	 txtsenha2.setVisible(false);
       	 String senha = String.valueOf(psfsenha.getText());
       	ImMostra1.setVisible(true);
        ImMostra1.setDisable(false);
        
        ImEsconde1.setVisible(false);
        ImEsconde1.setDisable(true);
       	 txtsenha.setText(senha);
           psfConfirma.setVisible(true);
    	
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

    @FXML
    void MostrarSenha2(MouseEvent event) {
    

    	String senha = String.valueOf(psfsenha.getText());

    	txtsenha2.setText(senha);
    	txtsenha2.setVisible(true);
        ImMostra1.setVisible(false);
        ImMostra1.setDisable(true);
        
        ImEsconde1.setVisible(true);
        ImEsconde1.setDisable(false);
        
        psfConfirma.setVisible(false);
    	
    	
    }
    
    
  
    
    @FXML
    void Entrar1(MouseEvent event) {
    	
    	imbtn.setEffect(efeito.Efeito());
    	
    }

    @FXML
    void Sair1(MouseEvent event) {
    	
    	imbtn.setEffect(null);
    }
    

    public void AlterarComponentes(Image fundo, Image logo, String txtf, String letraTxtf, String btn, String letraBtn,
            String corPrincipal, String corSecundaria, String corTercearia) {

        Logo.setImage(logo);

        PainelPrincipal.setStyle(PainelPrincipal.getStyle()+"-fx-background-color:" + corPrincipal);

        TxtEmail.setStyle(TxtEmail.getStyle() + "-fx-background-color:" + txtf + ";");
        TxtEmail.setStyle(TxtEmail.getStyle() + "-fx-text-fill:" + letraTxtf + ";");

        TxtPalavrasDeRecuperacao1.setStyle(TxtPalavrasDeRecuperacao1.getStyle() + "-fx-background-color:" + txtf + ";");
        TxtPalavrasDeRecuperacao2.setStyle(TxtPalavrasDeRecuperacao2.getStyle() + "-fx-background-color:" + txtf + ";");
        TxtPalavrasDeRecuperacao3.setStyle(TxtPalavrasDeRecuperacao3.getStyle() + "-fx-background-color:" + txtf + ";");
        
        TxtPalavrasDeRecuperacao1.setStyle(TxtPalavrasDeRecuperacao1.getStyle() + "-fx-text-fill:" + letraTxtf + ";");
        TxtPalavrasDeRecuperacao2.setStyle(TxtPalavrasDeRecuperacao2.getStyle() + "-fx-text-fill:" + letraTxtf + ";");
        TxtPalavrasDeRecuperacao3.setStyle(TxtPalavrasDeRecuperacao3.getStyle() + "-fx-text-fill:" + letraTxtf + ";");

        barraDeCima.setStyle(barraDeCima.getStyle() + "-fx-background-color:" + corPrincipal);

        divisor.setStyle(divisor.getStyle() + "-fx-background-color:" + corSecundaria);
        divisor2.setStyle(divisor2.getStyle() + "-fx-background-color:" + corSecundaria);

        this.fundo.setImage(fundo);

        imbtn.setStyle(imbtn.getStyle() + "-fx-background-color:" + btn + ";");
        imbtn.setStyle(imbtn.getStyle() + "-fx-text-fill:" + letraBtn + ";");

        lbl.setStyle(lbl.getStyle() + "-fx-text-fill:" + corSecundaria + ";");
        lbl2.setStyle(lbl2.getStyle() + "-fx-text-fill:" + corTercearia + ";");

        txtsenha.setStyle(txtsenha.getStyle() + "-fx-background-color:" + txtf + ";");
        txtsenha2.setStyle(txtsenha2.getStyle() + "-fx-background-color:" + txtf + ";");

        txtsenha.setStyle(txtsenha.getStyle() + "-fx-text-fill:" + letraTxtf + ";");
        txtsenha2.setStyle(txtsenha2.getStyle() + "-fx-text-fill:" + letraTxtf + ";");
    }



}
