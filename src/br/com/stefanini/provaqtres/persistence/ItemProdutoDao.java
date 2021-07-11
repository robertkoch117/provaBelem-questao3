package br.com.stefanini.provaqtres.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.stefanini.provaqtres.dto.ItemProdutoDto;
import br.com.stefanini.provaqtres.dto.VendaDto;

public class ItemProdutoDao extends Dao implements IItemProdutoDao{

	
	@Override
	public ItemProdutoDto findByCode(int code) throws Exception {
		open();
		stmt = conn.prepareStatement("SELECT p.idProduto, p.nome, p.preco, p.qtdEstoque, "
				+ "i.idItemProduto, i.id_venda, i.quantidade, i.precoAcumulado, "
				+ "v.id_cliente, v.dataVenda, v.valorVenda FROM produto p "
				+ "INNER JOIN itemproduto i ON p.idProduto = i.id_produto "
				+ "INNER JOINT venda v ON i.id_venda = v.idVenda "
				+ "and i.idItem = ?");
		stmt.setInt(1, code);
		rs = stmt.executeQuery();
		ItemProdutoDto itemprod = null;
		
		if (rs.next()) {
			itemprod = new ItemProdutoDto();
			
			itemprod.setIdProduto(rs.getInt(1));
			itemprod.setNome(rs.getString(2));
			itemprod.setPreco(rs.getDouble(3));
			itemprod.setQtdEstoque(rs.getInt(4));
			itemprod.setIdItemProduto(rs.getInt(5));
			itemprod.setIdVenda(rs.getInt(6));
			itemprod.setQuantidade(rs.getInt(7));
			itemprod.setPrecoAcumulado(rs.getDouble(8));
			itemprod.setIdCliente(rs.getInt(9));
			itemprod.setDataVenda(rs.getDate(10));
			itemprod.setValorDaVenda(rs.getDouble(11));
		}
		
		//itemprod.setProduto(prod);
		close();
		return itemprod;
	}
	
	
	public Integer createItemProduto(ItemProdutoDto itemprod) throws Exception {
		open();
		Integer chave = 0;
		try {
			stmt = conn.prepareStatement("INSERT INTO itemProduto VALUES (null, ?, ?, ?, ?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, itemprod.getIdVenda());
			stmt.setInt(2, itemprod.getIdProduto());
			stmt.setInt(3, itemprod.getQuantidade());
			stmt.setDouble(4, itemprod.getPrecoAcumulado());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			rs.next();
			chave = rs.getInt(1);
			System.out.println("\nProduto inserido com sucesso no ItemProduto\n");

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao inserir itemProduto");
		} finally {
			close();
		}
		return chave;
	}

	@Override
	public List<ItemProdutoDto> findAllItemProduto() throws Exception {
		ArrayList<ItemProdutoDto> listaItems = new ArrayList<ItemProdutoDto>();
		open();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			stmt = conn.prepareStatement("SELECT p.idProduto, p.nome, p.preco, p.qtdEstoque, "
					+ "i.idItemProduto, i.id_venda, i.quantidade, i.precoAcumulado, "
					+ "v.id_cliente, v.dataVenda, v.valorVenda FROM produto p "
					+ "INNER JOIN itemproduto i ON p.idProduto = i.id_produto "
					+ "INNER JOIN venda v ON i.id_venda = v.idVenda");
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				ItemProdutoDto itemprod = new ItemProdutoDto();
				itemprod = new ItemProdutoDto();
				
				itemprod.setIdProduto(rs.getInt(1));
				itemprod.setNome(rs.getString(2));
				itemprod.setPreco(rs.getDouble(3));
				itemprod.setQtdEstoque(rs.getInt(4));
				itemprod.setIdItemProduto(rs.getInt(5));
				itemprod.setIdVenda(rs.getInt(6));
				itemprod.setQuantidade(rs.getInt(7));
				itemprod.setPrecoAcumulado(rs.getDouble(8));
				itemprod.setIdCliente(rs.getInt(9));
				
				
				listaItems.add(itemprod);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		return listaItems;
	}

	@Override
	public void updateItemProduto(ItemProdutoDto itemprod) throws Exception {
		open();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("UPDATE itemproduto SET id_venda = ?, id_produto = ?, quantidade = ?, precoAcumulado = ?  WHERE idItemProduto = ?");
			stmt.setInt(1,itemprod.getIdVenda());
			stmt.setInt(2,itemprod.getIdProduto());
			stmt.setInt(3,itemprod.getQuantidade());
			stmt.setDouble(4, itemprod.getPrecoAcumulado());
			stmt.setInt(5, itemprod.getIdItemProduto());
			stmt.executeUpdate();
			
			System.out.println("Atualizado no banco com sucesso!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			ItemProdutoDao dao = new ItemProdutoDao();
			//Produto produto = new Produto(2, "Teclado", 35.90,30);
			//ItemProduto item = new ItemProduto(null,produto,20,produto.getPreco());
			
			
			
			//ItemProdutoDto idto = new ItemProdutoDto(null, new VendaDto(2,2,12.59,new Date(),"Mary","mary@gmail.com"), 1, 2, 0, String nome, Double preco, Integer qtdEstoque);
			ItemProdutoDto idto = new ItemProdutoDto(null, 2, 2);
			
			//System.out.println("Antes: "+dao.findByCode(2));
			//dao.createItemProduto(idto);
			//idto.setIdproduto(2);
			//idto.setPrecoCada(35.9);
			
			//idto.setQuantidade(2);
			idto.setPrecoAcumulado(0.0);
			idto.setQuantidade(2);
			
			//dao.updateItemProduto(idto);
			dao.createItemProduto(idto);
			System.out.println(dao.findAllItemProduto());
			//System.out.println("Depois: "+dao.findAllItemProduto());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
