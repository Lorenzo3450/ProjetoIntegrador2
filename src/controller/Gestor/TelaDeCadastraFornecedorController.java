package controller.Gestor;

import java.io.IOException;
import java.sql.SQLException;

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
import model.Gestor.TelaDeCadastrarFornecedoDao;

public class TelaDeCadastraFornecedorController {

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
    private TextField TxtEmail;

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtTelefone;

    @FXML
    private TextField TxtTelefone1;

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
    void Cadastrar(MouseEvent event) throws SQLException {

    	
    	TelaDeCadastrarFornecedoDao.cadastrarFornecedor(TxtNome.getText(), TxtEmail.getText(), TxtTelefone.getText(), TxtTelefone1.getText());
    	
    }

}
