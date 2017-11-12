package com.eder.tcc.modelo.disciplina;

import java.util.List;

public interface DisciplinaDAO {

	public void salvar(Disciplina disciplina);
	public void atualizar(Disciplina disciplina);
	public List<Disciplina> listar();
	public void excluir(Disciplina disciplina);
}
