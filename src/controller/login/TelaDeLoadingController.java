package controller.login;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaDeLoadingController implements Initializable {
	@FXML
	private ImageView imgbanana;

	@FXML
	private Label lblcarregando;

	@FXML
	private ImageView imglaranja;

	@FXML
	private ImageView imgabacaxi;

	@FXML
	private Pane pnlbanana;

	@FXML
	private Pane pnllaranja;

	@FXML
	private Pane pnlabacaxi;

	@FXML
	private AnchorPane anchorPane;

	private ImageView[] imageViews;
	private Timeline animationTimeline;
	private Timeline textoCarregamento;

	private double originalY1, originalY2, originalY3;
	private double timeElapsed = 0;
	private int pontosCarregamento = 1;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		imageViews = new ImageView[] { imgbanana, imglaranja, imgabacaxi };
		animationTimeline = new Timeline(new KeyFrame(Duration.seconds(0.016), event -> {
			// Ajusta as posições verticais das frutas para criar uma onda
			imgbanana.setLayoutY(originalY1 + Math.sin(timeElapsed) * 20);
			imglaranja.setLayoutY(originalY2 + Math.sin(timeElapsed + Math.PI) * 20);
			imgabacaxi.setLayoutY(originalY3 + Math.sin(timeElapsed + Math.PI / 2) * 20);

			timeElapsed += 0.05; // Ajuste a velocidade da onda conforme necessário
		}));
		animationTimeline.setCycleCount(Timeline.INDEFINITE);
		animationTimeline.play();

		textoCarregamento = new Timeline(new KeyFrame(Duration.seconds(0.55), event -> {
			lblcarregando.setText("CARREGANDO" + ".".repeat(pontosCarregamento));
			pontosCarregamento = (pontosCarregamento + 1) % 4;
		}));
		textoCarregamento.setCycleCount(Timeline.INDEFINITE);
		textoCarregamento.play();

		// Armazena as posições verticais iniciais
		originalY1 = imgbanana.getLayoutY();
		originalY2 = imglaranja.getLayoutY();
		originalY3 = imgabacaxi.getLayoutY();
		
	}
	}





	