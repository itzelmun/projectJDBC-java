package repository;

import java.util.List;

public interface Repositorio <T> {

	//va a recibir un tipo de objeto
	List<T> listar();
	
	T obtenerPorId(int id);
	void guardar(T t);
	void eliminar(int id);
	
}
