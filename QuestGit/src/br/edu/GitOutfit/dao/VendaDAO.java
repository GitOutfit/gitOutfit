package br.edu.GitOutfit.dao;
import br.edu.GitOutfit.jdbc.ConexaoUtil;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import br.edu.GitOutfit.dto.ClienteDTO;
import br.edu.GitOutfit.dto.SituacaoDTO;
import br.edu.GitOutfit.dto.VendaDTO;
import br.edu.GitOutfit.dto.ProdutoDTO;

// INSERIR DADOS 
public class VendaDAO {

	public void inserir(VendaDTO vendaDTO) {
		try {
		Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();

		String sql = "INSERT INTO VENDA(id_cliente, id_situacao, id_produto) VALUES(?, ?, ?)";
		//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, vendaDTO.getClienteDTO().getId_cliente());
		statement.setInt(2, vendaDTO.getSituacaoDTO().getId_Situacao());
		statement.setInt(3, vendaDTO.getProdutoDTO().getId_Produto());
	//	statement.setInt(4, vendaDTO.getEnderecoDTO().getId_Endereco());
		
		statement.execute();
		connection.close();
		
		System.out.println("INSERIDO COM SUCESSO!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// REMOVER DADOS
	public void remover(int idVenda) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM VENDA WHERE ID = ?";
			//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, idVenda);
			
			statement.execute();
			statement.close();
			System.out.println("Removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// CONSULTAR DADOS
	public List<VendaDTO> listarTodos(){
		List<VendaDTO> listaVenda = new ArrayList<VendaDTO>();
		try{
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM VENDA JOIN cliente on (cliente.id = venda.id_cliente)"
					+ "JOIN situacao ON (situacao.id = venda.id_situacao)"
					+ "JOIN produto ON (produto.id = venda.id_produto);";
					//+ "JOIN endereco ON (endereco.id = venda.id_endereco);";
			
			//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultset = statement.executeQuery();
			
			while(resultset.next()) {
				VendaDTO vendaDTO = new VendaDTO();
				vendaDTO.setId_Venda(resultset.getInt("id"));
				ClienteDTO clienteDTO = new ClienteDTO();
				clienteDTO.setId_cliente(resultset.getInt("Id_cliente"));
				clienteDTO.setNome(resultset.getString("Nome"));
				clienteDTO.setCpf(resultset.getString("CPF"));
				clienteDTO.setTelefone(resultset.getString("Telefone"));
				clienteDTO.setCelular(resultset.getString("Celular"));
				clienteDTO.setEmail(resultset.getString("Email"));
				clienteDTO.setSenha(resultset.getString("Senha"));
				vendaDTO.setClienteDTO(clienteDTO);
				SituacaoDTO situacaoDTO = new SituacaoDTO();
				situacaoDTO.setId_Situacao(resultset.getInt("id_situacao"));
				situacaoDTO.setDescricao(resultset.getString("descricao"));
				vendaDTO.setSituacaoDTO(situacaoDTO);
				ProdutoDTO produtoDTO = new ProdutoDTO();
				produtoDTO.setId_Produto(resultset.getInt("id_produto"));
				produtoDTO.setDescricao(resultset.getString("Descricao"));
				produtoDTO.setNome(resultset.getString("nome"));
				produtoDTO.setDescricao(resultset.getString("descricao"));
				produtoDTO.setPrecoVenda(resultset.getDouble("preco_venda"));
				produtoDTO.setEstoque(resultset.getInt("estoque"));
				produtoDTO.setEstoqueMin(resultset.getInt("estoque_min"));
				vendaDTO.setProdutoDTO(produtoDTO);
			/*	EnderecoDTO enderecoDTO = new EnderecoDTO();
				enderecoDTO.setId_Endereco(resultset.getInt("id_endereco"));
				enderecoDTO.setDescricao(resultset.getString("descricao"));
				enderecoDTO.setLogradouro(resultset.getString("logradouro"));
				enderecoDTO.setNumero(resultset.getString("id"));
				enderecoDTO.setComplemento(resultset.getString("complemento"));
				enderecoDTO.setCep(resultset.getInt("cep"));
				enderecoDTO.setBairro(resultset.getString("bairro"));
				enderecoDTO.setCidade(resultset.getString("cidade"));
				enderecoDTO.setUf(resultset.getString("uf"));
				vendaDTO.setEnderecoDTO(enderecoDTO);*/
				listaVenda.add(vendaDTO);
			}
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaVenda;
	}

	//ATUALIZAR DADOS
	public void atualizar(VendaDTO vendaDTO) {
		try {
			Connection connection = (Connection) ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE VENDA SET id = ?, id_cliente = ?, id_situacao = ?, id_produto = ? WHERE ID_VENDA = ?";
			//String sql = "UPDATE VENDA SET (nome, descricao, preco_venda, estoque, estoque_min) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
//CASO FOR AUTO INCRIMENT RETIRAR INTO ID;				
		//	statement.setString(1, vendaDTO.);
			statement.setInt(1, vendaDTO.getClienteDTO().getId_cliente());
			statement.setInt(2, vendaDTO.getSituacaoDTO().getId_Situacao());
			statement.setInt(3, vendaDTO.getProdutoDTO().getId_Produto());
			statement.setInt(4, vendaDTO.getId_Venda());
			//statement.setInt(4, vendaDTO.getEnderecoDTO().getId_Endereco());
			
			statement.execute();
			statement.close();
			System.out.println("Atualizado com sucesso!");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// INSERIR DADOS \/
	/*	VendaDTO vendaDTO = new VendaDTO();
		ClienteDTO clienteDTO = new ClienteDTO();
		SituacaoDTO situacaoDTO = new SituacaoDTO();
		ProdutoDTO produtoDTO = new ProdutoDTO();
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		
		clienteDTO.setId_cliente(2);
		situacaoDTO.setId_Situacao(2);
		produtoDTO.setId_Produto(14);
		enderecoDTO.setId_Endereco(3);
		
		vendaDTO.setClienteDTO(clienteDTO);
		vendaDTO.setSituacaoDTO(situacaoDTO);
		vendaDTO.setProdutoDTO(produtoDTO);
		vendaDTO.setEnderecoDTO(enderecoDTO);
		
		VendaDAO vendaDAO = new VendaDAO();
		
		vendaDAO.inserir(vendaDTO);
		*/
		// ATUALIZAR DADOS
		
		/*VendaDTO vendaDTO = new VendaDTO();
		
		
		
		ClienteDTO clienteDTO = new ClienteDTO();
		SituacaoDTO situacaoDTO = new SituacaoDTO();
		ProdutoDTO produtoDTO = new ProdutoDTO();
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		
		clienteDTO.setId_cliente(2);
		situacaoDTO.setId_Situacao(2);
		produtoDTO.setId_Produto(14);
		enderecoDTO.setId_Endereco(3);
		
		vendaDTO.setClienteDTO(clienteDTO);
		vendaDTO.setSituacaoDTO(situacaoDTO);
		vendaDTO.setProdutoDTO(produtoDTO);
		vendaDTO.setEnderecoDTO(enderecoDTO);
		
		VendaDAO vendaDAO = new VendaDAO();
		
		vendaDAO.atualizar(vendaDTO);/*
		
		
		// REMOVER DADOS
	/*	
		VendaDTO vendaDTO = new VendaDTO();
		
		VendaDAO vendaDAO = new VendaDAO();
		
		vendaDAO.remover(3);
		*/
		// LISTAR DADOS
		
		/*VendaDAO vendaDAO = new VendaDAO();
		
		List<VendaDTO> listaVenda = new ArrayList<>();
		
		listaVenda = vendaDAO.listarTodos();
		
		for(int i=0; i<listaVenda.size(); i++) {
			System.out.println(listaVenda.get(i));
		}*/
	}

}