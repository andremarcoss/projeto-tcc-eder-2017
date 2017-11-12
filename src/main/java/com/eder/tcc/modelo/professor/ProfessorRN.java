package com.eder.tcc.modelo.professor;

import java.util.List;

import com.eder.tcc.util.DAOFactory;

public class ProfessorRN {

	private ProfessorDAO professorDAO;

	public ProfessorRN() {
		this.professorDAO = DAOFactory.criarProfessorDAO();
	}

	public void salvar(Professor professor) {
		Integer codigo = professor.getCodigo();
		if (codigo == null || codigo == 0) {
			this.professorDAO.salvar(professor);
		} else {
			this.professorDAO.atualizar(professor);
		}
	}

	/*
	 * public List<SelectItem> getListaTurmas() { TurmaRN turmaRN = new
	 * TurmaRN(); List<SelectItem> lista = new ArrayList<SelectItem>();
	 * 
	 * List<Turma> turmas = turmaRN.listar();
	 * 
	 * for (Turma turma : turmas) { lista.add(new SelectItem(turma,
	 * turma.getDescricao())); }
	 * 
	 * return lista; }
	 */

	public List<Professor> listar() {
		return this.professorDAO.listar();
	}

	public void excluir(Professor professor) {
		this.professorDAO.excluir(professor);
	}
}
