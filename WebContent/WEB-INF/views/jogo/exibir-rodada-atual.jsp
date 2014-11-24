<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jogos</title>
</head>
<body>
<c:import url="../cabecalho.jsp"></c:import>

<jsp:useBean id="dao1" class="campeonatobrasileiro.dao.JogosDAO"/>
<jsp:useBean id="dao2" class="campeonatobrasileiro.dao.TimesDAO"/>

<h2>Tabela do Campeonato Brasileiro</h2><br>
<ul>
<c:if test="${rodadaAtual > 1}">
	<li><a href="rodadaAnterior">Ver rodada anterior</a></li>
</c:if>
<c:if test="${rodadaAtual < 38}">
	<li><a href="proximaRodada">Ver próxima rodada</a></li>
</c:if>
</ul>

<h3>${rodadaAtual}ª Rodada</h3>
<table>
<tr>
	<td>Equipe Mandante</td>
	<td>Equipe Visitante</td>
	<td>Estádio</td>
	<td>Data</td>
</tr>
<c:forEach var="jogo" items="${dao1.lista}">
   	<c:if test="${jogo.rodada == rodadaAtual}">
   		<tr>
   		<c:forEach var="equipe" items="${dao2.lista}">
   			<c:if test="${jogo.idMandante == equipe.id}">
		   			<td>${equipe.nome}</td>
		   	</c:if>
		 </c:forEach>
		 <c:forEach var="equipe2" items="${dao2.lista}">
		   	<c:if test="${jogo.idVisitante == equipe2.id}">
		   			<td>${equipe2.nome}</td>
		   	</c:if>
		 </c:forEach>
		 <td>${jogo.estadio}</td>
		 <td><fmt:formatDate value="${jogo.dataHora}" pattern="dd/MM/yyyy"/></td>
	   	</tr>
   	</c:if>
</c:forEach>
</table>

<c:import url="../rodape.jsp"></c:import>
</body>
</html>