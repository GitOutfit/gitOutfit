package br.edu.GitOutfit.dao;

import br.edu.GitOutfit.jdbc.ConexaoUtil;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import br.edu.GitOutfit.dto.ClienteDTO;
import br.edu.GitOutfit.dto.EnderecoDTO;
//import java.text.DateFormat;
// INSERIR DADOS 
// LINK CASO NECESSÁRIO: https://www.youtube.com/watch?v=hP5xzRFaHcE&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=3&ab_channel=GuilhermedeSouzaSilveira
public class EnderecoDAO {

	public void inserir(EnderecoDTO enderecoDTO) {
		try {
		Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
		
		//String sql = "INSERT INTO ENDERECO(ID, DESCRICAO) VALUES(?, ?)";
		String sql = "INSERT INTO ENDERECO(id_cliente, descricao, logradouro, numero, complemento, cep, bairro, cidade, uf) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, enderecoDTO.getClienteDTO().getId_cliente());
		statement.setString(2, enderecoDTO.getDescricao());
		statement.setString(3, enderecoDTO.getLogradouro());
		statement.setString(4, enderecoDTO.getNumero());
		statement.setString(5, enderecoDTO.getComplemento());
		statement.setInt(6, enderecoDTO.getCep());
		statement.setString(7, enderecoDTO.getBairro());
		statement.setString(8, enderecoDTO.getCidade());
		statement.setString(9, enderecoDTO.getUf());
		statement.execute();
		connection.close();
		
		System.out.println("INSERIDO COM SUCESSO!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// REMOVER DADOS
	
	public void remover(int idEndereco) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM ENDERECO WHERE ID = ?";
			//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idEndereco);
			
			statement.execute();
			statement.close();
			System.out.println("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// CONSULTAR DADOS
// DUVIDAS: https://www.youtube.com/watch?v=RpSmrS7m6T0&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=5&ab_channel=GuilhermedeSouzaSilveira
	
	public List<EnderecoDTO> listarTodos(){
		List<EnderecoDTO> listaEndereco = new ArrayList<EnderecoDTO>();
		try{
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM endereco LEFT JOIN cliente ON (cliente.id = endereco.id_cliente);";
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				EnderecoDTO enderecoDTO = new EnderecoDTO();
				ClienteDTO clienteDTO = new ClienteDTO();
				clienteDTO.setId_cliente(resultset.getInt("id_cliente"));
				clienteDTO.setNome(resultset.getString("Nome"));
				clienteDTO.setCpf(resultset.getString("CPF"));
				clienteDTO.setTelefone(resultset.getString("Telefone"));
				clienteDTO.setCelular(resultset.getString("Celular"));
				clienteDTO.setEmail(resultset.getString("Email"));
				clienteDTO.setSenha(resultset.getString("Senha"));
				enderecoDTO.setClienteDTO(clienteDTO);
				enderecoDTO.setId_Endereco(resultset.getInt("id"));
				enderecoDTO.setDescricao(resultset.getString("descricao"));
				enderecoDTO.setLogradouro(resultset.getString("logradouro"));
				enderecoDTO.setNumero(resultset.getString("id"));
				enderecoDTO.setComplemento(resultset.getString("complemento"));
				enderecoDTO.setCep(resultset.getInt("cep"));
				enderecoDTO.setBairro(resultset.getString("bairro"));
				enderecoDTO.setCidade(resultset.getString("cidade"));
				enderecoDTO.setUf(resultset.getString("uf"));
				listaEndereco.add(enderecoDTO);
			}
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaEndereco;
	}

//ATUALIZAR DADOS
//DUVIDAS https://www.youtube.com/watch?v=SvD1T1enjGM&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=6&ab_channel=GuilhermedeSouzaSilveira
	public void atualizar(EnderecoDTO enderecoDTO) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			//String sql = "UPDATE ENDERECO SET NOME = ? WHERE ID_CATEGORIA = ?";
			String sql = "UPDATE ENDERECO SET descricao = ?, logradouro = ?, numero = ?, complemento = ?, cep = ?, bairro = ?, cidade = ?, uf = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
		//	statement.setString(1, enderecoDTO.);
			statement.setString(1, enderecoDTO.getDescricao());
			statement.setString(2, enderecoDTO.getLogradouro());
			statement.setString(3, enderecoDTO.getNumero());
			statement.setString(4, enderecoDTO.getComplemento());
			statement.setInt(5, enderecoDTO.getCep());
			statement.setString(6, enderecoDTO.getBairro());
			statement.setString(7, enderecoDTO.getCidade());
			statement.setString(8, enderecoDTO.getUf());
			
			statement.execute();
			statement.close();
			System.out.println("Atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// INSERIR DADOS \/
		
		/*EnderecoDAO enderecoDAO = new EnderecoDAO();

		
		clienteDTO.setId_cliente(2);
		
		enderecoDTO.setClienteDTO(clienteDTO);
		
		enderecoDTO.setDescricao("Testendo02");
		
		enderecoDTO.setLogradouro("Rua Sebastião Rocha Cintra, 119 – Setor Sul");
		
		enderecoDTO.setNumero("130");
		
		enderecoDTO.setComplemento("Perto do Mercado");
		
		enderecoDTO.setCep(74014586);
		
		enderecoDTO.setBairro("Vila Olavo");
		
		enderecoDTO.setCidade("Jataí");
		
		enderecoDTO.setUf("GO");
		
		enderecoDAO.inserir(enderecoDTO);*/
		
		// ATUALIZAR DADOS
		
		/*EnderecoDTO enderecoDTO = new EnderecoDTO();
		
		EnderecoDAO enderecoDAO = new EnderecoDAO();

		enderecoDTO.setDescricao("Testendo15");
		enderecoDTO.setLogradouro("Rua Sebastião Rocha Cintra, 3229 – Setor Bueno");
		enderecoDTO.setNumero("1923");
		enderecoDTO.setComplemento("Perto do Estádio");
		enderecoDTO.setCep(74098586);
		enderecoDTO.setBairro("Setor Flamboyant");
		enderecoDTO.setCidade("Jataí");
		enderecoDTO.setUf("GO");
		enderecoDAO.atualizar(enderecoDTO);*/
		
		// REMOVER DADOS
		/*
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		enderecoDAO.remover(1);
		*/
		// LISTAR DADOS
		
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		
		List<EnderecoDTO> listaEndereco = new ArrayList<>();
		
		listaEndereco = enderecoDAO.listarTodos();
		
		for(int i=0; i<listaEndereco.size(); i++) {
			System.out.println(listaEndereco.get(i));
		}
		
	}

}