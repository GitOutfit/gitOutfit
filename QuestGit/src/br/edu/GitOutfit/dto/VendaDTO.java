package br.edu.GitOutfit.dto;

public class VendaDTO {
	
	private int id;
	private ClienteDTO clienteDTO;
	private SituacaoDTO situacaoDTO;
	private ProdutoDTO produtoDTO;
	
	public VendaDTO(){
		
	}
	
	public VendaDTO(ClienteDTO clienteDTO, SituacaoDTO situacaoDTO, ProdutoDTO produtoDTO) {
		this.setClienteDTO(clienteDTO);
		this.setSituacaoDTO(situacaoDTO);
		this.setProdutoDTO(produtoDTO);
		
	}
	
	public int getId_Venda() {
		return id;
	}
	public void setId_Venda(int id) {
		this.id = id;
	}
	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}
	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
	public SituacaoDTO getSituacaoDTO() {
		return situacaoDTO;
	}
	public void setSituacaoDTO(SituacaoDTO situacaoDTO) {
		this.situacaoDTO = situacaoDTO;
	}

	public ProdutoDTO getProdutoDTO() {
		return produtoDTO;
	}

	public void setProdutoDTO(ProdutoDTO produtoDTO) {
		this.produtoDTO = produtoDTO;
	}

	
	public String toString() {
		return "Cod: " + getId_Venda() + "\n " + "Id Cliente: " +getClienteDTO() + "\n " + "ID Situacao: " +getSituacaoDTO() + "\n " + "ID Produto: " +getProdutoDTO() + "\n " + "Endereco DTO: " + "\n " ;
		
	}
	
}
