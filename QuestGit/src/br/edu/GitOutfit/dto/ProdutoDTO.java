package br.edu.GitOutfit.dto;

public class ProdutoDTO {
	
	private int id;
	private CategoriaDTO categoriaDTO;
	private MarcaDTO marcaDTO;
	private String nome;
	private String descricao;
	private double precoVenda;
	private int estoque;
	private int estoqueMin;
	private String imagem;
	// CATEGORIA + MARCA + imagem blog ??;
	
	public ProdutoDTO() {
		
	}
	
	public ProdutoDTO(CategoriaDTO categoriaDTO, MarcaDTO marcaDTO) {
		this.setCategoriaDTO(categoriaDTO);
		this.setMarcaDTO(marcaDTO);
		
	}
	public int getId_Produto() {
		return id;
	}
	public void setId_Produto(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}
	public int getEstoque() {
		return estoque;
	}
	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	public int getEstoqueMin() {
		return estoqueMin;
	}
	public void setEstoqueMin(int estoqueMin) {
		this.estoqueMin = estoqueMin;
	}
	
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}

	public MarcaDTO getMarcaDTO() {
		return marcaDTO;
	}

	public void setMarcaDTO(MarcaDTO marcaDTO) {
		this.marcaDTO = marcaDTO;
	}
	
	public String toString() {
		return "Cod: " + getId_Produto() + "\n " + "Nome Produto: " +getNome() + "\n " + "Descricao Produto: " +getDescricao() + "\n " + "Preco Venda: " +getPrecoVenda() + "\n " + "Estoque Produto: " +getEstoque() + "\n " + "Estoque Min: "  +getEstoqueMin() + "\n\n " + "Id Categoria: " +getCategoriaDTO() + "\n " + "Id Marca: " +getMarcaDTO() + "Imagem: " + getImagem() + "\n ";
		
	}

}
