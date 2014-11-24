<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Classificação dos times</title>
</head>
<body>

<c:import url="../cabecalho.jsp"></c:import>

<h2>Classificação dos Times</h2>

<table>
	<tr>
		<td>Time</td>
		<td>Pontos</td>
		<td>Jogos</td>
		<td>Gols Pró</td>
		<td>Gols Contra</td>
		<td>Saldo de Gols</td>
	</tr>

</table>

<c:import url="../rodape.jsp"></c:import>

</body>
</html>