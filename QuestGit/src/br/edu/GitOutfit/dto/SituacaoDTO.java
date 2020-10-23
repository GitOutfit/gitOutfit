package br.edu.GitOutfit.dto;

public class SituacaoDTO {

	private int id;
	private String descricao;
	
	public int getId_Situacao() {
		return id;
	}
	public void setId_Situacao(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString() {
		return "Cod: " + getId_Situacao() + "\n " + "Descricao Situacao: " +getDescricao() + "\n ";
		
	}
}
