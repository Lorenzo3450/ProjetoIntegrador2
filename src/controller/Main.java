package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.dao.ConexãoBD;
import model.dao.login.MainModel;
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
	// tela de login e de carregamento e tela de recuperar a senha
	private static Scene login;
	private static Scene loading;
	private static Scene RecuperaSenha;

	// telas de cadastro
	private static Scene cadastro;
	private static Scene cadastro2;
	// telas gerente
	private static Scene MenuPrincipalGerente;
	private static Scene TabelaFuncionarios;

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SuperSminding");

		initMainStage();

	}

	private void initMainStage() throws Exception {

		// todas as cenas do projeto

		// cenas do pacote login
		Parent fxmlLoguin = FXMLLoader.load(getClass().getResource("/view/login/TelaDeLogin.fxml"));
		login = new Scene(fxmlLoguin);

		Parent fxmlLoading = FXMLLoader.load(getClass().getResource("/view/login/TelaDeLoading.fxml"));
		loading = new Scene(fxmlLoading);

		Parent fxmlRecuperaSenha = FXMLLoader.load(getClass().getResource("/view/login/TelaRecuperaSenha.fxml"));
		RecuperaSenha = new Scene(fxmlRecuperaSenha);

		Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("/view/login/TelaDeCadastro.fxml"));
		cadastro = new Scene(fxmlCadastro);

		Parent fxmlCadastro2 = FXMLLoader.load(getClass().getResource("/view/login/TelaDeCadastro2.fxml"));
		cadastro2 = new Scene(fxmlCadastro2);

		// cenas do pacote gerente

		Parent fxmlMenuPrincipalGerente = FXMLLoader
				.load(getClass().getResource("/view/gerente/TelaPrincipalGerente.fxml"));
		MenuPrincipalGerente = new Scene(fxmlMenuPrincipalGerente);

		Parent fxmlTabelaFuncionarios = FXMLLoader.load(getClass().getResource("/view/gerente/TabelaFuncionario.fxml"));
		TabelaFuncionarios = new Scene(fxmlTabelaFuncionarios);

		// inicializa as cenas

		// verifica a sessão do usuario para vê se ele já realizou login

		if (MainModel.VerificaSessao()) {

			// verifica o cargo do usuario

			String cargo = MainModel.verificaCargo();

			if (cargo.equalsIgnoreCase("gerente")) {

				this.primaryStage.setScene(MenuPrincipalGerente);
				this.primaryStage.show();

			}

		} else {
			this.primaryStage.setScene(login);
			this.primaryStage.show();
		}

	}
	
	
	//método para as outras classes alterarem as cenas do sistema

	public static void Cena(String a) throws Exception {
		if (a.equals("Login")) {

			primaryStage.setScene(login);

		}

		if (a.equals("RecuperaSenha")) {

			primaryStage.setScene(RecuperaSenha);

		}

		if (a.equals("loading")) {

			primaryStage.setScene(loading);

		}

		if (a.equals("Cadastro")) {

			primaryStage.setScene(cadastro);

		}

		if (a.equals("Cadastro2")) {

			primaryStage.setScene(cadastro2);

		}

		if (a.equals("TabelaFuncionarios")) {

			primaryStage.setScene(TabelaFuncionarios);

		}

		if (a.equals("TelaPrincipalGerente")) {

			primaryStage.setScene(MenuPrincipalGerente);

		}

	}

	//metodo main
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}