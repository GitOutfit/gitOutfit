package br.edu.GitOutfit.dao;

import br.edu.GitOutfit.jdbc.ConexaoUtil;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import br.edu.GitOutfit.dto.SituacaoDTO;

// INSERIR DADOS 
// LINK CASO NECESSÁRIO: https://www.youtube.com/watch?v=hP5xzRFaHcE&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=3&ab_channel=GuilhermedeSouzaSilveira
public class SituacaoDAO {

	public void inserir(SituacaoDTO situacaoDTO) {
		try {
		Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
		
		//String sql = "INSERT INTO situacao(ID, DESCRICAO) VALUES(?, ?)";
		String sql = "INSERT INTO SITUACAO(DESCRICAO) VALUES(?)";
		
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		//statement.setInt(1, situacaoDTO.getId_situacao());
		statement.setString(1, situacaoDTO.getDescricao());
		
		statement.execute();
		connection.close();
		
		System.out.println("INSERIDO COM SUCESSO!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// REMOVER DADOS
	
	public void remover(int idSituacao) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM SITUACAO WHERE ID = ?";
			//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idSituacao);
			
			statement.execute();
			statement.close();
			System.out.println("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// CONSULTAR DADOS
// DUVIDAS: https://www.youtube.com/watch?v=RpSmrS7m6T0&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=5&ab_channel=GuilhermedeSouzaSilveira
	
	public List<SituacaoDTO> listarTodos(){
		List<SituacaoDTO> listaSituacao = new ArrayList<SituacaoDTO>();
		try{
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM SITUACAO";
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				SituacaoDTO situacaoDTO = new SituacaoDTO();
				situacaoDTO.setId_Situacao(resultset.getInt("ID"));
				situacaoDTO.setDescricao(resultset.getString("descricao"));
				
				listaSituacao.add(situacaoDTO);
			}
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaSituacao;
	}

//ATUALIZAR DADOS
//DUVIDAS https://www.youtube.com/watch?v=SvD1T1enjGM&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=6&ab_channel=GuilhermedeSouzaSilveira
	public void atualizar(SituacaoDTO situacaoDTO) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE SITUACAO SET DESCRICAO = ? WHERE ID_SITUACAO = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			statement.setString(1, situacaoDTO.getDescricao());
			statement.setInt(2, situacaoDTO.getId_Situacao());
			
			statement.execute();
			statement.close();
			System.out.println("Atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// INSERIR DADOS \/
		
		/*SituacaoDTO situacaoDTO = new SituacaoDTO();
		
		situacaoDTO.setDescricao("Testando1");
		
		SituacaoDAO situacaoDAO = new SituacaoDAO();
		
		situacaoDAO.inserir(situacaoDTO);*/
		
		// ATUALIZAR DADOS
		/*
		SituacaoDTO situacaoDTO = new SituacaoDTO();
		
		SituacaoDAO situacaoDAO = new SituacaoDAO();
		
		situacaoDTO.setId_situacao(2);
		
		situacaoDTO.setDescricao("Teste3");
		
		situacaoDAO.atualizar(situacaoDTO);
		*/
		
		// REMOVER DADOS
		/*
		SituacaoDTO situacaoDTO = new SituacaoDTO();
		
		SituacaoDAO situacaoDAO = new SituacaoDAO();
		
		situacaoDAO.remover(6);
		*/
		// LISTAR DADOS
		
		SituacaoDAO situacaoDAO = new SituacaoDAO();
		
		List<SituacaoDTO> listaSituacao = new ArrayList<>();
		
		listaSituacao = situacaoDAO.listarTodos();
		
		for(int i=0; i<listaSituacao.size(); i++) {
			System.out.println(listaSituacao.get(i));
		}
		
	}

}