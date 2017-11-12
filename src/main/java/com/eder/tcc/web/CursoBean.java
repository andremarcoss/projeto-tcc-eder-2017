package com.eder.tcc.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.eder.tcc.modelo.curso.Curso;
import com.eder.tcc.modelo.curso.CursoRN;

@ManagedBean(name="cursoBean")
@RequestScoped
public class CursoBean {

	private Curso curso = new Curso();
	//private List<Curso> cursos = new ArrayList<Curso>();
	private List<Curso> lista;
	
	public String novo(){
		this.curso = new Curso();
		
		return "/admin/curso_formulario";
	}
	
	public String salvar(){
		
		CursoRN cursoRN = new CursoRN();
		cursoRN.salvar(this.curso);
		//cursos.add(curso);
		this.curso = new Curso();
		mostrarMenssagem("Curso salvo com sucesso!");
		
		return "/restrito/curso_lista";
	}
	
	public String excluir(){
		CursoRN cursoRN = new CursoRN();
		cursoRN.excluir(this.curso);
		this.lista = null;

		return null;
	}
	
	public String editar(){
		return "/admin/curso_formulario";
	}
	
	public String getDataAtual(){
		return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}

	public List<Curso> getLista() {
		if(lista == null){
			CursoRN cursoRN = new CursoRN();
			this.lista = cursoRN.listar();
		}
		return lista;
	}
	
	public void mostrarMenssagem(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(msg);
		context.addMessage(null, facesMessage);
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/*public List<Curso> getCursos() {
		return cursos;
	}
	
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}*/
}
