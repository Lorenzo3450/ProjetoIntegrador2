package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.Caixa.PagamentoEmDinheiroController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

	public static int id;
	
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
	private static Scene RelatorioABC;
	private static Scene GraficoDeLucrosDosMeses;
	private static Scene GraficoDeLucrosDasSecoesProduto;
	private static Scene TelaDePerfil;
	private static Scene SideBar;
	private static Scene PersonalizaSistema;
	
	//telas RH
	private static Scene MenuPrincipalRH;
	
	//telas Gestor
	private static Scene TelaPrincipalGestor;
	private static Scene CadastraProduto;
	private static Scene TabelaProdutos;
	private static Scene TelaDeEnviarMensagem;
	private static Scene TelaDeCadastraFornecedor;
	private static Scene SideBarGestor;
	
	//Telas de caixa
	private static Scene FrenteDeCaixa;
	private static Scene DefiniFormaPagamento;
	private static Scene PagamentoEmDinheiro;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("SuperSminding");

		  primaryStage.sceneProperty().addListener(new ChangeListener<Scene>() {
	            @Override
	            public void changed(ObservableValue<? extends Scene> observable, Scene oldScene, Scene newScene) {
	                // Este método será chamado sempre que a cena for alterada
	                if (newScene != null) {
	                    cenaExibida();
	                }
	            }
	        });
		
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
		
		Parent fxmlRelatorioABC = FXMLLoader.load(getClass().getResource("/view/gerente/RelatorioABC.fxml"));
		RelatorioABC = new Scene(fxmlRelatorioABC);

		Parent fxmlGraficoDeLucrosDosMeses = FXMLLoader.load(getClass().getResource("/view/gerente/GraficoDeLucroDosMeses.fxml"));
		GraficoDeLucrosDosMeses = new Scene(fxmlGraficoDeLucrosDosMeses);
		
		Parent fxmlGraficoDeLucrosDasSecoesProduto = FXMLLoader.load(getClass().getResource("/view/gerente/GraficoLucroSecoes.fxml"));
		GraficoDeLucrosDasSecoesProduto = new Scene(fxmlGraficoDeLucrosDasSecoesProduto);
		

		Parent fxmlTelaDePerfil = FXMLLoader.load(getClass().getResource("/view/gerente/TelaDePerfil.fxml"));
		TelaDePerfil = new Scene(fxmlTelaDePerfil);
		
		Parent fxmlSideBar = FXMLLoader.load(getClass().getResource("/view/gerente/SideBarGerente.fxml"));
		SideBar = new Scene(fxmlSideBar);
		
		Parent fxmlPersonalizaSistema = FXMLLoader.load(getClass().getResource("/view/gerente/PersonalizaSistema.fxml"));
		PersonalizaSistema = new Scene(fxmlPersonalizaSistema);
		
		
		//cenas do pacote RH descontinuado
		
		Parent fxmlMenuPrincipalRH = FXMLLoader
				.load(getClass().getResource("/view/RH/TelaPrincipalRH.fxml"));
		MenuPrincipalRH = new Scene(fxmlMenuPrincipalRH);
		
		

		
		//cenas gestor
	
		Parent fxmlTelaPrincipal = FXMLLoader
				.load(getClass().getResource("/view/gestor/TelaPrincipalGestor.fxml"));
		TelaPrincipalGestor = new Scene(fxmlTelaPrincipal);

		
		Parent fxmlCadastraProduto = FXMLLoader.load(getClass().getResource("/view/Gestor/TelaDeCadastraProduto.fxml"));
		CadastraProduto= new Scene(fxmlCadastraProduto);
		
		
		
		Parent fxmlTabelaProduto = FXMLLoader.load(getClass().getResource("/view/Gestor/TabelaProdutos.fxml"));
		TabelaProdutos= new Scene(fxmlTabelaProduto);
		
		Parent fxmlEnviaMensagem = FXMLLoader.load(getClass().getResource("/view/Gestor/TelaDeEnviarMensagem.fxml"));
		TelaDeEnviarMensagem = new Scene(fxmlEnviaMensagem);
		
		
		
		Parent fxmlTelaDeCadastraFornecedor = FXMLLoader.load(getClass().getResource("/view/Gestor/TelaDeCadastrarFornecedor.fxml"));
		TelaDeCadastraFornecedor = new Scene(fxmlTelaDeCadastraFornecedor);
		
		
		Parent fxmlSideBarGestor = FXMLLoader.load(getClass().getResource("/view/Gestor/SideBarGestor.fxml"));
		SideBarGestor = new Scene(fxmlSideBarGestor);
		
		
		//Telas caixa
		
		Parent fxmlFrenteDeCaixa = FXMLLoader.load(getClass().getResource("/view/Caixa/TelaDeVenda.fxml"));
		FrenteDeCaixa= new Scene(fxmlFrenteDeCaixa);
		
		Parent fxmlDefiniFormaPagamento = FXMLLoader.load(getClass().getResource("/view/Caixa/DefiniFormaDePagamento.fxml"));
		DefiniFormaPagamento= new Scene(fxmlDefiniFormaPagamento);
		
		Parent fxmlPagamentoEmDinheiro = FXMLLoader.load(getClass().getResource("/view/Caixa/PagamentoEmDinheiro.fxml"));
		PagamentoEmDinheiro= new Scene(fxmlPagamentoEmDinheiro);
		

	
		
		// inicializa as cenas

		// verifica a sessão do usuario para vê se ele já realizou login

		if (MainModel.VerificaSessao()) {

			// verifica o cargo do usuario

			String cargo = MainModel.verificaCargo();

			if (cargo.equalsIgnoreCase("gerente")) {

				
				this.primaryStage.setScene(MenuPrincipalGerente);
				this.primaryStage.show();
				
				
				
			}
			if(cargo.equalsIgnoreCase("RH")) {
				
				this.primaryStage.setScene(MenuPrincipalRH);
				this.primaryStage.show();
				
			}
			
			if(cargo.equalsIgnoreCase("Não definido")) {
				this.primaryStage.setScene(login);
				this.primaryStage.show();
				
			} if(cargo.equalsIgnoreCase("Atendente de caixa")) {
				this.primaryStage.setScene(FrenteDeCaixa);
				this.primaryStage.show();
				
			}

		} else {
			this.primaryStage.setScene(login);
			this.primaryStage.show();
		} 

		

	}
	
	
	//método para as outras classes alterarem as cenas do sistema

	public static void Cena(String a) throws Exception {
		
		//telas login
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
		
		//telas gerente 

		if (a.equals("TabelaFuncionarios")) {

			primaryStage.setScene(TabelaFuncionarios);

		}

		if (a.equals("TelaPrincipalGerente")) {

			primaryStage.setScene(MenuPrincipalGerente);

		}
		
		if (a.equals("TelaRelatorioABC")) {

			primaryStage.setScene(RelatorioABC);

		}
		
		if (a.equals("GraficoMes")) {

			primaryStage.setScene(GraficoDeLucrosDosMeses);

		}
		
		if (a.equals("GraficoSecao")) {

			primaryStage.setScene(GraficoDeLucrosDasSecoesProduto);

		} 
		

		if (a.equals("MenuGestor")) {

			primaryStage.setScene(TelaPrincipalGestor);

		} 
		
		
		if (a.equals("CadastraProduto")) {

			primaryStage.setScene(CadastraProduto);

		} 
		
		if (a.equals("TelaDePerfil")) {

			primaryStage.setScene(TelaDePerfil);

		} 
		
		if (a.equals("TabelaProdutos")) {

			primaryStage.setScene(TabelaProdutos);

		}
		
		if (a.equals("TelaDeVenda")) {

			primaryStage.setScene(FrenteDeCaixa);

		}
		
		if (a.equals("DefiniFormaDePagamento")) {

			primaryStage.setScene(DefiniFormaPagamento);

		}
		
		if (a.equals("PagamentoDinheiro")) {

			primaryStage.setScene(PagamentoEmDinheiro);

		}
		
		
		if (a.equals("PersonalizaSistema")) {

			primaryStage.setScene(PersonalizaSistema);

		}
		
		if (a.equals("Envia Mensagem")) {

			primaryStage.setScene(TelaDeEnviarMensagem);

		}
		
		if (a.equals("cadastra fornecedor")) {

			primaryStage.setScene(TelaDeCadastraFornecedor);

		}
		
		
		
		
	}
	
	
	private void cenaExibida() {
		Scene cenaAtual = primaryStage.getScene();
		
			if(cenaAtual == PagamentoEmDinheiro) {
	      
			}
		
		
	}


	//metodo main
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}