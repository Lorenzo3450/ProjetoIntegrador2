package controller.Gestor;

import java.sql.SQLException;

import controller.Main;
import controller.Ferramentas.EfeitoImage;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DesignSistema;
import model.dao.Gerente.PersonalizaSistemaDao;

public class SideBarGestorController {

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
    private ImageView Produtos2;

    @FXML
    private ImageView Relatorio3;

    @FXML
    private ImageView RelatorioABC;

    @FXML
    private ImageView TabelaFuncionario;

    @FXML
    private ImageView Vendas3;

    @FXML
    private ImageView carrinho2;

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
    private Label lblProdutos2;

    @FXML
    private Label lblRelatorio1;

    @FXML
    private Label lblRelatorio3;

    @FXML
    private Label lblRelatorioABC;

    @FXML
    private Label lblRelatorios2;

    @FXML
    private Label lblVendas1;

    @FXML
    private Label lblVendas2;

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
    private ImageView relatorios2;

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
    private ImageView setas31;

    @FXML
    private ImageView setas32;

    @FXML
    private ImageView setas33;

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
    	
    	ColorAdjust colorAdjust = new ColorAdjust();
    	
		String hexColor = corSecundaria;
		double[] hueValues = EfeitoImage.hexToHue(hexColor);
		
		colorAdjust.setHue(hueValues[0]); // Componente vermelho
		colorAdjust.setSaturation(hueValues[1]); // Componente verde
		colorAdjust.setBrightness(hueValues[2]); // Componente azul   
    	

    	Logo1.setImage(logo);

    	Logo11.setImage(logo);
	
    	painelABerto.setStyle(painelABerto.getStyle()+"-fx-background-color:"+corPrincipal);

    	painelFuncionario.setStyle(painelFuncionario.getStyle()+"-fx-background-color:"+corPrincipal);

        painelRelatorio.setStyle(painelRelatorio.getStyle()+"-fx-background-color:"+corPrincipal);
        
        
        
        Funcionario3.setEffect(colorAdjust);

        Funcionarios1.setEffect(colorAdjust);

        Inicio2.setEffect(colorAdjust);

        Inicio3.setEffect(colorAdjust);

       


        Perfil2.setEffect(colorAdjust);

        Produto3.setEffect(colorAdjust);

        Produtos2.setEffect(colorAdjust);

        Relatorio3.setEffect(colorAdjust);

        RelatorioABC.setEffect(colorAdjust);

        TabelaFuncionario.setEffect(colorAdjust);

        Vendas3.setEffect(colorAdjust);

        carrinho2.setEffect(colorAdjust);

        fechar1.setEffect(colorAdjust);

        fechar12.setEffect(colorAdjust);

        fechar2.setEffect(colorAdjust);

        funcionarios1.setEffect(colorAdjust);

        graficoMeses.setEffect(colorAdjust);

        graficoSessoes.setEffect(colorAdjust);

        inicio1.setEffect(colorAdjust);

        lblFuncionario.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+txtf+";");

        lblFuncionarios1.setStyle(lblFuncionarios1.getStyle()+"-fx-text-fill:"+txtf+";");

        lblFuncionarios2.setStyle(lblFuncionarios2.getStyle()+"-fx-text-fill:"+txtf+";");

        lblGraficoMeses.setStyle(lblGraficoMeses.getStyle()+"-fx-text-fill:"+txtf+";");

        lblGraficoSessoes.setStyle(lblGraficoSessoes.getStyle()+"-fx-text-fill:"+txtf+";");

        lblInicio.setStyle(lblInicio.getStyle()+"-fx-text-fill:"+txtf+";");

        lblInicio1.setStyle(lblInicio1.getStyle()+"-fx-text-fill:"+txtf+";");

        lblInicio2.setStyle(lblInicio2.getStyle()+"-fx-text-fill:"+txtf+";");

        lblPerfil2.setStyle(lblPerfil2.getStyle()+"-fx-text-fill:"+txtf+";");

        lblPerfil3.setStyle(lblPerfil3.getStyle()+"-fx-text-fill:"+txtf+";");

        lblProduto3.setStyle(lblProduto3.getStyle()+"-fx-text-fill:"+txtf+";");

        lblProdutos1.setStyle(lblProdutos1.getStyle()+"-fx-text-fill:"+txtf+";");

        lblProdutos2.setStyle(lblProdutos2.getStyle()+"-fx-text-fill:"+txtf+";");

        lblRelatorio1.setStyle(lblRelatorio1.getStyle()+"-fx-text-fill:"+txtf+";");

        lblRelatorio3.setStyle(lblRelatorio3.getStyle()+"-fx-text-fill:"+txtf+";");

        lblRelatorioABC.setStyle(lblRelatorioABC.getStyle()+"-fx-text-fill:"+txtf+";");

        lblRelatorios2.setStyle(lblRelatorios2.getStyle()+"-fx-text-fill:"+txtf+";");

        lblVendas1.setStyle(lblVendas1.getStyle()+"-fx-text-fill:"+txtf+";");

        lblVendas2.setStyle(lblVendas2.getStyle()+"-fx-text-fill:"+txtf+";");

        LblVendas3.setStyle(lblVendas2.getStyle()+"-fx-text-fill:"+txtf+";");
        
        lblperfil1.setStyle(lblperfil1.getStyle()+"-fx-text-fill:"+txtf+";");
        
        
        //
        
        lblFuncionario.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblFuncionarios1.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblFuncionarios2.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblGraficoMeses.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblGraficoSessoes.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblInicio.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblInicio1.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblInicio2.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblPerfil2.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblPerfil3.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblProduto3.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblProdutos1.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblProdutos2.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblRelatorio1.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblRelatorio3.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblRelatorioABC.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblRelatorios2.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblVendas1.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        lblVendas2.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);

        LblVendas3.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);
        
        lblperfil1.setStyle(lblFuncionario.getStyle()+"-fx-text-fill:"+letraTxtf);
        
        

        perfil.setEffect(colorAdjust);

        produto1.setEffect(colorAdjust);

        relatorio.setEffect(colorAdjust);

        relatorios2.setEffect(colorAdjust);

        separato1.setStyle(separato1.getStyle()+"-fx-background-color:"+corSecundaria);

        separato2.setStyle(separato2.getStyle()+"-fx-background-color:"+corSecundaria);

        separato3.setStyle(separato3.getStyle()+"-fx-background-color:"+corSecundaria);

        seta11.setEffect(colorAdjust);

        seta12.setEffect(colorAdjust);

        seta13.setEffect(colorAdjust);

        seta14.setEffect(colorAdjust);

        seta21.setEffect(colorAdjust);

        seta22.setEffect(colorAdjust);

        seta23.setEffect(colorAdjust);

        seta24.setEffect(colorAdjust);

        seta31.setEffect(colorAdjust);

        setas31.setEffect(colorAdjust);

        setas32.setEffect(colorAdjust);

        setas33.setEffect(colorAdjust);

        vendas1.setEffect(colorAdjust);

        
    	
    	
    }
    
    
}
