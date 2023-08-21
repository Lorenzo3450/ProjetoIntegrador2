package Principal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TesteBarra extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crie um Slider
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(50); // Valor inicial

        // Crie um layout para adicionar o Slider
        VBox root = new VBox();
        root.getChildren().add(slider);

        // Crie uma cena e adicione o layout
        Scene scene = new Scene(root, 300, 200);

        // Configure o palco (Stage)
        primaryStage.setTitle("JavaFX Slider Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}