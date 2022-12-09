package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.ConexionBaseDatos;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String url="jdbc:mysql://localhost:3306/ferreteria_db";
		//String user = "root";
		//String password ="023975";
		
		//la clase conection nos conecta con el driver
		try {
			Connection conexion = ConexionBaseDatos.getInstance();
		System.out.println("Si se conectó");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error, no se conectó");
		}
		
	}

}
