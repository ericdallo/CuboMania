package com.cubomania.cubo;

public class Cubo implements Comparable<Cubo> {
	
	private int id;
	private String nome;
	private String tamanho;
	private String tipo;
	private String dificuldade;
	private String imagem;
	private int quantidade;
	private double preco;

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Cubo(int id,String nome, String tamanho,String tipo, String dificuldade, String imagem,double preco) {
		this.id = id;
		this.nome = nome;
		this.tamanho = tamanho;
		this.dificuldade = dificuldade;
		this.tipo = tipo;
		this.imagem = imagem;
		this.preco = preco;
	} 
	
	public Cubo() {
	}

	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public String getTamanho() {
		return tamanho;
	}

	public String getDificuldade() {
		return dificuldade;
	}

	public String getTipo() {
		return tipo;
	}

	public String getImagem() {
		return imagem;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", tamanho=" + tamanho + ", dificuldade=" + dificuldade
				+ ", tipo=" + tipo + ", imagem=" + imagem;
	}

	@Override
	public int compareTo(Cubo cubo) {
		if (nome.equals(cubo.getNome())	&& tamanho.equals(cubo.getTamanho()) && dificuldade.equals(cubo.getDificuldade())
				&& tipo.equals(cubo.getTipo())) {
			return 0;
		}
		return -1;
	}

}
