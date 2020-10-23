package br.edu.GitOutfit.dto;

public class MarcaDTO {

	private int id;
	private String descricao;
	
	public int getId_Marca() {
		return id;
	}
	public void setId_Marca(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return "Cod: " + getId_Marca() + "\n " + "Descricao Marca: " +getDescricao() + "\n ";
		
	}
}
