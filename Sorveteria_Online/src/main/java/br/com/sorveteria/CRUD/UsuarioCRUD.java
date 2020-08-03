package br.com.sorveteria.CRUD;

import java.util.List;

public interface UsuarioCRUD<Entidade> {
	
	void salvar(Entidade entity);
	List<Entidade> listar();
	
	

}
