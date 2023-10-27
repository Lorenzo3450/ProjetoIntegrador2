package controller.gerente;

import controller.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SideBarController {

    @FXML
    private ImageView Logo;

    @FXML
    private ImageView Logo1;

    @FXML
    private ImageView Logo11;

    @FXML
    private ImageView Logo111;

    @FXML
    private AnchorPane painelABerto;

    @FXML
    private AnchorPane painelFuncionario;

    @FXML
    private AnchorPane painelRelatorio;
    
    @FXML
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    void initialize() {
        
    	AbrirSideBar(null);
    	
    	  if (stage != null) {
              stage.initStyle(StageStyle.UNDECORATED);
          }
    	
    }

    @FXML
    void AbrirSideBar(MouseEvent event) {

       	painelRelatorio.setVisible(false);
    	painelRelatorio.setDisable(true);
    	painelFuncionario.setVisible(false);
    	painelFuncionario.setDisable(true);
    	painelABerto.setVisible(true);
    	painelABerto.setDisable(false);
    	
    	
    }

    @FXML
    void FecharSideBar(MouseEvent event) {
    	Stage stage = (Stage) painelABerto.getScene().getWindow();
        stage.close();
    }

    @FXML
    void IrParaFuncionarios(MouseEvent event) {

    	painelRelatorio.setVisible(false);
    	painelRelatorio.setDisable(true);
    	painelFuncionario.setVisible(true);
    	painelFuncionario.setDisable(false);
    	painelABerto.setVisible(true);
    	painelABerto.setDisable(false);
    	
    }

    @FXML
    void IrParaGraficoMes(MouseEvent event) throws Exception {

    	System.out.println("mes");

    	Main.Cena("GraficoMes");
    	
    }

    @FXML
    void IrParaGraficoSecao(MouseEvent event) throws Exception {

    	Main.Cena("GraficoSecao");
    	
    }

    @FXML
    void IrParaInicio(MouseEvent event) throws Exception {
    	
    	Main.Cena("TelaPrincipalGerente");
    	
    }

    @FXML
    void IrParaPerfil(MouseEvent event) throws Exception {

    	Main.Cena("TelaDePerfil");
    	
    }

    @FXML
    void IrParaProdutos(MouseEvent event) {

    }

    @FXML
    void IrParaRelatorioABC(MouseEvent event) throws Exception {

    	Main.Cena("TelaRelatorioABC");
    	
    }

    @FXML
    void IrParaRelatorios(MouseEvent event) {

    	painelRelatorio.setVisible(true);
    	painelRelatorio.setDisable(false);
    	painelFuncionario.setVisible(false);
    	painelFuncionario.setDisable(true);
    	painelABerto.setVisible(true);
    	painelABerto.setDisable(false);
    	
    }

    @FXML
    void IrParaTabelaFuncionario(MouseEvent event) throws Exception {

    	Main.Cena("TabelaFuncionarios");

    	System.out.println("funci");
    	
    }

    @FXML
    void IrParaVendas(MouseEvent event) {

    }

}
