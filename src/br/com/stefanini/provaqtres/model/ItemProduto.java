package br.com.stefanini.provaqtres.model;

public class ItemProduto {
	private Integer idItemProduto;
	private Venda venda;
	private Produto produto;
	private Integer quantidade;
	private Double precoAcumulado;

	public ItemProduto() {
		super();
	}

	public ItemProduto(Integer idItemProduto, Venda venda, Produto produto, Integer quantidade, Double precoAcumulado) {
		super();
		this.idItemProduto = idItemProduto;
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoAcumulado = precoAcumulado;
	}

	public Integer getIdItemProduto() {
		return idItemProduto;
	}

	public void setIdItemProduto(Integer idItemProduto) {
		this.idItemProduto = idItemProduto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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

	@Override
	public String toString() {
		return "ItemProduto [idItemProduto=" + idItemProduto + ", venda=" + venda + ", produto=" + produto
				+ ", quantidade=" + quantidade + ", precoAcumulado=" + precoAcumulado + "]";
	}

	
	
}