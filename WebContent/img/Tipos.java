package model;

import java.util.ArrayList;
import java.util.TreeSet;

public class Tipos {
	
	private ArrayList<Cubo> cubos;

	public Tipos() {
		this.cubos = this.cadastroDeCubos();
	}

	public TreeSet<Cubo> listaDeCubos(String tamanho, String dificuldade, String tipo) {
		TreeSet<Cubo> tipos = new TreeSet<Cubo>();
		
		if (tamanho.length() > 0 && dificuldade.length() > 0 && tipo.length() > 0) 
			tipos = buscarTamanhoDificuldadeTipo(tamanho, dificuldade, tipo);
		 else if (tamanho.length() > 0 && dificuldade.length() > 0) 
			tipos = buscarTamanhoDificuldade(tamanho, dificuldade);
		 else if (tamanho.length() > 0 && tipo.length() > 0) 
			tipos = buscarTamanhoTipo(tamanho, tipo);
		 else if (dificuldade.length() > 0 && tipo.length() > 0) 
			tipos = buscarDificuldadeTipo(dificuldade, tipo);
		 else if (tamanho.length() > 0) 
			tipos = buscarTamanho(tamanho);
		 else if (dificuldade.length() > 0) 
			tipos = buscarDificuldade(dificuldade);
		 else if (tipo.length() > 0)
			tipos = buscarTipo(tipo);
		 else 
			tipos = todas();
		
		return tipos;
	}

	private TreeSet<Cubo> buscarTamanho(String tamanho) {
		TreeSet<Cubo> lista = new TreeSet<Cubo>();
		for (Cubo cubo : cubos) {
			if (tamanho.equals(cubo.getTamanho())) {
				lista.add(cubo);
			}
		}
		return lista;
	}

	private TreeSet<Cubo> buscarDificuldade(String dificuldade) {
		TreeSet<Cubo> lista = new TreeSet<Cubo>();
		for (Cubo cubo : cubos) {
			if (dificuldade.equals(cubo.getDificuldade())) {
				lista.add(cubo);
			}
		}
		return lista;
	}

	private TreeSet<Cubo> buscarTipo(String tipo) {
		TreeSet<Cubo> lista = new TreeSet<Cubo>();
		for (Cubo cubo : cubos) {
			if (tipo.equals(cubo.getTipo())) {
				lista.add(cubo);
			}
		}
		return lista;
	}

	private TreeSet<Cubo> buscarTamanhoDificuldade(String tamanho, String dificuldade) {
		TreeSet<Cubo> lista = new TreeSet<Cubo>();
		for (Cubo cubo : cubos) {
			if (tamanho.equals(cubo.getTamanho()) && dificuldade.equals(cubo.getDificuldade())) {
				lista.add(cubo);
			}
		}
		return lista;
	}

	private TreeSet<Cubo> buscarTamanhoTipo(String tamanho, String tipo) {
		TreeSet<Cubo> lista = new TreeSet<Cubo>();
		for (Cubo cubo : cubos) {
			if (tamanho.equals(cubo.getTamanho()) && tipo.equals(cubo.getTipo())) {
				lista.add(cubo);
			}
		}
		return lista;
	}

	private TreeSet<Cubo> buscarDificuldadeTipo(String dificuldade, String tipo) {
		TreeSet<Cubo> lista = new TreeSet<Cubo>();
		for (Cubo cubo : cubos) {
			if (dificuldade.equals(cubo.getDificuldade()) && tipo.equals(cubo.getTipo())) {
				lista.add(cubo);
			}
		}
		return lista;
	}

	private TreeSet<Cubo> buscarTamanhoDificuldadeTipo(String tamanho, String dificuldade,	String tipo) {
		TreeSet<Cubo> lista = new TreeSet<Cubo>();
		for (Cubo cubo : cubos) {
			if (tamanho.equals(cubo.getTamanho())
					&& dificuldade.equals(cubo.getDificuldade())
					&& tipo.equals(cubo.getTipo())) {
				lista.add(cubo);
			}
		}
		return lista;
	}
	
	private TreeSet<Cubo> todas() {
		TreeSet<Cubo> lista = new TreeSet<Cubo>();
		for (Cubo cubo : cubos) {
			lista.add(cubo);
		}
		return lista;
	}
	
	public void adicionar(TreeSet<Cubo> carrinho, String id, int quantidade){
		Cubo cubo = cubos.get(Integer.parseInt(id));
		if(cubo.getQuantidade() == 0){
			cubo.setQuantidade(quantidade);
			
			carrinho.add(cubo);
		}else{
			for(Cubo c : carrinho){
				if(c.getId() == Integer.parseInt(id)){
					c.setQuantidade(c.getQuantidade()+quantidade);
				}
			}
		}
		
		
	}
	
	public double calculaTotal(TreeSet<Cubo> carrinho){
		double total = 0.0;
		
		for(Cubo cubo : carrinho)
			total += cubo.getQuantidade()*cubo.getPreco();
		
		return total;
	}
	
	public void remover(TreeSet<Cubo> carrinho,int id){
		carrinho.remove(cubos.get(id));
	}
	
	public void diminuirQtd(TreeSet<Cubo> carrinho,int id){
		for(Cubo cubo : carrinho){
			if(cubo.getId() == id){
				if(cubo.getQuantidade() > 0) 
					cubo.setQuantidade(cubo.getQuantidade()-1);
			}
		}
		
	}
	
	public void aumentarQtd(TreeSet<Cubo> carrinho,int id){
		for(Cubo cubo : carrinho){
			if(cubo.getId() == id){
				cubo.setQuantidade(cubo.getQuantidade()+1);
			}
		}
		
	}

	private ArrayList<Cubo> cadastroDeCubos() {
		ArrayList<Cubo> cubos = new ArrayList<Cubo>();
		int id = 0;
		
		cubos.add(new Cubo(id++,"2x2x2", "2", "normal", "facil", "2x2x2",45.00));
		cubos.add(new Cubo(id++,"3x3x2", "3", "normal", "facil", "3x3x2",49.99));
		cubos.add(new Cubo(id++,"Clássico Android", "3", "normal", "medio", "3x3x3A",65.99));
		cubos.add(new Cubo(id++,"Clássico Braille v2", "3", "personalizado", "medio", "3x3x3B2",75.50));
		cubos.add(new Cubo(id++,"Clássico Braille", "3", "personalizado", "medio", "3x3x3B",76.50));
		cubos.add(new Cubo(id++,"4x4x4", "4", "normal", "dificil", "4x4x4",55.00));
		cubos.add(new Cubo(id++,"2x2x1", "2", "normal", "facil", "2x2x1",35.99));
		cubos.add(new Cubo(id++,"Clássico", "3", "normal", "medio", "3x3x3",51.99));
		cubos.add(new Cubo(id++,"3x3x3 Numeros", "3", "personalizado", "medio", "3x3x3N",49.99));
		cubos.add(new Cubo(id++,"3x3x3 Espelhado", "3", "personalizado", "medio", "3x3x3E",29.90));
		cubos.add(new Cubo(id++,"3x3x3 Sudoku", "3", "personalizado", "dificil", "3x3x3I",52.99));
		cubos.add(new Cubo(id++,"3x3x3 Gold", "3", "personalizado", "medio", "3x3x3EG",32.90));
		cubos.add(new Cubo(id++,"5x5x5", "5", "normal", "dificil", "5x5x5",60.00));
		
		return cubos;
	}

}