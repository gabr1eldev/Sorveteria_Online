package br.com.sorveteria.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.sorveteria.CRUD.UsuarioCRUD;
import br.com.sorveteria.DAO.UsuarioDAO;
import br.com.sorveteria.entity.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private String txtLogin;
	private String txtSenha;
	private UsuarioCRUD<Usuario> usuarioDAO;

	public UsuarioBean() {
		this.usuario = new Usuario();
		this.usuarioDAO = new UsuarioDAO();

	}

	public void salvar() {
		Usuario user = new Usuario(this.usuario.getNome(), this.usuario.getLogin(), this.usuario.getSenha());
		this.usuarioDAO.salvar(user);
	}

	public String entrar() {
		boolean verificar = false;
		for (Usuario user : this.usuarioDAO.listar()) {
			if (user.getLogin().equals(this.txtLogin) && user.getSenha().equals(this.txtSenha)) {
				verificar = true;
			}
		}

		if (verificar) {
			System.out.println("entrou");
		} else {
			System.out.println("login ou senha incorretos");
		}
		return "";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTxtLogin() {
		return txtLogin;
	}

	public void setTxtLogin(String txtLogin) {
		this.txtLogin = txtLogin;
	}

	public String getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(String txtSenha) {
		this.txtSenha = txtSenha;
	}

}
