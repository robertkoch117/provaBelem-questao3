package br.com.stefanini.provaqtres.model;

import java.util.Objects;

public class Produto {
	private Integer idProduto;
	private String nome;
	private Double preco;
	private Integer qtdEstoque;
	
	
	public Produto() {
		super();
	}


	public Produto(Integer idProduto, String nome, Double preco, Integer qtdEstoque) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.qtdEstoque = qtdEstoque;
	}


	public Integer getIdProduto() {
		return idProduto;
	}


	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
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


	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", preco=" + preco + ", qtdEstoque=" + qtdEstoque
				+ "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(idProduto, nome, preco, qtdEstoque);
	}


	@Override
	public boolean equals(Object obj) {
		 Produto other = (Produto) obj;
	     return this.idProduto.equals(other.getIdProduto());
	}

	
	
}
