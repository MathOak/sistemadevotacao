
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>



<!DOCTYPE html>
    <head>
    <!--  jquery-3.4.1.min.js-->
    	<script type="text/javascript" src="HTTP://AJAX.GOOGLEapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    	<script src="bootstrap-4.3.1-dist/js/bootstrap.js"></script>
    	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta charset="utf-8">
        
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge">-->
        <link rel="stylesheet" href="bootstrap-4.3.1-dist/css/bootstrap.css"/> 
        <link rel="stylesheet" href="mesario.css"/> 
        
        <script>
            function enviar(valor){
            document.comando.acao.value=valor;
            document.comando.submit();}
            
            var erro = '<%= request.getAttribute("erro") %>';
        	window.onload = function alertaInicio(){
        		if (erro == "3"){
        	
        			alert("Eleitor não autenticado! Erro: "+erro);
        		}
        	}
        </script>
        
        
        <title>Eleições 2019</title>
        <style>

        </style>

	</head>

    <body>
		<div class="container" align="center">
            <div class="row" >
                <div class="col-sm-12 col-md-6" >
		            
                        <table border='6'>
                        <tr><td>Liberar eleitor para votação:</td><td><button type="button" class="btn btn--white mesmo-tamanho" id="ExemploModalCentralizado1">Liberar Eleitor</button></td></tr>
                        <tr><td>Cabine de votação:</td><td><button type="button" class="btn btn--white mesmo-tamanho" id="ExemploModalCentralizado2">Liberar Cabine </button></td></tr>
                        <tr><td>Cabine de votação:</td><td><button type="button" class="btn btn--white mesmo-tamanho" id="ExemploModalCentralizado3">Encerrar Cabine</button></td></tr>
                        <tr><td>Relatorio de votos:</td><td><button type="button" class="btn btn--white mesmo-tamanho"  id="ExemploModalCentralizado4">Total de Votos</button></td></tr>
                        </table><br>
						
						
						<form id="botao-voltar">
						<input type="button" value="Voltar" onClick="window.location.href = 'http://localhost:8080/votacaoWEB/inicio.jsp';">
						</form>	
                </div>
            </div>
        </div>
		
		<!-- Modal liberar eleitor -->
		<div class="modal fade" id="ExemploModalCentralizado11" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="TituloModalCentralizado">Liberar Eleitor</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
				  <span aria-hidden="true">&times;</span>
				</button>
			  </div>
			  <form name="comando" action="Controlador" method="post">
			  <div class="modal-body">
				Liberar Eleitor para Votação: <input type='text' name='titulo' placeholder="Titulo">
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				
				<input type="hidden" name="acao">
				<button type="button" class="btn btn-primary" onclick="enviar('liberar_eleitor'); alertaInicio();">Confirmar</button>
				</form>
			  </div>
			</div>
		  </div>
		</div>
		
				
		<!-- Modal liberar cabine -->
		<div class="modal fade" id="ExemploModalCentralizado22" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="TituloModalCentralizado">Cabine de Votação</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
				  <span aria-hidden="true">&times;</span>
				</button>
			  </div>
			  <div class="modal-body">
				Deseja liberar a cabine de votação?
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<form name="comando2" action="Controlador" method="post">
				<input type="hidden" name="acao">
				<button type="button" class="btn btn-primary" onclick="enviar('liberar_cabine')">Confirmar</button>
				</form>
			  </div>
			</div>
		  </div>
		</div>
		
				
		<!-- Modal encerrar cabine -->
		<div class="modal fade" id="ExemploModalCentralizado33" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="TituloModalCentralizado">Cabine de Votação</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
				  <span aria-hidden="true">&times;</span>
				</button>
			  </div>
			  <div class="modal-body">
				Deseja encerrar a cabine de votação?
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<form name="comando3" action="Controlador" method="post">
				<input type="hidden" name="acao">
				<button type="button" class="btn btn-primary" onclick="enviar('encerrar_cabine')">Confirmar</button>
				</form>
			  </div>
			</div>
		  </div>
		</div>
		
				
		<!-- Modal relatorio de votos-->
		<div class="modal fade" id="ExemploModalCentralizado44" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="TituloModalCentralizado">Relatório de votos</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
				  <span aria-hidden="true">&times;</span>
				</button>
			  </div>
			  <div class="modal-body">
				Deseja gerar relatório de votos?
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<form name="comando4" action="Controlador" method="post">
				<input type="hidden" name="acao">
				<button type="button" class="btn btn-primary" onclick="enviar('rel')">Confirmar</button>
				</form>
			  </div>
			</div>
		  </div>
		</div>
		
	<script src="jscript.js"></script>			
    </body>

</html>