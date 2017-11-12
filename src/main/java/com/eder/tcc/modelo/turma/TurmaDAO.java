package com.eder.tcc.modelo.turma;

import java.util.List;

public interface TurmaDAO {

	public void salvar(Turma turma);
	public void atualizar(Turma turma);
	public void excluir(Turma turma);
	public List<Turma> listar();
	public Turma buscaPorDescricao(String descricao);
	public Boolean buscaDescricao(String descricao);
	
}
