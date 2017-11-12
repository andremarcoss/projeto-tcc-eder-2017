package com.eder.tcc.modelo.nota;

import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;

import com.eder.tcc.modelo.usuario.Usuario;
import com.eder.tcc.modelo.usuario.UsuarioRN;

public class NotaDAOHibernate implements NotaDAO{

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Nota nota) {
		this.session.saveOrUpdate(nota);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Nota> listar() {
		return this.session.createCriteria(Nota.class).list();
	}

	/* 
	 * SELECT n.valor, a.email FROM nota n, aluno a
				inner join usuario u on a.email = u.email
				where n.aluno = a.codigo;
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Nota> listarNotaAluno() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		String login = externalContext.getRemoteUser();
		Usuario usuario = new Usuario();
		if(login != null){
			UsuarioRN usuarioRN = new UsuarioRN();
			usuario = usuarioRN.buscarPorLogin(login);
		}
		
		String emailUsuario = usuario.getEmail();
		
		// System.out.println(emailUsuario);
		String hql = "select n from Nota n, Aluno a where a.email = :emailUsuario and n.aluno = a.codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("emailUsuario", emailUsuario);
		//System.out.println(consulta.list());
		List<Nota> lista = consulta.list();
		
		return lista;
	}

	@Override
	public void atualizar(Nota nota) {
		this.session.update(nota);
		
	}

	@Override
	public void excluir(Nota nota) {
		this.session.delete(nota);
		
	}


}
