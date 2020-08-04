package br.com.sorveteria.CRUD;

import java.util.List;

public interface UsuarioCRUD<Usuario> {
	
	void salvar(Usuario usuario);
	List<Usuario> listar();
	
	

}
