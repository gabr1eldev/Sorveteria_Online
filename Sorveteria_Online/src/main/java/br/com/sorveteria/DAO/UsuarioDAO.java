package br.com.sorveteria.DAO;

import java.util.List;

import br.com.sorveteria.CRUD.UsuarioCRUD;
import br.com.sorveteria.entity.Usuario;
import br.com.sorveteria.factory.Factory;

public class UsuarioDAO implements UsuarioCRUD<Usuario> {

	private static UsuarioDAO instance;

	public static UsuarioDAO getInstance() {
		if (instance == null)
			instance = new UsuarioDAO();
		return instance;
	}

	@Override
	public void salvar(Usuario entity) {

		try {
			Factory.getConnection().getTransaction().begin();
			Factory.getConnection().persist(entity);

		} catch (Exception e) {
			e.printStackTrace();
			Factory.getConnection().getTransaction().rollback();

		} finally {
			Factory.getConnection().getTransaction().commit();
			Factory.getConnection().close();
		}

	}

	@Override
	public List<Usuario> listar() {
		List<Usuario> lista = null;

		try {
			lista = Factory.getConnection().createQuery("from Usuario u").getResultList();
			return lista;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return lista;
	}

}
