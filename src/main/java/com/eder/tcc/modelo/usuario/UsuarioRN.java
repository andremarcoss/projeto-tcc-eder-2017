package com.eder.tcc.modelo.usuario;

import java.util.List;

import com.eder.tcc.util.DAOFactory;

public class UsuarioRN {

private UsuarioDAO usuarioDAO;
	
	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}
	
	public Usuario carregar(Integer codigo){
		return this.usuarioDAO.carregar(codigo);
	}
	
	public Usuario buscarPorLogin(String login){
		return this.usuarioDAO.buscarPorLogin(login);
	}
	
	public Boolean buscarLogin(String login){
		return this.usuarioDAO.buscaLogin(login);
	}
	
	public void salvar(Usuario usuario){
		Integer codigo = usuario.getCodigo();
		if(codigo == null || codigo == 0){
			usuario.getPermissao().add("ROLE_USUARIO");
			this.usuarioDAO.salvar(usuario);
		} else {
			usuario.getPermissao().add("ROLE_USUARIO");
			this.usuarioDAO.atualizar(usuario);			
		}
	}
	public void excluir(Usuario usuario){
		this.usuarioDAO.excluir(usuario);
	}
	public List<Usuario> listar(){
		return this.usuarioDAO.listar();
	}
}
