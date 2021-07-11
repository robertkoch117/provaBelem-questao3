package br.com.stefanini.provaqtres.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.stefanini.provaqtres.dto.ItemProdutoDto;
import br.com.stefanini.provaqtres.model.ItemProduto;
import br.com.stefanini.provaqtres.model.Produto;
import br.com.stefanini.provaqtres.persistence.ProdutoDao;
import br.com.stefanini.provaqtres.view.Tela;

public class ProdutoController {
	
	
	public List<Produto> recuperarProdutosDisponiveisLista() throws Exception {
		ProdutoDao proddao = new ProdutoDao();
		return proddao.findAllProduto();
	}
	
	public List<ItemProdutoDto> inserirProdutoNoCarrinho(int resposta, Scanner sc) throws Exception{
		List<Produto> carrinhoProduto = new ArrayList<>();
		List<ItemProdutoDto> listItemsDto = new ArrayList<>();;
		int id;
		
		while(resposta==1) {
			
			Tela.gerarTelaVerificarProdutos(recuperarProdutosDisponiveisLista());
			System.out.println("Qual é o Id do produto que você quer escolher?");
			id = sc.nextInt();
			
			ProdutoDao proddao = new ProdutoDao();
			carrinhoProduto.add(proddao.findByCode(id));
			
			System.out.println("Quantos deste produto você gostaria de comprar?");
			int qtdProdutoCarrinho = sc.nextInt();
			
			
			
			ItemProdutoDto itemProduto = new ItemProdutoDto();
			itemProduto.setIdProduto(id);
			itemProduto.setQuantidade(qtdProdutoCarrinho);
			
			ItemProdutoController itemprodcontroller = new ItemProdutoController();
			
			listItemsDto.add(itemProduto);
			listItemsDto = itemprodcontroller.addListaItemProduto(listItemsDto);
			
			sc.nextLine();
			System.out.println("\n\nGostaria de escolher mais algum produto da lista?");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			resposta = sc.nextInt();
			sc.nextLine();
		}
		
		return listItemsDto;
	}
	
	/*
	 * public static void main(String[] args) { try { int resposta = 1;
	 * ProdutoController prodController = new ProdutoController(); List<Produto>
	 * carrinho = prodController.recuperarCarrinho(resposta, new
	 * Scanner(System.in));
	 * 
	 * 
	 * }catch(Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */
}
