package br.com.stefanini.provaqtres.persistence;

import java.util.List;

import br.com.stefanini.provaqtres.model.Produto;

public interface IProdutoDao {
	public Produto findByCode(int code) throws Exception;

	public void createProduto(Produto prod) throws Exception;

	public List<Produto> findAllProduto() throws Exception;

	public void updateProduto(Produto prod) throws Exception;
	
}
