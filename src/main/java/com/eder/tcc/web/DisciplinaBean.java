package com.eder.tcc.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.eder.tcc.modelo.disciplina.Disciplina;
import com.eder.tcc.modelo.disciplina.DisciplinaRN;

@ManagedBean
@RequestScoped
public class DisciplinaBean {

	private Disciplina disciplina = new Disciplina();
	private List<Disciplina> lista;

	public String novo() {
		this.disciplina = new Disciplina();

		return "/admin/disciplina_formulario";
	}

	public String salvar() {

		DisciplinaRN disciplinaRN = new DisciplinaRN();
		disciplinaRN.salvar(this.disciplina);
		novo();
		mostrarMenssagem("Disciplina cadastrada com sucesso!");

		return "/restrito/disciplina_lista";
	}

	public String excluir() {
		DisciplinaRN disciplinaRN = new DisciplinaRN();
		disciplinaRN.excluir(this.disciplina);
		this.lista = null;

		return null;
	}

	public String editar() {
		return "/admin/disciplina_formulario";
	}

	public List<SelectItem> getProfessores() throws Exception {
		DisciplinaRN disciplinaRN = new DisciplinaRN();
		return disciplinaRN.getListaProfessores();
	}
	
	public List<Disciplina> getLista() {
		if (lista == null) {
			DisciplinaRN disciplinaRN = new DisciplinaRN();
			this.lista = disciplinaRN.listar();
		}
		return lista;
	}

	public void mostrarMenssagem(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(msg);
		context.addMessage(null, facesMessage);
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
