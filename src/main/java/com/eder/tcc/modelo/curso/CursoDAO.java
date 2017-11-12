package com.eder.tcc.modelo.curso;

import java.util.List;

public interface CursoDAO {

	public void salvar(Curso curso);
	public void atualizar(Curso curso);
	public List<Curso> listar();
	public void excluir(Curso curso);
}
