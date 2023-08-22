package Principal.Telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import BancoDeDados.ConexãoBD;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Task;
import Principal.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import Ferramentas.EfeitoBtn;

public class TelaDeLoginController {

	  @FXML
	    private ImageView ImEsconde;

	    @FXML
	    private ImageView ImMostra;
		
    	EfeitoBtn efeito = new EfeitoBtn();
	
    	@FXML
        private ImageView TxtSenha;

    	 @FXML
    	    private TextField txtsenha;
    	
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
	    private TextField TxtPalavrasDeRecuperacao1;

	    @FXML
	    private TextField TxtPalavrasDeRecuperacao2;

	    @FXML
	    private TextField TxtPalavrasDeRecuperacao3;
	  
	    public class DelayedTask extends Task<Void> {
	        @Override
	        protected Void call() throws Exception {
	            Thread.sleep(5000);
	            return null;
	        }
	    }
	    
	    
	    @FXML
	    void Log1(MouseEvent event) throws Exception{

	    	
	    	//conferindo no banco de dados as informações 
	    	Connection conecao = ConexãoBD.Conexao();
			

			String ComandoSql = "select *from funcionario where email=? and senha=?" ;
			
			
			
			PreparedStatement stmt = conecao.prepareStatement(ComandoSql);
			
			stmt.setString(1, txflogin.getText());
			stmt.setString(2, psfsenha.getText());
			
			ResultSet rs = stmt.executeQuery();
	    	
			if(rs.next()) {
				 String updateSql ="UPDATE sessao SET sessao = ? WHERE id = 1";
                 PreparedStatement updatePs = conecao.prepareStatement(updateSql);
                 updatePs.setInt(1, 1);
                 
                 int lf = updatePs.executeUpdate();
                 
                 updatePs.close();
                 
	            
                 
				Main.Cena("loading");

		        Service<Void> service = new Service<>() {
		            @Override
		            protected Task<Void> createTask() {
		                return new DelayedTask();
		            }
		        };
		        
		        service.setOnSucceeded(e -> {
					try {
						Main.Cena("TelaPrincipalGerente");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
		        service.start();
				
			}else JOptionPane.showMessageDialog(null, "erro, Senha ou email incorreto !");
			
			//encerrando a conexão  com o banco;
			stmt.close();
			conecao.close();
			
	    }

	    @FXML
	    void cliqueRecuperarSenha(MouseEvent event) throws Exception {

	    	Main.Cena("RecuperaSenha");
	    	
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

    

    

    
}