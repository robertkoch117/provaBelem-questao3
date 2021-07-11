package br.com.stefanini.provaqtres.controller;

import java.util.Date;
import java.util.List;

import br.com.stefanini.provaqtres.dto.ClienteDto;
import br.com.stefanini.provaqtres.dto.ItemProdutoDto;
import br.com.stefanini.provaqtres.dto.VendaDto;
import br.com.stefanini.provaqtres.persistence.VendaDao;

public class VendaController {

	public VendaDto realizarCompra(ClienteDto clientedto) throws Exception {
		
		VendaDto vendadto = new VendaDto();
		VendaDao vendadao = new VendaDao();
		
		vendadto.setIdCliente(clientedto.getIdCliente());
		vendadto.setDataVenda(new Date());
		vendadto.setValorDaVenda(0.0);
		vendadto.setNome(clientedto.getNome());
		vendadto.setEmail(clientedto.getEmail());
		
		int chave = vendadao.createVenda(vendadto);
		vendadto.setIdVenda(chave);
		System.out.println(vendadto.getIdVenda());
		return vendadto;
	}
	
	public Double calcularValorVenda(List<ItemProdutoDto> listvendadto) {
		Double valorDaVenda = 0.0;
		
		for(ItemProdutoDto ip: listvendadto) {
			
			valorDaVenda += ip.getPrecoAcumulado();
		}
		
		return valorDaVenda;
	}

	public void updateValorDaVenda(VendaDto vendadto) throws Exception {
		VendaDao vendadao = new VendaDao();
		
		vendadao.updateVenda(vendadto);
	
		
	}
	
}
