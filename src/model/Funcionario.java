package model;

import java.time.LocalDate;
import java.time.Period;
import javafx.beans.property.*;


public class Funcionario {
	
	private String senha;
    private StringProperty nomeCompletoProperty;
    private StringProperty cpfProperty;
    private IntegerProperty idadeProperty;
    private StringProperty telefoneProperty;
    private StringProperty emailProperty;
    private StringProperty cargoProperty;
    private DoubleProperty salarioProperty;
    private ObjectProperty<LocalDate> DataNascimentoProperty;
    private IntegerProperty idProperty;
    private Endereco endereco;
	private String EmailDeTrabalho;
	private String SenhaEmail;

	   
	    public Funcionario() {
	        nomeCompletoProperty = new SimpleStringProperty();
	        cpfProperty = new SimpleStringProperty();
	        idadeProperty = new SimpleIntegerProperty();
	        telefoneProperty = new SimpleStringProperty();
	        emailProperty = new SimpleStringProperty();
	        cargoProperty = new SimpleStringProperty();
	        salarioProperty = new SimpleDoubleProperty();
	        DataNascimentoProperty = new SimpleObjectProperty<>();
	        idProperty = new SimpleIntegerProperty();
	    }


    // Getters e setters


		

	
    public String getNomeCompleto() {
        return this.nomeCompletoProperty.get();
    }

    public String getEmailDeTrabalho() {
		return EmailDeTrabalho;
	}


	public void setEmailDeTrabalho(String emailDeTrabalho) {
		EmailDeTrabalho = emailDeTrabalho;
	}


	public String getSenhaEmail() {
		return SenhaEmail;
	}


	public void setSenhaEmail(String senhaEmail) {
		SenhaEmail = senhaEmail;
	}


	public int getIdade() {
		return this.idadeProperty.get();
	}

	public void setIdade(int idade) {
		this.idadeProperty.set(idade);
	}

	public void setNomeCompleto(String nomeCompleto) {
       this.nomeCompletoProperty.set(nomeCompleto);
    }

    public String getCpf() {
        return this.cpfProperty.get();
    }

    public void setCpf(String cpf) {
        this.cpfProperty.set(cpf);
    }

    public LocalDate getDataNascimento() {
        return this.DataNascimentoProperty.get();
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.DataNascimentoProperty.set(dataNascimento);;
    }

    public String getTelefone() {
        return this.telefoneProperty.get();
    }

    public void setTelefone(String telefone) {
        this.telefoneProperty.set(telefone);
    }

    public String getEmail() {
        return this.emailProperty.get();
    }

    public void setEmail(String email) {
        this.emailProperty.set(email);
    }

    public int getId() {
        return this.idProperty.get();
    }

    public void setId(int id) {
        this.idProperty.set(id);;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return this.cargoProperty.get();
    }

    public void setCargo(String cargo) {
        this.cargoProperty.set(cargo);;
    }

    public double getSalario() {
        return this.salarioProperty.get();
    }

    public void setSalario(double salario) {
        this.salarioProperty.set(salario);;
    }
    

 

    public StringProperty nomeCompletoProperty() {
        return nomeCompletoProperty;
    }

    public StringProperty cpfProperty() {
        return cpfProperty;
    }

    public IntegerProperty idadeProperty() {
        return idadeProperty;
    }

    public StringProperty telefoneProperty() {
        return telefoneProperty;
    }

    public StringProperty emailProperty() {
        return emailProperty;
    }

    public StringProperty cargoProperty() {
        return cargoProperty;
    }

    public DoubleProperty salarioProperty() {
        return salarioProperty;
    }
    
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    

}