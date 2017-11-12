package com.eder.tcc.modelo.nota;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.eder.tcc.modelo.aluno.Aluno;
import com.eder.tcc.modelo.aluno.AlunoRN;
import com.eder.tcc.modelo.disciplina.Disciplina;
import com.eder.tcc.modelo.disciplina.DisciplinaRN;
import com.eder.tcc.util.DAOFactory;


public class NotaRN {

	private NotaDAO notaDAO;
	
	public NotaRN() {
		this.notaDAO = DAOFactory.criarNotaDAO();
	}
	
	public void salvar(Nota nota){
		Integer id = nota.getCodigo();
		if(id == null || id  == 0){
			this.notaDAO.salvar(nota);
		} else {
			this.notaDAO.atualizar(nota);
		}
	}
	
	public List<Nota> listar(){
		return this.notaDAO.listar();
	}
	
	public List<Nota>listarNotaAluno(){
		return this.notaDAO.listarNotaAluno();
	}

	public void excluir(Nota nota) {
		this.notaDAO.excluir(nota);		
	}
	
	public List<SelectItem> getListaAnulos() {
		AlunoRN alunoRN = new AlunoRN();
		List<SelectItem> listaAluno = new ArrayList<SelectItem>();

		List<Aluno> alunos = alunoRN.listar();

		for (Aluno aluno : alunos) {
			listaAluno.add(new SelectItem(aluno, aluno.getNome()));
		}

		return listaAluno;
	}
	
	public List<SelectItem> getListaDisciplinas() {
		DisciplinaRN disciplinaRN = new DisciplinaRN();
		List<SelectItem> listaDisciplina = new ArrayList<SelectItem>();

		List<Disciplina> disciplinas = disciplinaRN.listar();

		for (Disciplina disciplina : disciplinas) {
			listaDisciplina.add(new SelectItem(disciplina, disciplina.getDescricao()));
		}

		return listaDisciplina;
	}
}
