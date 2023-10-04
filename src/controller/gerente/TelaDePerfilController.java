package controller.gerente;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

	EfeitoBtn efeito = new EfeitoBtn();

    @FXML
    private ImageView BtnEncerrarSessao;

    @FXML
    private TextField TxtBairro;

    @FXML
    private TextField TxtCPF;

    @FXML
    private TextField TxtCep;

    @FXML
    private TextField TxtCidade;

    @FXML
    private TextField TxtDataNascimento;

    @FXML
    private TextField TxtEmail;

    @FXML
    private TextField TxtLongradouro;

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtSenha;

    @FXML
    private TextField TxtTelefone;

    @FXML
    private ImageView imgFoto;

    @FXML
    private Label lblTrocarFoto;

 
    @FXML
    private void initialize() throws SQLException {
        int idFuncionario = MainModel.verificaID();
        List<Funcionario> funcionarios = TelaDePerfilDao.getFuncionarioComEndereco(idFuncionario);
        
        
        if (!funcionarios.isEmpty()) {
            Funcionario funcionario = funcionarios.get(0); // Supondo que você obtenha apenas um funcionário
            funcionario.setId(idFuncionario);
            TxtNome.setText(funcionario.getNomeCompleto());
            TxtCPF.setText(funcionario.getCpf());
            TxtDataNascimento.setText(funcionario.getDataNascimento().toString());
            TxtTelefone.setText(funcionario.getTelefone());
            TxtEmail.setText(funcionario.getEmail());
            TxtSenha.setText(funcionario.getSenha());
            // Preencha os campos de endereço
            TxtLongradouro.setText(funcionario.getEndereco().getLogradouro());
            TxtBairro.setText(funcionario.getEndereco().getBairro());
            TxtCep.setText(funcionario.getEndereco().getCep());
            TxtCidade.setText(funcionario.getEndereco().getCidade());

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
    void Entrar7(MouseEvent event) {

    	BtnEncerrarSessao.setEffect(efeito.Efeito());
    	
    }


    @FXML
    void RealizarAlteração(MouseEvent event) throws SQLException {
        int idFuncionario = MainModel.verificaID();
        List<Funcionario> funcionarios = TelaDePerfilDao.getFuncionarioComEndereco(idFuncionario);

        if (!funcionarios.isEmpty()) {
            Funcionario funcionario = funcionarios.get(0);

            // Atualize as informações do funcionário com os valores dos campos TextField
            funcionario.setNomeCompleto(TxtNome.getText());
            funcionario.setCpf(TxtCPF.getText());
            funcionario.setDataNascimento(LocalDate.parse(TxtDataNascimento.getText()));
            funcionario.setTelefone(TxtTelefone.getText());
            funcionario.setEmail(TxtEmail.getText());
            funcionario.setSenha(TxtSenha.getText());
            funcionario.setId(idFuncionario);

            // Atualize as informações do endereço
            Endereco endereco = funcionario.getEndereco();
            endereco.setLogradouro(TxtLongradouro.getText());
            endereco.setBairro(TxtBairro.getText());
            endereco.setCep(TxtCep.getText());
            endereco.setCidade(TxtCidade.getText());

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
    
    @FXML
    void Sair7(MouseEvent event) {

    	BtnEncerrarSessao.setEffect(null);
    	
    }
    
    
}