package com.eder.tcc.modelo.professor;

import java.util.List;

import org.hibernate.Session;

public class ProfessorDAOHibernate implements ProfessorDAO{

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Professor professor) {
		this.session.saveOrUpdate(professor);		
	}

	@Override
	public void atualizar(Professor professor) {
		this.session.update(professor);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> listar() {
		return this.session.createCriteria(Professor.class).list();
	}

	@Override
	public void excluir(Professor professor) {
		this.session.delete(professor);		
	}


}
