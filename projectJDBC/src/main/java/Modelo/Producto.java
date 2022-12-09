package Modelo;

import java.util.Date;

public class Producto {

	private Integer id;
	private String nombre;
	private int precio;
	private Date fechaRegistro;
	
	//se crea un constructor vacio
	public Producto() {
		
	}

	//se crea un constructor con todos los atributos
	public Producto(Integer id, String nombre, int precio, Date fechaRegistro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
	
	@Override
	public String toString() {
		return "Id ->" + id +" Nombre ->" + nombre + " Precio ->" + precio + " Fecha de Registro ->" + fechaRegistro;
	}
	
	
	
}
