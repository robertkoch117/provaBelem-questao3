package br.com.stefanini.provaqtres.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {
	private Integer idVenda;
	private Cliente cliente;
	private Double valorDaVenda;
	private java.util.Date dataVenda;
	private List<Produto> produtos;

	public Venda() {
		super();
	}

	public Venda(Integer idVenda, Double valorDaVenda, Date dataVenda, Cliente cliente) {
		super();
		this.idVenda = idVenda;
		this.valorDaVenda = valorDaVenda;
		this.dataVenda = dataVenda;
		this.cliente = cliente;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public Double getValorDaVenda() {
		return valorDaVenda;
	}

	public void setValorDaVenda(Double valorDaVenda) {
		this.valorDaVenda = valorDaVenda;
	}

	public java.util.Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(java.util.Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Venda [idVenda=" + idVenda + ", valorDaVenda=" + valorDaVenda + ", dataVenda=" + dataVenda
				+ ", cliente=" + cliente + "]";
	}

	public void add(Produto produto) {
		if(this.produtos == null) {
			this.produtos = new ArrayList<Produto>();
		}
		this.produtos.add(produto);
	}
	
	
}