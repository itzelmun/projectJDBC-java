package Principal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import Modelo.Producto;
import Modelo.Usuario;
import repository.ProductoRepositorioImplementa;
import repository.Repositorio;
import repository.UsuarioRepositorioImplementa;
import util.ConexionBaseDatos;

public class Principal {

	public static void main(String[] args) {
		
		try(Connection conectar= ConexionBaseDatos.getInstance()){
			/*
			Repositorio <Producto> repositorio = new ProductoRepositorioImplementa();
			System.out.println("--------------LISTA PRODUCTOS--------------");
			repositorio.listar().forEach(System.out::println);
			
			//filtra por id
			System.out.println("--------------OBTENER POR ID---------------");
			System.out.println(repositorio.obtenerPorId(1));
			
			
			System.out.println("--------------Insertar Producto------------");
			Producto product = new Producto();
			product.setNombre("Fanta");
			product.setPrecio(20);
			Date fecha= new Date(2022/07/05);
			product.setFechaRegistro(fecha);
			repositorio.guardar(product);
			System.out.println("Producto Ingresado");
			*/
			/*
			
			System.out.println("---------------Eliminar producto-----------");
			repositorio.eliminar(6);
			System.out.println("Producto eliminado");
			*/
			
			
			
			/*----------------------Usuarios--------------------------------------*/
			
			Repositorio <Usuario> repositori = new UsuarioRepositorioImplementa();
			System.out.println("---------------LISTA USUARIOS------------------");
			repositori.listar().forEach(System.out::println);
			
			System.out.println("---------------OBTENER POR ID------------------");
			System.out.println(repositori.obtenerPorId(1));
			/*
			System.out.println("---------------INSERTAR USUARIO-----------------");
			Usuario user = new Usuario();
			user.setUsername("Sanchez");
			user.setPassword("12345");
			user.setEmail("sanchez@gmail.com");
			repositori.guardar(user);
			System.out.println("Usuario Guardado");
			*/
			System.out.println("--------------ELIMINAR USUARIO------------------");
			repositori.eliminar(6);
			System.out.println("Usuario Eliminado");
			
			
		}catch (SQLException e){
			e.printStackTrace();
		}

	}

}
