<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Unidade</title>
<link rel="stylesheet"  type="text/css" href="principal.css"  />
</head>
<body>

<div id="container" >
<div id="top" >
<h1>Cadastro de Unidade:</h1>
<h3>${mensagem}</h3>
</div>
<div id="leftSide" >
<fieldset>
<legend>Unidade</legend>
<form action="SoftgrafController" method="post" class="form" >	
<input type="hidden" name="cmd" value="cadastrarUnidade"></input>
<label for="nome">Codigo*</label>
<div class="div_texbox">
<input type="text" name="codigo" id="codigo" value="${unidade.codigo}"/>
</div>
<label for="descricao">Descrição</label>
<div class="div_texbox">
<input type="text" name="descricao" id="descricao" value="${unidade.descricao}"/>
</div>
<div class="button_div">
<input name="cadastrar" type="submit" value="Cadastrar" class="buttons"/>
</div>	
</form>
</fieldset>	
</div>
<div id="rightSide" >
<c:import url="menu.jsp">
</c:import>
</div>
</div>

</body>
</html>