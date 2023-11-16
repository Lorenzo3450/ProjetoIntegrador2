package controller.gerente;

import java.sql.SQLException;

import controller.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DesignSistema;
import model.dao.Gerente.PersonalizaSistemaDao;

public class SideBarController {

	@FXML
    private ImageView Funcionario3;

    @FXML
    private ImageView Funcionarios1;

    @FXML
    private ImageView Inicio2;

    @FXML
    private ImageView Inicio3;

    @FXML
    private Label LblVendas3;

    @FXML
    private ImageView Logo1;

    @FXML
    private ImageView Logo11;

    @FXML
    private ImageView Perfil2;

    @FXML
    private ImageView Produto3;

    @FXML
    private ImageView Relatorio3;

    @FXML
    private ImageView RelatorioABC;

    @FXML
    private ImageView TabelaFuncionario;

    @FXML
    private ImageView Vendas3;

    @FXML
    private ImageView fechar1;

    @FXML
    private ImageView fechar12;

    @FXML
    private ImageView fechar2;

    @FXML
    private ImageView funcionarios1;

    @FXML
    private ImageView graficoMeses;

    @FXML
    private ImageView graficoSessoes;

    @FXML
    private ImageView inicio1;

    @FXML
    private Label lblFuncionario;

    @FXML
    private Label lblFuncionarios1;

    @FXML
    private Label lblFuncionarios2;

    @FXML
    private Label lblGraficoMeses;

    @FXML
    private Label lblGraficoSessoes;

    @FXML
    private Label lblInicio;

    @FXML
    private Label lblInicio1;

    @FXML
    private Label lblInicio2;

    @FXML
    private Label lblPerfil2;

    @FXML
    private Label lblPerfil3;

    @FXML
    private Label lblProduto3;

    @FXML
    private Label lblProdutos1;

    @FXML
    private Label lblRelatorio1;

    @FXML
    private Label lblRelatorio3;

    @FXML
    private Label lblRelatorioABC;

    @FXML
    private Label lblVendas1;

    @FXML
    private Label lblperfil1;

    @FXML
    private AnchorPane painelABerto;

    @FXML
    private AnchorPane painelFuncionario;

    @FXML
    private AnchorPane painelRelatorio;

    @FXML
    private ImageView perfil;

    @FXML
    private ImageView produto1;

    @FXML
    private ImageView relatorio;

    @FXML
    private Separator separato1;

    @FXML
    private Separator separato2;

    @FXML
    private Separator separato3;

    @FXML
    private ImageView seta11;

    @FXML
    private ImageView seta12;

    @FXML
    private ImageView seta13;

    @FXML
    private ImageView seta14;

    @FXML
    private ImageView seta21;

    @FXML
    private ImageView seta22;

    @FXML
    private ImageView seta23;

    @FXML
    private ImageView seta24;

    @FXML
    private ImageView seta31;

    @FXML
    private ImageView vendas1;
    
    @FXML
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    void initialize() {
        

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
    	FecharSideBar(event);
    	Main.Cena("GraficoMes");
    	
    }

    @FXML
    void IrParaGraficoSecao(MouseEvent event) throws Exception {

    	Main.Cena("GraficoSecao");
    	FecharSideBar(event);
    }

    @FXML
    void IrParaInicio(MouseEvent event) throws Exception {
    	FecharSideBar(event);
    	Main.Cena("TelaPrincipalGerente");
    	
    }

    @FXML
    void IrParaPerfil(MouseEvent event) throws Exception {

    	FecharSideBar(event);
    	Main.Cena("TelaDePerfil");
    	
    	
    }

    @FXML
    void IrParaProdutos(MouseEvent event) {

    }

    @FXML
    void IrParaRelatorioABC(MouseEvent event) throws Exception {
    	FecharSideBar(event);
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

    	FecharSideBar(event);
    	Main.Cena("TabelaFuncionarios");

    	System.out.println("funci");
    	
    }

    @FXML
    void IrParaVendas(MouseEvent event) {

    }

    public void AlterarComponentes(Image fundo,Image logo,String txtf,String letraTxtf,String btn,String letraBtn,
			String corPrincipal,String corSecundaria,String corTercearia) {
    	

    	Logo1.setImage(logo);

    	Logo11.setImage(logo);
	
    	painelABerto.setStyle(painelABerto.getStyle()+"-fx-background-color:"+corPrincipal);

    	painelFuncionario.setStyle(painelFuncionario.getStyle()+"-fx-background-color:"+corPrincipal);

        painelRelatorio.setStyle(painelRelatorio.getStyle()+"-fx-background-color:"+corPrincipal);
    	
    	
    }
    
    
}
