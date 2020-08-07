package br.com.sorveteria.DAO;

import java.util.Date;
import java.util.List;

import br.com.sorveteria.CRUD.PedidoCRUD;
import br.com.sorveteria.entity.Calda;
import br.com.sorveteria.entity.Pedido;
import br.com.sorveteria.entity.Sabor;
import br.com.sorveteria.entity.Sorvete;
import br.com.sorveteria.factory.Factory;

public class PedidoDAO implements PedidoCRUD<Pedido, Sorvete, Sabor, Calda> {

	private static PedidoDAO instance;

	public static PedidoDAO getInstance() {
		if (instance == null)
			instance = new PedidoDAO();
		return instance;

	}

	@Override
	public void salvarPedido(Pedido pedido) {
		try {
			Factory.getConnection().getTransaction().begin();
			Factory.getConnection().persist(pedido);

		} catch (Exception e) {
			e.printStackTrace();
			Factory.getConnection().getTransaction().rollback();

		} finally {
			Factory.getConnection().getTransaction().commit();
			Factory.getConnection().close();
		}

	}

	@Override
	public void salvarSorvete(Sorvete sorvete) {
		try {
			Factory.getConnection().getTransaction().begin();
			Factory.getConnection().persist(sorvete);

		} catch (Exception e) {
			e.printStackTrace();
			Factory.getConnection().getTransaction().rollback();

		} finally {
			Factory.getConnection().getTransaction().commit();
			Factory.getConnection().close();
		}

	}

	@Override
	public void editarPedido(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluidPedido(Pedido pedido) {
		// TODO Auto-generated method stub

	}

	@Override
	public void excluirSorvete(Sorvete sorvete) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> listarPedido() {
		List<Pedido> lista = null;

		try {
			lista = Factory.getConnection().createQuery("from Pedido p").getResultList();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sabor> listarSabor() {
		List<Sabor> lista = null;

		try {
			lista = Factory.getConnection().createQuery("from Sabor c").getResultList();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Calda> listarCalda() {
		List<Calda> lista = null;

		try {
			lista = Factory.getConnection().createQuery("from Calda c").getResultList();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	@Override
	public Pedido pesquisar(Long id) {
		
		Pedido pedido = Factory.getConnection().find(Pedido.class, id);
		return pedido;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> pesquisarPedido(Pedido pedido, Sorvete sorvete, Date dataInicio, Date dataFim) {
		List<Pedido> lista = null;
		try {

			lista = Factory.getConnection().createQuery("select distinct p.* from Pedido p, Sorvete s").getResultList();
			return lista;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
