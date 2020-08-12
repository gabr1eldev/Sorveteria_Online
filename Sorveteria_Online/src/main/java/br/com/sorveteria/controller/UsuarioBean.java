package br.com.sorveteria.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.sorveteria.CRUD.UsuarioCRUD;
import br.com.sorveteria.DAO.UsuarioDAO;
import br.com.sorveteria.Util.Faces;
import br.com.sorveteria.entity.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private String txtLogin;
	private String txtSenha;
	private UsuarioCRUD<Usuario> usuarioDAO;
	private Faces faces;

	public UsuarioBean() {
		this.usuario = new Usuario();
		this.usuarioDAO = new UsuarioDAO();
		this.faces = new Faces();

	}

	public void salvar() {
		boolean verificar = false;
		if (this.usuario.getNome().isEmpty() || this.usuario.getLogin().isEmpty()
				|| this.usuario.getSenha().isEmpty()) {
			this.faces.msgError("Preencha os Campos");
		} else {
			Usuario novoUser = new Usuario(this.usuario.getNome(), this.usuario.getLogin(), this.usuario.getSenha());
			for (Usuario user : this.usuarioDAO.listar()) {
				if (this.usuario.getLogin().equals(user.getLogin())) {
					verificar = true;
				}
			}
			if (verificar) {
				this.usuario = new Usuario();
				this.faces.msgError("você já possui cadastro!");
			} else {
				this.usuarioDAO.salvar(novoUser);
				this.faces.msgInfor("cadastrado com sucesso!");
			}
			this.usuario = new Usuario();
		}
	}

	public String entrar() {

		Usuario logIn = null;
		if (this.txtLogin.isEmpty() || this.txtSenha.isEmpty()) {
			this.faces.msgError("Preencha os Campos!");
		} else {

			for (Usuario user : this.usuarioDAO.listar()) {
				if (user.getLogin().equals(this.txtLogin) && user.getSenha().equals(this.txtSenha)) {
					logIn = user;
				}
			}

			if (logIn == null && !this.txtLogin.isEmpty() && !this.txtSenha.isEmpty()) {
				this.txtLogin = null;
				this.txtSenha = null;
				this.faces.msgError("Login ou senha incorretos");

			} else {
				HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext()
						.getSession(true);
				sessao.setAttribute("logIn", logIn);
				return "/pagina/pedido.xhtml?faces-redirect=true&amp;includeViewParams=true";
			}
		}

		return "";
	}

	public Faces getFaces() {
		return faces;
	}

	public void setFaces(Faces faces) {
		this.faces = faces;
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
