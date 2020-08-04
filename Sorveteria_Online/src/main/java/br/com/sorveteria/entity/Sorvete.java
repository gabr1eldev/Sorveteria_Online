package br.com.sorveteria.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SORVETE")
public class Sorvete implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_SORVETE")
	@SequenceGenerator(name = "S_SORVETE", sequenceName = "S_SORVETE", initialValue = 1, allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pedido", referencedColumnName = "id", nullable = false)
	private Pedido pedido;

	@OneToOne
	@JoinColumn(name = "calda", referencedColumnName = "nome", nullable = false)
	private Calda calda;

	@OneToOne
	@JoinColumn(name = "sabor", referencedColumnName = "nome", nullable = false)
	private Sabor sabor;

	@Column(name = "quantidade")
	private int quantidade;

	public Sorvete() {

	}

	public Sorvete(Calda calda, Sabor sabor, int quantidade) {
		this.calda = calda;
		this.sabor = sabor;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Calda getCalda() {
		return calda;
	}

	public void setCalda(Calda calda) {
		this.calda = calda;
	}

	public Sabor getSabor() {
		return sabor;
	}

	public void setSabor(Sabor sabor) {
		this.sabor = sabor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sorvete other = (Sorvete) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sorvete [id=" + id + ", pedido=" + pedido + ", calda=" + calda + ", sabor=" + sabor + ", quantidade="
				+ quantidade + "]";
	}

}
