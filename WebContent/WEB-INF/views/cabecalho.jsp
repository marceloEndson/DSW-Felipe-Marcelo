<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h1>Bol�o do Campeonato Brasileiro</h1>
<div>
<ul>
<li>Usu�rio: ${usuarioLogado.login}</li>
<li>Ultimo login: <fmt:formatDate value="${usuarioLogado.ultimoLogin.time}" pattern="dd/MM/yyyy hh:mm:ss"/></li>
<li><a href="exibirEnvioToken">Trocar senha</a></li>
<li><a href="deslogarUsuario">Sair</a></li>
</ul>
</div>
<hr>