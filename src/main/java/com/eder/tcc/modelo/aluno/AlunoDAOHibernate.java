package com.eder.tcc.modelo.aluno;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class AlunoDAOHibernate implements AlunoDAO{

	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Aluno aluno) {
		this.session.saveOrUpdate(aluno);		
	}

	@Override
	public void atualizar(Aluno aluno) {
		this.session.update(aluno);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aluno> listar() {
		return this.session.createCriteria(Aluno.class).list();
	}

	@Override
	public void excluir(Aluno aluno) {
		this.session.delete(aluno);		
	}

	@Override
	public Aluno buscaPorRa(String ra) {
		String hql = "select a from Aluno a where a.ra = :ra";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("ra", ra);
		
		return (Aluno) consulta.uniqueResult();
	}

	@Override
	public Boolean buscaRa(String ra) {
		Aluno aluno = buscaPorRa(ra);
		if(aluno == null){
			return false;
		} else {
			return true;
		}
	}

}
