package controller.gerente;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.dao.ConexãoBD;
import model.dao.Gerente.GraficoDeLucroSecoesDao;
import model.Secao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import controller.Main;
import controller.Ferramentas.EfeitoBtn;
import javafx.scene.image.Image;



public class GraficoLucroSecoesController {

	EfeitoBtn efeito = new EfeitoBtn();
	
	
	@FXML
    void initialize() {
		
		inicializarGraficoPizza();
		
	}
	
    @FXML
    private ImageView BtnImprimir;

    @FXML
    private AnchorPane PainelGrafico;


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
          ImageView imageView1 = new ImageView(new Image("file:///" + caminhoCompleto));

          String caminhoCompleto2 = "F:/Projeto_Integrador/ProjetoIntegrador/Imagens/imagens gerente/Tabela funcionario/SuperSmindig.png";
          ImageView imageView2 = new ImageView(new Image("file:///" + caminhoCompleto2));

        // Conectar ao banco de dados (substitua as informações da conexão conforme necessário)
        try {
            Connection conexao = ConexãoBD.Conexao();

            // Criar uma instância do seu DAO
            GraficoDeLucroSecoesDao dao = new GraficoDeLucroSecoesDao(conexao);

            // Obter os dados das secoes para o gráfico
            List<Secao> dadosSecoes = dao.obterDadosSecoesParaGrafico();

            // Criar o gráfico de pizza
            PieChart graficoPizza = new PieChart();

            // Adicionar os dados do gráfico de pizza com base na lista de secoes
            for (Secao secao : dadosSecoes) {
                double lucro = secao.getLucro();
                PieChart.Data data = new PieChart.Data(secao.getNomeSecao() + " (" + String.format("%.1f%%", (lucro / getTotalLucro(dadosSecoes)) * 100) + ")", lucro);
                graficoPizza.getData().add(data);
            }

            // Defina as dimensões do gráfico (aumente conforme necessário)
            graficoPizza.setMinWidth(500); // Largura em pixels
            graficoPizza.setMinHeight(500); // Altura em pixels

            // Criar um Node que contém as imagens e o gráfico
            AnchorPane imprimirNode = new AnchorPane();
            imprimirNode.getChildren().addAll(imageView1, imageView2, graficoPizza);

            // Definir as posições das imagens e do gráfico no AnchorPane
            AnchorPane.setTopAnchor(imageView1, 0.0); // Posição vertical (topo) da primeira imagem
            AnchorPane.setLeftAnchor(imageView1, 0.0); // Posição horizontal (esquerda) da primeira imagem

            AnchorPane.setTopAnchor(imageView2, 40.0); // Posição vertical (topo) da segunda imagem
            AnchorPane.setLeftAnchor(imageView2, 140.0); // Posição horizontal (esquerda) da segunda imagem

            AnchorPane.setTopAnchor(graficoPizza, 100.0); // Ajuste a posição vertical conforme necessário para o gráfico
            AnchorPane.setLeftAnchor(graficoPizza, 0.0); // Ajuste a posição horizontal conforme necessário para o gráfico

            // Criar uma instância de PrinterJob
            PrinterJob printerJob = PrinterJob.createPrinterJob();

            if (printerJob != null) {
                // Imprimir o Node composto
                if (printerJob.showPrintDialog(null)) {
                    boolean success = printerJob.printPage(imprimirNode);
                    if (success) {
                        printerJob.endJob();
                    }
                }
            }

            // Fechar a conexão com o banco de dados
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
    
    
    
    
    
    

    @FXML
    void vol1(MouseEvent event) throws Exception {

    	Main.Cena("TelaPrincipalGerente");
    	
    }
   
 
    private void inicializarGraficoPizza() {
        // Conectar ao banco de dados (substitua as informações da conexão conforme necessário)
        try {
            Connection conexao = ConexãoBD.Conexao();

            // Criar uma instância do seu DAO
            GraficoDeLucroSecoesDao dao = new GraficoDeLucroSecoesDao(conexao);

            // Obter os dados das secoes para o gráfico
            List<Secao> dadosSecoes = dao.obterDadosSecoesParaGrafico();

            // Criar o gráfico de pizza
            PieChart graficoPizza = new PieChart();

            // Adicionar os dados do gráfico de pizza com base na lista de secoes
            for (Secao secao : dadosSecoes) {
                double lucro = secao.getLucro();
                PieChart.Data data = new PieChart.Data(secao.getNomeSecao() + " (" + String.format("%.1f%%", (lucro / getTotalLucro(dadosSecoes)) * 100) + ")", lucro);
                graficoPizza.getData().add(data);
            }

            // Definir as dimensões do gráfico (aumente conforme necessário)
            graficoPizza.setMinWidth(1100); // Largura em pixels
            graficoPizza.setMinHeight(400); // Altura em pixels

            // Adicionar o gráfico de pizza ao PainelGrafico
            PainelGrafico.getChildren().add(graficoPizza);

            // Fechar a conexão com o banco de dados
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    
   

    
    // Método para calcular o total de lucro
    private double getTotalLucro(List<Secao> dadosSecoes) {
        double total = 0;
        for (Secao secao : dadosSecoes) {
            total += secao.getLucro();
        }
        return total;
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
