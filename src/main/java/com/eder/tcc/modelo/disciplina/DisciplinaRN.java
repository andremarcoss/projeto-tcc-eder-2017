package com.eder.tcc.modelo.disciplina;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.eder.tcc.modelo.professor.Professor;
import com.eder.tcc.modelo.professor.ProfessorRN;
import com.eder.tcc.util.DAOFactory;


public class DisciplinaRN {

	private DisciplinaDAO disciplinaDAO;
	
	public DisciplinaRN() {
		this.disciplinaDAO = DAOFactory.criarDisciplinaDAO();
	}
	
	public void salvar(Disciplina disciplina){
		Integer id = disciplina.getCodigo();
		if(id == null || id  == 0){
			this.disciplinaDAO.salvar(disciplina);
		} else {
			this.disciplinaDAO.atualizar(disciplina);
		}
	}
	
	public List<Disciplina> listar(){
		return this.disciplinaDAO.listar();
	}

	public void excluir(Disciplina disciplina) {
		this.disciplinaDAO.excluir(disciplina);		
	}
	
	public List<SelectItem> getListaProfessores() {
		ProfessorRN professorRN = new ProfessorRN();
		List<SelectItem> lista = new ArrayList<SelectItem>();

		List<Professor> professores = professorRN.listar();

		for (Professor professor : professores) {
			lista.add(new SelectItem(professor, professor.getNome()));
		}

		return lista;
	}
}
