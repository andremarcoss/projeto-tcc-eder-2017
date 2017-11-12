package com.eder.tcc.modelo.nota;

import java.util.List;

public interface NotaDAO {

	public void salvar(Nota nota);
	public void atualizar(Nota nota);
	public List<Nota> listar();
	public void excluir(Nota nota);
	public List<Nota> listarNotaAluno();
}
