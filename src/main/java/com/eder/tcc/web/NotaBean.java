package com.eder.tcc.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.eder.tcc.modelo.nota.Nota;
import com.eder.tcc.modelo.nota.NotaRN;

@ManagedBean
@RequestScoped
public class NotaBean {

	private Nota nota = new Nota();
	private List<Nota> lista;
	private List<Nota> listaNotaAluno;

	public String novo() {
		this.nota = new Nota();
		return "/nota/nota_formulario";
	}

	public String salvar() {

		NotaRN notaRN = new NotaRN();
		notaRN.salvar(this.nota);
		this.nota = new Nota();
		mostrarMenssagem("Nota cadastrada com sucesso!");

		return "/restrito/nota_lista";
	}

	public String excluir() {
		NotaRN notaRN = new NotaRN();
		notaRN.excluir(this.nota);
		this.lista = null;

		return null;
	}

	public String editar() {
		return "/nota/nota_formulario";
	}

	public String getDataAtual() {
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	public List<SelectItem> getDisciplinas() throws Exception {
		NotaRN notaRN = new NotaRN();
		return notaRN.getListaDisciplinas();
	}
	
	public List<SelectItem> getAlunos() throws Exception {
		NotaRN notaRN = new NotaRN();
		return notaRN.getListaAnulos();
	}
	
	public List<Nota> getLista() {
		if (lista == null) {
			NotaRN notaRN = new NotaRN();
			this.lista = notaRN.listar();
		}
		return lista;
	}
	
	public List<Nota> getListaNotaAluno() {
		if (listaNotaAluno == null) {
			NotaRN notaRN = new NotaRN();
			this.listaNotaAluno = notaRN.listarNotaAluno();
		}
		return listaNotaAluno;
	}

	public void mostrarMenssagem(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(msg);
		context.addMessage(null, facesMessage);
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
}
