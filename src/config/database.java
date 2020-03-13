package config;
import java.sql.*;
public class database {
    public Connection connection = null;
    
    public void conexion(){
        if (connection != null){
		return;
	}
	String url = "jdbc:postgresql:java";
	String password = "123456789";
	try{
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection(url, "postgres", password);
                
		if (connection != null){
                    System.out.println("Conexion exitosa");
		}
                
	} catch (Exception e){
	      System.out.println("Problemas de conexion");
	  }
    }
    
}
