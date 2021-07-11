package br.com.stefanini.provaqtres.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.stefanini.provaqtres.dto.VendaDto;

public class VendaDao extends Dao implements IVendaDao{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	
	@Override
	public VendaDto findByCode(int code) throws Exception {
		
		open();

		stmt = conn.prepareStatement("SELECT v.idVenda, v.dataVenda, v.valorVenda, "
				+ "c.idCliente, c.nome, c.email FROM venda v "
				+ "INNER JOIN cliente c ON v.id_cliente = c.idCliente "
				+ "and v.idVenda = ?");
		
		stmt.setInt(1, code);
		rs = stmt.executeQuery();
		VendaDto vendadto = null;
		
		if (rs.next()) {
			vendadto = new VendaDto();
			
			vendadto.setIdVenda(rs.getInt(1));
			vendadto.setDataVenda(rs.getDate(2));
			vendadto.setValorDaVenda(rs.getDouble(3));
			vendadto.setIdCliente(rs.getInt(4));
			vendadto.setNome(rs.getString(5));
			vendadto.setEmail(rs.getString(6));
		}
		
		//itemprod.setProduto(prod);
		close();
		return vendadto;
	}

	@Override
	public Integer createVenda(VendaDto vendadto) throws Exception {

		open();
		Integer chave = 0;
		try {
			stmt = conn.prepareStatement("INSERT INTO venda VALUES (null, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, vendadto.getIdCliente());
			stmt.setDate(2, new java.sql.Date(vendadto.getDataVenda().getTime()));
			stmt.setDouble(3, vendadto.getValorDaVenda());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			rs.next();
			chave = rs.getInt(1);
			//System.out.println(chave);
			stmt.close();
			System.out.println("\nVenda do Cliente: " + vendadto.getNome() +" Inserido com sucesso\n\n");
		} catch (Exception ex) {
			System.out.println("Erro ao inserir venda");
			ex.printStackTrace();
		} finally {
			close();
		}
		return chave;
		
	}

	@Override
	public List<VendaDto> findAllVenda() throws Exception {

		ArrayList<VendaDto> listaVendadto = new ArrayList<VendaDto>();
		open();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement("SELECT * FROM produto");
			
			stmt = conn.prepareStatement("SELECT v.idVenda, v.dataVenda, v.valorVenda, "
					+ "c.idCliente, c.nome, c.email FROM venda v "
					+ "INNER JOIN cliente c ON v.id_cliente = c.idCliente");
			
			rs = stmt.executeQuery();
			while (rs.next()) {
				VendaDto vendadto = new VendaDto();
				vendadto.setIdVenda(rs.getInt(1));
				vendadto.setDataVenda(rs.getDate(2));
				vendadto.setValorDaVenda(rs.getDouble(3));
				vendadto.setIdCliente(rs.getInt(4));
				vendadto.setNome(rs.getString(5));
				vendadto.setEmail(rs.getString(6));
				
				listaVendadto.add(vendadto);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			close();
		}
		return listaVendadto;
		
	}

	@Override
	public void updateVenda(VendaDto vendadto) throws Exception {

		open();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("UPDATE venda SET id_cliente = ?, dataVenda = ?, valorVenda = ?  WHERE idVenda = ?");
			stmt.setInt(1,vendadto.getIdCliente());
			stmt.setDate(2,new java.sql.Date(vendadto.getDataVenda().getTime()));
			stmt.setDouble(3,vendadto.getValorDaVenda());
			stmt.setInt(4, vendadto.getIdVenda());
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
			VendaDao vendadao = new VendaDao();
			VendaDto vendadto = new VendaDto(2,2,12.59,new Date(),"Mary","mary@gmail.com");
		
			//vendadao.createVenda(vendadto);
			vendadao.updateVenda(vendadto);
			System.out.println(vendadao.findAllVenda());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
