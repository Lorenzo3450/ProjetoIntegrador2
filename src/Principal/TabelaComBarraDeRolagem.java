package Principal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TabelaComBarraDeRolagem extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Item> tableView = new TableView<>();
        
        TableColumn<Item, String> colunaNome = new TableColumn<>("lolo");
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        tableView.getColumns().add(colunaNome);

        for (int i = 1; i <= 100; i++) {
            tableView.getItems().add(new Item("Item " + i));
        }

        ScrollPane scrollPane = new ScrollPane(tableView);
        scrollPane.setFitToHeight(true);

        Scene scene = new Scene(scrollPane, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tabela com Barra de Rolagem");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public class Item {
        private String nome;

        public Item(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
}
