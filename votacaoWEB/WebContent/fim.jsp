<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="bootstrap-4.3.1-dist/css/bootstrap.css"/> 
        <link rel="stylesheet" href="fim.css"/> 
		<script type="text/javascript" src="HTTP://AJAX.GOOGLEapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="jscript.js"></script>
        <script src="bootstrap-4.3.1-dist/js/bootstrap.js"></script>
        <title>Eleições 2019</title>
        <style>

        </style>
			<script>
			function Temporizador(){
				location.reload();
			}
			
			function ChamarTemp(){
				console.log("Passou");
				setTimeout(function(){
				window.location.href = "file:///C:/Users/PC/Documents/GitHub/sistemadevotacao/votacaoWEB/WebContent/inicio.html";
				//location.reload();
				}, 5000);
			}
			
			
			</script>
	</head>

    <body onload="ChamarTemp()">
		
		<img src="img/fim.jpg" alt="some text" width=300 height=200 onclick="ChamarTemp();">
	
    </body>

</html>