package controller.gerente;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.imageio.ImageIO;
import controller.Main;
import controller.Ferramentas.EfeitoBtn;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import model.Endereco;
import model.Funcionario;
import model.PerfilGeralModel;
import model.dao.ConexãoBD;
import model.dao.Gerente.TelaDePerfilDao;
import model.dao.login.MainModel;

public class TelaDePerfilController {
    @FXML
    private Button BtnEncerrarSessao;

    EfeitoBtn efeito = new EfeitoBtn();
    
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

    private Connection conex;
    private TelaDePerfilDao perfilGeralDAO;
    private int idFuncionario;
    private PerfilGeralModel pgm;

    public TelaDePerfilController() throws SQLException {
        conex = ConexãoBD.Conexao();
        pgm = new PerfilGeralModel();
        perfilGeralDAO = new TelaDePerfilDao(conex, pgm);
    }

    @FXML
    private void initialize() throws SQLException {
        int idFuncionario = MainModel.verificaID();
        setIdFuncionario(idFuncionario); // Carrega a imagem do perfil no início da janela
        List<Funcionario> funcionarios = TelaDePerfilDao.getFuncionarioComEndereco(idFuncionario);

        if (!funcionarios.isEmpty()) {
            Funcionario funcionario = funcionarios.get(0);
            funcionario.setId(idFuncionario);

            TxtNome.setText(funcionario.getNomeCompleto());
            TxtCPF.setText(funcionario.getCpf());
            TxtDataNascimento.setText(funcionario.getDataNascimento().toString());
            TxtTelefone.setText(funcionario.getTelefone());
            TxtEmail.setText(funcionario.getEmail());
            TxtSenha.setText(funcionario.getSenha());
            TxtLongradouro.setText(funcionario.getEndereco().getLogradouro());
            TxtBairro.setText(funcionario.getEndereco().getBairro());
            TxtCep.setText(funcionario.getEndereco().getCep());
            TxtCidade.setText(funcionario.getEndereco().getCidade());
        }
    }

    @FXML
    void trocaFoto(MouseEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Imagens", "*.jpg", "*.png", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(new Stage());

        if (selectedFile != null) {
            try {
                // Ler os dados da imagem como um array de bytes
                File file = new File(selectedFile.toURI());
                FileInputStream inputStream = new FileInputStream(file);
                byte[] imageData = new byte[(int) file.length()];
                inputStream.read(imageData);
                inputStream.close();

                // Atualizar a imagem exibida na tela
                Image novaImagem = new Image(selectedFile.toURI().toString());
                imgFoto.setImage(novaImagem);

                // Atualizar a imagem no banco de dados
                pgm.setId(idFuncionario); // Defina o ID do funcionário
                pgm.setFotoPerfil(imageData);
                if (perfilGeralDAO.salvarFotoPerfil(pgm)) {
                    System.out.println("A foto do perfil foi salva com sucesso.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                // Trate as exceções aqui, se necessário.
            }
        }
    }

    @FXML
    void vol1(MouseEvent event) throws Exception {
        Main.Cena("TelaPrincipalGerente");
    }

    @FXML
    void EncerrarSessao(MouseEvent event) throws Exception {
        salvarFotoPerfil(); // Salva a foto do perfil ao encerrar a sessão
        Connection conecao = ConexãoBD.Conexao();
        String updateSql = "UPDATE sessao SET sessao = ? WHERE id = 1";
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

            funcionario.setNomeCompleto(TxtNome.getText());
            funcionario.setCpf(TxtCPF.getText());
            funcionario.setDataNascimento(LocalDate.parse(TxtDataNascimento.getText()));
            funcionario.setTelefone(TxtTelefone.getText());
            funcionario.setEmail(TxtEmail.getText());
            funcionario.setSenha(TxtSenha.getText());
            funcionario.setId(idFuncionario);

            Endereco endereco = funcionario.getEndereco();
            endereco.setLogradouro(TxtLongradouro.getText());
            endereco.setBairro(TxtBairro.getText());
            endereco.setCep(TxtCep.getText());
            endereco.setCidade(TxtCidade.getText());

            boolean atualizacaoSucesso = TelaDePerfilDao.atualizarFuncionario(funcionario);

            if (atualizacaoSucesso) {
                System.out.println("As informações foram atualizadas com sucesso.");
            } else {
                System.out.println("Falha na atualização das informações.");
            }
        }
    }

    @FXML
    void Sair7(MouseEvent event) {
        BtnEncerrarSessao.setEffect(null);
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
        byte[] imagemData = perfilGeralDAO.carregarFoto(idFuncionario);
        if (imagemData != null) {
            Image imagem = new Image(new ByteArrayInputStream(imagemData));
            imgFoto.setImage(imagem);
        }
    }
    public void salvarFotoPerfil() {
        if (idFuncionario > 0) {
            try {
                // Obtenha a imagem atual do ImageView
                Image imagem = imgFoto.getImage();

                if (imagem != null) {
                    // Converta a imagem em um array de bytes
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    BufferedImage bImage = SwingFXUtils.fromFXImage(imagem, null);
                    ImageIO.write(bImage, "png", byteArrayOutputStream);
                    byte[] imageData = byteArrayOutputStream.toByteArray();

                    // Salve a imagem no banco de dados
                    perfilGeralDAO.salvarFotoPerfil(idFuncionario, imageData);
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Lide com exceções, se necessário
            }
        }
    }
}

