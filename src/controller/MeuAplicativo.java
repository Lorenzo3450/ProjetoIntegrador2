package controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

public class MeuAplicativo extends Application {
    @Override
    public void start(Stage palco) throws Exception {
        // Configurar os dados do gráfico de pizza
        PieChart grafico = new PieChart();

        // Configurar os dados do gráfico
        grafico.setTitle("Meu Gráfico de Pizza");

        // Criar os dados do gráfico de pizza (substitua pelos seus próprios dados)
        PieChart.Data slice1 = new PieChart.Data("Produto A", 30);
        PieChart.Data slice2 = new PieChart.Data("Produto B", 45);
        PieChart.Data slice3 = new PieChart.Data("Produto C", 25);

        // Adicionar os dados ao gráfico de pizza
        grafico.getData().addAll(slice1, slice2, slice3);

        // Criar a cena e adicionar o gráfico
        Scene cena = new Scene(grafico, 800, 600);
        palco.setScene(cena);

        palco.setTitle("Meu Gráfico de Pizza JavaFX");
        palco.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}