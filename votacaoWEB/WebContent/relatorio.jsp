<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	
	<title>Eleições 2019</title>
	<link rel="stylesheet" href="rel.css" media="screen"/>
    </style>

	</head>

    <body>
		

		
	<div class="clearfix container">
		<div class="floatedbox">
			<div class="img-container">
				<img src="img/bob.jpg" alt="Bob" style="width:100%">
			</div>
		</div>
			<h3>Bob Esponja</h3>
			<input id="tela" type="text" maxlength="2" class="form-control-lg tela-voto" readonly>
	</div>

	<div class="clearfix container">
		<div class="floatedbox">
			<div class="img-container">
				<img src="img/patrick.jpg" alt="Bob" style="width:100%">
			</div>
		</div>
			<h3>Patrick Estrela</h3>
			<input id="tela" type="text" maxlength="2" class="form-control-lg tela-voto" readonly>
	</div>
	
	<div class="clearfix container">
		<div class="floatedbox">
			<div class="img-container">
				<img src="img/lula.jpg" alt="Bob" style="width:100%">
			</div>
		</div>
			<h3>Lula Molusco</h3>
			<input id="tela" type="text" maxlength="2" class="form-control-lg tela-voto" readonly>
	</div>
	
	<div class="clearfix container">
		<div class="floatedbox">
			<div class="img-container">
				<img src="img/siri.jpg" alt="Bob" style="width:100%">
			</div>
		</div>
			<h3>Sirigueijo</h3>
			<input id="tela" type="text" maxlength="2" class="form-control-lg tela-voto" readonly>
	</div>

	<div class="clearfix container">
		<div class="floatedbox">
			<div class="img-container">
				<img src="img/gary.jpg" alt="Bob" style="width:100%">
			</div>
		</div>
			<h3>Gary</h3>
			<input id="tela" type="text" maxlength="2" class="form-control-lg tela-voto" readonly>
	</div><br>
	
	<form id="botao-voltar">
		<input type="button" value="Voltar" onClick="history.go(-1)">
	</form>	
	
    </body>

</html>