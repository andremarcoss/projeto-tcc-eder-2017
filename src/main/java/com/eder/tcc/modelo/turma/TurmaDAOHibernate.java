package com.eder.tcc.modelo.turma;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class TurmaDAOHibernate implements TurmaDAO {
	
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Turma turma) {
		this.session.save(turma);
		
	}

	@Override
	public void atualizar(Turma turma) {
		this.session.saveOrUpdate(turma);
		
	}

	@Override
	public void excluir(Turma turma) {
		this.session.delete(turma);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> listar() {
		return this.session.createCriteria(Turma.class).list();
	}

	@Override
	public Turma buscaPorDescricao(String descricao) {
		String hql = "select t from Turma t where t.descricao = :descricao";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("descricao", descricao);
		return (Turma) consulta.uniqueResult();
	}

	@Override
	public Boolean buscaDescricao(String descricao) {
		Turma turma = buscaPorDescricao(descricao);
		if(turma == null){
			return false;
		} else {
			return true;
		}
	}

}
