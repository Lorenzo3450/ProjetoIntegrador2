package Principal.Telas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import BancoDeDados.ConexãoBD;
import Principal.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import Ferramentas.EfeitoBtn;

public class TelaDeLoginController {

		
		
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

	    	
	    	//conferindo no banco de dados as informações 
	    	Connection conecao = ConexãoBD.Conexao();
			

			String ComandoSql = "select *from funcionario where email=? and senha=?" ;
			
			
			
			PreparedStatement stmt = conecao.prepareStatement(ComandoSql);
			
			stmt.setString(1, txflogin.getText());
			stmt.setString(2, psfsenha.getText());
			
			ResultSet rs = stmt.executeQuery();
	    	
			if(rs.next()) {
				
				JOptionPane.showMessageDialog(null,"seja bem vindo ");
				
				
			}else JOptionPane.showMessageDialog(null, "erro, Senha ou email incorreto !");
			
			//encerrando a conexão  com o banco;
			stmt.close();
			conecao.close();
			
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