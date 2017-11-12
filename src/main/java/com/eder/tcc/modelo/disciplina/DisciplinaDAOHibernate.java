package com.eder.tcc.modelo.disciplina;

import java.util.List;

import org.hibernate.Session;

public class DisciplinaDAOHibernate implements DisciplinaDAO{

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Disciplina disciplina) {
		this.session.saveOrUpdate(disciplina);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Disciplina> listar() {
		return this.session.createCriteria(Disciplina.class).list();
	}

	@Override
	public void atualizar(Disciplina disciplina) {
		this.session.update(disciplina);
		
	}

	@Override
	public void excluir(Disciplina disciplina) {
		this.session.delete(disciplina);
		
	}

}
