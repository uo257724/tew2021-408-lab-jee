<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	//Logica de la calculadora

	//Parametros: 1. numero1 2. numero2 3. operador
	//El operador puede ser SUMA RESTA PRODUCTO o DIVISION

	Integer n1, n2;String num1,num2;
	String operador = "";
	Integer resultado = 0;

	num1 = request.getParameter("num1");
	num2 = request.getParameter("num2");
	operador = request.getParameter("operador");

	//Si parametro es nulo, lo pasamos como 0, sino, su valor
	if (num1 == null)
		n1 = new Integer(0);
	else
		n1 = Integer.parseInt(num1);
	
	
	if (num2 == null)
		n2 = new Integer(0);
	else
		n2 = Integer.parseInt(num2);
	
	System.out.println("OPERADOR -> "+operador);
	if (operador == null) operador = "";
	

	if (operador.equals("SUMA"))
		resultado = n1 + n2;
	else if (operador.equals("RESTA"))
		resultado = n1 - n2;
	else if (operador.equals("PRODUCTO"))
		resultado = n1 * n2;
	else if (operador.equals("DIVISION"))
		resultado = n1 / n2;
	else
		resultado = 0;
	
	System.out.println("EL RESULTADO ES "+resultado);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculadora</title>
</head>
<body>

	<form action="calculadora.jsp">
		<p>OPERADOR</p>
		<select name="operador" size="1">
			<option value="SUMA">Suma +</option>
			<option value="RESTA">Resta -</option>
			<option value="PRODUCTO">Multiplicacion *</option>
			<option value="DIVISION">Division /</option>
		</select>

		<p>Primer numero:</p>
		<INPUT TYPE="NUMBER" NAME="num1" SIZE="15">
		<p>Segundo numero:</p>
		<INPUT TYPE="NUMBER" NAME="num2" SIZE="15"> <input
			type="submit" value=" RESULTADO ">
	</form>
	<hr>

	<p style="color: rgb(0, 204, 0)">
		Resultado:
		<%=resultado%></p>
</body>
</html>