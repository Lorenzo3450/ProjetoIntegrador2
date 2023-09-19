package model;

public class Secao {
    private String nomeSecao;
    private double lucro;

    public Secao(String nomeSecao, double lucro) {
        this.nomeSecao = nomeSecao;
        this.lucro = lucro;
    }

    public String getNomeSecao() {
        return nomeSecao;
    }

    public double getLucro() {
        return lucro;
    }
}
