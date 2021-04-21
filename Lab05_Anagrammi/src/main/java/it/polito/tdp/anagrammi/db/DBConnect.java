package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class DBConnect {
	
	static private final String jdbcURL="jdbc:mysql://localhost/dizionario?user=root&password=root";
	static private HikariDataSource ds=null;//non ho un ds quando il programma parte
	
	public static Connection getConnection() {
		
		if(ds==null) {
			
			ds=new HikariDataSource();
			ds.setJdbcUrl(jdbcURL);
			//ds.setUsername("root"); -->metto uname e pwd qui se non li ho gia messi sopra
			//ds.setPassword("root");
		}
		
		try {
			
			Connection connection=ds.getConnection();
			return connection;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
