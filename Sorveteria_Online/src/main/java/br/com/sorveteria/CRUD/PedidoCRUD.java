package br.com.sorveteria.CRUD;

import java.util.List;

public interface PedidoCRUD<Pedido, Sorvete, Sabor, Calda> {

	void salvarPedido(Pedido pedido);

	void salvarSorvete(Sorvete sorvete);

	void editarPedido(Pedido pedido);

	void excluidPedido(Pedido pedido);
	
	void excluirSorvete(Sorvete sorvete);
	
	Pedido pesquisar(Long id);

	List<Pedido> listarPedido();

	List<Sabor> listarSabor();

	List<Calda> listarCalda();
}
