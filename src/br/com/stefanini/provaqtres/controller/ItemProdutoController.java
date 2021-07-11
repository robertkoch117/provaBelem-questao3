package br.com.stefanini.provaqtres.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.stefanini.provaqtres.dto.ItemProdutoDto;
import br.com.stefanini.provaqtres.dto.VendaDto;
import br.com.stefanini.provaqtres.model.Produto;
import br.com.stefanini.provaqtres.persistence.ItemProdutoDao;
import br.com.stefanini.provaqtres.persistence.ProdutoDao;

public class ItemProdutoController {
	List<ItemProdutoDto> carrinhoConta = new ArrayList<>();

	
	public List<ItemProdutoDto> inserirItemProdutoNoBanco(VendaDto vendadto, List<ItemProdutoDto> carrinho) throws Exception {
		
		ItemProdutoDto itemdto;
		ItemProdutoDao itemdao = new ItemProdutoDao();
		List<ItemProdutoDto> carrinhoConta = new ArrayList<>();
		
		for(ItemProdutoDto p : carrinho) {
			itemdto = new ItemProdutoDto();
			
			itemdto.setIdVenda(vendadto.getIdVenda());
			itemdto.setIdProduto(p.getIdProduto());
			itemdto.setQuantidade(p.getQuantidade());
			itemdto.setIdCliente(vendadto.getIdCliente());
			itemdto.setDataVenda(vendadto.getDataVenda());
			itemdto.setEmail(vendadto.getEmail());
			itemdto.setPrecoAcumulado(p.getPreco()*p.getQuantidade());
			//itemdto.setIdVenda(vendadto.get);
			
			//itemdto.setIdVenda(p.getIdVenda());
			//itemdto.setIdProduto(p.getIdProduto());
			itemdao.createItemProduto(itemdto);
			carrinhoConta.add(itemdto);
		}
		
		System.out.println("Produtos selecionados com sucesso!");
		return carrinhoConta;
	}

	public List<ItemProdutoDto> addListaItemProduto(List<ItemProdutoDto> listItemsDto) throws Exception {
		
		ProdutoDao produtoDao = new ProdutoDao();
		Produto produto;
		ItemProdutoDao itemdao = new ItemProdutoDao();
		ItemProdutoDto itemdto;
		
		for(ItemProdutoDto ip : listItemsDto) {
			itemdto = new ItemProdutoDto();
			
			produto = produtoDao.findByCode(ip.getIdProduto());
			
			itemdto.setIdItemProduto(null);
			itemdto.setIdVenda(null);
			itemdto.setIdProduto(ip.getIdProduto());
			itemdto.setQuantidade(ip.getQuantidade());
			itemdto.setPrecoAcumulado(null);
			itemdto.setNome(produto.getNome());
			itemdto.setPreco(produto.getPreco());
			itemdto.setQtdEstoque(produto.getQtdEstoque());
			itemdto.setIdCliente(null);
			itemdto.setValorDaVenda(null);
			itemdto.setDataVenda(null);
			itemdto.setEmail(null);
			
			carrinhoConta.add(itemdto);
		}
		
		return carrinhoConta;
	}
	
}
