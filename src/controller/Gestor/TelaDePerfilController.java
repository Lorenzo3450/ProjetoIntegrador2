package controller.Gestor;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Endereco;
import model.Funcionario;
import model.InformacoesDoSuperMercado;
import model.dao.ConexãoBD;
import model.dao.Gerente.TelaDePerfilDao;
import model.dao.login.MainModel;

public class TelaDePerfilController {

    @FXML
    private ImageView ImagemDeFundo;

    @FXML
    private ImageView Logo;

    @FXML
    private AnchorPane PainelDeCima;

    @FXML
    private AnchorPane PainelPrincipal;

    @FXML
    private AnchorPane PainelPrincipal1;

    @FXML
    private Label TextoDoPainelDeCima;

    @FXML
    private ImageView btnLogo;

    @FXML
    private ImageView imgFoto;

    @FXML
    private ImageView imgSideBar;

    @FXML
    private Label lbl;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl11;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl41;

    @FXML
    private Label lbl42;

    @FXML
    private Label lbl44;

    @FXML
    private Label lbl441;

    @FXML
    private Label lbl442;

    @FXML
    private Label lbl4421;

    @FXML
    private Label lbl44211;

    @FXML
    private Label lbl442112;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblsenha;

    @FXML
    private Line linha1;

    @FXML
    private Line linha2;

    @FXML
    private Line linha3;

    @FXML
    private Line linha4;

    @FXML
    private Label trocaFoto;

    @FXML
    private TextField txtBairro;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtCep;

    @FXML
    private TextField txtCidade;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtEmailComercial;

    @FXML
    private TextField txtLogradouro;

    @FXML
    private TextField txtNascimento;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSenha;

    @FXML
    private TextField txtSenhaEmail;

    @FXML
    private TextField txtTelefone;

    @FXML
    public void initialize() throws SQLException {
        int idFuncionario = MainModel.verificaID();
        List<Funcionario> funcionarios = TelaDePerfilDao.getFuncionarioComEndereco(idFuncionario);

        
        if (!funcionarios.isEmpty()) {
            Funcionario funcionario = funcionarios.get(0); 
            funcionario.setId(idFuncionario);
            txtNome.setText(funcionario.getNomeCompleto());
            txtCPF.setText(funcionario.getCpf());
            txtNascimento.setText(funcionario.getDataNascimento().toString());
            txtTelefone.setText(funcionario.getTelefone());
            txtEmail.setText(funcionario.getEmail());
            txtSenha.setText(funcionario.getSenha());
            // Preencha os campos de endereço
            txtLogradouro.setText(funcionario.getEndereco().getLogradouro());
            txtBairro.setText(funcionario.getEndereco().getBairro());
            txtCep.setText(funcionario.getEndereco().getCep());
            txtCidade.setText(funcionario.getEndereco().getCidade());
            
            if(txtEmailComercial !=null && txtSenhaEmail != null) {
           	 txtEmailComercial.setText(funcionario.getEmailDeTrabalho());
                txtSenhaEmail.setText(funcionario.getSenhaEmail());
           }
           
            
        }
        

        
    }
    

    
    @FXML
    void trocaFoto(MouseEvent event) {
        // Configurar o FileChooser para filtrar arquivos de imagem
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Imagens", "*.jpg", "*.png", "*.jpeg"));

        // Mostrar o diálogo de seleção de arquivo
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            imgFoto.setImage(new Image(selectedFile.toURI().toString()));     
        }
    }
    
   

    @FXML
    void vol1(MouseEvent event) throws Exception {

    	Main.Cena("TelaPrincipalGerente");
    	
    }

    @FXML
    void EncerrarSessao(MouseEvent event) throws Exception {

    	
    	Connection conecao = ConexãoBD.Conexao();
    	String updateSql ="UPDATE sessao SET sessao = ? WHERE id = 1";
        PreparedStatement updatePs = conecao.prepareStatement(updateSql);
        updatePs.setInt(1, 0);
        int lf = updatePs.executeUpdate();
        
        updatePs.close();
        conecao.close();
        
        Main.Cena("Login");
    	
    	
    	
    }




    @FXML
    void RealizarAlteracao(MouseEvent event) throws SQLException {
        int idFuncionario = MainModel.verificaID();
        List<Funcionario> funcionarios = TelaDePerfilDao.getFuncionarioComEndereco(idFuncionario);

        if (!funcionarios.isEmpty()) {
            Funcionario funcionario = funcionarios.get(0);

            // Atualize as informações do funcionário com os valores dos campos TextField
            funcionario.setNomeCompleto(txtNome.getText());
            funcionario.setCpf(txtCPF.getText());
            funcionario.setDataNascimento(LocalDate.parse(txtNascimento.getText()));
            funcionario.setTelefone(txtTelefone.getText());
            funcionario.setEmail(txtEmail.getText());
            funcionario.setSenha(txtSenha.getText());
            funcionario.setId(idFuncionario);
            funcionario.setEmailDeTrabalho(txtEmailComercial.getText());
            funcionario.setSenhaEmail(txtSenhaEmail.getText());
            

            // Atualize as informações do endereço
            Endereco endereco = funcionario.getEndereco();
            endereco.setLogradouro(txtLogradouro.getText());
            endereco.setBairro(txtBairro.getText());
            endereco.setCep(txtCep.getText());
            endereco.setCidade(txtCidade.getText());
            

            
            

            // Agora, chame o método para atualizar o funcionário no banco de dados
            boolean atualizacaoSucesso = TelaDePerfilDao.atualizarPadrao(funcionario);

            if (atualizacaoSucesso) {
                // Atualização bem-sucedida, você pode exibir uma mensagem de sucesso
                JOptionPane.showMessageDialog(null, "As informações foram atualizadas com sucesso.");
            } else {
            	 JOptionPane.showMessageDialog(null, "Falha na atualização das informações.");
                
            }
        }
    }
    

    
    @FXML
    void IrParaPersolizaSistema(MouseEvent event) throws Exception {
    	
    	Main.Cena("PersonalizaSistema");
    	
    }

    
    @FXML
    void AbrirSideBar(MouseEvent event) {

	 try {
	        // Carregue a cena da barra lateral a partir do arquivo FXML
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Gestor/SideBarGestor.fxml"));
	        AnchorPane sideBarRoot = loader.load();

	        // Crie uma nova janela para exibir a cena da barra lateral
	        Stage sideBarStage = new Stage();
	        sideBarStage.initStyle(StageStyle.UNDECORATED);
	        Scene sideBarScene = new Scene(sideBarRoot);
	        sideBarStage.setScene(sideBarScene);

	        sideBarStage.setX(0);
	        sideBarStage.setY(0);
	        // Exiba a janela da barra lateral
	        sideBarStage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	
}

}
