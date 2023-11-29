package model;

import java.sql.Date;

public class Produto2 {
	
	String descricao;
	Double valorUnidade;
	String codigo;
	 private String DataCompra;
	 private String Validade;
	 private float ValorCompradoUnidade;
	 private String MarcaProduto;
	    private int IdFornecedor;
	    private int setQuantidadeVendida;
	    private int IdSecao; 
	    private int estoqueMinimo;
	    private int quatidadeComprautomatica;
	    private int Quantidade;
	
	
	
	
	

		public int getQuantidade() {
			return Quantidade;
		}

		public void setQuantidade(int quantidade) {
			Quantidade = quantidade;
		}

		public String getDataCompra() {
			return DataCompra;
		}

		public void setDataCompra(String dataCompra) {
			DataCompra = dataCompra;
		}

		public String getValidade() {
			return Validade;
		}

		public void setValidade(String validade) {
			Validade = validade;
		}

		public float getValorCompradoUnidade() {
			return ValorCompradoUnidade;
		}

		public void setValorCompradoUnidade(float valorCompradoUnidade) {
			ValorCompradoUnidade = valorCompradoUnidade;
		}

		public String getMarcaProduto() {
			return MarcaProduto;
		}

		public void setMarcaProduto(String marcaProduto) {
			MarcaProduto = marcaProduto;
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

		public int getQuatidadeComprautomatica() {
			return quatidadeComprautomatica;
		}

		public void setQuatidadeComprautomatica(int quatidadeComprautomatica) {
			this.quatidadeComprautomatica = quatidadeComprautomatica;
		}

	public Produto2(String descricao, Double valorUnidade,String codigo) {
		this.descricao = descricao;
		this.valorUnidade = valorUnidade;
		this.codigo=codigo;
		
	}

	public Produto2() {
		// TODO Auto-generated constructor stub
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
