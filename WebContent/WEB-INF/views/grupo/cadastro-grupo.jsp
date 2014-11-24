<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Grupo</title>
</head>
<body>

<c:import url="../cabecalho.jsp"></c:import>

<h2>Cadastro de Grupo</h2>
<p>Informe o nome do grupo que deseja cadastrar.</p>
<form action="cadastrarGrupo" method="post">
	Nome: <input type="text" name="nome"><br>
	<br><input type="submit" value="Cadastrar">
	<input type="hidden" name="idDono" value="${usuarioLogado.id}">
</form>

<c:import url="../rodape.jsp"></c:import>

</body>
</html>