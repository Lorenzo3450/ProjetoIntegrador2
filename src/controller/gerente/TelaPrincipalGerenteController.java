package controller.gerente;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DesignSistema;
import model.dao.Gerente.PersonalizaSistemaDao;

public class TelaPrincipalGerenteController {

    @FXML
    private ImageView ImagemDeFundo;

    @FXML
    private ImageView Logo;

    @FXML
    private AnchorPane PainelDeCima;

    @FXML
    private Label TextoDoPainelDeCima;
    
    
    @FXML
	private void initialize() {
    	
    	 DesignSistema design = null;
         try {
             design = PersonalizaSistemaDao.buscaDesign();
         } catch (SQLException e) {
             e.printStackTrace();
             // Lidere com erros de consulta aqui, se necessário
         }
    	
         if(design!=null) {
         
         Image Fundo = new Image(design.getFundoImagem());
         Image Logo = new Image(design.getLogoImagem());
         
    	AlterarComponentes(Fundo, Logo, design.getCorSecundaria(), design.getTipoFonte(),design.getCorSecundaria() , design.getTipoFonte(), design.getCorPrincipal()
    			, design.getCorSecundaria(), design.getCorTerciaria());
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
    
    public void AlterarComponentes(Image fundo,Image logo,String txtf,String letraTxtf,String btn,String letraBtn,
			String corPrincipal,String corSecundaria,String corTercearia) {
    	
    	
    		ImagemDeFundo.setImage(fundo);

    		Logo.setImage(logo);
    		
    		PainelDeCima.setStyle("-fx-background-color:"+corPrincipal);

    	   TextoDoPainelDeCima.setStyle("-fx-background-color:"+corSecundaria);
    	   TextoDoPainelDeCima.setStyle("-fx-text-fill:"+letraTxtf);
    	
    	
    }
    

}
