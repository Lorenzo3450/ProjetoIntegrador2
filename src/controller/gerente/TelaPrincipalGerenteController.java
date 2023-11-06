package controller.gerente;

import java.net.URL;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import model.dao.ConexãoBD;
import controller.Ferramentas.EfeitoBtn;
import controller.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;

public class TelaPrincipalGerenteController {

	EfeitoBtn efeito = new EfeitoBtn();
	
	   @FXML
	    private ImageView FuncionariosIcon;

	    @FXML
	    private ImageView ImagemDeFundo;

	    @FXML
	    private ImageView InicioIcon;

	    @FXML
	    private ImageView Logo;

	    @FXML
	    private ImageView LogoSideBar;

	    @FXML
	    private AnchorPane PainelDeCima;

	    @FXML
	    private ImageView ProdutosIcon;

	    @FXML
	    private ImageView RelatoriosABCicon;

	    @FXML
	    private ImageView RelatoriosIcon;

	    @FXML
	    private Pane SideBar;

	    @FXML
	    private ImageView VendasIcon;

	    @FXML
	    private ImageView fecharSideBar;

	    @FXML
	    private ImageView perfil_Icon;

	    @FXML
	    private Label txtFuncionarios;

	    @FXML
	    private Label txtInicio;

	    @FXML
	    private Label txtPerfil;

	    @FXML
	    private Label txtProdutos;

	    @FXML
	    private Label txtRelatorios;

	    @FXML
	    private Label txtRelatoriosABC;

	    @FXML
	    private Label txtVendas;
	    
	    @FXML
	    private ImageView abrirSideBar;

		private Stage stage;

   
    private static class DelayService extends Service<Void> {
        private final Duration duration;

        public DelayService(Duration duration) {
            this.duration = duration;
        }

        @Override
        protected Task<Void> createTask() {
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    Thread.sleep((long) duration.toMillis());
                    return null;
                }
            };
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    void initialize() {
    	
    	fecharSideBar.setOnMouseClicked(event -> {
            System.exit(0);
        });
        
    	AbrirSideBar();
    	
    	  if (stage != null) {
              stage.initStyle(StageStyle.UNDECORATED);
          }
    	
    }

    @FXML
    void AbrirSideBar() {

         SideBar.setVisible(false);

         FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5),SideBar);
         fadeTransition.setFromValue(1);
         fadeTransition.setToValue(0);
         fadeTransition.play();

         TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),SideBar);
         translateTransition.setByX(-600);
         translateTransition.play();

         abrirSideBar.setOnMouseClicked(event -> {


             SideBar.setVisible(true);

             FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),SideBar);
             fadeTransition1.setFromValue(0);
             fadeTransition1.setToValue(0.15);
             fadeTransition1.play();

             TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),SideBar);
             translateTransition1.setByX(+600);
             translateTransition1.play();
         });

         SideBar.setOnMouseClicked(event -> {



             FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),SideBar);
             fadeTransition1.setFromValue(0.15);
             fadeTransition1.setToValue(0);
             fadeTransition1.play();

             fadeTransition1.setOnFinished(event1 -> {
                 SideBar.setVisible(false);
             });


             TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5),SideBar);
             translateTransition1.setByX(-600);
             translateTransition1.play();
         });
     }
}

    

    


}
