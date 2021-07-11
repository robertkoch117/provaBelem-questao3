package br.com.stefanini.provaqtres.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.stefanini.provaqtres.model.Produto;

public class VendaDto {
	private Integer idVenda;
	private Integer idCliente;
	private Double valorDaVenda;
	private java.util.Date dataVenda;
	private List<Produto> produtos;
	private String nome;
	private String email;
	
	public VendaDto() {
		
	}
	
	public VendaDto(Integer idVenda, Integer idCliente, Double valorDaVenda, Date dataVenda, String nome, String email) {
		super();
		this.idVenda = idVenda;
		this.idCliente = idCliente;
		this.valorDaVenda = valorDaVenda;
		this.dataVenda = dataVenda;
		this.nome = nome;
		this.email = email;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public VendaDto setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
		return this;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "VendaDto [idVenda=" + idVenda + ", idCliente=" + idCliente + ", valorDaVenda=" + valorDaVenda
				+ ", dataVenda=" + dataVenda + ", produtos=" + produtos + ", nome=" + nome + ", email=" + email + "]";
	}
	
	public void add(Produto produto) {
		if (produtos == null) {
			this.produtos = new ArrayList<>();
		}
		this.produtos.add(produto);
	}
	
}
