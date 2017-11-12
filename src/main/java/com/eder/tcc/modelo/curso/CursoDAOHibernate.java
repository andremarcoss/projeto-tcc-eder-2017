package com.eder.tcc.modelo.curso;

import java.util.List;

import org.hibernate.Session;

public class CursoDAOHibernate implements CursoDAO{

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Curso curso) {
		this.session.saveOrUpdate(curso);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listar() {
		return this.session.createCriteria(Curso.class).list();
	}

	@Override
	public void atualizar(Curso curso) {
		this.session.update(curso);
		
	}

	@Override
	public void excluir(Curso curso) {
		this.session.delete(curso);
		
	}

}
