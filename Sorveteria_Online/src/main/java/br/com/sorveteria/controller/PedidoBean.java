package br.com.sorveteria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sorveteria.CRUD.PedidoCRUD;
import br.com.sorveteria.DAO.PedidoDAO;
import br.com.sorveteria.entity.Calda;
import br.com.sorveteria.entity.Pedido;
import br.com.sorveteria.entity.Sabor;
import br.com.sorveteria.entity.Sorvete;

@ManagedBean(name = "PedidoBean")
@RequestScoped
public class PedidoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Pedido pedido;
	private Sorvete sorvete;
	private List<Calda> caldas;
	private List<Sabor> sabores;

	private PedidoCRUD<Pedido, Sorvete, Sabor, Calda> pedidoDAO;

	public PedidoBean() {
		this.pedidoDAO = new PedidoDAO();

		this.pedido = new Pedido();
		this.pedido.setDataPedido(new Date());
		this.pedido.setSorvetes(new ArrayList<Sorvete>());

		this.sorvete = new Sorvete();
		this.sorvete.setCalda(new Calda());
		this.sorvete.setSabor(new Sabor());

		this.caldas = this.pedidoDAO.listarCalda();
		this.sabores = this.pedidoDAO.listarSabor();

	}

	public void salvarPedido() {
		this.pedidoDAO.salvarPedido(this.pedido);
		this.pedido = new Pedido(this.pedido.getCliente(), new Date(), new ArrayList<Sorvete>());

	}

	public void adicionarPedido() {
		this.sorvete.setPedido(this.pedido);
		this.pedido.getSorvetes().add(this.sorvete);
		this.sorvete = new Sorvete(new Calda(), new Sabor(), this.sorvete.getQuantidade());

	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Sorvete getSorvete() {
		return sorvete;
	}

	public void setSorvete(Sorvete sorvete) {
		this.sorvete = sorvete;
	}

	public List<Calda> getCaldas() {
		return caldas;
	}

	public void setCaldas(List<Calda> caldas) {
		this.caldas = caldas;
	}

	public List<Sabor> getSabores() {
		return sabores;
	}

	public void setSabores(List<Sabor> sabores) {
		this.sabores = sabores;
	}

}
