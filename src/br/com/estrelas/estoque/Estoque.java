package br.com.estrelas.estoque;

import java.io.IOException;
import java.util.List;

public interface Estoque <Tipo>  {

	void alteraPrecoProdutos(float porcentagem, boolean aumenta);

	boolean cadastraProduto(Tipo produto);

	boolean removeProduto(long codigoDeBarras);

	List<Tipo> listaProdutos();

	void alteraPrecoProduto(float porcentagem, boolean aumenta, long codigoDeBarras);

	Tipo consultaProduto(long codigoBarras);

	boolean gravaListaProdutos() throws IOException;

	int quantidadeProdutosEmEstoque();

	float getPrecoVenda();
}
