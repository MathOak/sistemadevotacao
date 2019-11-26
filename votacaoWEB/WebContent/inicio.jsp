<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">

  <head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta charset="utf-8">

    <title>Eleições 2019</title>

    <link rel="stylesheet" href="inicio_css.css">
	<script src="JQuery-3.4.1.min.js"></script>
    <script src="jscript.js"></script>

  </head>

  <body>

    <div class="container">

      <div class="box">

        <div class="imgBx">

          <img src="img/img2.jpg">

        </div>

        <div class="content">

          <h3>Login</h3><br><br>

			Entrar como:  <select id="select" name="select">
							<option value="" selected>Selecione</option>
							<option value="div1">Eleitor</option>
							<option value="div2">Mesário</option>
							</select><br><br> 
		
		
		<div id="pai">
			<div id="div1">
			<form name="formulario" action="Controller" method="post">
			<input type="hidden" name="acao" value="inicio_eleitor">
              <table><tr><td> Titulo: <input type="text" name="titulo" title="Insira corretamente o Titulo de Eleitor" required pattern="^\d{12}$">
								<button type="submit">Entrar</button></td></tr>
				</table>
			</form>
			</div>
			   
			<div id="div2">	  
			<form name="formulario" action="Controller" method="post">
			<input type="hidden" name="acao" value="inicio_mesario">
			  <table>
				<tr><td>Titulo:</td><td colspan='2'><input type="text" name="titulo" title="Insira corretamente o Titulo de Eleitor" required pattern="^\d{12}$"></td><td></td></tr>			
				<tr><td>Senha:</td><td colspan="2"><input type="password" name="senha" title="" required pattern="^\d{4}$"></td><td></td></tr>
				<tr><td colspan='3' align="right"><button type="submit">Entrar</button></td></tr>
				</table>
			</form>
			</div>
		</div>
        </div>

      </div>

    </div>

  </body>

</html>
