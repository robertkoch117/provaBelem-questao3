package br.com.stefanini.provaqtres.persistence;

import java.util.List;

import br.com.stefanini.provaqtres.dto.ItemProdutoDto;

public interface IItemProdutoDao {
	public ItemProdutoDto findByCode(int code) throws Exception;

	public Integer createItemProduto(ItemProdutoDto itemprod) throws Exception;

	public List<ItemProdutoDto> findAllItemProduto() throws Exception;

	public void updateItemProduto(ItemProdutoDto itemprod) throws Exception;

}
