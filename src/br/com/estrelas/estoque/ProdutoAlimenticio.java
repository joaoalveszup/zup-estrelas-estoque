package br.com.estrelas.estoque;

public class ProdutoAlimenticio extends Produto {
	
	@Override
	public String toString() {
		return "Produto Alimentício [precoCusto = " + getPrecoCusto() + ", precoVenda = " + getPrecoVenda() + ", nome = " + getNome()
		+ ", codigoDeBarras = " + getCodigoDeBarras() + ", dataValidade = " + getDataValidade() + ", origem = " + origem + "] \n";
}
	
	private String origem;
	
	public ProdutoAlimenticio(float precoCusto, float precoVenda, String nome, long codigoDeBarras, String dataValidade, String origem) {
		super(precoCusto, precoVenda, nome, codigoDeBarras, dataValidade);
		this.origem = origem; 	
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}
}
