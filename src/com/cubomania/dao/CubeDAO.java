package com.cubomania.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cubomania.cubo.Cubo;

public class CuboDAO{
	
	private Connection conn;
	private AcessoBD bd;
	
	public CuboDAO(){
		try{
			bd = new AcessoBD();
			conn = bd.obtemConexao();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Inclusao de cubos
	public void incluir(int id, String nome, String tamanho,String tipo,String dificuldade,String imagem,String preco){
		String sqlInsert = "INSERT INTO cubo(id, nome, tamanho, tipo, dificuldade, imagem, preco )	VALUES (?, ?, ?, ?, ?, ?, ?)";

		try	(PreparedStatement st = conn.prepareStatement(sqlInsert) ){
			// Inclusao dos dados na tabela Cubos
			st.setInt(1, id);
			st.setString(2, nome);
			st.setString(3, tamanho);
			st.setString(4, tipo);
			st.setString(5, dificuldade);
			st.setString(6, imagem);
			st.setString(7, preco);
			st.execute();
		}catch (Exception e)	{
			e.printStackTrace();
			try	{
				conn.rollback();
			}
			catch (SQLException e1)	{ 
				System.out.print(e1.getStackTrace());
			}
		}
	}
	public void excluir(int  id){
		String sqlDelete = "DELETE FROM cubo WHERE id = ?";
		
		try	(PreparedStatement stm = conn.prepareStatement(sqlDelete)){
			stm.setInt(1, id);

			stm.execute();
		}catch (Exception e)	{
			e.printStackTrace();
			try	{
				conn.rollback();
			}
			catch (SQLException e1)	{
				System.out.print(e1.getStackTrace());
			}
		}
		
	}
	public List<Cubo> carregarAll(){
		String sql = "SELECT * FROM cubo ORDER BY id";
		List<Cubo> lista = new ArrayList<Cubo>();
		try (PreparedStatement st = conn.prepareStatement(sql); ResultSet rs = st.executeQuery()){
			
			while(rs.next()){
				Cubo cubo = new Cubo();
				cubo.setId(rs.getInt(1));
				cubo.setNome(rs.getString(2));
				cubo.setTamanho(rs.getString(3));
				cubo.setTipo(rs.getString(4));
				cubo.setDificuldade(rs.getString(5));
				cubo.setImagem(rs.getString(6));
				cubo.setPreco(rs.getDouble(7));
				lista.add(cubo);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return lista;
	}
	
	

	public Cubo selecionarId(String id) {
		String query = "SELECT * FROM cubo WHERE id = ?";
		
		Cubo cubo = new Cubo();
		try (PreparedStatement st = conn.prepareStatement(query)){
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){
				cubo.setId(rs.getInt(1));
				cubo.setNome(rs.getString(2));
				cubo.setTamanho(rs.getString(3));
				cubo.setTipo(rs.getString(4));
				cubo.setDificuldade(rs.getString(5));
				cubo.setImagem(rs.getString(6));
				cubo.setPreco(rs.getDouble(7));
			}
		} catch (SQLException sqe) {
			sqe.printStackTrace();
		}
		return cubo;
	}
	
	
} 
