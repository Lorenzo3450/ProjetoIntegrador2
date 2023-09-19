package controller.Gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TeladeCadastraProdutoController {

    @FXML
    private ImageView BtnSalvar;

    @FXML
    private TextField TxtCodigoDeBarras;

    @FXML
    private TextField TxtDataCompra;

    @FXML
    private TextField TxtDescricao;

    @FXML
    private TextField TxtEstoqueMinimo;

    @FXML
    private TextField TxtFornecedor;

    @FXML
    private TextField TxtLucroPorcentagem;

    @FXML
    private TextField TxtLucroReais;

    @FXML
    private TextField TxtPrecoUnidade;

    @FXML
    private TextField TxtPrecoVenda;

    @FXML
    private TextField TxtUnidade;

    @FXML
    private TextField TxtValidade;


    @FXML
    void Salvar(ActionEvent event) {
        String codigoDeBarras = TxtCodigoDeBarras.getText();
        String dataCompra = TxtDataCompra.getText();
        String descricao = TxtDescricao.getText();

        // Valide os campos aqui, se necessário

        try {
            // Conectar ao banco de dados (substitua as informações de conexão conforme necessário)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/seubanco", "seuusuario", "suasenha");

            // Preparar a consulta SQL para inserir os dados na tabela de produtos
            String sql = "INSERT INTO produtos (codigo_de_barras, data_compra, descricao) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, codigoDeBarras);
            stmt.setString(2, dataCompra);
            stmt.setString(3, descricao);

            // Execute a consulta SQL
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                mostrarAlerta("Produto salvo com sucesso.");
            } else {
                mostrarAlerta("Erro ao salvar o produto.");
            }

            // Fechar a conexão com o banco de dados
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            mostrarAlerta("Erro ao salvar o produto: " + e.getMessage());
        }
    }

    private void mostrarAlerta(String mensagem) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
    
    
    
    @FXML
    void Vol1(MouseEvent event) {

    }

}
