package com.cubomania.cubo;

import java.util.List;
import java.util.TreeSet;

import com.cubomania.dao.CuboDAO;


public class TipoCubos {
	
	public void adicionar(List<Item> carrinho, String id, int quantidade){
		Cubo cubo = buscarPorId(id);
		if (cubo != null){
			Item item = new Item(cubo, quantidade);
			//se nao adicionar, pq ja existe, soma na quantidade
			if (!carrinho.add(item)){
				for(Item outro: carrinho){
					if (outro.equals(item)){
						outro.setQuantidade(item.getQuantidade() + outro.getQuantidade());
					}
				}
			}
		}
	}
	
	public void alterar(TreeSet<Item> carrinho, String id){
		Cubo cubo = buscarPorId(id);
		
		if (cubo != null){
			Item item = new Item(cubo, 0);
			for(Item outro: carrinho){
				if (outro.comparar(item)){
					carrinho.remove(outro);
					break;
				}
			}
		}
	}
	
	private Cubo buscarPorId(String id) {
		CuboDAO dao = new CuboDAO();
		return dao.selecionarId(id);
	}


	public List<Cubo> todos() {
		return new CuboDAO().carregarAll();
	}
	
	public double calculaTotal(TreeSet<Cubo> carrinho){
		double total = 0.0;
		
		for(Cubo cubo : carrinho)
			total += cubo.getQuantidade()*cubo.getPreco();
		
		return total;
	}
	
	public void diminuirQtd(TreeSet<Item> carrinho,String id){
		Cubo cubo = buscarPorId(id);
		
		for(Item outro: carrinho){
			if(outro.equals(cubo) && outro.getQuantidade() > 0){
				outro.setQuantidade(outro.getQuantidade()-1);
			}
		}
		
		
	}
	
	public void aumentarQtd(TreeSet<Item> carrinho,String id){
		Cubo cubo = buscarPorId(id);
		for(Item item: carrinho){
			
			if(item.equals(cubo)){
				
				System.out.println("acho o item");
				item.setQuantidade(item.getQuantidade()+1);
			}
		}
	}
	/*
	private ArrayList<Cubo> cadastroDeCubos() {
		ArrayList<Cubo> cubos = new ArrayList<Cubo>();
		int id = 0;
		
		cubos.add(new Cubo(id++,"2x2x2", "2", "normal", "facil", "2x2x2",45.00));
		cubos.add(new Cubo(id++,"3x3x2", "3", "normal", "facil", "3x3x2",49.99));
		cubos.add(new Cubo(id++,"7x7x7", "7", "normal", "dificil", "7x7x7",76.50));
		cubos.add(new Cubo(id++,"Clássico Android", "3", "normal", "medio", "3x3x3A",65.99));
		cubos.add(new Cubo(id++,"Clássico Braille v2", "3", "personalizado", "medio", "3x3x3B2",75.50));
		cubos.add(new Cubo(id++,"Clássico Braille", "3", "personalizado", "medio", "3x3x3B",76.50));
		cubos.add(new Cubo(id++,"Clássico Sem Cores", "3", "personalizado", "medio", "3x3x3S",70.00));
		cubos.add(new Cubo(id++,"4x4x4", "4", "normal", "dificil", "4x4x4",55.00));
		cubos.add(new Cubo(id++,"2x2x1", "2", "normal", "facil", "2x2x1",35.99));
		cubos.add(new Cubo(id++,"Clássico", "3", "normal", "medio", "3x3x3",51.99));
		cubos.add(new Cubo(id++,"3x3x3 Numeros", "3", "personalizado", "medio", "3x3x3N",49.99));
		cubos.add(new Cubo(id++,"3x3x3 Espelhado", "3", "personalizado", "medio", "3x3x3E",29.90));
		cubos.add(new Cubo(id++,"3x3x3 Sudoku", "3", "personalizado", "dificil", "3x3x3I",52.99));
		cubos.add(new Cubo(id++,"3x3x3 Gold", "3", "personalizado", "medio", "3x3x3EG",32.90));
		cubos.add(new Cubo(id++,"5x5x5", "5", "normal", "dificil", "5x5x5",60.00));
		
		return cubos;
	}*/

}