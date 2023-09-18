package controller.gerente;


import javafx.fxml.FXML;
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

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GraficoDeLucrosDosMesesController {

	
	
    @FXML
    private ImageView BtnImprimir;

    @FXML
    private AnchorPane PainelGrafico;
    
    
    @FXML
    void initialize() {
        // Configurar o gráfico de barras
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Mês");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Lucro");
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("");
        barChart.setPrefWidth(1600); 
        barChart.setPrefHeight(600);

     

        try {
        	Connection conexao = ConexãoBD.Conexao();
            GraficoDeLucrosDosMesesDao dao = new GraficoDeLucrosDosMesesDao(conexao);
            List<LucroMensal> lucrosMensais = dao.obterLucrosMensaisDoBanco(2023); 

           
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            for (LucroMensal lucroMensal : lucrosMensais) {
                series.getData().add(new XYChart.Data<>(lucroMensal.getMes(), lucroMensal.getLucro()));
            }

          
            barChart.getData().add(series);

           
            PainelGrafico.getChildren().add(barChart);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @FXML
    void EfeitoImprimir(MouseEvent event) {

    }

    @FXML
    void SairImprimir(MouseEvent event) {

    }

    @FXML
    void imprimir(MouseEvent event) {

    }

    @FXML
    void vol1(MouseEvent event) {

    }

}
