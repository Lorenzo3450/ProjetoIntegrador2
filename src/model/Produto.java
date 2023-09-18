package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;

public class Produto {
    private StringProperty descricao;
    private ObjectProperty<LocalDate> validade;
    private IntegerProperty quantidade;
    private DoubleProperty valorCompraUnidade;
    private DoubleProperty valorVendaUnidade;
    private StringProperty marca;
    private StringProperty codigo;
    private IntegerProperty quantidadeAdquirida;
    private IntegerProperty quantidadeVendida;
    private DoubleProperty faturamento;
    private StringProperty porcentagem;
    private StringProperty curva;  
    private StringProperty porcentagemAcumulada;



    public Produto(String descricao, LocalDate validade, int quantidade, double valorCompraUnidade,
            double valorVendaUnidade, String marca, String codigo, int quantidadeAdquirida,
            int quantidadeVendida, double faturamento) {
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
 this.curva = new SimpleStringProperty(""); // Inicialize o campo curva aqui
 this.porcentagem = new SimpleStringProperty("");
 this.porcentagemAcumulada = new SimpleStringProperty("");

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
    

    // Métodos getters e setters para os campos

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

    public void setValidade(LocalDate validade) {
        this.validade.set(validade);
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

    public String getPorcentagem() {
        return porcentagem.get();
    }

    public StringProperty porcentagemProperty() {
        return porcentagem;
    }

    public void setPorcentagem(String porcentagem) {
        this.porcentagem.set(porcentagem);
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
                ", curva='" + curva.get() + '\'' + // Inclua a curva na representação
                '}';
    }
}
