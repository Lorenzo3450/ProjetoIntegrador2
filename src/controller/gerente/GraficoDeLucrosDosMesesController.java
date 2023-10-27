package controller.gerente;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.LucroMensal;
import model.Produto;
import model.dao.ConexãoBD;
import model.dao.Gerente.GraficoDeLucrosDosMesesDao;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import controller.Main;
import controller.Ferramentas.EfeitoBtn;
import controller.Ferramentas.ObterAnoAtual;
import javafx.scene.image.Image;


public class GraficoDeLucrosDosMesesController {

	
	
	EfeitoBtn efeito = new EfeitoBtn();

	
    @FXML
    private ImageView BtnImprimir;

    @FXML
    private AnchorPane PainelGrafico;
    
    
    
    Color[] coresMeses = {
		    Color.BLUE,
		    Color.RED,
		    Color.GREEN,
		    Color.ORANGE,
		    Color.PURPLE,
		    Color.CYAN,
		    Color.YELLOW,
		    Color.PINK,
		    Color.LIME,
		    Color.BROWN,
		    Color.GRAY,
		    Color.MAGENTA
		    
		};
	
	private String toHex(Color color) {
	    int r = (int) (color.getRed() * 255);
	    int g = (int) (color.getGreen() * 255);
	    int b = (int) (color.getBlue() * 255);
	    return String.format("#%02X%02X%02X", r, g, b);
	}
    
    
    @FXML
    void initialize() {
        // Configurar o gráfico de barras
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Mês");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Lucro");
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("");
        barChart.setPrefWidth(1100); 
        barChart.setPrefHeight(400);
        barChart.setBarGap(-40); // Defina barGap como 0 para eliminar o espaço entre barras
        barChart.setCategoryGap(40); // Defina categoryGap para ajustar o espaço entre as categorias (meses)
     
     

        try {
        	Connection conexao = ConexãoBD.Conexao();
            GraficoDeLucrosDosMesesDao dao = new GraficoDeLucrosDosMesesDao(conexao);
            List<LucroMensal> lucrosMensais = dao.obterLucrosMensaisDoBanco(ObterAnoAtual.ObtemAno()); 

           
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            for (int i = 0; i < lucrosMensais.size(); i++) {
                LucroMensal lucroMensal = lucrosMensais.get(i);
                String mes = lucroMensal.getMes();
                double lucro = lucroMensal.getLucro();

                // Criar uma série de dados para o mês com uma cor da paleta
                XYChart.Series<String, Number> mesSeries = new XYChart.Series<>();
                mesSeries.getData().add(new XYChart.Data<>(mes, lucro));
                mesSeries.setName(mes); // Definir o nome da série como o mês
                Node node = mesSeries.getNode();
                if (node != null) {
                    node.setStyle("-fx-bar-fill: " + toHex(coresMeses[i]) + ";");
                }

                // Adicionar a série de dados do mês ao gráfico
                barChart.getData().add(mesSeries);
            }
           
            PainelGrafico.getChildren().add(barChart);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    void EfeitoImprimir(MouseEvent event) {
    		
    	BtnImprimir.setEffect(efeito.Efeito());
    		
    }

    @FXML
    void SairImprimir(MouseEvent event) {

    	BtnImprimir.setEffect(null);

    	
    }

    @FXML
    void imprimir(MouseEvent event) {
        String caminhoCompleto = "F:/Projeto_Integrador/ProjetoIntegrador/Imagens/imagens gerente/Tabela funcionario/Group38.png";
        ImageView headerImage = new ImageView(new Image("file:///" + caminhoCompleto));

        String caminhoCompleto2 = "F:/Projeto_Integrador/ProjetoIntegrador/Imagens/imagens gerente/Tabela funcionario/SuperSmindig.png";
        ImageView headerImage2 = new ImageView(new Image("file:///" + caminhoCompleto2));
        
        // Criar uma instância de PrinterJob
        PrinterJob printerJob = PrinterJob.createPrinterJob();

        if (printerJob != null) {
            // Configurar o gráfico para impressão
            BarChart<String, Number> barChart = criarGraficoDeBarras();

            // Criar um Node que contém o gráfico e a imagem do cabeçalho
            AnchorPane imprimirNode = new AnchorPane();
            imprimirNode.getChildren().addAll(barChart, headerImage, headerImage2);

            // Definir as posições do gráfico e da imagem no AnchorPane
            AnchorPane.setTopAnchor(headerImage, 0.0); // Posição vertical (topo)
            AnchorPane.setLeftAnchor(headerImage, 0.0); // Posição horizontal (esquerda)
            
            AnchorPane.setTopAnchor(headerImage2, 40.0); // Posição vertical (topo)
            AnchorPane.setLeftAnchor(headerImage2, 140.0); // Posição horizontal (esquerda)
            
            AnchorPane.setTopAnchor(barChart, 100.0); // Ajuste a posição vertical conforme necessário
            AnchorPane.setLeftAnchor(barChart, 0.0); // Ajuste a posição horizontal conforme necessário

            // Imprimir o Node composto
            if (printerJob.showPrintDialog(null)) {
                boolean success = printerJob.printPage(imprimirNode);
                if (success) {
                    printerJob.endJob();
                }
            }
        }
    }
    
    
    private BarChart<String, Number> criarGraficoDeBarras() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Mês");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Lucro");
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("");
        barChart.setPrefWidth(500);
        barChart.setPrefHeight(400);
        barChart.setBarGap(-20);
        barChart.setCategoryGap(0);

        try {
            Connection conexao = ConexãoBD.Conexao();
            GraficoDeLucrosDosMesesDao dao = new GraficoDeLucrosDosMesesDao(conexao);
            List<LucroMensal> lucrosMensais = dao.obterLucrosMensaisDoBanco(ObterAnoAtual.ObtemAno());

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            for (int i = 0; i < lucrosMensais.size(); i++) {
                LucroMensal lucroMensal = lucrosMensais.get(i);
                String mes = lucroMensal.getMes();
                double lucro = lucroMensal.getLucro();

                XYChart.Series<String, Number> mesSeries = new XYChart.Series<>();
                mesSeries.getData().add(new XYChart.Data<>(mes, lucro));
                mesSeries.setName(mes);
                Node node = mesSeries.getNode();
                if (node != null) {
                    node.setStyle("-fx-bar-fill: " + toHex(coresMeses[i]) + ";");
                }

                barChart.getData().add(mesSeries);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return barChart;
    }


    @FXML
    void vol1(MouseEvent event) throws Exception {

    	Main.Cena("TelaPrincipalGerente");
    	
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
    

}
