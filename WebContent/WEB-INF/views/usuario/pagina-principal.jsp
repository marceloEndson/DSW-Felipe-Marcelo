<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página Principal</title>
</head>
<body>

<c:import url="../cabecalho.jsp"></c:import>

<jsp:useBean id="dao1" class="campeonatobrasileiro.dao.UsuariosGrupoDAO"/>
<jsp:useBean id="dao2" class="campeonatobrasileiro.dao.GruposDAO"/>

<h2>Página Principal</h2>
<a href="exibirCadastroGrupo">Cadastrar novo grupo</a><br>
<a href="exibirRodadas">Ver tabela do campeonato</a>

<h3>Meus Grupos</h3>

<table>

<c:forEach var="gruposUsuario" items="${dao1.lista}">
   <tr>
   		<c:if test="${gruposUsuario.idUsuario == usuarioLogado.id}">
   				<td>${gruposUsuario.idGrupo}</td>
   				<c:forEach var="grupo1" items="${dao2.lista}">
   					<c:if test="${gruposUsuario.idGrupo == grupo1.id}">
   						  <td>${grupo1.nome}</td> 					
   					</c:if>   					
   				</c:forEach> 
   		</c:if>    
    </tr>
   
</c:forEach>

</table>



<h3>Todos os Grupos</h3>

<table>

<c:forEach var="grupo2" items="${dao2.lista}">
   <tr>
         <td>${grupo2.id}</td>
         <td>${grupo2.nome}</td>
    </tr>
</c:forEach>

</table>


<c:import url="../rodape.jsp"></c:import>

</body>
</html>