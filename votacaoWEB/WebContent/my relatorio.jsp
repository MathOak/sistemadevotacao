<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <title>Prefeitura de Naboo</title>
    <link href="relatorio1.css" rel="stylesheet" type="text/css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1, minimum-scale=1, user-scalable=no" />
    <script type="text/javascript">
			function enviar(valor){
				document.formulario.acao.value=valor;
				document.formulario.submit();
			}
	</script>
  </head>
  <body>
    <div class="body-container">
    <div class="header">
    
    </div>
    <div class="main-heading">
      <h3>Mylena Costa</h3>
    </div>
      <div class="arrow-down"></div>

    <div class="main-score">
      <p class="score-number">31.368</p>
      <p class="score-title">Votos Válidos</p>
    </div>

    <div class="sub-heading"></div>

    <div class="chart">
    <table style="width:100%">
     <tr>
        <td class="name">
            <h3 class="tiny-header">Cidade</h3>
        </td>
        <td class="value">Naboo</td>
      </tr>
      <tr>
        <td class="name">Votação</td>
        <td class="value">
          Em Andamento<br />
          </td>
        
      </tr>
       <tr>
        <td class="name">Partido</td>
        <td class="value">Partido das Baixinhas (PB)</td>
      </tr>
    </table>
    </div>

    <div class="button-container">
    	<form name='formulario' action='Controller' method='post'>
			<input type='hidden' name='acao'>                             
			<button type="button" class="button" value='back' onclick='enviar(3)'>Voltar</button>
        </form>
    </div>

    <div class="footer">
      <h3></h3>
      <h5></h5>
    </div>

      </div>
  </body>
</html>