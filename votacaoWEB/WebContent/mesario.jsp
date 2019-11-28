<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="stylesheet" href="bootstrap-4.3.1-dist/css/bootstrap.css"/> 
        <link rel="stylesheet" href="mesario.css"/> 
        <script src="jscript.js"></script>
        <script>
            function enviar(valor){
            document.comando.acao.value=valor;
            document.comando.submit();}
        </script>
        <script src="jquery-3.4.1.min.js"></script>
        <script src="bootstrap-4.3.1-dist/js/bootstrap.js"></script>
        <title>Eleições 2019</title>
        <style>

        </style>

	</head>

    <body>
		<div class="container" align="center">
            <div class="row" >
                <div class="col-sm-12 col-md-6" >
		            <form name="comando" action="Controlador" method="post">
                    <input type="hidden" name="acao">
                        <table border='6'>
                        <tr><td>Liberar eleitor para votação:</td><td><button type="button" class="btn btn--white mesmo-tamanho" value="libera_eleitor" onclick="enviar('liberar_eleitor')">Liberar Eleitor</button></td></tr>
                        <tr><td>Cabine de votação:</td><td><button type="button" class="btn btn--white mesmo-tamanho" value="liberar_cabine" onclick="enviar('liberar_cabine')">Liberar Cabine </button></td></tr>
                        <tr><td>Cabine de votação:</td><td><button type="button" class="btn btn--white mesmo-tamanho" value="encerrar_cabine" onclick="enviar('encerrar_cabine')">Encerrar Cabine</button></td></tr>
                        <tr><td>Relatorio de votos:</td><td><button type="button" class="btn btn--white mesmo-tamanho" value="rel" onclick="enviar('rel')">Total de Votos</button></td></tr>
                        </table><br>
						</form>
						
						<form id="botao-voltar">
						<input type="button" value="Voltar" onClick="history.go(-1)">
						</form>	
                </div>
            </div>
        </div>
    </body>

</html>