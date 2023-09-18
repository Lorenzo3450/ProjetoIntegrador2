package controller.gerente;

import controller.Ferramentas.EfeitoBtn;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.stage.Stage;


public class TabelaFuncionario_FiltroController {

	private static String outros ="";
	
	private static int contador=0;
	
	EfeitoBtn efeito = new EfeitoBtn();
	
	TabelaFuncionarioController c = new TabelaFuncionarioController();

	String com1,com2,com3 ="(",com4="" ;
	

	@FXML
    private AnchorPane Painel;
	
    @FXML
    private RadioButton RBtnRH;
	
	@FXML
    private RadioButton RBtnAtendente;
    
    @FXML
    private ImageView BtnPesquisa;
    
    @FXML
    private ImageView BtnLimpar;

    @FXML
    private RadioButton RBtnGerente;

    @FXML
    private RadioButton RBtnGestor;

    @FXML
    private RadioButton RBtnNãoDefinido;
    
    @FXML
    private TextField TxtFieldOutros;

    @FXML
    private VBox ScrollPane;

    @FXML
    private TextField TxtIdade1;

    @FXML
    private TextField TxtIdade2;

    @FXML
    private TextField TxtISalario1;

    @FXML
    private TextField TxtSalario2;

    private TabelaFuncionarioController tabelaFuncionarioController;

    
    public void setTabelaFuncionarioController(TabelaFuncionarioController controller) {
        this.tabelaFuncionarioController = controller;
    }
    
    @FXML
    void Fechar(MouseEvent event) {

    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        stage.close();
    
    	
    	
    }
    
    
    
    @FXML
    void PresionaEnter(KeyEvent event) {
    	
    	
    	
        if (event.getCode() == KeyCode.ENTER) {
            String textoDigitado = TxtFieldOutros.getText();
            
            Label label = new Label(textoDigitado);
           ScrollPane.getChildren().add(label);
           	
           if(contador ==0) {
           
           outros += "cargo = '"+ textoDigitado+"'";
           }else {
        	   
        	   outros += " or "+ "cargo = '"+textoDigitado+"'";	
           
           }
           System.out.println(outros);
           
           contador++;
           
            TxtFieldOutros.clear();
        }
    }


    @FXML
    void Pesquisar(MouseEvent event) {
    	

    	com1=null;
    	com2=null;
    	com3 = "(";
    	com4="";
    	
    	if(TxtIdade1.getText() != "" && TxtIdade2.getText() != "") {
    		
    		com1 = "TIMESTAMPDIFF(YEAR, data_nasc, CURDATE()) BETWEEN "+TxtIdade1.getText()+" and "+TxtIdade2.getText();
    		
    	}
    	
    	if (!TxtISalario1.getText().isEmpty() && !TxtSalario2.getText().isEmpty()) {
    	    com2 = "salario >= " + TxtISalario1.getText() + " and salario <= " + TxtSalario2.getText();
    	}
    	
    	if(RBtnRH.isSelected()) {
    		if(RBtnGerente.isSelected()||RBtnAtendente.isSelected()|| RBtnGestor.isSelected()||RBtnNãoDefinido.isSelected()) {
    		com3 += "cargo = 'RH'or ";
    		}else com3 += "cargo = 'RH'";
    	}
    	
    	if(RBtnGerente.isSelected()) {
    		if(RBtnAtendente.isSelected()|| RBtnGestor.isSelected()||RBtnNãoDefinido.isSelected()) {
    		com3 += "cargo = 'Gerente'or ";
    		}else com3 += "cargo = 'Gerente'";
    	}
    	
    	if(RBtnGestor.isSelected()) {
    		if(RBtnAtendente.isSelected()||RBtnNãoDefinido.isSelected()) {
    		com3 += "cargo = 'Gestor' or ";
    		}else com3 += "cargo = 'Gestor'";
    	}
    	
    	if(RBtnAtendente.isSelected()) {
    		if(RBtnNãoDefinido.isSelected()) {
    		com3 += "cargo = 'Atendente' or ";
    		}else com3 += "cargo='Atendente'";
    	}
    	
    	if(RBtnNãoDefinido.isSelected()) {
    	
    		com3 += "cargo ='Não definido'";
    	
    	}
    	
    	if(outros.equals("")) {
    		
    	com3 +=")";
    	
    	}else if(com3.equals("(")){
    		
    		com3 += outros+")";
    	
    		
    	}else {
    		
    		com3 += " or "+outros+")";
    		
    	}
    	
    	com4 = com1 != null ? com4+com1 : com4+"";
    	System.out.println("1:"+com4);
    	com4 = com1 != null && com2!=null ?com4+" and " : com4+"";
    	System.out.println("2:"+com4);
    	com4 = com2 != null ? com4+com2 : com4+"";
    	System.out.println("3:"+com4);
    	com4 = (com2 !=null||com1 != null) && ! com3.equals("()") ? com4+" and " : com4+"" ;
    	System.out.println("4:"+com4);
    	com4 = com3.equals("()") ? com4+"" : com4+com3;
    	
    	System.out.println("4:"+com4);
    	
    	   if (tabelaFuncionarioController != null) {
    		
               tabelaFuncionarioController.AplicaFiltro(com4);
              
           }
    	
    }
    
    
    @FXML
    void LimparCampos(MouseEvent event) {
    	
    	outros ="";
    	contador=0;
    	ScrollPane.getChildren().clear();
    	
    }
    

    @FXML
    void Entrar1(MouseEvent event) {

    	BtnPesquisa.setEffect(efeito.Efeito());
    	
    }

    
    @FXML
    void Entrar2(MouseEvent event) {

    	BtnLimpar.setEffect(efeito.Efeito());
    	
    }
    


    @FXML
    void Sair1(MouseEvent event) {
    	
    	BtnPesquisa.setEffect(null);
    }
    
    
    @FXML
    void Sair2(MouseEvent event) {
    	
    	BtnPesquisa.setEffect(null);
    }
    

}

