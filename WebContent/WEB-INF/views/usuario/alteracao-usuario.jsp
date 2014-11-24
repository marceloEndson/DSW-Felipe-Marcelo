<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alteração de Dados do Usuário</title>
</head>
<body>

<c:import url="../cabecalho.jsp"></c:import>

<h2>Alteração de Dados do Usuário</h2>
<p>Use o formulário abaixo para alterar os campos desejados.</p>
<p>Os campos nome, e-mail e cidade não podem ficar em branco.</p>
<form action="alterarUsuario" method="post">
	Nome: <input type="text" name="nome"><br>
	E-mail: <input type="text" name="email"><br>
	Cidade: <input type="text" name="cidade"><br>
	<br><input type="submit" value="Alterar">
</form>

<c:import url="../rodape.jsp"></c:import>

</body>
</html>