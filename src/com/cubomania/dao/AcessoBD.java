package com.cubomania.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Classe responsável pela conexão com banco de dados MySQL
public class AcessoBD{
	
	public AcessoBD(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
	//Carrega driver JDBC
	
	//Obtém conexão com o banco de dados
	public Connection obtemConexao() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost/cubos?user=root&password=123mudar");
	}
}