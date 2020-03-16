package br.com.estrelas.estoque;

public abstract class Produto {
	
	
	@Override
	public String toString() {
		return "Produto [precoCusto = " + precoCusto + ", precoVenda = " + precoVenda + ", nome = " + nome
				+ ", codigoDeBarras = " + codigoDeBarras + ", dataValidade = " + dataValidade + "] \n";
	}

	private float precoCusto;
	private float precoVenda;
	private String nome;
	private long codigoDeBarras;  // decidi mudar o código de barras como long pq ele pode guardar mais informações e nesse caso, código de barras pode ser extenso
	private String dataValidade;
	
	public Produto(float precoCusto, float precoVenda, String nome, long codigoDeBarras, String dataValidade) {
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.nome = nome;
		this.codigoDeBarras = codigoDeBarras;
		this.dataValidade = dataValidade;
	}

	public float getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(float precoCusto) {
		this.precoCusto = precoCusto;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(long codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
}
