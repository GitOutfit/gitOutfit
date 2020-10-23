package br.edu.GitOutfit.dao;

import br.edu.GitOutfit.jdbc.ConexaoUtil;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import br.edu.GitOutfit.dto.ClienteDTO;

//import java.text.DateFormat;
// INSERIR DADOS 
// LINK CASO NECESSÁRIO: https://www.youtube.com/watch?v=hP5xzRFaHcE&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=3&ab_channel=GuilhermedeSouzaSilveira
public class ClienteDAO {

	public void inserir(ClienteDTO clienteDTO) {
		try {

		Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
		
		//String sql = "INSERT INTO CLIENTE(ID, DESCRICAO) VALUES(?, ?)";
		String sql = "INSERT INTO CLIENTE(NOME, CPF, TELEFONE, CELULAR, EMAIL, SENHA) VALUES(?, ?, ?, ?, ?, ?)";
		
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//statement.setInt(1, categoriaDTO.getId_categoria());
		//Date Dtnascimento = new Date();
		statement.setString(1, clienteDTO.getNome());
		statement.setString(2, clienteDTO.getCpf());
		statement.setString(3, clienteDTO.getTelefone());
		statement.setString(4, clienteDTO.getCelular());
		statement.setString(5, clienteDTO.getEmail());
		statement.setString(6, clienteDTO.getSenha());
		//statement.setInt(7, clienteDTO.getEnderecoDTO().getId_Endereco());
		
		statement.execute();
		connection.close();
		
		System.out.println("INSERIDO COM SUCESSO!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// REMOVER DADOS
	
	public void remover(int idCliente) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM CLIENTE WHERE ID = ?";
			//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idCliente);
			
			statement.execute();
			statement.close();
			System.out.println("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// CONSULTAR DADOS
// DUVIDAS: https://www.youtube.com/watch?v=RpSmrS7m6T0&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=5&ab_channel=GuilhermedeSouzaSilveira
	
	public List<ClienteDTO> listarTodos(){
		List<ClienteDTO> listaCliente = new ArrayList<ClienteDTO>();
		try{
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM Cliente";
			/*String sql = "SELECT cliente.id AS IdClient, cliente.nome AS NomeCliente, cliente.Cpf AS CPFCliente, cliente.telefone AS TelefoneCliente,\r\n" + 
					"cliente.celular AS CelularCliente, cliente.email AS EmailCliente,\r\n" + 
					"cliente.senha AS SenhaCliente, endereco.* \r\n" + 
					"FROM endereco JOIN cliente ON (endereco.id = cliente.id_endereco);";*/
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				ClienteDTO clienteDTO = new ClienteDTO();
				
				
				clienteDTO.setId_cliente(resultset.getInt("Id"));
				clienteDTO.setNome(resultset.getString("Nome"));
				clienteDTO.setCpf(resultset.getString("CPF"));
				clienteDTO.setTelefone(resultset.getString("Telefone"));
				clienteDTO.setCelular(resultset.getString("Celular"));
				clienteDTO.setEmail(resultset.getString("Email"));
				clienteDTO.setSenha(resultset.getString("Senha"));
				/*EnderecoDTO enderecoDTO = new EnderecoDTO();
				enderecoDTO.setId_Endereco(resultset.getInt("id"));
				enderecoDTO.setDescricao(resultset.getString("descricao"));
				enderecoDTO.setLogradouro(resultset.getString("logradouro"));
				enderecoDTO.setNumero(resultset.getString("id"));
				enderecoDTO.setComplemento(resultset.getString("complemento"));
				enderecoDTO.setCep(resultset.getInt("cep"));
				enderecoDTO.setBairro(resultset.getString("bairro"));
				enderecoDTO.setCidade(resultset.getString("cidade"));
				enderecoDTO.setUf(resultset.getString("uf"));
				//enderecoDTO.setId_Endereco(resultset.getInt("id"));*/
				listaCliente.add(clienteDTO);
			}
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaCliente;
	}

//ATUALIZAR DADOS
//DUVIDAS https://www.youtube.com/watch?v=SvD1T1enjGM&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=6&ab_channel=GuilhermedeSouzaSilveira
	public void atualizar(ClienteDTO clienteDTO) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			//String sql = "UPDATE CLIENTE SET NOME = ? WHERE ID_CATEGORIA = ?";
			String sql = "UPDATE CLIENTE SET NOME = ?, CPF = ?, TELEFONE = ?, CELULAR = ?, EMAIL = ?, SENHA = ? WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
		//	statement.setString(1, clienteDTO.);
			statement.setString(1, clienteDTO.getNome());
			statement.setString(2, clienteDTO.getCpf());
			statement.setString(3, clienteDTO.getTelefone());
			statement.setString(4, clienteDTO.getCelular());
			statement.setString(5, clienteDTO.getEmail());
			statement.setString(6, clienteDTO.getSenha());
			statement.setInt(7, clienteDTO.getId_cliente());
			statement.execute();
			statement.close();
			System.out.println("Atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// INSERIR DADOS \/
	/*	ClienteDTO clienteDTO = new ClienteDTO();
	//	EnderecoDTO enderecoDTO = new EnderecoDTO();
		
		//enderecoDTO.setId_Endereco(1);
		
		clienteDTO.setNome("Felipe");
		
		clienteDTO.setCpf("123.456.789");
		
		clienteDTO.setTelefone("36367049");
		
		clienteDTO.setCelular("99523805");
		
		clienteDTO.setEmail("qualquer3@hotmail.com");
		
		clienteDTO.setSenha("123456");
		
	//	clienteDTO.setEnderecoDTO(enderecoDTO);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		clienteDAO.inserir(clienteDTO);*/
		
		// ATUALIZAR DADOS
		
		/*ClienteDTO clienteDTO = new ClienteDTO();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		clienteDTO.setNome("Joao");
		clienteDTO.setCpf("999.999.999");
		clienteDTO.setTelefone("36327049");
		clienteDTO.setCelular("9952695");
		clienteDTO.setEmail("qualquer9@hotmail.com");
		clienteDTO.setSenha("123789");
		clienteDTO.setId_cliente(2);
		clienteDAO.atualizar(clienteDTO);*/
		
		// REMOVER DADOS
		/*
		ClienteDTO clienteDTO = new ClienteDTO();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		clienteDAO.remover(1);
		*/
		// LISTAR DADOS
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		List<ClienteDTO> listaCliente = new ArrayList<>();
		
		listaCliente = clienteDAO.listarTodos();
		
		for(int i=0; i<listaCliente.size(); i++) {
			System.out.println(listaCliente.get(i));
		}
		
	}

}