<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Falha no Cadastramento</title>
</head>
<body>

<c:import url="../cabecalho.jsp"></c:import>

<h2>Falha no Cadastramento</h2>

<p>Não foi possível realizar o cadastramento.</p>

<p>Clique no link abaixo para tentar novamente e observe que o preenchimento
de todos os campos é obrigatório.</p>

<a href="exibirCadastroUsuario">Cadastro</a>

<c:import url="../rodape.jsp"></c:import>

</body>
</html>