package Principal.Telas.Gerente;

import Ferramentas.EfeitoBtn;
import Principal.Main;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class TelaPrincipalGerenteController {

	EfeitoBtn efeito = new EfeitoBtn();
	
    @FXML
    private ImageView BtnProduto;

    @FXML
    private ImageView BtnProduto1;

    @FXML
    private ImageView BtnRelatorio;

    @FXML
    private ImageView BtnRelatorio1;

    @FXML
    private ImageView BtnTabelas;

    @FXML
    private ImageView BtnTabelas1;

    @FXML
    private ImageView BtnVendas;

    @FXML
    private ImageView BtnVendas1;

    @FXML
    private ImageView btnfuncionario;

    @FXML
    private ImageView btnfuncionario1;

    @FXML
    private AnchorPane painelABerto;

    @FXML
    private AnchorPane painelFechado;

    @FXML
    private AnchorPane painelFuncionario;

    @FXML
    private AnchorPane painelTabelas;

    @FXML
    void AbrirSideBar(MouseEvent event) {

    	
    	painelFechado.setVisible(false);
    	painelFechado.setDisable(true);
    	painelFuncionario.setVisible(false);
    	painelFuncionario.setDisable(true);
    	painelTabelas.setVisible(false);
    	painelTabelas.setDisable(true);
    	painelABerto.setVisible(true);
    	painelABerto.setDisable(false);
    	
    }
    
    @FXML
    void Entrar(MouseEvent event) {

    	btnfuncionario.setEffect(efeito.Efeito());
    	
    }

    @FXML
    void Entrar2(MouseEvent event) {

    	BtnProduto.setEffect(efeito.Efeito());
    	
    }

    @FXML
    void Entrar3(MouseEvent event) {
    	
    	BtnVendas.setEffect(efeito.Efeito());
    	
    }

    @FXML
    void Entrar4(MouseEvent event) {

    	BtnRelatorio.setEffect(efeito.Efeito());
    	
    }

    @FXML
    void Entrar5(MouseEvent event) {

    	BtnTabelas.setEffect(efeito.Efeito());
    	
    }



    @FXML
    void FecharSideBar(MouseEvent event) {

    	
    	painelFechado.setVisible(true);
    	painelFechado.setDisable(false);
    	painelFuncionario.setVisible(false);
    	painelFuncionario.setDisable(true);
    	painelTabelas.setVisible(false);
    	painelTabelas.setDisable(true);
    	painelABerto.setVisible(true);
    	painelABerto.setDisable(false);
    	
    }

    @FXML
    void IrParaAdicionaCargo(MouseEvent event) {

    }

    @FXML
    void IrParaAlterarSalario(MouseEvent event) {

    }

    @FXML
    void IrParaFuncionarios(MouseEvent event) {

    	painelFechado.setVisible(false);
    	painelFechado.setDisable(true);
    	painelFuncionario.setVisible(true);
    	painelFuncionario.setDisable(false);
    	painelTabelas.setVisible(false);
    	painelTabelas.setDisable(true);
    	painelABerto.setVisible(true);
    	painelABerto.setDisable(false);
    	
    }

    @FXML
    void IrParaFuncionarios2(MouseEvent event) {


    	
    }

    @FXML
    void IrParaInico(MouseEvent event) {

    }

    @FXML
    void IrParaPerfil(MouseEvent event) {

    }

    @FXML
    void IrParaProduto(MouseEvent event) {

    }

    @FXML
    void IrParaProdutos2(MouseEvent event) {

    }

    @FXML
    void IrParaRelatorio(MouseEvent event) {

    }

    @FXML
    void IrParaRelatorios2(MouseEvent event) {

    }

    @FXML
    void IrParaRemoverFuncionario(MouseEvent event) {

    }

    @FXML
    void IrParaTabela(MouseEvent event) {
    	
    	painelFechado.setVisible(false);
    	painelFechado.setDisable(true);
    	painelFuncionario.setVisible(false);
    	painelFuncionario.setDisable(true);
    	painelTabelas.setVisible(true);
    	painelTabelas.setDisable(false);
    	painelABerto.setVisible(true);
    	painelABerto.setDisable(false);

    }

    @FXML
    void IrParaTabelas2(MouseEvent event) {

    }

    @FXML
    void IrParaTabelaFuncionario(MouseEvent event) throws Exception {
    	
    	Main.Cena("TabelaFuncionarios");

    }

    @FXML
    void IrParaTabelaGastos(MouseEvent event) {

    }

    @FXML
    void IrParaTabelaLucro(MouseEvent event) {

    }
    
    
    @FXML
    void IrParaVendas(MouseEvent event) {

    }

    @FXML
    void IrParaVendas2(MouseEvent event) {

    }

    @FXML
    void Sair(MouseEvent event) {

    	btnfuncionario.setEffect(null);
    	
    }

    @FXML
    void Sair2(MouseEvent event) {

    	BtnProduto.setEffect(null);
    	
    }

    @FXML
    void Sair3(MouseEvent event) {

    	BtnVendas.setEffect(null);
    	
    }

    @FXML
    void Sair4(MouseEvent event) {

    	BtnRelatorio.setEffect(null);
    	
    }

    @FXML
    void Sair5(MouseEvent event) {

    	BtnTabelas.setEffect(null);
    	
    }


}
