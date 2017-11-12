package com.eder.tcc.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.eder.tcc.modelo.curso.Curso;
import com.eder.tcc.util.HibernateUtil;

@FacesConverter(forClass = Curso.class)
public class CursoConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigo) {
		if (codigo != null && !codigo.isEmpty()) {
			return (Curso) HibernateUtil.getSessionFactory().getCurrentSession().get(Curso.class, new Integer(codigo));
		}

		return codigo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		if (objeto != null) {
			Curso c = (Curso) objeto;
			return c.getCodigo() != null && c.getCodigo() > 0 ? c.getCodigo().toString() : null;
		}

		return null;
	}

}
