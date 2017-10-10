package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConectionFactory {
	public Connection getConnection(){
		try{
				ComboPooledDataSource cpds = new ComboPooledDataSource();
				cpds.setDriverClass("org.postgresql.Driver");
				cpds.setJdbcUrl("jdbc:postgresql://localhost/teste");
				cpds.setUser("postgres");
				cpds.setPassword("postgres");
				cpds.setMinPoolSize(3);
				cpds.setAcquireIncrement(5);
				cpds.setMaxPoolSize(20);
				
				return 	cpds.getConnection();
					
			
			
			
			/*
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost/teste","postgres","postgres");
			*/
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

}
