package com.eder.tcc.modelo.aluno;

import java.util.List;

public interface AlunoDAO {

	public void salvar(Aluno aluno);
	public void atualizar(Aluno aluno);
	public void excluir(Aluno aluno);
	public List<Aluno> listar();
	public Aluno buscaPorRa(String ra);
	public Boolean buscaRa(String ra);
	
}
