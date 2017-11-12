package com.eder.tcc.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.eder.tcc.modelo.aluno.AlunoRN;
import com.eder.tcc.modelo.professor.Professor;
import com.eder.tcc.modelo.professor.ProfessorRN;

@ManagedBean
@RequestScoped
public class ProfessorBean {

	private Professor professor = new Professor();
	private List<Professor> lista;

	public String novo() {
		this.professor = new Professor();
		return "/admin/professor_formulario";
	}

	public String salvar() {
		ProfessorRN professorRN = new ProfessorRN();
		professorRN.salvar(this.professor);
		this.professor = new Professor();

		mostrarMenssagem("Professor cadastrado com sucesso!");
		return "";
	}

	public String editar() {
		return "/admin/professor_formulario";
	}

	public String excluir() {
		ProfessorRN professorRN = new ProfessorRN();
		professorRN.excluir(this.professor);

		return null;
	}

	public List<SelectItem> getTurmas() throws Exception {
		AlunoRN alunoRN = new AlunoRN();
		return alunoRN.getListaTurmas();
	}

	public void mostrarMenssagem(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(msg);
		context.addMessage(null, facesMessage);
	}

	public List<Professor> getLista() {
		if (lista == null) {
			ProfessorRN professorRN = new ProfessorRN();
			this.lista = professorRN.listar();
		}

		return lista;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}
