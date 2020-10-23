package br.edu.GitOutfit.dao;

import br.edu.GitOutfit.jdbc.ConexaoUtil;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import br.edu.GitOutfit.dto.UsuarioDTO;

// INSERIR DADOS 
// LINK CASO NECESSÁRIO: https://www.youtube.com/watch?v=hP5xzRFaHcE&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=3&ab_channel=GuilhermedeSouzaSilveira
public class UsuarioDAO {

	public void inserir(UsuarioDTO usuarioDTO) {
		try {
		Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
		
		//String sql = "INSERT INTO CLIENTE(ID, DESCRICAO) VALUES(?, ?)";
		String sql = "INSERT INTO USUARIO(NOME, EMAIL, SENHA, admin) VALUES(?, ?, ?, ?)";
		
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//statement.setInt(1, categoriaDTO.getId_categoria());
		statement.setString(1, usuarioDTO.getNome());
		statement.setString(2, usuarioDTO.getEmail());
		statement.setString(3, usuarioDTO.getSenha());
		statement.setBoolean(4, usuarioDTO.getAdministrador());
		
		statement.execute();
		connection.close();
		
		System.out.println("INSERIDO COM SUCESSO!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// REMOVER DADOS
	
	public void remover(int idUsuario) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM USUARIO WHERE ID = ?";
			//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idUsuario);
			
			statement.execute();
			statement.close();
			System.out.println("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// CONSULTAR DADOS
// DUVIDAS: https://www.youtube.com/watch?v=RpSmrS7m6T0&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=5&ab_channel=GuilhermedeSouzaSilveira
	
	public List<UsuarioDTO> listarTodos() {
		List<UsuarioDTO> listaUsuario = new ArrayList<UsuarioDTO>();
		try{
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM usuario";
		
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				usuarioDTO.setId_usuario(resultset.getInt("ID"));
				usuarioDTO.setNome(resultset.getString("Nome"));
				usuarioDTO.setEmail(resultset.getString("Email"));
				usuarioDTO.setSenha(resultset.getString("Senha"));
				usuarioDTO.setAdministrador(resultset.getBoolean("Admin"));
				
				listaUsuario.add(usuarioDTO);
			}
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaUsuario;
	}

//ATUALIZAR DADOS
//DUVIDAS https://www.youtube.com/watch?v=SvD1T1enjGM&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=6&ab_channel=GuilhermedeSouzaSilveira
	public void atualizar(UsuarioDTO usuarioDTO) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			//String sql = "UPDATE CLIENTE SET NOME = ? WHERE ID_CATEGORIA = ?";
			String sql = "UPDATE USUARIO SET NOME = ?, EMAIL = ?, SENHA = ?,admin = ? WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
		//	statement.setString(1, clienteDTO.);
			statement.setString(1, usuarioDTO.getNome());
			statement.setString(2, usuarioDTO.getEmail());
			statement.setString(3, usuarioDTO.getSenha());
			statement.setBoolean(4, usuarioDTO.getAdministrador());
			statement.setInt(5, usuarioDTO.getId_usuario());
			
			statement.execute();
			statement.close();
			System.out.println("Atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// INSERIR DADOS \/
		
		/*UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		usuarioDTO.setNome("Felipe");
		
		usuarioDTO.setEmail("felipedruidzao@gmail.com");
		
		usuarioDTO.setSenha("123456");
		
		usuarioDTO.setAdministrador(true);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.inserir(usuarioDTO);*/
		
		// ATUALIZAR DADOS
		/*
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDTO.setNome("Pedro");
		usuarioDTO.setEmail("pedrocabral1990@hotmail.com");
		usuarioDTO.setSenha("123456");
		usuarioDTO.setAdministrador(true);
		usuarioDTO.setId_usuario(3);
		usuarioDAO.atualizar(usuarioDTO);
		*/
		
		// REMOVER DADOS
		/*
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.remover(1);
		*/
		// LISTAR DADOS
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		List<UsuarioDTO> listaUsuario = new ArrayList<>();
		
		listaUsuario = usuarioDAO.listarTodos();
		
		for(int i=0; i<listaUsuario.size(); i++) {
			System.out.println(listaUsuario.get(i));
		}
		
	}

}