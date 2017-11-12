package com.eder.tcc.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.eder.tcc.modelo.aluno.Aluno;
import com.eder.tcc.modelo.aluno.AlunoRN;

@ManagedBean(name="alunoBean")
@RequestScoped
public class AlunoBean {
	
	private Aluno aluno = new Aluno();
	private List<Aluno> lista;

	public String novo(){
		this.aluno = new Aluno();
		return "/admin/aluno_formulario";
	}
	
	public String salvar(){
		AlunoRN alunoRN = new AlunoRN();
		alunoRN.salvar(this.aluno);
		aluno = new Aluno();
		
		mostrarMenssagem("Aluno cadastrado com sucesso!");
		
		return "";
	}
	
	public String editar(){
		return "/admin/aluno_formulario";
	}
	
	public String excluir() {
		AlunoRN alunoRN = new AlunoRN();
		alunoRN.excluir(this.aluno);

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
	
	public List<Aluno> getLista() {
		if(lista == null){
			AlunoRN alunoRN = new AlunoRN();
			this.lista = alunoRN.listar();
		}
		return lista;
	}
	
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
