package br.com.stefanini.provaqtres.dto;

import java.util.Date;
import java.util.List;

import br.com.stefanini.provaqtres.model.Produto;

public class ItemProdutoDto {
	private Integer idItemProduto;
	private Integer idVenda;
	private Integer idProduto;
	private Integer quantidade;
	private Double precoAcumulado;
	private String nome;
	private Double preco;
	private Integer qtdEstoque;
	private Integer idCliente;
	private Double valorDaVenda;
	private java.util.Date dataVenda;
	private String email;
	
	public ItemProdutoDto() {
		super();
	}

	public ItemProdutoDto(Integer idItemProduto, Integer idVenda, Integer idProduto, Integer quantidade,
			Double precoAcumulado, String nome, Double preco, Integer qtdEstoque, Integer idCliente,
			Double valorDaVenda, Date dataVenda, String email) {
		super();
		this.idItemProduto = idItemProduto;
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.precoAcumulado = precoAcumulado;
		this.nome = nome;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
		this.idCliente = idCliente;
		this.valorDaVenda = valorDaVenda;
		this.dataVenda = dataVenda;
		this.email = email;
	}

	public ItemProdutoDto(Integer idItemProduto, Integer idVenda, Integer idProduto) {
		super();
		this.idItemProduto = idItemProduto;
		this.idVenda = idVenda;
		this.idProduto = idProduto;
	}

	public Integer getIdItemProduto() {
		return idItemProduto;
	}

	public void setIdItemProduto(Integer idItemProduto) {
		this.idItemProduto = idItemProduto;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoAcumulado() {
		return precoAcumulado;
	}

	public void setPrecoAcumulado(Double precoAcumulado) {
		this.precoAcumulado = precoAcumulado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ItemProdutoDto [idItemProduto=" + idItemProduto + ", idVenda=" + idVenda + ", idProduto=" + idProduto
				+ ", quantidade=" + quantidade + ", precoAcumulado=" + precoAcumulado + ", nome=" + nome + ", preco="
				+ preco + ", qtdEstoque=" + qtdEstoque + ", idCliente=" + idCliente + ", valorDaVenda=" + valorDaVenda
				+ ", dataVenda=" + dataVenda + ", email=" + email + "]";
	}

	
	
}
