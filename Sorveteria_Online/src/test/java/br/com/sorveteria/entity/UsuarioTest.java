package br.com.sorveteria.entity;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sorveteria.CRUD.UsuarioCRUD;
import br.com.sorveteria.DAO.UsuarioDAO;

public class UsuarioTest {
	
	@Test
	@Ignore
	public void salvar() {
		Usuario user = new Usuario("gabriel", "greg123", "12345");
		UsuarioCRUD<Usuario> usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(user);
	}
	
	@Test
	public void listar() {
		UsuarioCRUD<Usuario> usuarioDAO = new UsuarioDAO();
		
		
		for(Usuario lista : usuarioDAO.listar()) {
			System.out.println(lista);
		}
	}

}
