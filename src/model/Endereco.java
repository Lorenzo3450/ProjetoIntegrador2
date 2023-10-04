package model;

public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;


    // Construtor vazio
    public Endereco() {
    }

 
    
    // Construtor com todos os atributos
    public Endereco(String logradouro, String bairro, String cep, String cidade) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }

    // Métodos getters e setters para todos os atributos

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // Outros métodos, se necessário
}
