package com.eder.tcc.modelo.turma;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.eder.tcc.modelo.curso.Curso;
import com.eder.tcc.modelo.curso.CursoRN;
import com.eder.tcc.util.DAOFactory;

public class TurmaRN {

	private TurmaDAO turmaDAO;

	public TurmaRN() {
		this.turmaDAO = DAOFactory.criarTurmaDAO();
	}

	public void salvar(Turma turma) {
		Integer codigo = turma.getCodigo();
		if (codigo == null || codigo == 0) {
			this.turmaDAO.salvar(turma);
		} else {
			this.turmaDAO.atualizar(turma);
		}
	}

	public List<Turma> listar() {
		return this.turmaDAO.listar();
	}

	public void excluir(Turma turma) {
		this.turmaDAO.excluir(turma);
	}

	public List<SelectItem> getListaCursos() {
		CursoRN cursoRN = new CursoRN();
		List<SelectItem> lista = new ArrayList<SelectItem>();

		List<Curso> cursos = cursoRN.listar();

		for (Curso curso : cursos) {
			lista.add(new SelectItem(curso, curso.getDescricao()));
		}

		return lista;
	}

	public Boolean buscaDescricao(String descricao) {
		return this.turmaDAO.buscaDescricao(descricao);
	}

}
