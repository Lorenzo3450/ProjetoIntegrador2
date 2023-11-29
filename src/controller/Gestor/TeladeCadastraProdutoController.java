package controller.Gestor;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Gestor.TelaDeCadastrarProdutoDao;

public class TeladeCadastraProdutoController {

    @FXML
    private Button BtnEnviar;

    @FXML
    private ImageView ImagemDeFundo;

    @FXML
    private ImageView Logo;

    @FXML
    private AnchorPane PainelDeCima;

    @FXML
    private AnchorPane PainelPrincipal;

    @FXML
    private Label TextoDoPainelDeCima;

    @FXML
    private Label TextoDoPainelDeCima1;

    @FXML
    private TextField TxtCodigoDeBarras;

    @FXML
    private TextField TxtDataCompra;

    @FXML
    private TextField TxtDescricao;

    @FXML
    private TextField TxtFornecedor;

    @FXML
    private TextField TxtMarcaDoProduto;

    @FXML
    private TextField TxtQtdAdquirida;

    @FXML
    private TextField TxtQtdCompraAutomatica;

    @FXML
    private TextField TxtQtdMinima;

    @FXML
    private TextField TxtSetor;

    @FXML
    private TextField TxtValidade;

    @FXML
    private TextField TxtValorCompra;

    @FXML
    private TextField TxtValorDeVenda;

    @FXML
    void initialize() {
    	
    	TxtQtdCompraAutomatica.setText("0");
    	
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

    @FXML
    void AtivarCompraAutomatica(MouseEvent event) {

    	TxtQtdCompraAutomatica.setEditable(true);
    	
    	
    }

    @FXML
    void Cadastrar(MouseEvent event) {
        try {
        	
            String descricao = TxtDescricao.getText();
            String dataCompra = TxtDataCompra.getText();
            String validade = TxtValidade.getText();
            int quantidade = Integer.parseInt(TxtQtdAdquirida.getText());
            float valorCompra = Float.parseFloat(TxtValorCompra.getText());
            float valorVenda = Float.parseFloat(TxtValorDeVenda.getText());
            String marcaProduto = TxtMarcaDoProduto.getText();
            String codigoProduto = TxtCodigoDeBarras.getText();
            int idFornecedor = Integer.parseInt(TxtFornecedor.getText());
            int idSecao = Integer.parseInt(TxtSetor.getText());
            
            int estoqueMinimo = Integer.parseInt(TxtQtdMinima.getText());
            int quantidadeDaCompra = Integer.parseInt(TxtQtdCompraAutomatica.getText());

            TelaDeCadastrarProdutoDao.cadastrarProduto(
                    descricao, dataCompra, validade, quantidade, valorCompra, valorVenda,
                    marcaProduto, codigoProduto, idFornecedor, idSecao,
                    estoqueMinimo, quantidadeDaCompra
            );

            // Adicione aqui qualquer lógica adicional após o cadastro, se necessário.

        } catch (Exception e) {
            e.printStackTrace();  // Trate a exceção de forma adequada para o seu aplicativo.
        }
    }
}

