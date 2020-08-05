package br.com.sorveteria.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.sorveteria.CRUD.PedidoCRUD;
import br.com.sorveteria.DAO.PedidoDAO;
import br.com.sorveteria.Util.Faces;
import br.com.sorveteria.entity.Calda;
import br.com.sorveteria.entity.Pedido;
import br.com.sorveteria.entity.Sabor;
import br.com.sorveteria.entity.Sorvete;
import br.com.sorveteria.entity.Usuario;

@ManagedBean(name = "PedidoBean")
@RequestScoped
public class PedidoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Pedido pedido;
	private Sorvete sorvete;
	private List<Calda> caldas;
	private List<Sabor> sabores;
	private String nomeCalda;
	private String nomeSabor;
	private int numQtd;
	private Faces faces;
	private String label;
	private Usuario logIn;
	private PedidoCRUD<Pedido, Sorvete, Sabor, Calda> pedidoDAO;

	public PedidoBean() {
		this.pedidoDAO = new PedidoDAO();

		this.pedido = new Pedido();
		this.pedido.setDataPedido(new Date());
		this.pedido.setSorvetes(new ArrayList<Sorvete>());

		this.sorvete = new Sorvete();
		this.sorvete.setCalda(new Calda());
		this.sorvete.setSabor(new Sabor());
		this.faces = new Faces();

		this.caldas = this.pedidoDAO.listarCalda();
		this.sabores = this.pedidoDAO.listarSabor();

	}

	public void usuarioLogado() {
		HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		this.logIn = (Usuario) sessao.getAttribute("logIn");
		this.label = this.logIn.getNome();
	}

	public void salvarPedido() {
		if (this.pedido.getSorvetes().isEmpty()) {
			this.faces.msgError("Você precisa Adicionar primeiro!");
		} else {
			this.pedidoDAO.salvarPedido(this.pedido);
			this.pedido = new Pedido(this.pedido.getCliente(), new Date(), new ArrayList<Sorvete>());
			this.faces.msgInfor("Salvo com Sucesso!");
		}
	}

	public void adicionarPedido() {
		Sorvete sorv = null;
		if (this.pedido.getCliente().isEmpty() || this.sorvete.getCalda().getNome().isEmpty()
				|| this.sorvete.getSabor().getNome().isEmpty() || this.sorvete.getQuantidade() == 0) {
			this.faces.msgError("Preencha todos os Campos!");
		} else {
			this.sorvete.setPedido(this.pedido);

			if (this.sorvete.getCalda().getNome().equals(this.sorvete.getSabor().getNome())) {
				this.faces.msgError("Sabor e Calda Iguais! troque a calda!!!");
			} else {
				for (Sorvete verificar : this.pedido.getSorvetes()) {
					if (verificar.getSabor().getNome().equals(this.sorvete.getCalda().getNome())) {
						sorv = verificar;
					}
				}
				if (sorv != null) {
					this.faces.msgError("Sabor e Calda Iguais,troque a calda!!!");
				} else {
					this.pedido.getSorvetes().add(this.sorvete);
					this.sorvete = new Sorvete(new Calda(), new Sabor(), this.sorvete.getQuantidade());
				}

			}
		}

	}

	public String remover() {
		Sorvete encontrado = null;
		for (Sorvete procurar : this.pedido.getSorvetes()) {
			if (procurar.getCalda().getNome().equals(this.nomeCalda)
					&& procurar.getSabor().getNome().equals(this.nomeSabor)
					&& procurar.getQuantidade() == this.numQtd) {
				encontrado = procurar;
			}
		}

		if (encontrado != null) {
			this.pedido.getSorvetes().remove(encontrado);
		}

		return "";
	}

	public Usuario getLogIn() {
		return logIn;
	}

	public void setLogIn(Usuario logIn) {
		this.logIn = logIn;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Faces getFaces() {
		return faces;
	}

	public void setFaces(Faces faces) {
		this.faces = faces;
	}

	public int getNumQtd() {
		return numQtd;
	}

	public void setNumQtd(int numQtd) {
		this.numQtd = numQtd;
	}

	public String getNomeCalda() {
		return nomeCalda;
	}

	public void setNomeCalda(String nomeCalda) {
		this.nomeCalda = nomeCalda;
	}

	public String getNomeSabor() {
		return nomeSabor;
	}

	public void setNomeSabor(String nomeSabor) {
		this.nomeSabor = nomeSabor;
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
