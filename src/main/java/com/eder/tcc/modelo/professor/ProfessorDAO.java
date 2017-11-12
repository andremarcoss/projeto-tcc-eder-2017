package com.eder.tcc.modelo.professor;

import java.util.List;

public interface ProfessorDAO {

	public void salvar(Professor aluno);
	public void atualizar(Professor aluno);
	public void excluir(Professor aluno);
	public List<Professor> listar();
	
}
