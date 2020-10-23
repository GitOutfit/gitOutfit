package br.edu.GitOutfit.dao;

import br.edu.GitOutfit.jdbc.ConexaoUtil;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import br.edu.GitOutfit.dto.CategoriaDTO;
import br.edu.GitOutfit.dto.MarcaDTO;
import br.edu.GitOutfit.dto.ProdutoDTO;

//import java.text.DateFormat;
// INSERIR DADOS 
// LINK CASO NECESSÁRIO: https://www.youtube.com/watch?v=hP5xzRFaHcE&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=3&ab_channel=GuilhermedeSouzaSilveira
public class ProdutoDAO {

	public void inserir(ProdutoDTO produtoDTO) {
		try {
		Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
		
		//String sql = "INSERT INTO PRODUTO(ID, DESCRICAO) VALUES(?, ?)";
		String sql = "INSERT INTO PRODUTO(nome, descricao, preco_venda, estoque, estoque_min, id_categoria, id_marca, imagem) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, produtoDTO.getNome());
		statement.setString(2, produtoDTO.getDescricao());
		statement.setDouble(3, produtoDTO.getPrecoVenda());
		statement.setInt(4, produtoDTO.getEstoque());
		statement.setInt(5, produtoDTO.getEstoqueMin());
		statement.setInt(6, produtoDTO.getCategoriaDTO().getId_Categoria());
		statement.setInt(7, produtoDTO.getMarcaDTO().getId_Marca());
		statement.setString(8, produtoDTO.getImagem());
		
		statement.execute();
		connection.close();
		
		System.out.println("INSERIDO COM SUCESSO!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// REMOVER DADOS
	
	public void remover(int idProduto) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM PRODUTO WHERE ID = ?";
			//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idProduto);
			
			statement.execute();
			statement.close();
			System.out.println("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// CONSULTAR DADOS
// DUVIDAS: https://www.youtube.com/watch?v=RpSmrS7m6T0&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=5&ab_channel=GuilhermedeSouzaSilveira
	
	public List<ProdutoDTO> listarTodos(){
		List<ProdutoDTO> listaProduto = new ArrayList<ProdutoDTO>();
		try{
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT produto.id, produto.nome, produto.descricao, produto.preco_venda, produto.estoque, produto.estoque_min, produto.id_categoria AS IDCat,  "
					+ "produto.id_marca AS IDMarca, produto.imagem FROM produto join categoria ON (categoria.id = produto.id_categoria) "
					+ "join marca ON (marca.id = produto.id_marca);";
			
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				ProdutoDTO produtoDTO = new ProdutoDTO();
				produtoDTO.setId_Produto(resultset.getInt("id"));
				produtoDTO.setNome(resultset.getString("nome"));
				produtoDTO.setDescricao(resultset.getString("descricao"));
				produtoDTO.setPrecoVenda(resultset.getDouble("preco_venda"));
				produtoDTO.setEstoque(resultset.getInt("estoque"));
				produtoDTO.setEstoqueMin(resultset.getInt("estoque_min"));
				CategoriaDTO categoriaDTO = new CategoriaDTO();
				categoriaDTO.setId_Categoria(resultset.getInt("IDCat"));
				categoriaDTO.setDescricao(resultset.getString("Descricao"));
				produtoDTO.setCategoriaDTO(categoriaDTO);
				MarcaDTO marcaDTO = new MarcaDTO();
				marcaDTO.setId_Marca(resultset.getInt("IDMarca"));
				marcaDTO.setDescricao(resultset.getString("Descricao"));
				produtoDTO.setMarcaDTO(marcaDTO);
				produtoDTO.setImagem(resultset.getString("imagem"));
				listaProduto.add(produtoDTO);
			}
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaProduto;
	}

	//ATUALIZAR DADOS
//DUVIDAS https://www.youtube.com/watch?v=SvD1T1enjGM&list=PLWOeg0VagJCQk4szJ1DV6uE7JNLA7uhSC&index=6&ab_channel=GuilhermedeSouzaSilveira
	public void atualizar(ProdutoDTO produtoDTO) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE PRODUTO SET NOME = ?, Descricao = ?, Preco_Venda = ?, Estoque = ?, Estoque_Min = ?, id_categoria = ?, id_marca = ?, Imagem = ? WHERE id = ?";
			//String sql = "UPDATE PRODUTO SET (nome, descricao, preco_venda, estoque, estoque_min) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
		//	statement.setString(1, produtoDTO.);
			statement.setString(1, produtoDTO.getNome());
			statement.setString(2, produtoDTO.getDescricao());
			statement.setDouble(3, produtoDTO.getPrecoVenda());
			statement.setInt(4, produtoDTO.getEstoque());
			statement.setInt(5, produtoDTO.getEstoqueMin());
			statement.setInt(6, produtoDTO.getCategoriaDTO().getId_Categoria());
			statement.setInt(7, produtoDTO.getMarcaDTO().getId_Marca());
			statement.setString(8, produtoDTO.getImagem());
			statement.setInt(9, produtoDTO.getId_Produto());
			statement.execute();
			statement.close();
			System.out.println("Atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// INSERIR DADOS \/
		//MarcaDTO marca = new MarcaDTO();
		/*CategoriaDTO categoriaDTO = new CategoriaDTO();
		MarcaDTO marcaDTO = new MarcaDTO();
		ProdutoDTO produtoDTO = new ProdutoDTO();
		
		categoriaDTO.setId_Categoria(2);
		marcaDTO.setId_Marca(2);
	
		produtoDTO.setNome("Produto01");
		
		produtoDTO.setDescricao("Testendo01");
		
		produtoDTO.setPrecoVenda(250.00);
		
		produtoDTO.setEstoque(3);
		
		produtoDTO.setEstoqueMin(3);
		
		produtoDTO.setCategoriaDTO(categoriaDTO);
		
		produtoDTO.setMarcaDTO(marcaDTO);
		
		produtoDTO.setImagem("testando");
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		produtoDAO.inserir(produtoDTO);*/
		
		// ATUALIZAR DADOS
	/*	
		ProdutoDTO produtoDTO = new ProdutoDTO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		MarcaDTO marcaDTO = new MarcaDTO();
		
		produtoDTO.setNome("Produto015");
		produtoDTO.setDescricao("Testendo0190");
		produtoDTO.setPrecoVenda(750.00);
		produtoDTO.setEstoque(7);
		produtoDTO.setEstoqueMin(4);
		produtoDTO.setImagem("testando");
		marcaDTO.setId_Marca(2);
		categoriaDTO.setId_Categoria(2);
		produtoDTO.setCategoriaDTO(categoriaDTO);
		produtoDTO.setMarcaDTO(marcaDTO);
		produtoDTO.setId_Produto(14);
		produtoDAO.atualizar(produtoDTO);
		
		*/
		// REMOVER DADOS
		/*
		ProdutoDTO produtoDTO = new ProdutoDTO();
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		produtoDAO.remover(3);
		*/
		// LISTAR DADOS
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		List<ProdutoDTO> listaProduto = new ArrayList<>();
		
		listaProduto = produtoDAO.listarTodos();
		
		for(int i=0; i<listaProduto.size(); i++) {
			System.out.println(listaProduto.get(i));
		}
	}

}