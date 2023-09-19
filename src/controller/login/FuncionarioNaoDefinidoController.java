package controller.login;


import controller.Ferramentas.EfeitoBtn;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class FuncionarioNaoDefinidoController {

	EfeitoBtn efeito = new EfeitoBtn();

	
    @FXML
    private Button Btn;

    @FXML
    void EntrarBtn(MouseEvent event) {

    	Btn.setEffect(efeito.Efeito());
    	
    }

    @FXML
    void SairBtn(MouseEvent event) {

    	Btn.setEffect(null);
    	
    }

    @FXML
    void Voltar(MouseEvent event) {

    	Stage stage = (Stage) Btn.getScene().getWindow(); // Obtém o palco atual
        stage.close();
    	
    }

}
