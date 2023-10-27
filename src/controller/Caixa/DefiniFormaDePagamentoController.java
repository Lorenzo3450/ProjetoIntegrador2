package controller.Caixa;

import java.io.IOException;

import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;


public class DefiniFormaDePagamentoController {

    @FXML
    private AnchorPane Painel;
	
    @FXML
    private ImageView ImagemDeFundo;

    @FXML
    private Label Lbl;

    @FXML
    private Label Lbl1;

    @FXML
    private Label Lbl2;

    @FXML
    private Label Lbl3;

    @FXML
    private Label Lbl4;

    @FXML
    private Label Lbl5;

    @FXML
    private ImageView Logo;

    @FXML
    private AnchorPane PainelDeCima;

    @FXML
    private AnchorPane PainelPrincipal;

    @FXML
    private Label TextoDoPainelDeCima;
    
    
    
    @FXML
    void AbrirSideBar(MouseEvent event) {

    	Painel.requestFocus();
    	
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
    
    public void initialize() {
    	
    	

 	   Painel.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
 	        if (event.getCode() == KeyCode.DIGIT4) {
 	           try {
					Main.Cena("DefiniFormaDePagamento");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 	            System.out.println("Tecla F12 foi pressionada");
 	        }
 	    });
    }
    

}
