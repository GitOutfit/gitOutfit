package br.edu.GitOutfit.dto;

public class EnderecoDTO {
	
	private int id;
	private ClienteDTO clienteDTO;
	private String descricao;
	private String logradouro;
	private String numero;
	private String complemento;
	private int cep;
	private String bairro;
	private String cidade;
	private String uf;
	
	public EnderecoDTO() {
		
	}
	
		public EnderecoDTO(ClienteDTO clienteDTO) {
			this.setClienteDTO(clienteDTO);	
		}
	
	public int getId_Endereco() {
		return id;
	}
	public void setId_Endereco(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}
	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
	
	public String toString() {
		return "Cod: " + getId_Endereco() + "\n " + "ID Cliente: " +getClienteDTO() + "\n " + "Descricao Cliente: " +getDescricao() + "\n " + "Logradouro Venda: " +getLogradouro() + "\n " + "Numero: " +getNumero() + "\n " + "Complemento:"  +getComplemento() + "\n " + "CEP: " +getCep() + "\n " + "Bairro: " +getBairro() + "\n " + "Cidade: " + getCidade() + "\n" + " Estado:" + getUf() + "\n";
		
	}

}