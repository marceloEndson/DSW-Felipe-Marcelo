<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuário</title>
</head>
<body>

<c:import url="../cabecalho.jsp"></c:import>

<h2>Cadastro de Usuário</h2>
<p>Preencha os campos abaixo para se cadastrar no Bolão do Campeonato Brasileiro.</p>
<p>Todos os campos são de preenchimento obrigatório.</p>
<form action="cadastrarUsuario" method="post">
	Login: <input type="text" name="login"><br>
	Nome: <input type="text" name="nome"><br>
	E-mail: <input type="text" name="email"><br>
	Cidade: <input type="text" name="cidade"><br>
	Senha: <input type="password" name="senha"><br>
	Confirmar senha: <input type="password" name="confirmarSenha"><br>
	<br><input type="submit" value="Cadastrar">
</form>

<c:import url="../rodape.jsp"></c:import>

</body>
</html>