package br.com.estrelas.estoque;

public class ProdutoLimpeza extends Produto {
	
	@Override
	public String toString() {
		return "Produto de Limpeza [precoCusto = " + getPrecoCusto() + ", precoVenda = " + getPrecoVenda() + ", nome = " + getNome()
				+ ", codigoDeBarras = " + getCodigoDeBarras() + ", dataValidade = " + getDataValidade() + ", aroma = " + aroma + ", parteDaCasa = " + parteDaCasa + "] \n";
	}
	
	private String aroma;
	private String parteDaCasa;
	
	public ProdutoLimpeza(float precoCusto, float precoVenda, String nome, long codigoDeBarras, String dataValidade, String aroma, String parteDaCasa) {
		// XXX: Aqui está sendo utilizado o preço de venda duas vezes.
		super(precoVenda, precoVenda, parteDaCasa, codigoDeBarras, dataValidade);
		this.aroma = aroma;
		this.parteDaCasa = parteDaCasa;
	}
	
	public String getAroma() {
		return aroma;
	}
	public void setAroma(String aroma) {
		this.aroma = aroma;
	}
	public String getParteDaCasa() {
		return parteDaCasa;
	}
	public void setParteDaCasa(String parteDaCasa) {
		this.parteDaCasa = parteDaCasa;
	}
}

