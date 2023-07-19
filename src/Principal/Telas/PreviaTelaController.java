package Principal.Telas;

import Principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class PreviaTelaController {

	
	
    @FXML
    private AnchorPane Painel;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnLogar;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    void Cadatro(ActionEvent event) throws Exception {
    	
    	Main.Cena("Cadastro");
    	
    }

    @FXML
    void Logar(ActionEvent event) throws Exception {
    	
    	Main.Cena("Login");
    	

    }

}
