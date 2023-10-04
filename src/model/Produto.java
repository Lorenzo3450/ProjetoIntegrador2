package model;

import javafx.beans.property.*;

import java.sql.Date;
import java.time.LocalDate;

public class Produto {
    private final StringProperty descricao;
    private final ObjectProperty<LocalDate> validade;
    private final IntegerProperty quantidade;
    private final DoubleProperty valorCompraUnidade;
    private final DoubleProperty valorVendaUnidade;
    private final StringProperty marca;
    private final StringProperty codigo;
    private final IntegerProperty quantidadeAdquirida;
    private final IntegerProperty quantidadeVendida;
    private final DoubleProperty faturamento;
    private final StringProperty porcentagem;
    private final StringProperty curva;
    private final StringProperty porcentagemAcumulada;
    private final IntegerProperty estoqueMinimoProperty;
    private Date DataCompra;
    private Date Validade;
    private float ValorCompradoUnidade;
    private float ValorVendidoUnidade;
    private String MarcaProduto;
    private String CodigoProduto;
    private int IdFornecedor;
    private int setQuantidadeVendida;
    private int IdSecao; 
    private int estoqueMinimo;
    
    
    public int getIdSecao() {
		return IdSecao;
	}






	public void setIdSecao(int idSecao) {
		IdSecao = idSecao;
	}






	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}






	public void setEstoqueMinimo(int estoqueMinimo) {
	    this.estoqueMinimo = estoqueMinimo;
	}






	public String getCodigoProduto() {
		return CodigoProduto;
	}






	public void setCodigoProduto(String codigoProduto) {
		CodigoProduto = codigoProduto;
	}






	public int getIdFornecedor() {
		return IdFornecedor;
	}






	public void setIdFornecedor(int idFornecedor) {
		IdFornecedor = idFornecedor;
	}






	public int getSetQuantidadeVendida() {
		return setQuantidadeVendida;
	}






	public void setSetQuantidadeVendida(int setQuantidadeVendida) {
		this.setQuantidadeVendida = setQuantidadeVendida;
	}






	public float getValorVendidoUnidade() {
		return ValorVendidoUnidade;
	}






	public void setValorVendidoUnidade(float valorVendidoUnidade) {
		ValorVendidoUnidade = valorVendidoUnidade;
	}






	public String getMarcaProduto() {
		return MarcaProduto;
	}






	public void setMarcaProduto(String marcaProduto) {
		MarcaProduto = marcaProduto;
	}






	public float getValorCompradoUnidade() {
		return ValorCompradoUnidade;
	}






	public void setValorCompradoUnidade(float valorCompradoUnidade) {
		ValorCompradoUnidade = valorCompradoUnidade;
	}






	public void setValidade(Date validade) {
		Validade = validade;
	}






	public Date getDataCompra() {
		return DataCompra;
	}






	public void setDataCompra(Date dataCompra) {
		DataCompra = dataCompra;
	}





	public Produto(
		    String descricao, LocalDate validade, int quantidade, double valorCompraUnidade,
		    double valorVendaUnidade, String marca, String codigo, int quantidadeAdquirida,
		    int quantidadeVendida, double faturamento, int estoqueMinimo
		) {
		    this.descricao = new SimpleStringProperty(descricao);
		    this.validade = new SimpleObjectProperty<>(validade);
		    this.quantidade = new SimpleIntegerProperty(quantidade);
		    this.valorCompraUnidade = new SimpleDoubleProperty(valorCompraUnidade);
		    this.valorVendaUnidade = new SimpleDoubleProperty(valorVendaUnidade);
		    this.marca = new SimpleStringProperty(marca);
		    this.codigo = new SimpleStringProperty(codigo);
		    this.quantidadeAdquirida = new SimpleIntegerProperty(quantidadeAdquirida);
		    this.quantidadeVendida = new SimpleIntegerProperty(quantidadeVendida);
		    this.faturamento = new SimpleDoubleProperty(faturamento);
		    this.curva = new SimpleStringProperty("");
		    this.porcentagem = new SimpleStringProperty("");
		    this.porcentagemAcumulada = new SimpleStringProperty("");
		    this.estoqueMinimoProperty = new SimpleIntegerProperty(estoqueMinimo);
		}





    public String getPorcentagem() {
        return porcentagem.get();
    }

    public StringProperty porcentagemProperty() {
        return porcentagem;
    }
    
    public IntegerProperty estoqueMinimoProperty() {
        return estoqueMinimoProperty;
    }

    public void setPorcentagem(String porcentagem) {
        this.porcentagem.set(porcentagem);
    }




	public String getDescricao() {
        return descricao.get();
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public LocalDate getValidade() {
        return validade.get();
    }

    public ObjectProperty<LocalDate> validadeProperty() {
        return validade;
    }

 

    public int getQuantidade() {
        return quantidade.get();
    }

    public IntegerProperty quantidadeProperty() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade.set(quantidade);
    }

    public double getValorCompraUnidade() {
        return valorCompraUnidade.get();
    }

    public DoubleProperty valorCompraUnidadeProperty() {
        return valorCompraUnidade;
    }

    public void setValorCompraUnidade(double valorCompraUnidade) {
        this.valorCompraUnidade.set(valorCompraUnidade);
    }

    public double getValorVendaUnidade() {
        return valorVendaUnidade.get();
    }

    public DoubleProperty valorVendaUnidadeProperty() {
        return valorVendaUnidade;
    }

    public void setValorVendaUnidade(double valorVendaUnidade) {
        this.valorVendaUnidade.set(valorVendaUnidade);
    }

    public String getMarca() {
        return marca.get();
    }

    public StringProperty marcaProperty() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    public String getCodigo() {
        return codigo.get();
    }

    public StringProperty codigoProperty() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo.set(codigo);
    }

    public int getQuantidadeAdquirida() {
        return quantidadeAdquirida.get();
    }

    public IntegerProperty quantidadeAdquiridaProperty() {
        return quantidadeAdquirida;
    }

    public void setQuantidadeAdquirida(int quantidadeAdquirida) {
        this.quantidadeAdquirida.set(quantidadeAdquirida);
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida.get();
    }

    public IntegerProperty quantidadeVendidaProperty() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida.set(quantidadeVendida);
    }

    public double getFaturamento() {
        return faturamento.get();
    }

    public DoubleProperty faturamentoProperty() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento.set(faturamento);
    }

   
    
    public String getCurva() {
        return curva.get();
    }

    public StringProperty curvaProperty() {
        return curva;
    }

    public void setCurva(String curva) {
        this.curva.set(curva);
    }

    public String getPorcentagemAcumulada() {
        return porcentagemAcumulada.get();
    }

    public StringProperty porcentagemAcumuladaProperty() {
        return porcentagemAcumulada;
    }

    public void setPorcentagemAcumulada(String porcentagemAcumulada) {
        this.porcentagemAcumulada.set(porcentagemAcumulada);
    }
    
    
    
    

    @Override
    public String toString() {
        return "Produto{" +
                "descricao='" + descricao.get() + '\'' +
                ", validade=" + validade.get() +
                ", quantidade=" + quantidade.get() +
                ", valorCompraUnidade=" + valorCompraUnidade.get() +
                ", valorVendaUnidade=" + valorVendaUnidade.get() +
                ", marca='" + marca.get() + '\'' +
                ", codigo='" + codigo.get() + '\'' +
                ", quantidadeAdquirida=" + quantidadeAdquirida.get() +
                ", quantidadeVendida=" + quantidadeVendida.get() +
                ", faturamento=" + faturamento.get() +
                ", porcentagem=" + porcentagem.get() +
                ", curva='" + curva.get() + '\'' +
                ", porcentagemAcumulada='" + porcentagemAcumulada.get() + '\'' +
                '}';
    }











}



