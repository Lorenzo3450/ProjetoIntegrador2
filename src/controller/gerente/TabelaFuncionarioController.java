package controller.gerente;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler; 
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ColorAdjust;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;
import model.dao.ConexãoBD;
import model.dao.Gerente.TabelaFuncionarioDao;
import controller.Ferramentas.EditButtonCell;
import controller.Ferramentas.EfeitoBtn;
import controller.Ferramentas.EfeitoImage;
import controller.Main;

public class TabelaFuncionarioController {

	private static Scene filtrofuncionario;
	
	EfeitoBtn efeito = new EfeitoBtn();

    @FXML
    private Separator divisor;
	
    @FXML
    private ImageView BtnFiltro;

    @FXML
    private ImageView BtnImprimir;

    @FXML
    private ImageView BtnPesquisar;

    @FXML
    private ImageView ImagemDeFundo;

    @FXML
    private ImageView Logo;

    @FXML
    private AnchorPane PainelDeCima;

    @FXML
    private AnchorPane PainelPrincipal;

    @FXML
    private Label TextoDoPainelDeCima;

    @FXML
    private Label TextoDoPainelDeCima1;

    @FXML
    private Label TextoDoPainelDeCima11;

    @FXML
    private TextField TxtPesquisa;

	@FXML
	private TableView<Funcionario> tableView;
	
    @FXML
    private TableColumn<Funcionario, Void> imageColumn;

	@FXML
	private TableColumn<Funcionario, String> nomeCompletoColumn;
	

	@FXML
	private TableColumn<Funcionario, String> cpfColumn;

	@FXML
	private TableColumn<Funcionario, Integer> idadeColumn;

	@FXML
	private TableColumn<Funcionario, String> telefoneColumn;

	@FXML
	private TableColumn<Funcionario, String> emailColumn;

	@FXML
	private TableColumn<Funcionario, String> cargoColumn;

	@FXML
	private TableColumn<Funcionario, Double> salarioColumn;

	// inicializa a tabelafuncionario
	

	
	@FXML
	private void initialize() {
		
	
	
		
		ColorAdjust colorAdjust = new ColorAdjust();
	
		String hexColor = "#002147";
		double[] hueValues = EfeitoImage.hexToHue(hexColor);
		
		colorAdjust.setHue(hueValues[0]); // Componente vermelho
		colorAdjust.setSaturation(hueValues[1]); // Componente verde
		colorAdjust.setBrightness(hueValues[2]); // Componente azul    
		
		
   //     BtnFiltro.setEffect(colorAdjust);
		//		BtnImprimir.setEffect(colorAdjust);
        
		tableView.getItems().clear();
		nomeCompletoColumn.setCellValueFactory(cellData -> cellData.getValue().nomeCompletoProperty());
		cpfColumn.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
		idadeColumn.setCellValueFactory(cellData -> {
			IntegerProperty idadeProperty = cellData.getValue().idadeProperty();
			if (idadeProperty != null) {
				return idadeProperty.asObject();
			} else {
				return new SimpleIntegerProperty(0).asObject();
			}
		});

		telefoneColumn.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());
		emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		cargoColumn.setCellValueFactory(cellData -> cellData.getValue().cargoProperty());
		salarioColumn.setCellValueFactory(cellData -> cellData.getValue().salarioProperty().asObject());

		imageColumn.setCellFactory(param -> {
		    EditButtonCell cell = new EditButtonCell();
		    
		    // Configure a ação do botão personalizado para chamar o método Editar
		    cell.setEditarAction(event -> {
		        Funcionario funcionario = cell.getTableRow().getItem();
		        if (funcionario != null) {
		            Editar(funcionario);
		        }
		    });
		    
		    return cell;
		});
		
		try {
			tableView.getItems().addAll(TabelaFuncionarioDao.inicializatabela());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// filtra os funcionarios
	@FXML
	void Filtro(MouseEvent event) {

		try {

			   FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/gerente/TabelaFuncionario_Filtro.fxml"));
		        Parent root = loader.load();
		        TabelaFuncionario_FiltroController filtroController = loader.getController();
		        filtroController.setTabelaFuncionarioController(this); // Passa a instância atual

		        // Configuração do novo Stage
		        Stage newStage = new Stage();
		        newStage.initStyle(StageStyle.UNDECORATED); // Remove a barra de título
		        newStage.setTitle("Filtro");
		        newStage.initModality(Modality.APPLICATION_MODAL);
		        newStage.setScene(new Scene(root));

		        // Torna a janela arrastável (draggable)
		        makeStageDraggable(newStage, root);

		        // Exibe a nova cena em um novo Stage
		        newStage.showAndWait();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}

	// remove um funcionario da tabela
	@FXML
	void RemoverFuncionario(MouseEvent event) {

	}

	@FXML
	void Pesquisar(MouseEvent event) {

		if (TxtPesquisa.getText() != "") {
			tableView.getItems().clear();
			nomeCompletoColumn.setCellValueFactory(cellData -> cellData.getValue().nomeCompletoProperty());
			cpfColumn.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
			idadeColumn.setCellValueFactory(cellData -> {
				IntegerProperty idadeProperty = cellData.getValue().idadeProperty();
				if (idadeProperty != null) {
					return idadeProperty.asObject();
				} else {
					return new SimpleIntegerProperty(0).asObject();
				}
			});

			telefoneColumn.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());
			emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
			cargoColumn.setCellValueFactory(cellData -> cellData.getValue().cargoProperty());
			salarioColumn.setCellValueFactory(cellData -> cellData.getValue().salarioProperty().asObject());

			try {
				tableView.getItems().addAll(TabelaFuncionarioDao.PesquisaFuncionario(TxtPesquisa.getText()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			initialize();
		}

	}

	@FXML
	void vol1(MouseEvent event) throws Exception {

		Main.Cena("TelaPrincipalGerente");

	}

	@FXML
	void PressionarEnter(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {

			Pesquisar(null);

		}

	}

	public void AplicaFiltro(String comando) {
		tableView.getItems().clear();
		nomeCompletoColumn.setCellValueFactory(cellData -> cellData.getValue().nomeCompletoProperty());
		cpfColumn.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());
		idadeColumn.setCellValueFactory(cellData -> {
			IntegerProperty idadeProperty = cellData.getValue().idadeProperty();
			if (idadeProperty != null) {
				return idadeProperty.asObject();
			} else {
				return new SimpleIntegerProperty(0).asObject();
			}
		});

		telefoneColumn.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());
		emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
		cargoColumn.setCellValueFactory(cellData -> cellData.getValue().cargoProperty());
		salarioColumn.setCellValueFactory(cellData -> cellData.getValue().salarioProperty().asObject());

		try {
			tableView.getItems().addAll(TabelaFuncionarioDao.aplicarFiltro(comando));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	public void Editar(Funcionario funcionario) {
		

		try {

			  
		        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/gerente/EditaFuncionario.fxml"));
		        Parent root = loader.load();
		        EditaFuncionarioController EditaFuncionarioController = loader.getController();
		        EditaFuncionarioController.setTabelaFuncionarioController(this);
		        EditaFuncionarioController.setFuncionario(funcionario); // Configura o funcionário a ser editado
		        
		        // Configuração do novo Stage
		        Stage newStage = new Stage();
		        newStage.initStyle(StageStyle.UNDECORATED); // Remove a barra de título
		        newStage.setTitle("Edita Funcionario");
		        newStage.initModality(Modality.APPLICATION_MODAL);
		        newStage.setScene(new Scene(root));

		     
		        makeStageDraggable(newStage, root);

		       
		        newStage.showAndWait();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		

	}

	@FXML
	void imprimir(MouseEvent event) {

		PrinterJob printerJob = PrinterJob.createPrinterJob();
		if (printerJob != null && printerJob.showPrintDialog(tableView.getScene().getWindow())) {
			printerJob.printPage(tableView);
			printerJob.endJob();
		}

	}

	// efeitos dos botões



	@FXML
	void EfeitoFiltro(MouseEvent event) {

		BtnFiltro.setEffect(efeito.Efeito());

	}

	@FXML
	void EfeitoImprimir(MouseEvent event) {

		BtnImprimir.setEffect(efeito.Efeito());

	}



	@FXML
	void SairFiltro(MouseEvent event) {

		BtnFiltro.setEffect(null);

	}

	@FXML
	void SairImprimir(MouseEvent event) {

		BtnImprimir.setEffect(null);

	}

	

	
	private void makeStageDraggable(Stage stage, Parent root) {
	    final Delta dragDelta = new Delta();

	    root.setOnMousePressed(event -> {
	        // Quando o mouse é pressionado, calcula a diferença entre a posição atual do mouse
	        // e a posição da janela
	        dragDelta.x = stage.getX() - event.getScreenX();
	        dragDelta.y = stage.getY() - event.getScreenY();
	    });

	    root.setOnMouseDragged(event -> {
	        // Quando o mouse é arrastado, move a janela para a nova posição
	        stage.setX(event.getScreenX() + dragDelta.x);
	        stage.setY(event.getScreenY() + dragDelta.y);
	    });
	}

	// Classe auxiliar para armazenar a diferença entre as coordenadas do mouse e da janela
	class Delta {
	    double x, y;
	}
	
	 @FXML
	    void AbrirSideBar(MouseEvent event) {

	    	 try {
	    	        // Carregue a cena da barra lateral a partir do arquivo FXML
	    	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/gerente/SideBarGerente.fxml"));
	    	        AnchorPane sideBarRoot = loader.load();

	    	        // Crie uma nova janela para exibir a cena da barra lateral
	    	        Stage sideBarStage = new Stage();
	    	        sideBarStage.initStyle(StageStyle.UNDECORATED);
	    	        Scene sideBarScene = new Scene(sideBarRoot);
	    	        sideBarStage.setScene(sideBarScene);

	    	        sideBarStage.setX(0);
	    	        sideBarStage.setY(0);
	    	        // Exiba a janela da barra lateral
	    	        sideBarStage.show();
	    	    } catch (IOException e) {
	    	        e.printStackTrace();
	    	    }
	    	
	    	
	    }
	    
	   
	  public void AlterarComponentes(Image fundo,Image logo,String txtf,String letraTxtf,String btn,String letraBtn,
				String corPrincipal,String corSecundaria,String corTercearia) {
		  
		  

		  

	

		    ImagemDeFundo.setImage(fundo);

		    Logo.setImage(logo);;

		    PainelDeCima.setStyle("-fx-background-color:"+corPrincipal);

		    PainelPrincipal.setStyle("-fx-background-color:"+corPrincipal);

		    TextoDoPainelDeCima.setStyle("-fx-background-color:"+corSecundaria);
		    
		    TextoDoPainelDeCima.setStyle("-fx-text-fill:"+letraTxtf);


		    TextoDoPainelDeCima1.setStyle("-fx-background-color:"+corSecundaria);

		    TextoDoPainelDeCima11.setStyle("-fx-background-color:"+corSecundaria);

		    TxtPesquisa.setStyle("-fx-background-color:"+corSecundaria);

		 
		    TextoDoPainelDeCima1.setStyle("-fx-text-fill:"+letraTxtf);

		    TextoDoPainelDeCima11.setStyle("-fx-text-fill:"+letraTxtf);

		    TxtPesquisa.setStyle("-fx-text-fill:"+letraTxtf);
		    

		  
		  
	  }
	
	
}
