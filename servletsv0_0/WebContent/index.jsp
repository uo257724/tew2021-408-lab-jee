<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Hola Mundo!!</title>
</head>
<body>
<h1>¡¡Bienvenido a mi primera página web!!</h1>
<br>
<%
 Integer contador = (Integer)application.getAttribute("contador");
 if ( contador == null ){
 contador = new Integer(0);
 }
 application.setAttribute("contador",new Integer(contador.intValue()+1));
%>
<%=contador%> visitas
</body>
</html>