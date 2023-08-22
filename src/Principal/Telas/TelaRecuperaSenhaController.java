	package Principal.Telas;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BancoDeDados.ConexãoBD;
import Ferramentas.EfeitoBtn;
import Principal.Main;
import javafx.fxml.FXML;
	import javafx.scene.control.PasswordField;
	import javafx.scene.control.TextField;
	import javafx.scene.image.ImageView;
	import javafx.scene.input.KeyEvent;
	import javafx.scene.input.MouseEvent;

	public class TelaRecuperaSenhaController {

		EfeitoBtn efeito = new EfeitoBtn();
		
	    @FXML
	    private ImageView Btnfinal;

	    @FXML
	    private ImageView ImEsconde;

	    @FXML
	    private ImageView ImEsconde1;

	    @FXML
	    private ImageView ImMostra;

	    @FXML
	    private ImageView ImMostra1;
	    
	    @FXML
	    private TextField TxtCpf;

	    @FXML
	    private TextField TxtPalavrasDeRecuperacao1;

	    @FXML
	    private TextField TxtPalavrasDeRecuperacao2;

	    @FXML
	    private TextField TxtPalavrasDeRecuperacao3;

	    @FXML
	    private PasswordField psfConfirmaNovaSenha;

	    @FXML
	    private PasswordField psfsNovaSenha;
	    
	    @FXML
	    private TextField txtSenha;

	    @FXML
	    private TextField txtSenha1;

	    @FXML
	    void BtnFinalizar(MouseEvent event) throws SQLException {
	    	
	    	if(TxtPalavrasDeRecuperacao1.getText() !=""&& TxtPalavrasDeRecuperacao2.getText() !=""
    			&& TxtPalavrasDeRecuperacao3.getText() !=""&& TxtCpf.getText() != "" &&
    			psfConfirmaNovaSenha.getText() != "" && psfsNovaSenha.getText() != ""){
	    		
	    		if(psfsNovaSenha.getText().equals(psfConfirmaNovaSenha.getText())) {
	    			
	    			//conferindo no banco de dados as informações 
	    	    	Connection conecao = ConexãoBD.Conexao();
	    			
	    	    	String selectSql = "SELECT id_senha FROM perguntas WHERE nome_meio_mae = ? AND primeira_escola = ? AND apelido_infancia = ?";
	                PreparedStatement selectPs = conecao.prepareStatement(selectSql);
	                selectPs.setString(1,TxtPalavrasDeRecuperacao1.getText() );
	                selectPs.setString(2, TxtPalavrasDeRecuperacao2.getText());
	                selectPs.setString(3, TxtPalavrasDeRecuperacao3.getText());
	                
	                System.out.println(TxtPalavrasDeRecuperacao1.getText());
	                System.out.println(TxtPalavrasDeRecuperacao2.getText());
	                System.out.println(TxtPalavrasDeRecuperacao3.getText());
	                
	                ResultSet resultSet = selectPs.executeQuery();

	                if (resultSet.next()) {
	                    int idSenha = resultSet.getInt("id_senha");

	                    String updateSql = "UPDATE funcionario SET senha = ? WHERE id = ?";
	                    PreparedStatement updatePs = conecao.prepareStatement(updateSql);
	                    updatePs.setString(1,psfsNovaSenha.getText()  );
	                    updatePs.setInt(2, idSenha);

	                    int lf = updatePs.executeUpdate();

	                    if (lf > 0) {
	                        JOptionPane.showMessageDialog(null, "Senha alterada com sucesso");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Senha não trocada");
	                    }

	                    updatePs.close();
	                } else {
	                    JOptionPane.showMessageDialog(null, "As respostas não correspondem ou ocorreu um erro");
	                }

	                selectPs.close();
	                conecao.close();

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

	}

	
	

