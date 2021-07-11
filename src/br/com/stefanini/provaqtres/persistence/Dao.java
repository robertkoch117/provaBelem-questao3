package br.com.stefanini.provaqtres.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao implements IDao{
	Connection conn;
	PreparedStatement stmt;
	PreparedStatement stmt1;
	ResultSet rs;
	
	public void open() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/bdquestao3";
		String user = "root";
		String password = "DBMySQL";
		conn = DriverManager.getConnection(url,user,password);
		
	}
	
	public void close() throws Exception{
		conn.close();
	}
}
