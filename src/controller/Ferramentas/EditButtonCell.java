package controller.Ferramentas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Funcionario;

public class EditButtonCell extends TableCell<Funcionario, Void> {
    private final Button editButton = new Button();
    private final ImageView imageView = new ImageView(new Image("file:///F:/ProjetoIntegrador/ProjetoIntegrador/Imagens/imagens%20gerente/Tabela%20funcionario/Group%2037.png"));
    private EventHandler<ActionEvent> editarAction; // Adiciona o evento de edição

    public EditButtonCell() {
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
