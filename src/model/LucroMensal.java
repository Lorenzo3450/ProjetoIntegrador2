package model;

public class LucroMensal {
    private String mes;
    private int ano;
    private double lucro;

    public LucroMensal(String mes, int ano, double lucro) {
        this.mes = mes;
        this.ano = ano;
        this.lucro = lucro;
    }

    public String getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public double getLucro() {
        return lucro;
    }
}