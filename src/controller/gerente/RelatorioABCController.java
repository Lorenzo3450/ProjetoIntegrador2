package controller.gerente;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Produto;
import model.dao.ConexãoBD;
import model.dao.Gerente.RelatorioABCDao;

import java.util.List;

import controller.Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Collections; 


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RelatorioABCController {
	
	DecimalFormat df = new DecimalFormat("#.00");

    @FXML
    private TableColumn<Produto, String> AcumuladaColumn;

    @FXML
    private ImageView BtnFiltro;

    @FXML
    private ImageView BtnImprimir;

    @FXML
    private ImageView BtnPesquisar;

    @FXML
    private TableColumn<Produto, String> CurvaColumn;

    @FXML
    private TableColumn<Produto, Double> FaturamentoColumn;

    @FXML
    private TableColumn<Produto, String> PorcentagemColumn;

    @FXML
    private TableColumn<Produto, String> ProdutoColumn;

    @FXML
    private TextField TxtPesquisa;

    @FXML
    private TableView<Produto> tableView;
    
    private RelatorioABCDao relatorioABCDao;

 
    private ObservableList<Produto> produtosList = FXCollections.observableArrayList(); // Crie uma lista observável para armazenar seus produtos


    private void calcularPorcentagensEAdicionarCurva() {
    	


       
        Collections.sort(produtosList, (produto1, produto2) -> {
            double faturamento1 = produto1.getFaturamento();
            double faturamento2 = produto2.getFaturamento();
            return Double.compare(faturamento2, faturamento1);
        });

        double totalFaturamento = 0.0;

        // Calcular o total do faturamento
        for (Produto produto : produtosList) {
            totalFaturamento += produto.getFaturamento();
        }

        double porcentagemAcumulada = 0.0;

        // Calcular porcentagens e adicionar a curva
        for (Produto produto : produtosList) {
            double faturamentoProduto = produto.getFaturamento();
            double porcentagemProduto = (faturamentoProduto / totalFaturamento) * 100;
            porcentagemAcumulada += porcentagemProduto;
            produto.setPorcentagem(df.format(porcentagemProduto)+"%");
            produto.setPorcentagemAcumulada(df.format(porcentagemAcumulada)+"%");
            if (porcentagemAcumulada <= 60) {
                produto.setCurva("A");
            } else if (porcentagemAcumulada <= 90) {
                produto.setCurva("B");
            } else {
                produto.setCurva("C");
            }
        }
    }

    private void carregarDadosDoBanco() {
    	
    	
    	
        try {
            Connection conexao = ConexãoBD.Conexao(); // Obtenha uma conexão com o banco de dados
            relatorioABCDao = new RelatorioABCDao(conexao); // Crie uma instância do DAO com a conexão

            // Substitua o método abaixo com o método apropriado do seu DAO para obter os produtos do banco de dados
            List<Produto> produtosDoBanco = relatorioABCDao.obterProdutosDoBanco();

            produtosList.addAll(produtosDoBanco);

            calcularPorcentagensEAdicionarCurva(); // Calcule porcentagens e adicione a curva
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void initialize() {
    	
        ProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().descricaoProperty());
        CurvaColumn.setCellValueFactory(cellData -> cellData.getValue().curvaProperty());
        FaturamentoColumn.setCellValueFactory(cellData -> cellData.getValue().faturamentoProperty().asObject());
        PorcentagemColumn.setCellValueFactory(cellData -> cellData.getValue().porcentagemProperty());
        AcumuladaColumn.setCellValueFactory(cellData -> cellData.getValue().porcentagemAcumuladaProperty());
  


    	
    	
        carregarDadosDoBanco();


        calcularPorcentagensEAdicionarCurva();

      
        
        tableView.setItems(produtosList);
       
        
        
    }
    
    
    @FXML
    void EfeitoFiltro(MouseEvent event) {

    }

    @FXML
    void EfeitoImprimir(MouseEvent event) {

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
    void SairFiltro(MouseEvent event) {

    }

    @FXML
    void SairImprimir(MouseEvent event) {

    }

    @FXML
    void imprimir(MouseEvent event) {

    }

    @FXML
    void vol1(MouseEvent event) throws Exception {

    	Main.Cena("TelaPrincipalGerente");

    	
    }

}
