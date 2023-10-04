package controller.Gestor;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Gestor.TelaDeCadastrarProdutoDao;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    private TextField TxtPrecoUnidade;

    @FXML
    private TextField TxtQuantidadeTotal;

    @FXML
    private TextField TxtValidade;

    @FXML
    private TextField TxtVendidoUnidade;
    
    @FXML
    private TextField TxtEstoqueMinimo;

    
    @FXML
    void Vol1(MouseEvent event) throws Exception {
    	
    	Main.Cena("MenuGestor");
    	
    }

    @FXML
    void Salvar(MouseEvent event) {
        // Obtenha os valores dos campos de entrada
        String codigoDeBarras = TxtCodigoDeBarras.getText();
        String descricao = TxtDescricao.getText();
        String precoUnidade = TxtPrecoUnidade.getText();
        String quantidadeTotal = TxtQuantidadeTotal.getText();
        String validade = TxtValidade.getText();
        String vendidoUnidade = TxtVendidoUnidade.getText();
        String Estoque_Minimo = TxtEstoqueMinimo.getText();

        try {
            // Obtenha a data da compra como uma string do campo de entrada
            String dataCompraStr = TxtDataCompra.getText();

            // Formate a data da compra para o formato "yyyy-MM-dd"
            SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd");

            Date dataCompra = sdfInput.parse(dataCompraStr);
            String dataCompraFormatada = sdfOutput.format(dataCompra);

            // Formate a data da validade para o formato "yyyy-MM-dd"
            Date validadeDate = sdfInput.parse(validade);
            String validadeFormatada = sdfOutput.format(validadeDate);

            // Crie uma instância do DAO
            TelaDeCadastrarProdutoDao produtoDao = new TelaDeCadastrarProdutoDao();

            // Chame o método de cadastro de produto
            produtoDao.cadastraProduto(codigoDeBarras, dataCompraFormatada, descricao, precoUnidade, quantidadeTotal, validadeFormatada, vendidoUnidade, Estoque_Minimo);

            // Exiba uma mensagem de sucesso
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Cadastro de Produto");
            alert.setHeaderText(null);
            alert.setContentText("Produto cadastrado com sucesso!");
            alert.showAndWait();

            // Limpe os campos após o cadastro
            LimparCampos();

        } catch (ParseException e) {
            // Em caso de erro na conversão de data, exiba uma mensagem de erro
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Formato de data inválido. Use o formato dd/MM/yyyy.");
            alert.showAndWait();
        } catch (Exception e) {
            // Em caso de erro, exiba uma mensagem de erro
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Ocorreu um erro ao cadastrar o produto.");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    
    
    // Método para limpar os campos após o cadastro
    private void LimparCampos() {
        TxtCodigoDeBarras.clear();
        TxtDataCompra.clear();
        TxtDescricao.clear();
        TxtPrecoUnidade.clear();
        TxtQuantidadeTotal.clear();
        TxtValidade.clear();
        TxtVendidoUnidade.clear();
        TxtEstoqueMinimo.clear();
    }
}