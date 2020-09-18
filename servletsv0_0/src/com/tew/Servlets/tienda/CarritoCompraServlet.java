package com.tew.Servlets.tienda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarritoCompraServlet
 */
@WebServlet("/CarritoCompraServlet")
public class CarritoCompraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoCompraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		HashMap<String, Integer> carrito = (HashMap<String, Integer>) request.getSession().getAttribute("carrito");
		if (carrito == null) {
			carrito = new HashMap<String, Integer>();
		}

		//Añadimos el producto recibido al carrito de la compra (en caso de que no sea nulo!)
		String producto = request.getParameter("productos");
		if (producto != null) {
			Integer cantidad = (Integer) carrito.get(producto);
			if (cantidad == null)
				cantidad = new Integer(1);
			else
				cantidad = new Integer(cantidad.intValue() + 1);
			//Y añadimos el producto al carrito
			carrito.put(producto, cantidad);
		}

		
		
//		PrintWriter out = response.getWriter();
//		
//		out.println("<HTML>");
//		 out.println("<HEAD><TITLE>Hola Mundo!</TITLE></HEAD>");
//		 out.println("<BODY>");
//		 
//		 out.println("<FORM>");
//		 
//		 out.println("<SELECT NAME=\"productos\" SIZE=\"1\">");
//		 
//			 out.println("<OPTION VALUE=\"010\">La trampa</OPTION>");
//			 out.println("<OPTION VALUE=\"345\">Los pajaros</OPTION>");
//			 out.println("<OPTION VALUE=\"554\">Matrix reloades</OPTION>");
//			 out.println("<OPTION VALUE=\"004\">Peli4</OPTION>");
//			 out.println("<OPTION VALUE=\"005\">Peli 5</OPTION>");
//			 out.println("<OPTION VALUE=\"006\">Peli 6</OPTION>");
//			 out.println("<OPTION VALUE=\"007\">Peli 7</OPTION>");
//			 out.println("<OPTION VALUE=\"008\">Peli 8</OPTION>");
//			 out.println("<OPTION VALUE=\"009\">Peli 9</OPTION>");
//			 out.println("<OPTION VALUE=\"011\">Peli 11</OPTION>");
//		 
//		 out.println("</SELECT>");
//		 out.println("<input type=\"submit\" value=\"Submit\">");
//		 out.println("</FORM>");
//		 
//		 for(Entry<String, Integer> entry : carrito.entrySet()) {
//			 
//			 String key = entry.getKey();
//			 Integer value = entry.getValue();
//			 out.println("<p>"+key+": "+value+"</p>");
//			 
//		 }
//		 
//		 out.println("</BODY>");
//		 out.println("</HTML>");	
		 
		//Añadimos el carrito a la sesión
		request.getSession().setAttribute("carrito", carrito);
		
		 RequestDispatcher dispatcher =
				 getServletContext().getNamedDispatcher("CarritoCompraVista");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
