package br.edu.GitOutfit.dto;

public class UsuarioDTO {

	private int id;
	private String nome;
	private String email;
	private String senha;
	private boolean administrador;

	public int getId_usuario() {
		return id;
	}
	public void setId_usuario(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public boolean getAdministrador() {
		return administrador;
	}
	public void setAdministrador(boolean adminstrador) {
		this.administrador = adminstrador;
	}
	
	public String toString() {
		return "Cod: " + getId_usuario() + "\n " + "Nome Uusário: " +getNome() + "\n " + "Email: "  +getEmail() + "\n "  + "Senha Usuario: " +getSenha() + "\n "  +"Administrador: " +getAdministrador() ;
		
	}
}
