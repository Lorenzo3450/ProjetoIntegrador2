package controller.Caixa;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PagamentoEmDinheiroController {

    @FXML
    private ImageView ImagemDeFundo;

    @FXML
    private ImageView Logo;

    @FXML
    private AnchorPane PainelDeCima;

    @FXML
    private Label TextoDoPainelDeCima;

    @FXML
    private TextField txtSubTotal;

    @FXML
    private TextField txtTotalRecebido;

    @FXML
    private TextField txtTroco;

    double subtotal;
    
    
    @FXML
    private void initialize() {
       
    	subtotal=TelaDeVendaController.subtotal;
    	txtTotalRecebido.requestFocus();
    }
    
    
    @FXML
    void calcularTroco() {
        try {
            double totalRecebido = Double.parseDouble(txtTotalRecebido.getText());
            double troco = totalRecebido - subtotal;
            txtTroco.setText(String.format("%.2f", troco));
        } catch (NumberFormatException e) {
            // Trate erros de formatação incorreta do valor recebido
            txtTroco.setText("Erro");
        }
    }
    
    
    
    @FXML
    void onTotalRecebidoKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            calcularTroco();
        }
    }
    
    
    
    @FXML
    void AbrirSideBar(MouseEvent event) {
    	
    	 try {
 	        // Carregue a cena da barra lateral a partir do arquivo FXML
 	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/gerente/SideBarGerente.fxml"));
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
