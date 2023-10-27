package controller.Ferramentas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Funcionario;
import model.Produto;

public class EditButtonCellProduto extends TableCell<Produto, Void> {
    private final Button editButton = new Button();
    private final ImageView imageView = new ImageView(new Image("file:///C:/Users/rainn/Downloads/ProjetoIntegradorProjetoIntegrador/Imagens/imagens%20gerente/Tabela%20funcionario/Group%2037.png"));
    private EventHandler<ActionEvent> editarAction; // Adiciona o evento de edição

    public EditButtonCellProduto() {
        editButton.setGraphic(imageView);
        editButton.setStyle("-fx-background-color: transparent;");
        editButton.setOnAction(event -> {
            if (editarAction != null) {
                ActionEvent newEvent = new ActionEvent(getTableRow().getItem(), event.getTarget());
                editarAction.handle(newEvent);
            }
        });
    }

    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(editButton);
        }
    }

    public void setEditarAction(EventHandler<ActionEvent> editarAction) {
        this.editarAction = editarAction;
    }
}
