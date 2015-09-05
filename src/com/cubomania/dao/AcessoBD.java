package com.cubomania.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cubomania.util.CuboManiaConfig;

public class AcessoBD{
	
	private final static String DB_HOST = CuboManiaConfig.getValue(CuboManiaConfig.Property.DB_HOST);
	private final static String DB_USER = CuboManiaConfig.getValue(CuboManiaConfig.Property.DB_USER);
	private final static String DB_PASSWORD = CuboManiaConfig.getValue(CuboManiaConfig.Property.DB_PASSWORD);
	private final static String DB_DATABASE= CuboManiaConfig.getValue(CuboManiaConfig.Property.DB_DATABASE);

	public AcessoBD(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e){
			throw new RuntimeException(e);
		}
	}
	
	public Connection obtemConexao() throws SQLException{
		String dbConnection = "jdbc:mysql://"+DB_HOST+"/"+ DB_DATABASE + "?user=" + DB_USER + "&password=" + DB_PASSWORD;
		return DriverManager.getConnection(dbConnection);
	}

}