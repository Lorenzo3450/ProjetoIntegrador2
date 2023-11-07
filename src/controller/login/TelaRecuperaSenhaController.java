	package controller.login;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.DesignSistema;
import model.dao.ConexãoBD;
import model.dao.Gerente.PersonalizaSistemaDao;
import model.dao.login.RecuperSenhaModel;
import controller.Ferramentas.EfeitoBtn;
import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
	import javafx.scene.input.KeyEvent;
	import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

	public class TelaRecuperaSenhaController {

		EfeitoBtn efeito = new EfeitoBtn();
		

		@FXML
		private ImageView ImEsconde;
		  
	    @FXML
	    private Button Btnfinal;

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
	    private TextField TxtCpf;

	    @FXML
	    private TextField TxtPalavrasDeRecuperacao1;

	    @FXML
	    private TextField TxtPalavrasDeRecuperacao2;

	    @FXML
	    private TextField TxtPalavrasDeRecuperacao3;

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
	    private PasswordField psfConfirmaNovaSenha;

	    @FXML
	    private PasswordField psfsNovaSenha;

	    @FXML
	    private TextField txtSenha;

	    @FXML
	    private TextField txtSenha1;


	    @FXML
    	private void initialize() {
        	
        	 DesignSistema design = null;
             try {
                 design = PersonalizaSistemaDao.buscaDesign();
             } catch (SQLException e) {
                 e.printStackTrace();
                 // Lidere com erros de consulta aqui, se necessário
             }
        	
             Image Fundo = new Image(design.getFundoImagem());
             Image Logo = new Image(design.getLogoImagem());
             
        	AlterarComponentes(Fundo, Logo, design.getCorSecundaria(), design.getTipoFonte(),design.getCorSecundaria() , design.getTipoFonte(), design.getCorPrincipal()
        			, design.getCorSecundaria(), design.getCorTerciaria());
        	
        }
	   
	    
	    @FXML
	    void BtnFinalizar(MouseEvent event) throws SQLException {
	    	
	    	if(TxtPalavrasDeRecuperacao1.getText() !=""&& TxtPalavrasDeRecuperacao2.getText() !=""
    			&& TxtPalavrasDeRecuperacao3.getText() !=""&& TxtCpf.getText() != "" &&
    			psfConfirmaNovaSenha.getText() != "" && psfsNovaSenha.getText() != ""){
	    		
	    		if(psfsNovaSenha.getText().equals(psfConfirmaNovaSenha.getText())) {
	    			
	    			
	    			RecuperSenhaModel.AlteraSenha(psfsNovaSenha.getText(), TxtPalavrasDeRecuperacao1.getText()
	    					, TxtPalavrasDeRecuperacao2.getText(), TxtPalavrasDeRecuperacao3.getText());
	    			
	    			

	            } else JOptionPane.showMessageDialog(null, "senha digitada no campo de confirmação não é igual a senha digitada no campo senha");
	    			
	    			
	    			
	    		} else JOptionPane.showMessageDialog(null, "prencha todos os campos");
	    		
	    		
	    		
	    	}
	    	
	    @FXML
	    void EscondeSenhaSenha(MouseEvent event) {

	    	txtSenha.setVisible(false);
	       	 String senha = String.valueOf(psfsNovaSenha.getText());
	       	ImMostra.setVisible(true);
	        ImMostra.setDisable(false);
	        
	        ImEsconde.setVisible(false);
	        ImEsconde.setDisable(true);
	       	 txtSenha.setText(senha);
	           psfsNovaSenha.setVisible(true);
	    	
	    }

	    @FXML
	    void EscondeSenhaSenha1(MouseEvent event) {

	    	txtSenha1.setVisible(false);
	       	 String senha = String.valueOf(psfConfirmaNovaSenha.getText());
	       	ImMostra1.setVisible(true);
	        ImMostra1.setDisable(false);
	        
	        ImEsconde1.setVisible(false);
	        ImEsconde1.setDisable(true);
	       	 txtSenha1.setText(senha);
	           psfConfirmaNovaSenha.setVisible(true);
	    	
	    }

	    @FXML
	    void MostrarSenha(MouseEvent event) {

	    	String senha = String.valueOf(psfsNovaSenha.getText());

	    	txtSenha.setText(senha);
	    	txtSenha.setVisible(true);
	        ImMostra.setVisible(false);
	        ImMostra.setDisable(true);
	        
	        ImEsconde.setVisible(true);
	        ImEsconde.setDisable(false);
	        
	        psfsNovaSenha.setVisible(false);
	    	
	    }

	    @FXML
	    void MostrarSenha1(MouseEvent event) {

	    	String senha = String.valueOf(psfConfirmaNovaSenha.getText());

	    	txtSenha1.setText(senha);
	    	txtSenha1.setVisible(true);
	        ImMostra1.setVisible(false);
	        ImMostra1.setDisable(true);
	        
	        ImEsconde1.setVisible(true);
	        ImEsconde1.setDisable(false);
	        
	        psfConfirmaNovaSenha.setVisible(false);
	    	
	    	
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
	    void vol1(MouseEvent event) throws Exception {
	    	
	    	Main.Cena("Login");
	    	
	    }

	
	
	    public void AlterarComponentes(Image fundo, Image logo, String txtf, String letraTxtf, String btn, String letraBtn,
	            String corPrincipal, String corSecundaria, String corTercearia) {

	        Btnfinal.setStyle(Btnfinal.getStyle() + "-fx-background-color:" + btn + ";");
	        Btnfinal.setStyle(Btnfinal.getStyle() + "-fx-text-fill:" + letraBtn + ";");

	        Logo.setImage(logo);

	        PainelPrincipal.setStyle(PainelPrincipal.getStyle() + "-fx-background-color:" + corPrincipal);

	        barraDeCima.setStyle(barraDeCima.getStyle() + "-fx-background-color:" + corPrincipal);

	        divisor.setStyle(divisor.getStyle() + "-fx-background-color:" + corSecundaria);

	        divisor2.setStyle(divisor2.getStyle() + "-fx-background-color:" + corSecundaria);

	        this.fundo.setImage(fundo);

	        lbl1.setStyle(lbl1.getStyle() + ";-fx-background-color:" + corSecundaria);
	        lbl1.setStyle(lbl1.getStyle() + ";-fx-text-fill:" + letraTxtf);

	        TxtCpf.setStyle(TxtCpf.getStyle() + "-fx-background-color:" + txtf);

	        TxtPalavrasDeRecuperacao1.setStyle(TxtPalavrasDeRecuperacao1.getStyle() + "-fx-background-color:" + txtf);

	        TxtPalavrasDeRecuperacao2.setStyle(TxtPalavrasDeRecuperacao2.getStyle() + "-fx-background-color:" + txtf);

	        TxtPalavrasDeRecuperacao3.setStyle(TxtPalavrasDeRecuperacao3.getStyle() + "-fx-background-color:" + txtf);

	        psfConfirmaNovaSenha.setStyle(psfConfirmaNovaSenha.getStyle() + "-fx-background-color:" + txtf);

	        psfsNovaSenha.setStyle(psfsNovaSenha.getStyle() + "-fx-background-color:" + txtf);

	        txtSenha.setStyle(txtSenha.getStyle() + "-fx-background-color:" + txtf);

	        txtSenha1.setStyle(txtSenha1.getStyle() + "-fx-background-color:" + txtf);

	        TxtCpf.setStyle(TxtCpf.getStyle() + "-fx-text-fill:" + letraTxtf);

	        TxtPalavrasDeRecuperacao1.setStyle(TxtPalavrasDeRecuperacao1.getStyle() + "-fx-text-fill:" + letraTxtf);

	        TxtPalavrasDeRecuperacao2.setStyle(TxtPalavrasDeRecuperacao2.getStyle() + "-fx-text-fill:" + letraTxtf);

	        TxtPalavrasDeRecuperacao3.setStyle(TxtPalavrasDeRecuperacao3.getStyle() + "-fx-text-fill:" + letraTxtf);

	        psfConfirmaNovaSenha.setStyle(psfConfirmaNovaSenha.getStyle() + "-fx-text-fill:" + letraTxtf);

	        psfsNovaSenha.setStyle(psfsNovaSenha.getStyle() + "-fx-text-fill:" + letraTxtf);

	        txtSenha.setStyle(txtSenha.getStyle() + "-fx-text-fill:" + letraTxtf);

	        txtSenha1.setStyle(txtSenha1.getStyle() + "-fx-text-fill:" + letraTxtf);
	    }

    

	}
	
	

