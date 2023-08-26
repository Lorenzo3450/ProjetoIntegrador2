package controller.login;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import model.dao.ConexãoBD;
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
    		
    
				//cadastro no banco de dados os dados;
    		
    			Connection conecao = ConexãoBD.Conexao();
    			
    			String ComandoSql1 = " insert into funcionario (nome_completo,cpf,data_nasc,"
    					+ "telefone, email, senha,cargo) values (?, ?, ?, ?, ?, ?,?)";
    			
    			String ComandoSql2 = "insert into endereco(logradouro,bairro,cep,cidade) values (?, ?, ?, ?)";
    			
    			String ComandoSql3 = "insert into perguntas(nome_meio_mae,primeira_escola,apelido_infancia) values (? , ?, ?)";
    			
    			
    			
    			PreparedStatement stmt1 = conecao.prepareStatement(ComandoSql1);
    			PreparedStatement stmt2 = conecao.prepareStatement(ComandoSql2);
    			PreparedStatement stmt3 = conecao.prepareStatement(ComandoSql3);
    			
    			stmt1.setString(1, TxtNome.getText());
    			stmt1.setString(2, TxtCpf.getText());
    			stmt1.setString(3, TrocaData.trocaData(TxtDataDeNascimento.getText()));
    			stmt1.setString(4, TxtTelefone.getText());
    			stmt1.setString(5, TelaDeCadastroController.email);
    			stmt1.setString(6, TelaDeCadastroController.senha);
    			stmt1.setString(7, "Não definido");
    		
    			
    			stmt2.setString(1, TxtRuaCasaComplemento.getText());
    			stmt2.setString(2, TxtBairro.getText());
    			stmt2.setString(3, TxtCep.getText());
    			stmt2.setString(4, TxtCidade.getText());
    			
    			stmt3.setNString(1, TelaDeCadastroController.txtr1);
    			stmt3.setNString(2, TelaDeCadastroController.txtr2);
    			stmt3.setNString(3, TelaDeCadastroController.txtr3);

    			stmt1.execute();
    			stmt2.execute();
    			stmt3.execute();
    			
    			stmt1.close();
    			stmt2.close();
    			stmt3.close();
    			conecao.close();
    			
    			JOptionPane.showMessageDialog(null, "dados cadastrados com sucesso");

    			
    	
    				//troca para tela de login
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
