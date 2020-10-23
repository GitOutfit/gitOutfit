package br.edu.GitOutfit.dao;

import br.edu.GitOutfit.jdbc.ConexaoUtil;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import br.edu.GitOutfit.dto.CategoriaDTO;

// INSERIR DADOS 
// LINK CASO NECESSÁRIO: https://www.youtube.com/watch?v=hP5xzRFaHcE&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=3&ab_channel=GuilhermedeSouzaSilveira
public class CategoriaDAO {

	public void inserir(CategoriaDTO categoriaDTO) {
		try {
		Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
		
		//String sql = "INSERT INTO categoria(ID, DESCRICAO) VALUES(?, ?)";
		String sql = "INSERT INTO CATEGORIA(DESCRICAO) VALUES(?)";
		
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//statement.setInt(1, categoriaDTO.getId_categoria());
		statement.setString(1, categoriaDTO.getDescricao());
		
		statement.execute();
		connection.close();
		
		System.out.println("INSERIDO COM SUCESSO!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// REMOVER DADOS
	
	public void remover(int idCategoria) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM CATEGORIA WHERE ID = ?";
			//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idCategoria);
			
			statement.execute();
			statement.close();
			System.out.println("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// CONSULTAR DADOS
// DUVIDAS: https://www.youtube.com/watch?v=RpSmrS7m6T0&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=5&ab_channel=GuilhermedeSouzaSilveira
	
	public List<CategoriaDTO> listarTodos(){
		List<CategoriaDTO> listaCategoria = new ArrayList<CategoriaDTO>();
		try{
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM CATEGORIA";
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				CategoriaDTO categoriaDTO = new CategoriaDTO();
				categoriaDTO.setId_Categoria(resultset.getInt("ID"));
				categoriaDTO.setDescricao(resultset.getString("descricao"));
				
				listaCategoria.add(categoriaDTO);
			}
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaCategoria;
	}

//ATUALIZAR DADOS
//DUVIDAS https://www.youtube.com/watch?v=SvD1T1enjGM&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=6&ab_channel=GuilhermedeSouzaSilveira
	public void atualizar(CategoriaDTO categoriaDTO) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE CATEGORIA SET DESCRICAO = ? WHERE ID = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			statement.setString(1, categoriaDTO.getDescricao());
			statement.setInt(2, categoriaDTO.getId_Categoria());
			
			statement.execute();
			statement.close();
			System.out.println("Atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// INSERIR DADOS \/
		
	/*	CategoriaDTO categoriaDTO = new CategoriaDTO();
		
		categoriaDTO.setDescricao("Test4");
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		
		categoriaDAO.inserir(categoriaDTO);*/
		
		// ATUALIZAR DADOS
		
		/*CategoriaDTO categoriaDTO = new CategoriaDTO();
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		
		categoriaDTO.setId_Categoria(2);
		
		categoriaDTO.setDescricao("Teste3");
		
		categoriaDAO.atualizar(categoriaDTO);*/
		
		
		// REMOVER DADOS
		/*
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		
		categoriaDAO.remover(1);
		*/
		// LISTAR DADOS
		
		/*CategoriaDAO categoriaDAO = new CategoriaDAO();
		
		List<CategoriaDTO> listaCategoria = new ArrayList<>();
		
		listaCategoria = categoriaDAO.listarTodos();
		
		for(int i=0; i<listaCategoria.size(); i++) {
			System.out.println(listaCategoria.get(i));
		}*/
		
	}

}


