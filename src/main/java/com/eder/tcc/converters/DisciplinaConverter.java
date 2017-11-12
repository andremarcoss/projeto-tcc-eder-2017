package com.eder.tcc.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.eder.tcc.modelo.disciplina.Disciplina;
import com.eder.tcc.util.HibernateUtil;

@FacesConverter(forClass = Disciplina.class)
public class DisciplinaConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String codigo) {
		if (codigo != null && !codigo.isEmpty()) {
			return (Disciplina) HibernateUtil.getSessionFactory().getCurrentSession().get(Disciplina.class,
					new Integer(codigo));
		}

		return codigo;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object objeto) {
		if (objeto != null) {
			Disciplina t = (Disciplina) objeto;
			return t.getCodigo() != null && t.getCodigo() > 0 ? t.getCodigo().toString() : null;
		}

		return null;
	}

}
