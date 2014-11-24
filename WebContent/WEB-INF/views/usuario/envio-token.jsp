<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Envio de Token</title>
</head>
<body>

<c:import url="../cabecalho.jsp"></c:import>

<h2>Envio de Token</h2>
<p>Preencha o campo abaixo com o seu e-mail para receber um token para a alteração
da sua senha.</p>
<p>O e-mail informado deve ser o mesmo cadastrado no sistema.</p>
<form action="enviarToken" method="post">
	E-mail: <input type="text" name="email"><br>
	<br><input type="submit" value="Enviar">
</form>

<c:import url="../rodape.jsp"></c:import>

</body>
</html>