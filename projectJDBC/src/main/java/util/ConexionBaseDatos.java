package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

	//se usa el patron de diseño singleton y solo se hace una instancia unica
	private static String url ="jdbc:mysql://localhost:3306/tienda";
	private static String username= "root";
	private static String password="023975";
	private static Connection conexion;
	
	//metodo de tipo conecction que obtiene una instancia
	public static Connection getInstance() throws SQLException {
		//si no tiene una instancia, entonces hazmela
		if(conexion == null) {
			conexion = DriverManager.getConnection(url, username, password);
			
		}
		//si tiene la instancia se sale de la conexion y te retorna la conexion
		return conexion;
	}
	
}
