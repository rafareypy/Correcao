<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.softgraf.model.bean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta Unidade</title>
<link rel="stylesheet" type="text/css" href="principal.css">
</head>
<body>
<div id="container">
	<h1>Consulta Unidade</h1>
	<h3>${mensagem }</h3>
	<div id="leftSide">
		<table>
			<thead>
				<tr>
					<td>Descri��o</td>
					<td colspan="2">Op��es</td>
				</tr>
			</thead>
			<c:forEach var="unidade" items="${unidades}">
				<tr>
						<td>${unidade.descricao}</td>
						<td><a href="SoftgrafController?cmd=atualizarUnidade&codigo=${unidade.codigo}">Atualizar</a></td>
						<td><a href="SoftgrafController?cmd=excluirUnidade&codigo=${unidade.codigo}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="rightSide">
		<c:import url="menu.jsp"></c:import>
	</div>
</div>
</body>
</html>