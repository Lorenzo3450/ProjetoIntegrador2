package controller.gerente;

import javafx.fxml.FXML;


import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Endereco;
import model.Funcionario;
import model.dao.ConexãoBD;
import model.dao.Gerente.TelaDePerfilDao;
import model.dao.login.MainModel;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import controller.Main;
import controller.Ferramentas.EfeitoBtn;

public class TelaDePerfilController {

    @FXML
    private ImageView AlterarFotoIcon;
    
    @FXML
    private ImageView FotoDoPerfil;

    @FXML
    private ImageView ImagemDeFundo;

    @FXML
    private Label LabelAlterarfoto;

    @FXML
    private ImageView Logo;

    @FXML
    private AnchorPane PainelDaFoto;

    @FXML
    private AnchorPane PainelDeCima;

    @FXML
    private AnchorPane PainelDosDados;

    @FXML
    private ImageView abrirSideBar;

    @FXML
    private PasswordField senha;

    @FXML
    private TextField txfBairro;

    @FXML
    private TextField txfCEP;

    @FXML
    private TextField txfCPF;

    @FXML
    private TextField txfCidade;

    @FXML
    private TextField txfDataNascimento;

    @FXML
    private TextField txfEmail;

    @FXML
    private TextField txfNome;

    @FXML
    private TextField txfRua_Casa;

    @FXML
    private TextField txfTelefone;

    @FXML
    private Text txtBairro;

    @FXML
    private Text txtCEP;

    @FXML
    private Text txtCPF;

    @FXML
    private Text txtCidade;

    @FXML
    private Text txtDadosPesssoais;

    @FXML
    private Text txtDataNascimento;

    @FXML
    private Text txtEmail;

    @FXML
    private Text txtEndereço;

    @FXML
    private Text txtNome;

    @FXML
    private Text txtLogradouro;

    @FXML
    private Text txtSenha;

    @FXML
    private Text txtTelefone;

 
    @FXML
    private void initialize() throws SQLException {
        int idFuncionario = MainModel.verificaID();
        List<Funcionario> funcionarios = TelaDePerfilDao.getFuncionarioComEndereco(idFuncionario);
        
        
        if (!funcionarios.isEmpty()) {
            Funcionario funcionario = funcionarios.get(0); // Supondo que você obtenha apenas um funcionário
            funcionario.setId(idFuncionario);
            txtNome.setText(funcionario.getNomeCompleto());
            txtCPF.setText(funcionario.getCpf());
            txtDataNascimento.setText(funcionario.getDataNascimento().toString());
            txtTelefone.setText(funcionario.getTelefone());
            txtEmail.setText(funcionario.getEmail());
            txtSenha.setText(funcionario.getSenha());
            // Preencha os campos de endereço
            txtLogradouro.setText(funcionario.getEndereco().getLogradouro());
            txtBairro.setText(funcionario.getEndereco().getBairro());
            txtCEP.setText(funcionario.getEndereco().getCep());
            txtCidade.setText(funcionario.getEndereco().getCidade());

            // Exemplo: TxtBairro.setText(funcionario.getEndereco().getBairro());
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
            FotoDoPerfil.setImage(new Image(selectedFile.toURI().toString()));     
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
    void RealizarAlteração(MouseEvent event) throws SQLException {
        int idFuncionario = MainModel.verificaID();
        List<Funcionario> funcionarios = TelaDePerfilDao.getFuncionarioComEndereco(idFuncionario);

        if (!funcionarios.isEmpty()) {
            Funcionario funcionario = funcionarios.get(0);

            // Atualize as informações do funcionário com os valores dos campos TextField
            funcionario.setNomeCompleto(txtNome.getText());
            funcionario.setCpf(txtCPF.getText());
            funcionario.setDataNascimento(LocalDate.parse(txtDataNascimento.getText()));
            funcionario.setTelefone(txtTelefone.getText());
            funcionario.setEmail(txtEmail.getText());
            funcionario.setSenha(txtSenha.getText());
            funcionario.setId(idFuncionario);

            // Atualize as informações do endereço
            Endereco endereco = funcionario.getEndereco();
            endereco.setLogradouro(txtLogradouro.getText());
            endereco.setBairro(txtBairro.getText());
            endereco.setCep(txtCEP.getText());
            endereco.setCidade(txtCidade.getText());

            // Agora, chame o método para atualizar o funcionário no banco de dados
            boolean atualizacaoSucesso = TelaDePerfilDao.atualizarFuncionario(funcionario);

            if (atualizacaoSucesso) {
                // Atualização bem-sucedida, você pode exibir uma mensagem de sucesso
                System.out.println("As informações foram atualizadas com sucesso.");
            } else {
                // Trate o caso em que a atualização falhou
                System.out.println("Falha na atualização das informações.");
            }
        }
    }
    
    
}
