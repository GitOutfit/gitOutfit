package br.edu.GitOutfit.dao;

import br.edu.GitOutfit.jdbc.ConexaoUtil;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import br.edu.GitOutfit.dto.MarcaDTO;

// INSERIR DADOS 
// LINK CASO NECESSÁRIO: https://www.youtube.com/watch?v=hP5xzRFaHcE&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=3&ab_channel=GuilhermedeSouzaSilveira
public class MarcaDAO {

	public void inserir(MarcaDTO marcaDTO) {
		try {
		Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
		
		//String sql = "INSERT INTO marca(ID, DESCRICAO) VALUES(?, ?)";
		String sql = "INSERT INTO MARCA(DESCRICAO) VALUES(?)";
		
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//statement.setInt(1, marcaDTO.getId_marca());
		statement.setString(1, marcaDTO.getDescricao());
		
		statement.execute();
		connection.close();
		
		System.out.println("INSERIDO COM SUCESSO!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// REMOVER DADOS
	
	public void remover(int idMarca) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM MARCA WHERE ID = ?";
			//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idMarca);
			
			statement.execute();
			statement.close();
			System.out.println("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// CONSULTAR DADOS
// DUVIDAS: https://www.youtube.com/watch?v=RpSmrS7m6T0&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=5&ab_channel=GuilhermedeSouzaSilveira
	
	public List<MarcaDTO> listarTodos(){
		List<MarcaDTO> listaMarca = new ArrayList<MarcaDTO>();
		try{
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM MARCA";
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				MarcaDTO marcaDTO = new MarcaDTO();
				marcaDTO.setId_Marca(resultset.getInt("ID"));
				marcaDTO.setDescricao(resultset.getString("descricao"));
				
				listaMarca.add(marcaDTO);
			}
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaMarca;
	}

//ATUALIZAR DADOS
//DUVIDAS https://www.youtube.com/watch?v=SvD1T1enjGM&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=6&ab_channel=GuilhermedeSouzaSilveira
	public void atualizar(MarcaDTO marcaDTO) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE MARCA SET DESCRICAO = ? WHERE ID = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			statement.setString(1, marcaDTO.getDescricao());
			statement.setInt(2, marcaDTO.getId_Marca());
			
			statement.execute();
			statement.close();
			System.out.println("Atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// INSERIR DADOS \/
		
	/*	MarcaDTO marcaDTO = new MarcaDTO();
		
		marcaDTO.setDescricao("Test4");
		
		MarcaDAO marcaDAO = new MarcaDAO();
		
		marcaDAO.inserir(marcaDTO);*/
		
		// ATUALIZAR DADOS
		/*
		MarcaDTO marcaDTO = new MarcaDTO();
		
		MarcaDAO marcaDAO = new MarcaDAO();
		
		marcaDTO.setId_marca(2);
		
		marcaDTO.setDescricao("Teste3");
		
		marcaDAO.atualizar(marcaDTO);
		*/
		
		// REMOVER DADOS
		/*
		MarcaDTO marcaDTO = new MarcaDTO();
		
		MarcaDAO marcaDAO = new MarcaDAO();
		
		marcaDAO.remover(1);
		*/
		// LISTAR DADOS
		
		MarcaDAO marcaDAO = new MarcaDAO();
		
		List<MarcaDTO> listaMarca = new ArrayList<>();
		
		listaMarca = marcaDAO.listarTodos();
		
		for(int i=0; i<listaMarca.size(); i++) {
			System.out.println(listaMarca.get(i));
		}
		
	}

}


