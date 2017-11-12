package com.eder.tcc.modelo.aluno;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.eder.tcc.modelo.turma.Turma;
import com.eder.tcc.modelo.turma.TurmaRN;
import com.eder.tcc.util.DAOFactory;

public class AlunoRN {

	private AlunoDAO alunoDAO;
	
	public AlunoRN() {
		this.alunoDAO = DAOFactory.criarAlunoDAO();
	}
	
	public void salvar(Aluno aluno){
		Integer codigo = aluno.getCodigo();
		if(codigo == null || codigo  == 0){
			this.alunoDAO.salvar(aluno);
		} else {
			this.alunoDAO.atualizar(aluno);
		}
	}
	
	public List<SelectItem> getListaTurmas() {
		TurmaRN turmaRN = new TurmaRN();
		List<SelectItem> lista = new ArrayList<SelectItem>();

		List<Turma> turmas = turmaRN.listar();

		for (Turma turma : turmas) {
			lista.add(new SelectItem(turma, turma.getDescricao()));
		}

		return lista;
	}
	
	public List<Aluno> listar(){
		return this.alunoDAO.listar();
	}

	public void excluir(Aluno aluno) {
		this.alunoDAO.excluir(aluno);
	}
}
