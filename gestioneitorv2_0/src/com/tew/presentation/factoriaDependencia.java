package com.tew.presentation;

import javax.faces.context.FacesContext;

import com.tew.model.Alumno;

public class factoriaDependencia {
	
	public Alumno factoria(Alumno alumno) {
		
		if (alumno == null) {
			System.out.println("BeanAlumnos - No existia");
			alumno = new BeanAlumno();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put( "alumno",
					alumno);
		}
		
		return alumno;
	}

}
