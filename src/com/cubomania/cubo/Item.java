package com.cubomania.cubo;

import java.io.Serializable;

public class Item implements Comparable<Item>, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Cube cubo;
	private int quantidade;
	
	public Item(Cube cubo, int quantidade) {
		this.cubo = cubo;
		this.quantidade = quantidade;
	}

	public Cube getCubo() {
		return cubo;
	}

	public void setCubo(Cube cubo) {
		this.cubo = cubo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	public boolean equals(Cube obj) {
		if (this.cubo.getId() == obj.getId())
			return true;
		return false;
	}

	@Override
	public String toString() {
		return "Item [cubo=" + cubo + ", quantidade=" + quantidade + "]";
	}

	public boolean comparar(Item item) {
		if(this.cubo.getId() == item.getCubo().getId())
			return true;
		return false;
	}

	@Override
	public int compareTo(Item outro) {
		if(this.equals(outro)){
			return 0;
		} else {
			return this.getCubo().getNome().compareTo(outro.getCubo().getNome());
		}
	}
}
