package br.edu.GitOutfit.dto;

public class CategoriaDTO {

	private int id;
	private String descricao;
	
	public int getId_Categoria() {
		return id;
	}
	public void setId_Categoria(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return "Cod: " + getId_Categoria() + "\n " + "Descricao Categoria: " +getDescricao() + "\n ";
		
	}
}
