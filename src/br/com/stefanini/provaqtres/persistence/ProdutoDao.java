package br.com.stefanini.provaqtres.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.stefanini.provaqtres.model.Produto;

public class ProdutoDao extends Dao implements IProdutoDao {

	public Produto findByCode(int code) throws Exception {
		open();
		stmt = conn.prepareStatement("SELECT idProduto, nome, preco, qtdEstoque FROM produto WHERE idProduto = ?");
		stmt.setInt(1, code);
		rs = stmt.executeQuery();
		Produto prod = null;
		if (rs.next()) {
			prod = new Produto();
			prod.setIdProduto(rs.getInt(1));
			prod.setNome(rs.getString(2));
			prod.setPreco(rs.getDouble(3));
			prod.setQtdEstoque(rs.getInt(4));
		}
		close();
		return prod;
	}

	public void createProduto(Produto prod) throws Exception {
		open();
		try {
			stmt = conn.prepareStatement("INSERT INTO produto VALUES (null, ?, ?, ?)");
			stmt.setString(1, prod.getNome());
			stmt.setDouble(2, prod.getPreco());
			stmt.setInt(3, prod.getQtdEstoque());
			System.out.println(prod);
			stmt.executeUpdate();
			System.out.println("Nome: " + prod.getNome() + "Inserido com sucesso");

		} catch (Exception ex) {
			System.out.println("Erro ao inserir cliente");
		} finally {
			close();
		}
	}

	public List<Produto> findAllProduto() throws Exception {
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		open();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement("SELECT * FROM produto");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Produto prod = new Produto();
				prod.setIdProduto(rs.getInt(1));
				prod.setNome(rs.getString(2));
				prod.setPreco(rs.getDouble(3));
				prod.setQtdEstoque(rs.getInt(4));
				listaProdutos.add(prod);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close();
		}
		return listaProdutos;
	}

	public void updateProduto(Produto prod) throws Exception {

		open();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("UPDATE produto SET nome = ?, preco = ?, qtdEstoque = ?  WHERE idProduto = ?");
			stmt.setString(1, prod.getNome());
			stmt.setDouble(2, prod.getPreco());
			stmt.setInt(3, prod.getQtdEstoque());
			stmt.setInt(4, prod.getIdProduto());
			stmt.executeUpdate();

			System.out.println("Update realizado com sucesso.");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close();
		}
	}

	public Produto delete(Produto prod) throws Exception {

		open();
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
			stmt.setLong(1, prod.getIdProduto());
			stmt.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close();
		}

		return prod;
	}
	
	/*
	 * public static void main(String[] args) { try { Produto produto = new
	 * Produto(2, "Teclado", 35.90,30); ProdutoDao pdao = new ProdutoDao();
	 * 
	 * pdao.updateProduto(produto);
	 * 
	 * //System.out.println(pdao.findAllProduto()); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
	
	public static void main(String[] args) {
		try {
			Produto produto = new Produto(null, "Teclado", 32.90, 50);
			Produto produto2 = new Produto(null, "Mouse", 20.00, 40);
			ProdutoDao dao = new ProdutoDao();
			
			dao.createProduto(produto2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
