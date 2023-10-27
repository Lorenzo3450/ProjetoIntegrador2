package model;

public class Produto2 {
	
	String descricao;
	Double valorUnidade;
	String codigo;
	
	public Produto2(String descricao, Double valorUnidade,String codigo) {
		this.descricao = descricao;
		this.valorUnidade = valorUnidade;
		this.codigo=codigo;
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorUnidade() {
		return valorUnidade;
	}

	public void setValorUnidade(Double valorUnidade) {
		this.valorUnidade = valorUnidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	
}
