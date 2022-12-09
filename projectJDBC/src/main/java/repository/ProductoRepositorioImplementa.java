package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Producto;
import util.ConexionBaseDatos;

public class ProductoRepositorioImplementa  implements Repositorio<Producto>{

	
	private Connection getConnection() throws SQLException {
		return ConexionBaseDatos.getInstance();
	}
	@Override
	public List<Producto> listar() {
		//nos devuelve una lista de tipo producto
		//creamos un arraylist de tipo producto
		List<Producto> productos= new ArrayList<>();
		
		try(Statement stmt= getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT*FROM producto")){
				while(rs.next()) {
					Producto producto = crearProducto(rs);
					productos.add(producto);
					
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return productos;
	}
	

	@Override
	public Producto obtenerPorId(int id) {
		Producto producto = null;
		try(PreparedStatement stmt= getConnection().prepareStatement("SELECT * FROM producto WHERE id=?")){
			//se setea el prametro y le pasamos el index donde esta el atributo y despues le pasas el parámetro
			stmt.setInt(1, id);
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				producto= crearProducto(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}

	@Override
	public void guardar(Producto producto) {
		String query;
		if(producto.getId() !=null && producto.getId()>0) {
				query="UPDATE producto SET nombre=?, precio=?, fechaRegistro=? WHERE id=? ";
		}else {
			query ="INSERT INTO producto(nombre, precio, fechaRegistro)VALUES(?,?,?)";
		} 
	
	try(PreparedStatement stmt= getConnection().prepareStatement(query)){
		stmt.setString(1, producto.getNombre());
		stmt.setInt(2, producto.getPrecio());
		Date fecha= new Date(producto.getFechaRegistro().getTime());
		stmt.setDate(3, fecha);
		//stmt.setDate(3, new Date (producto.getFechaRegistro().getTime()));
		
		stmt.executeUpdate();
		
	}catch (SQLException e){
		e.printStackTrace();
		
	}
	
}

	@Override
	public void eliminar(int id) {
		try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM producto WHERE id =?")){
			stmt.setInt(1, id);
			stmt.executeUpdate(); 
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	private Producto crearProducto(ResultSet rs) throws SQLException {
		Producto producto= new Producto();
		producto.setId(rs.getInt("id"));
		producto.setNombre(rs.getString("nombre"));
		producto.setPrecio(rs.getInt("precio"));
		producto.setFechaRegistro(rs.getDate("fechaRegistro"));
		return producto;
	}

	
}
