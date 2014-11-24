<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Palpites e Jogos</title>
</head>
<body>

<c:import url="../cabecalho.jsp"></c:import>

<h2>Rodada X</h2>
<p><a href="#">Anterior</a> | <a href="#">Próxima</a></p>

<table>
	<tr>
		<td>Data</td>
		<td>Hora</td>
		<td>Estádio</td>
		<td>Equipe da Casa</td>
		<td>Equipe Visitante</td>
		<td>Gols EC</td>
		<td>Gols EV</td>
		<td>Palpite EC</td>
		<td>Palpite EV</td>
		<td>Pontos Ganhos</td>
	</tr>

</table>

<c:import url="../rodape.jsp"></c:import>

</body>
</html>