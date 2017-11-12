package com.eder.tcc.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.eder.tcc.modelo.turma.Turma;
import com.eder.tcc.modelo.turma.TurmaRN;

@ManagedBean
@RequestScoped
public class TurmaBean {

	private Turma turma = new Turma();
	private List<Turma> lista;

	public String novo() {
		this.turma = new Turma();
		return "/admin/turma_formulario";
	}

	public String salvar() {
		TurmaRN turmaRN = new TurmaRN();
		String descricao = this.turma.getDescricao();
		if (turmaRN.buscaDescricao(descricao)) {
			mostrarMenssagem("Turma já existe.");
			return null;
		} else {
			turmaRN.salvar(turma);
			novo();
			mostrarMenssagem("Turma cadastrada com sucesso!");

			return null;
		}
	}

	public String atualizar() {
		TurmaRN turmaRN = new TurmaRN();

		turmaRN.salvar(turma);
		novo();
		mostrarMenssagem("Turma atualizada com sucesso!");

		return null;

	}

	public String editar() {
		return "/admin/turma_editar";
	}

	public String excluir() {
		TurmaRN turmaRN = new TurmaRN();
		turmaRN.excluir(this.turma);

		return null;
	}

	public List<SelectItem> getCursos() throws Exception {
		TurmaRN turmaRN = new TurmaRN();
		return turmaRN.getListaCursos();
	}

	public List<Turma> getLista() {
		if (lista == null) {
			TurmaRN turmaRN = new TurmaRN();
			this.lista = turmaRN.listar();
		}
		return lista;
	}

	public void mostrarMenssagem(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(msg);
		context.addMessage(null, facesMessage);
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
