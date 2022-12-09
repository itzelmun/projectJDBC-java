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
import Modelo.Usuario;
import util.ConexionBaseDatos;

public class UsuarioRepositorioImplementa implements Repositorio<Usuario>{

	private Connection getConnection() throws SQLException{
		return ConexionBaseDatos.getInstance();
		
	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> users= new ArrayList<>();
		
		try(Statement stmt= getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM usuario")){
				while(rs.next()) {
					Usuario usuario = crearUsuario(rs);
					users.add(usuario);
					
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}

	
	@Override
	public Usuario obtenerPorId(int id) {
		Usuario usuario = null;
		try(PreparedStatement stmt= getConnection().prepareStatement("SELECT * FROM usuario WHERE id=?")){
			//se setea el prametro y le pasamos el index donde esta el atributo y despues le pasas el parámetro
			stmt.setInt(1, id);
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				usuario= crearUsuario(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	

	
	@Override
	public void guardar(Usuario usuario) {
		String query;
		if(usuario.getId() !=null && usuario.getId()>0) {
				query="UPDATE usuario SET username=?, password=?, email=? WHERE id=? ";
		}else {
			query ="INSERT INTO usuario(username, password, email)VALUES(?,?,?)";
		} 
	
	try(PreparedStatement stmt= getConnection().prepareStatement(query)){
		stmt.setString(1, usuario.getUsername());
		stmt.setString(2, usuario.getPassword() );
		stmt.setString(3, usuario.getEmail());
		stmt.executeUpdate();
		
	}catch (SQLException e){
		e.printStackTrace();
		
	}
		
	}

	@Override
	public void eliminar(int id) {
		try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM usuario WHERE id =?")){
			stmt.setInt(1, id);
			stmt.executeUpdate(); 
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	private Usuario crearUsuario(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt("id"));
		usuario.setUsername(rs.getString("username"));
		usuario.setPassword(rs.getString("password"));
		usuario.setEmail(rs.getString("email"));
		
		return usuario;
		
		
	}
}
