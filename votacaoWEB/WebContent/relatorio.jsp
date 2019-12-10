<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<%@page import="com.web.bean.Candidato" %>
<%@page import="com.web.bean.User" %>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	
	<title>Eleições 2019</title>
	<link rel="stylesheet" href="rel.css" media="screen"/>
    </style>

	<%	User teste = new User();
	Candidato cand1 = new Candidato();
	Candidato cand2 = new Candidato();
	Candidato cand3 = new Candidato();
	Candidato cand4 = new Candidato();
	Candidato cand5 = new Candidato();
	
	cand1 = (Candidato)request.getAttribute("candidato11");
	cand2 = (Candidato)request.getAttribute("candidato22");
	cand3 = (Candidato)request.getAttribute("candidato33");
	cand4 = (Candidato)request.getAttribute("candidato44");
	cand5 = (Candidato)request.getAttribute("candidato55");
	
	cand1.getVotos()
	cand2.getVotos()
	cand3.getVotos()
	cand4.getVotos()
	cand5.getVotos()	
	%>		

	</head>

    <body>
		

		
	<div class="clearfix container">
		<div class="floatedbox">
			<div class="img-container">
				<img src="img/bob.jpg" alt="Bob" style="width:100%">
			</div>
		</div>
			<h3>Bob Esponja</h3>
			<input id="tela" type="text" value="<%=cand1.getVotos()%>" maxlength="2" class="form-control-lg tela-voto" disabled>
	</div>

	<div class="clearfix container">
		<div class="floatedbox">
			<div class="img-container">
				<img src="img/patrick.jpg" alt="Bob" style="width:100%">
			</div>
		</div>
			<h3>Patrick Estrela</h3>
			<input id="tela" type="text" value="<%=cand2.getVotos()%>" maxlength="2" class="form-control-lg tela-voto" disabled>
	</div>
	
	<div class="clearfix container">
		<div class="floatedbox">
			<div class="img-container">
				<img src="img/lula.jpg" alt="Bob" style="width:100%">
			</div>
		</div>
			<h3>Lula Molusco</h3>
			<input id="tela" type="text" value="<%=cand3.getVotos()%>" maxlength="2" class="form-control-lg tela-voto" disabled>
	</div>
	
	<div class="clearfix container">
		<div class="floatedbox">
			<div class="img-container">
				<img src="img/siri.jpg" alt="Bob" style="width:100%">
			</div>
		</div>
			<h3>Sirigueijo</h3>
			<input id="tela" type="text" value="<%=cand4.getVotos()%>" maxlength="2" class="form-control-lg tela-voto" disabled>
	</div>

	<div class="clearfix container">
		<div class="floatedbox">
			<div class="img-container">
				<img src="img/gary.jpg" alt="Bob" style="width:100%">
			</div>
		</div>
			<h3>Gary</h3>
			<input id="tela" type="text" value="<%=cand5.getVotos()%>" maxlength="2" class="form-control-lg tela-voto" disabled>
	</div><br>
	
	<form id="botao-voltar">
		<input type="button" value="Voltar" onClick="history.go(-1)">
	</form>	
	
    </body>

</html>