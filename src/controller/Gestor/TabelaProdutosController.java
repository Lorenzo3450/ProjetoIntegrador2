package controller.Gestor;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Produto;
import model.Gestor.TabelaProdutoDao;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import controller.Main;
import controller.Ferramentas.EditButtonCell;
import controller.Ferramentas.EditButtonCellProduto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler; 
import javafx.scene.control.cell.PropertyValueFactory;

	public class TabelaProdutosController {

	    @FXML
	    private ImageView BtnFiltro;

	    @FXML
	    private ImageView BtnImprimir;

	    @FXML
	    private ImageView BtnPesquisar;

	    @FXML
	    private ImageView BtnRemoverFuncionario;

	    @FXML
	    private TableView<Produto> tableView;

	    @FXML
	    private TableColumn<Produto, String> columSessao;

	    @FXML
	    private TableColumn<Produto, Integer> EstoqueMinimo;

	    @FXML
	    private TableColumn<Produto, Integer> Quantidade;

	    @FXML
	    private TableColumn<Produto, LocalDate> Validae;

	    @FXML
	    private TableColumn<Produto, Double> PrecoVendido;

	    @FXML
	    private TableColumn<Produto, Void> imageColumn;

	    @FXML
	    private TableColumn<Produto, String> nomeDescrição;

	    @FXML
	    private TableColumn<Produto, Double> PrecoComprado;

	    
	    
	    
	    @FXML
	    private void initialize() {
	        configurarColunas();
	        preencherTabela();
	    }

	    private void configurarColunas() {
	        // Limpar os itens existentes na tabela
	        tableView.getItems().clear();

	        // Configurar as colunas da tabela
	        columSessao.setCellValueFactory(cellData -> cellData.getValue().codigoProperty());
	        EstoqueMinimo.setCellValueFactory(cellData -> cellData.getValue().estoqueMinimoProperty().asObject());
	        Quantidade.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty().asObject());
	        Validae.setCellValueFactory(cellData -> cellData.getValue().validadeProperty());
	        PrecoVendido.setCellValueFactory(cellData -> cellData.getValue().valorVendaUnidadeProperty().asObject());
	        nomeDescrição.setCellValueFactory(cellData -> cellData.getValue().descricaoProperty());
	        PrecoComprado.setCellValueFactory(cellData -> cellData.getValue().valorCompraUnidadeProperty().asObject());

	        imageColumn.setCellFactory(param -> {
	            EditButtonCellProduto cell = new EditButtonCellProduto();

	            // Configure a ação do botão personalizado para chamar o método Editar
	            cell.setEditarAction(event -> {
	                Produto produto = cell.getTableRow().getItem();
	                if (produto != null) {
	                    Editar(produto);
	                }
	            });

	            return cell;
	        });
	    }

	    private void preencherTabela() {
	        // Preencher a tabela com os produtos
	        try {
	            tableView.getItems().addAll(TabelaProdutoDao.inicializarTabela());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    private void Editar(Produto produto) {
			// TODO Auto-generated method stub
			
		}



		@FXML
	    void EfeitoFiltro(MouseEvent event) {

	    }

	    @FXML
	    void EfeitoImprimir(MouseEvent event) {

	    }

	    @FXML
	    void EfeitoRemoverFuncionario(MouseEvent event) {

	    }

	    @FXML
	    void Filtro(MouseEvent event) {

	    }

	    @FXML
	    void Pesquisar(MouseEvent event) {

	    }

	    @FXML
	    void PressionarEnter(KeyEvent event) {

	    }

	    @FXML
	    void RemoverFuncionario(MouseEvent event) {

	    }

	    @FXML
	    void SairFiltro(MouseEvent event) {

	    }

	    @FXML
	    void SairImprimir(MouseEvent event) {

	    }

	    @FXML
	    void SairRemoverFuncionario(MouseEvent event) {

	    }

	    @FXML
	    void imprimir(MouseEvent event) {

	    }

	    @FXML
	    void vol1(MouseEvent event) throws Exception {

	    	Main.Cena("MenuGestor");
	    	
	    }

	}

	
	

