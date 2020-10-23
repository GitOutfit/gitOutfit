package br.edu.GitOutfit.dto;

import java.util.Date;

//FALTAR COLOCAR O DATA E ENDEREÇO;

public class ClienteDTO {

	private int id;
	private EnderecoDTO enderecoDTO;
	private String nome;
	private String cpf;
	private String telefone;
	private String celular;
	private String email;
	private String senha;
	private Date dtnascimento;
	public ClienteDTO() {
		
	}
	
	
	public ClienteDTO(EnderecoDTO enderecoDTO) {
		this.setEnderecoDTO(enderecoDTO);
	}
		
	public int getId_cliente() {
		return id;
	}
	public void setId_cliente(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public EnderecoDTO getEnderecoDTO() {
		return enderecoDTO;
	}
	public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
		this.enderecoDTO = enderecoDTO;
	}
	
	public Date getDtnascimento() {
		return dtnascimento;
	}

	public void setDtnascimento(Date dtnascimento) {
		this.dtnascimento = dtnascimento;
	}
	
	public String toString() {
		return "Cod: " + getId_cliente() + "\n " + "Nome Cliente: " +getNome() + "\n " + "CPF: " +getCpf() + "\n " + "Telefone: " +getTelefone() + "\n " + "Celular: " +getCelular() + "\n " + "Email: "  +getEmail() + "\n " + "Senha: " +getSenha() + "\n " + "Id Endereco: " +getEnderecoDTO() + "\n " + "Data de Nascimento: " +getDtnascimento() + "\n";
		
	}

}