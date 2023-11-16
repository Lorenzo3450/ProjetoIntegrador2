package controller.gerente;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DesignSistema;
import model.dao.Gerente.PersonalizaSistemaDao;
import javafx.stage.FileChooser.ExtensionFilter;

public class PersonalizaSistemaController {

	
	private  String fonte;
	private  String cor1;
	private  String cor2;
	private  String cor3;
	private  String logo;
	private  String fundo;
	
    @FXML
    private Button btnSalvar;

	
    @FXML
    private ImageView BtnFundo;

    @FXML
    private ImageView Fundo2;

    @FXML
    private ImageView Fundo21;

    @FXML
    private ImageView ImagemDeFundo;

    @FXML
    private ImageView Logo;

    @FXML
    private ImageView Logo2;

    @FXML
    private ImageView Logo21;

    @FXML
    private AnchorPane PainelDeCima;

    @FXML
    private AnchorPane PainelDeCima1;

    @FXML
    private AnchorPane PainelPrincipal;

    @FXML
    private AnchorPane PainelPrincipal1;

    @FXML
    private AnchorPane PainelPrincipal11;

    @FXML
    private Label TextoDoPainelDeCima;

    @FXML
    private Label TextoDoPainelDeCima1;

    @FXML
    private Label TextoDoPainelDeCima11;

    @FXML
    private Label TextoDoPainelDeCima111;

    @FXML
    private Label TextoDoPainelDeCima1111;

    @FXML
    private Label TextoDoPainelDeCima12;

    @FXML
    private Label TextoDoPainelDeCima121;

    @FXML
    private Label TextoDoPainelDeCima1211;

    @FXML
    private TextField TxtFonte;

    @FXML
    private TextField Txtcor1;

    @FXML
    private TextField Txtcor11;

    @FXML
    private TextField Txtcor2;

    @FXML
    private TextField Txtcor3;

    @FXML
    private ImageView btnLogo;

    @FXML
    private Button btnVisualizacao;

    @FXML
    private Separator divisor;

    @FXML
    private Separator divisor1;

    @FXML
    private ImageView imgSideBar;

    @FXML
    private Line linha1;

    @FXML
    private Line linha10;

    @FXML
    private Line linha11;

    @FXML
    private Line linha12;

    @FXML
    private Line linha13;

    @FXML
    private Line linha14;

    @FXML
    private Separator linha15;

    @FXML
    private Line linha16;

    @FXML
    private Line linha2;

    @FXML
    private Line linha3;

    @FXML
    private Line linha4;

    @FXML
    private Line linha5;

    @FXML
    private Line linha6;

    @FXML
    private Line linha7;

    @FXML
    private Line linha8;

    @FXML
    private Line linha81;

    @FXML
    private Line linha9;

    
    @FXML
    private Label TextoDoPainelDeCima11111;
    
    @FXML
    private Label TextoDoPainelDeCima111111;
    
    @FXML
	private void initialize() {
    	
    	 DesignSistema design = null;
         try {
             design = PersonalizaSistemaDao.buscaDesign();
         } catch (SQLException e) {
             e.printStackTrace();
             // Lidere com erros de consulta aqui, se necessário
         }
         if(design!=null) {

         Image Fundo = new Image(design.getFundoImagem());
         Image Logo = new Image(design.getLogoImagem());
         
    	AlterarComponentes(Fundo, Logo, design.getCorSecundaria(), design.getTipoFonte(),design.getCorSecundaria() , design.getTipoFonte(), design.getCorPrincipal()
    			, design.getCorSecundaria(), design.getCorTerciaria());
         }
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

    
    @FXML
    void AlterarFundo(MouseEvent event) {

   	 // Configurar o FileChooser para filtrar arquivos de imagem
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Imagens", "*.jpg", "*.png", "*.jpeg"));

        // Mostrar o diálogo de seleção de arquivo
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            Fundo2.setImage(new Image(selectedFile.toURI().toString()));   
            Fundo21.setImage(new Image(selectedFile.toURI().toString()));
           fundo = selectedFile.toURI().toString();
            
        }

    	
    }

    @FXML
    void AlterarLogo(MouseEvent event) {

    	 // Configurar o FileChooser para filtrar arquivos de imagem
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Imagens", "*.jpg", "*.png", "*.jpeg"));

        // Mostrar o diálogo de seleção de arquivo
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        if (selectedFile != null) {
            Logo2.setImage(new Image(selectedFile.toURI().toString())); 
            Logo21.setImage(new Image(selectedFile.toURI().toString())); 
            logo = selectedFile.toURI().toString();
        }
	
    	
    }

    
    @FXML
    void PressionarEnter(KeyEvent event) {

    	if (event.getCode() == KeyCode.ENTER) {

    		
    		fonte = TxtFonte.getText();
    		TextoDoPainelDeCima1211.setStyle(TextoDoPainelDeCima1211.getStyle()+"-fx-font-family:"+fonte+";");
    		TextoDoPainelDeCima1111.setStyle(TextoDoPainelDeCima1111.getStyle()+"-fx-font-family:"+fonte+";");
    		TextoDoPainelDeCima11111.setStyle(TextoDoPainelDeCima11111.getStyle()+"-fx-font-family:"+fonte+";");
    		TextoDoPainelDeCima111111.setStyle(TextoDoPainelDeCima111111.getStyle()+"-fx-font-family:"+fonte+";");
    		btnVisualizacao.setStyle(btnVisualizacao.getStyle()+"-fx-font-family:"+fonte+";");
    		
    	}
    }
    

    @FXML
    void PressionarEnter2(KeyEvent event) {

    	if (event.getCode() == KeyCode.ENTER) {
    			
    		cor1 = Txtcor1.getText();
    		PainelPrincipal11.setStyle(PainelPrincipal11.getStyle()+"-fx-background-color:"+cor1+";");
    		PainelDeCima1.setStyle(PainelDeCima1.getStyle()+"-fx-background-color:"+cor1+";");
    		btnVisualizacao.setStyle(btnVisualizacao.getStyle()+"-fx-text-fill:"+cor1+";");

		}
    	
    }

    @FXML
    void PressionarEnter3(KeyEvent event) {

    	if (event.getCode() == KeyCode.ENTER) {

    		cor2 = Txtcor2.getText();
    		TextoDoPainelDeCima1211.setStyle(TextoDoPainelDeCima1211.getStyle()+"-fx-text-fill:"+cor2+";");
    		TextoDoPainelDeCima1111.setStyle(TextoDoPainelDeCima1111.getStyle()+"-fx-text-fill:"+cor2+";");
    		Txtcor11.setStyle(Txtcor11.getStyle()+"-fx-background-color:"+cor2+";");
    		btnVisualizacao.setStyle(btnVisualizacao.getStyle()+"-fx-background-color:"+cor2+";");
    		linha81.setStyle(linha81.getStyle()+"-fx-background-color:"+cor2+";");
    		TextoDoPainelDeCima11111.setStyle(TextoDoPainelDeCima11111.getStyle()+"-fx-text-fill:"+cor2+";");
		}
    	
    }

    @FXML
    void PressionarEnter4(KeyEvent event) {

    	if (event.getCode() == KeyCode.ENTER) {

    		cor3 = Txtcor3.getText();
    		
    		TextoDoPainelDeCima111111.setStyle(TextoDoPainelDeCima111111.getStyle()+"-fx-text-fill:"+cor3+";");

		}
    	
    }
    
    

   @FXML
    void Salvar(MouseEvent event) {
    	
    	 System.out.println(cor1+cor2+ fundo+ cor3+ fonte+ logo);
    	

        System.out.println(cor1+cor2+ fundo+ cor3+ fonte+ logo);
        if (cor1 != null && !cor1.isEmpty() &&
        	    cor2 != null && !cor2.isEmpty() &&
        	    cor3 != null && !cor3.isEmpty() &&
        	    fundo != null && !fundo.isEmpty() &&
        	    fonte != null && !fonte.isEmpty() &&
        	    logo != null && !logo.isEmpty()) {
        	
        	    DesignSistema design = new DesignSistema(cor1, cor2, fundo, cor3, fonte, logo);
        	   try {
        	    	
        	       PersonalizaSistemaDao.atualizaDesign(design);
        	       JOptionPane.showMessageDialog(null,"Design salvo com sucesso.");
        	    } catch (SQLException e) {
        	        e.printStackTrace();
        	        JOptionPane.showMessageDialog(null,"Erro ao salvar o design.");
        	  }
        	} else {
        	    System.out.println("Preencha todos os campos antes de salvar.");
        	}

}
   
   
   
	public void AlterarComponentes(Image fundo,Image logo,String txtf,String letraTxtf,String btn,String letraBtn,
			String corPrincipal,String corSecundaria,String corTercearia) {
		
		
		Fundo2.setImage(fundo);;
		Fundo21.setImage(fundo);
		ImagemDeFundo.setImage(fundo);
		
		Logo.setImage(logo);
		Logo2.setImage(logo);
		Logo21.setImage(logo);
		
		
		PainelDeCima.setStyle(PainelDeCima.getStyle()+"-fx-background-color:"+corPrincipal);
		PainelDeCima1.setStyle(PainelDeCima1.getStyle()+"-fx-background-color:"+corPrincipal);
		
		
		PainelPrincipal.setStyle(PainelPrincipal.getStyle()+"-fx-background-color:"+corPrincipal);
		PainelPrincipal1.setStyle(PainelPrincipal1.getStyle()+"-fx-background-color:"+corPrincipal);
		PainelPrincipal11.setStyle(PainelPrincipal11.getStyle()+"-fx-background-color:"+corPrincipal);


		
	}
    
    
    }
