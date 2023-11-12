package controller.Caixa;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.DesignSistema;
import model.Produto2;
import model.dao.Caixa.TelaDeVendaDao;
import model.dao.Gerente.PersonalizaSistemaDao;

import java.text.DecimalFormat;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyCodeCombination;


import controller.Main;

public class TelaDeVendaController {

	DecimalFormat formato = new DecimalFormat("#.##");
	
    @FXML
    private AnchorPane PainelPrincipal;
	
    @FXML
    private AnchorPane Painel;
	
	
    @FXML
    private ImageView ImagemDeFundo;

    @FXML
    private ImageView Logo;

    @FXML
    private AnchorPane PainelDeCima;

    private Label TextoInicial = new Label();
    
    @FXML
    private Label TextoDoPainelDeCima;

    @FXML
    private TextField TxtPrecoUnitario;

    @FXML
    private ListView<Label> lvListagem;

    @FXML
    private TextField txtCodigoDeBarra;

    @FXML
    private TextField txtDescricao;

    @FXML
    private TextField txtPrecoTotal;

    @FXML
    private TextField txtQuantida;

    @FXML
    private TextField txtSubTotal;
    
    public static double subtotal=0;
    double total=0;
    String codigo;
    int quantidade=1;
    int nItem=0;

    
    // Outros campos anotados com @FXML
    
    public void initialize() {
    	
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

    	   Painel.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
    	        if (event.getCode() == KeyCode.F12) {
    	           try {
					Main.Cena("DefiniFormaDePagamento");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	            System.out.println("Tecla F12 foi pressionada");
    	        }
    	    });
    	
    
    	
    	
        // Adicione um ouvinte de eventos de teclado ao campo de texto txtCodigoDeBarra
        txtCodigoDeBarra.setOnKeyPressed(event -> {
            // Verifica se a tecla Enter (ou outra tecla que sua máquina de leitura de código de barras emule) foi pressionada
            if (event.getCode().isDigitKey() || event.getCode().isLetterKey()) {
                // A tecla pressionada parece ser parte do código de barras
                // Você pode armazenar temporariamente os caracteres e verificar se o código foi concluído
                String codigoDigitado = txtCodigoDeBarra.getText();
                
                // Verifique se o código está completo, por exemplo, se termina com um caractere especial
                if (codigoDigitado.length()==13) {
                	
                	System.out.println("funcionou");
                	System.out.println(codigoDigitado);
                    String codigoDeBarras = codigoDigitado.trim();
                    
                 
                    
                    try {
						processarCodigoDeBarras(codigoDeBarras);
						this.codigo=codigoDeBarras;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
        });

        TextoInicial.setText("NºIntem       Codigo            Descrição            Qtd      Val.Unit     Total");
        TextoInicial.setStyle("-fx-text-fill: black; -fx-font-family: 'Arial'; -fx-font-size: 18;");
        // Adicionar o item ao ListView
        lvListagem.getItems().add(TextoInicial);
    }
    

    
   
    
    //metodo para tratar o codigo de barras recebido
    public void processarCodigoDeBarras(String codigoDeBarras) throws SQLException {
    	
        codigoDeBarras = txtCodigoDeBarra.getText();
        Produto2 produto;
        
        System.out.println("funcionou2");
        //ele está chamando o metodo getProduto que pesquisa no banco o produto com base no codigo de barras fornecido e retorna um objeto da classe produto 
        
        produto = TelaDeVendaDao.getProdutoByCodigoDeBarras(codigoDeBarras);
        
        System.out.println(produto.getDescricao());
        
        //verifica se existe algo no objeto produto 
        if (produto != null) {
        	
            System.out.println("funcionou3");
            
            //altera os Textfield com as informações do produto
            txtDescricao.setText(produto.getDescricao());
            TxtPrecoUnitario.setText(produto.getValorUnidade().toString());
            subtotal += produto.getValorUnidade();
            txtSubTotal.setText("" + formato.format(subtotal));

            
            
           
            if(total==0) {
            	total=produto.getValorUnidade();
            }

            
            if (produto.getCodigo().equals(codigo)) {
            	System.out.println(""+codigo);
            	
            	System.out.println("oi");
            	quantidade++;
            	txtQuantida.setText(""+quantidade);
            	total += produto.getValorUnidade();
            	txtPrecoTotal.setText(""+formato.format(total));
            	
            	
            	//se o produto for o mesmo ele altera o label com a nova quantidade
            	String rotuloFormatado = formatarLabel(nItem, produto.getCodigo(), produto.getDescricao(), quantidade, produto.getValorUnidade(), total);
            	int index = lvListagem.getItems().size() - 1;
                Label produtoLabel = lvListagem.getItems().get(index);
                produtoLabel.setText(rotuloFormatado);
            	
            } else {
                quantidade = 1;
              
                nItem++;
            
                total = produto.getValorUnidade();
               
            
            
          
                String rotuloFormatado = formatarLabel(nItem, produto.getCodigo(), produto.getDescricao(), quantidade, produto.getValorUnidade(), total);
                
              
                lvListagem.getItems().add(new Label(rotuloFormatado));
            }
            
            txtPrecoTotal.setText("" + formato.format(total));
            txtQuantida.setText("" + quantidade);

           

        } else {
            // Lidar com o caso em que o produto não foi encontrado
        }
        txtCodigoDeBarra.clear();
    }

            
            
    public String formatarLabel(int nItem, String codigo, String descricao, int quantidade, double valorUnitario, double total) {
        String linhaFormatada = String.format("%11s %30s %24s %26d %21.2f %20.2f", nItem, codigo, descricao, quantidade, valorUnitario, total);
        return linhaFormatada;
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

    	 
    		PainelPrincipal.setStyle(PainelPrincipal.getStyle()+"-fx-background-color:"+corPrincipal);
    		
    	   
    		
    		
    	   ImagemDeFundo.setImage(fundo);

    	   Logo.setImage(logo);

    	    
    	    PainelDeCima.setStyle("-fx-background-color:"+corPrincipal);;

    	   
    	    
    	   

    	  

    	
    	
    	
    }
    
    

}
