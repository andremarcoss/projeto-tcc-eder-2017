package com.eder.tcc.modelo.curso;

import java.util.List;

import com.eder.tcc.util.DAOFactory;


public class CursoRN {

	private CursoDAO cursoDAO;
	
	public CursoRN() {
		this.cursoDAO = DAOFactory.criarCursoDAO();
	}
	
	public void salvar(Curso curso){
		Integer id = curso.getCodigo();
		if(id == null || id  == 0){
			this.cursoDAO.salvar(curso);
		} else {
			this.cursoDAO.atualizar(curso);
		}
	}
	
	public List<Curso> listar(){
		return this.cursoDAO.listar();
	}

	public void excluir(Curso curso) {
		this.cursoDAO.excluir(curso);		
	}
}
