package com.eder.tcc.web;

import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.eder.tcc.modelo.usuario.Usuario;
import com.eder.tcc.modelo.usuario.UsuarioRN;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	private String loginUsuario;
	private List<Usuario> lista;
	private String destinoSalvar;

	public String novo() {
		this.destinoSalvar = "/admin/principal";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);

		return "/admin/usuario";
	}

	public String editar() {
		this.confirmarSenha = this.usuario.getSenha();
		return "/admin/usuario_editar";
	}

	public String salvar() {

		String senha = this.usuario.getSenha();
		String login = this.usuario.getLogin();
		if (!senha.equals(this.confirmarSenha)) {
			mostrarMenssagem("A senha não foi confirmada corretamente.");
			return null;
		}

		UsuarioRN usuarioRN = new UsuarioRN();

		if (usuarioRN.buscarLogin(login)) {
			mostrarMenssagem("Login já existe, escolha outro.");
			return null;
		} else {
			this.usuario.setAtivo(true);
			usuarioRN.salvar(this.usuario);
			novo();

			mostrarMenssagem("Usuário cadastrado com sucesso.");
			return this.destinoSalvar;
		}
	}

	public String atualizar() {

		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			mostrarMenssagem("A senha não foi confirmada corretamente.");
			return null;
		}

		UsuarioRN usuarioRN = new UsuarioRN();

		this.usuario.setAtivo(true);
		usuarioRN.salvar(this.usuario);
		novo();

		mostrarMenssagem("Usuário atualizado com sucesso.");
		return "/admin/principal?faces-redirect=true";

	}

	public String excluir() {
		UsuarioRN usuarioRN = new UsuarioRN();
		mostrarMenssagem("Usuário removido com sucesso.");
		usuarioRN.excluir(this.usuario);
		this.lista = null;

		return null;
	}

	public String ativar() {
		if (this.usuario.isAtivo()) {
			this.usuario.setAtivo(false);
		} else {
			this.usuario.setAtivo(true);
		}

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);

		return null;
	}

	public void mostrarMenssagem(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(msg);
		context.addMessage(null, facesMessage);
	}

	public String atribuiPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		Set<String> permissoes = this.usuario.getPermissao();
		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}

		return null;
	}

	public List<Usuario> getLista() {
		if (this.lista == null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}

		return this.lista;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}
}
