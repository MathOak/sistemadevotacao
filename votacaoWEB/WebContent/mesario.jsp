<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
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
		            
                        <table border='6'>
                        <tr><td>Liberar eleitor para votação:</td><td><button type="button" class="btn btn--white mesmo-tamanho" data-toggle="modal" data-target="#ExemploModalCentralizado1">Liberar Eleitor</button></td></tr>
                        <tr><td>Cabine de votação:</td><td><button type="button" class="btn btn--white mesmo-tamanho" data-toggle="modal" data-target="#ExemploModalCentralizado2">Liberar Cabine </button></td></tr>
                        <tr><td>Cabine de votação:</td><td><button type="button" class="btn btn--white mesmo-tamanho" data-toggle="modal" data-target="#ExemploModalCentralizado3">Encerrar Cabine</button></td></tr>
                        <tr><td>Relatorio de votos:</td><td><button type="button" class="btn btn--white mesmo-tamanho"  data-toggle="modal" data-target="#ExemploModalCentralizado4">Total de Votos</button></td></tr>
                        </table><br>
						
						
						<form id="botao-voltar">
						<input type="button" value="Voltar" onClick="history.go(-1)">
						</form>	
                </div>
            </div>
        </div>
		
		<!-- Modal liberar eleitor -->
		<div class="modal fade" id="ExemploModalCentralizado1" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="TituloModalCentralizado">Liberar Eleitor</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
				  <span aria-hidden="true">&times;</span>
				</button>
			  </div>
			  <div class="modal-body">
				Liberar Eleitor para Votação: <input type='text' name='libera_eleitor' placeholder="Titulo">
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
				<form name="formulario" action="Controlador" method="post">
				<input type="hidden" name="acao">
				<button type="button" class="btn btn-primary" onclick="enviar('liberar_eleitor')">Confirmar</button>
				</form>
			  </div>
			</div>
		  </div>
		</div>
		
				
		<!-- Modal liberar cabine -->
		<div class="modal fade" id="ExemploModalCentralizado2" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
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
				<form name="formulario" action="Controlador" method="post">
				<input type="hidden" name="acao">
				<button type="button" class="btn btn-primary" onclick="enviar('liberar_cabine')">Confirmar</button>
				</form>
			  </div>
			</div>
		  </div>
		</div>
		
				
		<!-- Modal encerrar cabine -->
		<div class="modal fade" id="ExemploModalCentralizado3" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
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
				<form name="formulario" action="Controlador" method="post">
				<input type="hidden" name="acao">
				<button type="button" class="btn btn-primary" onclick="enviar('encerrar_cabine')">Confirmar</button>
				</form>
			  </div>
			</div>
		  </div>
		</div>
		
				
		<!-- Modal relatorio de votos-->
		<div class="modal fade" id="ExemploModalCentralizado4" tabindex="-1" role="dialog" aria-labelledby="TituloModalCentralizado" aria-hidden="true">
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
				<form name="formulario" action="Controlador" method="post">
				<input type="hidden" name="acao">
				<button type="button" class="btn btn-primary" onclick="enviar('rel')">Confirmar</button>
				</form>
			  </div>
			</div>
		  </div>
		</div>
		
				
    </body>

</html>