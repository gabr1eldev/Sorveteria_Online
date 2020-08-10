package br.com.sorveteria.controller;

import java.io.Serializable;
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

@ManagedBean
@RequestScoped
public class PesquisaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Pedido pedido;
	private Sorvete sorvete;
	private List<Pedido> listaPedido;
	private Date dataInicio, dataFim;
	private PedidoCRUD<Pedido, Sorvete, Sabor, Calda> pedidoDAO;

	public PesquisaBean() {
		this.pedidoDAO = new PedidoDAO();
	}

	public void pesquisar() {
		this.listaPedido = this.pedidoDAO.pesquisarPedido(pedido, sorvete, dataInicio, dataFim);
	}

	public String voltar() {
		return "/pagina/pedido.xhtml?faces-redirect=true&amp;includeViewParams=true";
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

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
