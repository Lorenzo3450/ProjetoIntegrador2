package Principal;
	
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public static String email[]= new String[10000];
	public static String senha[]= new String[10000];
	private static Stage primaryStage;
	private static AnchorPane principal;
	private static Scene primaryScene;
	private static Scene login;
	
	private static Scene cadastro;
	private static Scene cadastro2;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception{
	
		
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("LOLOAPP");
		
		initMainStage();
		
		
		
	}
	
	private void initMainStage() throws Exception{
		
			
			Parent fxmlLoguin = FXMLLoader.load(getClass().getResource("Telas/TelaDeLogin.fxml"));
			login = new Scene(fxmlLoguin);
			
		
			Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("Telas/TelaDeCadastro.fxml"));
			cadastro = new Scene(fxmlCadastro);
			
			Parent fxmlCadastro2 = FXMLLoader.load(getClass().getResource("Telas/TelaDeCadastro2.fxml"));
			cadastro2 = new Scene(fxmlCadastro2);
			
			Parent fxmlPrevia = FXMLLoader.load(getClass().getResource("Telas/PreviaTela.fxml"));
			primaryScene = new Scene(fxmlPrevia);
			
			this.primaryStage.setScene(primaryScene);
			this.primaryStage.show();
			
		
	}
	
	public static void Cena(String a) throws Exception{
		if(a.equals("Login")) {
			
			primaryStage.setScene(login);
			
		}
		
		if(a.equals("Inicio")) {
			
			primaryStage.setScene(primaryScene);
			
		}
		
		if(a.equals("Cadastro")) {
			
			primaryStage.setScene(cadastro);
			
		}
		
		if(a.equals("Cadastro2")) {
			
			primaryStage.setScene(cadastro2);
			
		}
	
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
