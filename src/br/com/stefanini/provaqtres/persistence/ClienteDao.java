package br.com.stefanini.provaqtres.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.stefanini.provaqtres.dto.ClienteDto;
import br.com.stefanini.provaqtres.dto.EnderecoDto;

public class ClienteDao extends Dao implements IClienteDao {

	@Override
	public ClienteDto findByCode(int code) throws Exception {
		open();
		//stmt = conn.prepareStatement("SELECT * from cliente where idCliente=?");
		stmt = conn.prepareStatement("SELECT c.idCliente, c.nome, c.email, c.senha, " 
				+ "e.bairro, e.cidade FROM cliente c "
				+ "LEFT JOIN endereco e ON c.idCliente = e.id_cliente "
				+ "and c.idCliente = ?");
		
		stmt.setInt(1, code);
		rs = stmt.executeQuery();
		ClienteDto clientedto = null;
		if (rs.next()) {
				clientedto = new ClienteDto();
				clientedto.setIdCliente(rs.getInt(1));
				clientedto.setNome(rs.getString(2));
				clientedto.setEmail(rs.getString(3));
				clientedto.setSenha(rs.getString(4));
				clientedto.setBairro(rs.getString(5));
				clientedto.setCidade(rs.getString(6));
		}
		close();
		return clientedto;
	}

	public ClienteDto findByEmail(String email) throws Exception {
		open();
		//stmt = conn.prepareStatement("SELECT * from cliente where idCliente=?");
		stmt = conn.prepareStatement("SELECT c.idCliente, c.nome, c.email, c.senha, " 
				+ "e.bairro, e.cidade FROM cliente c "
				+ "LEFT JOIN endereco e ON c.idCliente = e.id_cliente "
				+ "and c.email = ?");
		
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		ClienteDto clientedto = null;
		if (rs.next()) {
				clientedto = new ClienteDto();
				clientedto.setIdCliente(rs.getInt(1));
				clientedto.setNome(rs.getString(2));
				clientedto.setEmail(rs.getString(3));
				clientedto.setSenha(rs.getString(4));
				clientedto.setBairro(rs.getString(5));
				clientedto.setCidade(rs.getString(6));
		}
		close();
		return clientedto;
	}
	
	public Integer createCliente(ClienteDto cliente, EnderecoDto endereco) throws Exception {
		open();
		Integer chave = 0;
		conn.setAutoCommit(false);
		try {
			stmt = conn.prepareStatement("INSERT INTO cliente VALUES (null, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getSenha());
			stmt.setString(4, cliente.getUuid());
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			rs.next();
			chave = rs.getInt(1);
			System.out.println(chave);
			stmt.close();
			
			stmt1 = conn.prepareStatement("INSERT INTO endereco VALUES (null, ?, ?, ?, ?)");
			stmt1.setString(1, endereco.getBairro());
			stmt1.setString(2, endereco.getCidade());
			stmt1.setString(3, endereco.getCep());
			stmt1.setInt(4, chave);
			stmt1.executeUpdate();
			stmt1.close();
			conn.commit();
			
			System.out.println("Inserido no banco com sucesso!");
		} catch (Exception ex) {
			ex.printStackTrace();
			conn.rollback();
		} finally {
			close();
		}
		return chave;
	}
	
	public List<ClienteDto> findAllCliente() throws Exception{
		ArrayList<ClienteDto> listaClientes = new ArrayList<ClienteDto>();
		open();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("SELECT * FROM cliente");
			rs = stmt.executeQuery();
			while(rs.next()) {
				ClienteDto cli = new ClienteDto();
				cli.setIdCliente(rs.getInt(1));
				cli.setNome(rs.getString(2));
				cli.setEmail(rs.getString(3));
				cli.setSenha(rs.getString(4));
				listaClientes.add(cli);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		return listaClientes;
	}

	@Override
	public ClienteDto update(ClienteDto clientedto, EnderecoDto endereco) throws Exception {

		open();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("UPDATE cliente SET nome = ?, email = ?, senha = ?  WHERE idCliente = ?");
			stmt.setString(1,clientedto.getNome());
			stmt.setString(2,clientedto.getEmail());
			stmt.setString(3,clientedto.getSenha());
			stmt.setInt(4,clientedto.getIdCliente());
			stmt.executeUpdate();
			/*
			 * idEndereco int PRIMARY KEY auto_increment, bairro varchar(50), cidade
			 * varchar(50), cep varchar(50), id_cliente int unique,
			 */
			stmt1 = conn.prepareStatement("UPDATE endereco SET bairro = ?, cidade = ?, cep = ?  WHERE idEndereco = ?");
			stmt1.setString(1,endereco.getBairro());
			stmt1.setString(2,endereco.getCidade());
			stmt1.setString(3,endereco.getCep());
			stmt1.setLong(4,endereco.getIdEndereco());
			stmt1.executeUpdate();
			System.out.println("Atualizado no banco com sucesso!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		
		return null;
	}
	
	public ClienteDto delete(ClienteDto clientedto) throws Exception {

		open();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.prepareStatement("DELETE FROM cliente WHERE idCliente = ?");
			stmt.setLong(1,clientedto.getIdCliente());
			stmt.executeUpdate();
			
			System.out.println("Deletado do banco com sucesso!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			close();
		}
		
		return clientedto;
	}
	
	public static void main(String[] args) {
		try {
			ClienteDto clientedto = new ClienteDto(null,"Robert","robert@gmail.com","12345",UUID.randomUUID().toString(),"Tijuca","Rio de Janeiro");
			ClienteDto clientedto2 = new ClienteDto(null,"Maria","maria@gmail.com","12365",UUID.randomUUID().toString(),"São Paulo","São Paulo");
			
			
			clientedto.gerarCriptografia();
			ClienteDao clientedao = new ClienteDao();
			EnderecoDto enderecodto = new EnderecoDto(null,"São Paulo", "São Paulo", "20001234",null);
			
			
			clientedao.createCliente(clientedto2, enderecodto);
			//clientedto.setIdCliente(3);
			//enderecodto.setIdEndereco(2);
			//clientedao.delete(clientedto);
			//clientedao.update(clientedto, enderecodto);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
