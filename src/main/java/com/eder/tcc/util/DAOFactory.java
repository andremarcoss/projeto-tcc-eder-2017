package com.eder.tcc.util;

import com.eder.tcc.modelo.aluno.AlunoDAO;
import com.eder.tcc.modelo.aluno.AlunoDAOHibernate;
import com.eder.tcc.modelo.curso.CursoDAO;
import com.eder.tcc.modelo.curso.CursoDAOHibernate;
import com.eder.tcc.modelo.disciplina.DisciplinaDAO;
import com.eder.tcc.modelo.disciplina.DisciplinaDAOHibernate;
import com.eder.tcc.modelo.nota.NotaDAO;
import com.eder.tcc.modelo.nota.NotaDAOHibernate;
import com.eder.tcc.modelo.professor.ProfessorDAO;
import com.eder.tcc.modelo.professor.ProfessorDAOHibernate;
import com.eder.tcc.modelo.turma.TurmaDAO;
import com.eder.tcc.modelo.turma.TurmaDAOHibernate;
import com.eder.tcc.modelo.usuario.UsuarioDAO;
import com.eder.tcc.modelo.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public DAOFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static UsuarioDAO criarUsuarioDAO(){
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return usuarioDAO;
	}

	public static AlunoDAO criarAlunoDAO() {
		AlunoDAOHibernate alunoDAO = new AlunoDAOHibernate();
		alunoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return alunoDAO;
	}
	
	public static ProfessorDAO criarProfessorDAO() {
		ProfessorDAOHibernate professorDAO = new ProfessorDAOHibernate();
		professorDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return professorDAO;
	}
	
	public static CursoDAO criarCursoDAO(){
		CursoDAOHibernate cursoDAO = new CursoDAOHibernate();
		cursoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return cursoDAO;
	}

	public static TurmaDAO criarTurmaDAO() {
		TurmaDAOHibernate turmaDAO = new TurmaDAOHibernate();
		turmaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return turmaDAO;
	}
	
	public static DisciplinaDAO criarDisciplinaDAO() {
		DisciplinaDAOHibernate disciplinaDAO = new DisciplinaDAOHibernate();
		disciplinaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return disciplinaDAO;
	}
	
	public static NotaDAO criarNotaDAO() {
		NotaDAOHibernate notaDAO = new NotaDAOHibernate();
		notaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return notaDAO;
	}
}
