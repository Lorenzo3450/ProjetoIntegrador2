package Principal;
	
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BancoDeDados.ConexãoBD;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	

	private static Stage primaryStage;
	//tela de login e de carregamento e tela de recuperar a senha
	private static Scene login;
	private static Scene loading;
	private static Scene RecuperaSenha;
	
	//telas de cadastro
	private static Scene cadastro;
	private static Scene cadastro2;
	//telas gerente
	private static Scene MenuPrincipalGerente;
	private static Scene TabelaFuncionarios;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception{
	
		
		
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SuperSminding");
		
		initMainStage();
		
		
		
	}
	
	private void initMainStage() throws Exception{
		
			
			Parent fxmlLoguin = FXMLLoader.load(getClass().getResource("Telas/TelaDeLogin.fxml"));
			login = new Scene(fxmlLoguin);
			
			Parent fxmlLoading = FXMLLoader.load(getClass().getResource("Telas/TelaDeLoading.fxml"));
			loading = new Scene(fxmlLoading);
			
			Parent fxmlRecuperaSenha = FXMLLoader.load(getClass().getResource("Telas/TelaRecuperaSenha.fxml"));
			RecuperaSenha = new Scene(fxmlRecuperaSenha);
		
			Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("Telas/TelaDeCadastro.fxml"));
			cadastro = new Scene(fxmlCadastro);
			
			Parent fxmlCadastro2 = FXMLLoader.load(getClass().getResource("Telas/TelaDeCadastro2.fxml"));
			cadastro2 = new Scene(fxmlCadastro2);
			
			Parent fxmlMenuPrincipalGerente = FXMLLoader.load(getClass().getResource("Telas/Gerente/TelaPrincipalGerente.fxml"));
			MenuPrincipalGerente = new Scene(fxmlMenuPrincipalGerente);
			
			Parent fxmlTabelaFuncionarios = FXMLLoader.load(getClass().getResource("Telas/Gerente/TabelaFuncionario.fxml"));
			TabelaFuncionarios = new Scene(fxmlTabelaFuncionarios);
			
			Connection conecao = ConexãoBD.Conexao();
			

			String ComandoSql = "select *from sessao where id=1 and sessao=1" ;
			
			
			PreparedStatement stmt = conecao.prepareStatement(ComandoSql);

			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
			this.primaryStage.setScene(MenuPrincipalGerente);
			this.primaryStage.show();
			}else {
				this.primaryStage.setScene(login);
				this.primaryStage.show();
			}
		
	}
	
	public static void Cena(String a) throws Exception{
		if(a.equals("Login")) {
			
			primaryStage.setScene(login);
			
		}
		
		if(a.equals("RecuperaSenha")) {
			
			primaryStage.setScene(RecuperaSenha);
			
		}
		
		if(a.equals("loading")) {
			
			primaryStage.setScene(loading);
			
			
		}
		

		if(a.equals("Cadastro")) {
			
			primaryStage.setScene(cadastro);
			
		}
		
		if(a.equals("Cadastro2")) {
			
			primaryStage.setScene(cadastro2);
			
		}
	
		if(a.equals("TabelaFuncionarios")) {
			
			primaryStage.setScene(TabelaFuncionarios);
			
		}
		
		if(a.equals("TelaPrincipalGerente")) {
			
			primaryStage.setScene(MenuPrincipalGerente);
			
		}
		
	}
	
	

	public static void main(String[] args) {
		launch(args);
	}
}
