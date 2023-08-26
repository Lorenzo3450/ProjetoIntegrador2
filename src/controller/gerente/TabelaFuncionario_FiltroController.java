package controller.gerente;

import controller.Ferramentas.EfeitoBtn;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class TabelaFuncionario_FiltroController {

	EfeitoBtn efeito = new EfeitoBtn();
	
	TabelaFuncionarioController c = new TabelaFuncionarioController();

	String com1,com2,com3 ="(",com4="" ;
	
	@FXML
    private RadioButton RBtnAtendente;
    
    @FXML
    private ImageView BtnPesquisa;

    @FXML
    private RadioButton RBtnGerente;

    @FXML
    private RadioButton RBtnGestor;

    @FXML
    private RadioButton RBtnNãoDefinido;

    @FXML
    private TextField TxtIdade1;

    @FXML
    private TextField TxtIdade2;

    @FXML
    private TextField TxtISalario1;

    @FXML
    private TextField TxtSalario2;

    @FXML
    void Entrar1(MouseEvent event) {

    	BtnPesquisa.setEffect(efeito.Efeito());
    	
    }
    private TabelaFuncionarioController tabelaFuncionarioController;

    
    public void setTabelaFuncionarioController(TabelaFuncionarioController controller) {
        this.tabelaFuncionarioController = controller;
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
    	
    	com3 +=")";
    	
    	com4 = com1 != null ? com4+com1 : com4+"";
    	System.out.println("1:"+com4);
    	com4 = com1 != null && com2!=null ?com4+" and " : com4+"";
    	System.out.println("2:"+com4);
    	com4 = com2 != null ? com4+com2 : com4+"";
    	System.out.println("3:"+com4);
    	com4 = (com2 !=null||com1 != null) && ! com3.equals("()") ? com4+" and " : com4+"" ;
    	System.out.println("4:"+com4);
    	com4 = com3.equals("()") ? com4+"" : com4+com3;
    	
    	   if (tabelaFuncionarioController != null) {
    		
               tabelaFuncionarioController.AplicaFiltro(com4);
              
           }
    	
    }
    
    
    
    
    
    


    @FXML
    void Sair1(MouseEvent event) {
    	
    	BtnPesquisa.setEffect(null);
    }

}

