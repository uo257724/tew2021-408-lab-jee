package com.tew.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundoServlet
 */
@WebServlet(name = "HolaMundo", urlPatterns = { "/HolaMundoCordial" })
public class HolaMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet (HttpServletRequest request, HttpServletResponse response)
    		 throws IOException, ServletException {
    	
    	String nombre = (String) request.getParameter("NombreUsuario");
    	Vector listado = (Vector) request.getSession().getAttribute("listado");
    	
    	if( listado == null) {
    		listado = new Vector(); //Se instancia para evitar errores
    	}
    	
    	request.getSession().setAttribute("listado", listado);
    	
    		 response.setCharacterEncoding("UTF-8");
    		 response.setContentType("text/html");
    		 PrintWriter out = response.getWriter();
    		 out.println("<HTML>");
    		 out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
    		 out.println("<BODY>");
    		 
    		 if(nombre != null) {
    			 listado.addElement(nombre);
    			 out.println("<br>Hola "+nombre+"<br>");
    		 }
    		 
    		 out.println("Bienvenido a mi primera página web!");
    		 
    		 out.println("<br>");
    		 out.println("Contigo, hoy me han visitado:<br>");
    		 for ( int i = 0 ; i < listado.size() ; i++ ){
    			 out.println("<br>"+(String)listado.elementAt(i));
    		 }
    		 out.println("<a href=\"index.html\">volver</a>");
    		 
    		 out.println("</BODY></HTML>");
    		 
    		 
    	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    		 throws IOException, ServletException {
    		 doGet(request,response );
    		}

}
