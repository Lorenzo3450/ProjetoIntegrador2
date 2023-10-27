package controller.gerente;

import java.sql.SQLException;

import controller.Ferramentas.EfeitoBtn;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Funcionario;
import model.dao.Gerente.EditaFuncionarioDao;
import javafx.scene.control.MenuItem;


public class EditaFuncionarioController {
	
	private String textoSelecionado = "";

    @FXML
    private Button BtnAlteracao;
    @FXML
    private MenuButton MenuButton;

    @FXML
    private TextField TxtFieldCPF;


    @FXML
    private TextField TxtFieldNovo;
    
    EfeitoBtn efeito = new EfeitoBtn();

    private TabelaFuncionarioController tabelaFuncionarioController;

    private static Funcionario funcionario;
   

    @FXML
    void Fechar(MouseEvent event) {

    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();

    	
    }


    public void initialize() {
        MenuItem item1 = new MenuItem("Nome Completo");
        MenuItem item2 = new MenuItem("CPF");
        MenuItem item3 = new MenuItem("Data de nascimento");
        MenuItem item4 = new MenuItem("Telefone");
        MenuItem item5 = new MenuItem("Email");
        MenuItem item6 = new MenuItem("Cargo");
        MenuItem item7 = new MenuItem("Salário");

        MenuButton.getItems().removeAll();
        MenuButton.getItems().addAll(item1, item2, item3, item4, item5, item6, item7);

        // Adicione um evento de ação para cada MenuItem
        item1.setOnAction(event -> {
            textoSelecionado = "Nome Completo";
            MenuButton.setText(textoSelecionado);
        });

        item2.setOnAction(event -> {
            textoSelecionado = "CPF";
            MenuButton.setText(textoSelecionado);
        });

        item3.setOnAction(event -> {
            textoSelecionado = "Data de nascimento";
            MenuButton.setText(textoSelecionado);
        });

        item4.setOnAction(event -> {
            textoSelecionado = "Telefone";
            MenuButton.setText(textoSelecionado);
        });

        item5.setOnAction(event -> {
            textoSelecionado = "Email";
            MenuButton.setText(textoSelecionado);
        });

        item6.setOnAction(event -> {
            textoSelecionado = "Cargo";
            MenuButton.setText(textoSelecionado);
        });

        item7.setOnAction(event -> {
            textoSelecionado = "Salario";
            MenuButton.setText(textoSelecionado);
        });
    }
    	
    	
    public void setTabelaFuncionarioController(TabelaFuncionarioController controller) {
        this.tabelaFuncionarioController = controller;
    }
    
    
    
    @FXML
    void RelizaAltercao(MouseEvent event) throws SQLException {
    	
    	EditaFuncionarioDao.AlterarDados(TxtFieldCPF.getText(), MenuButton.getText(), TxtFieldNovo.getText());

    }
    
    @FXML
    void Entrar1(MouseEvent event) {

    	BtnAlteracao.setEffect(efeito.Efeito());
    	
    }
    

    @FXML
    void Sair1(MouseEvent event) {

    	
    	BtnAlteracao.setEffect(null);
    	
    }


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
		TxtFieldCPF.setText(this.funcionario.getCpf());
		
		
	}

}
