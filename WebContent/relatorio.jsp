<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <script src="https://kit.fontawesome.com/bdd89edb33.js"></script>
    <link
      href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="relatorio.css" />
    <title>Prefeitura de Naboo</title>
    <script type="text/javascript">
			function enviar(valor){
				document.formulario.acao.value=valor;
				document.formulario.submit();
				document.frm.acao.value=valor;
				document.frm.submit();
				document.f.acao.value=valor;
				document.f.submit();
			}
	</script>
  </head>
  <body>
                        
    <section class="section-plans" id="section-plans">
      <div class="u-center-text u-margin-bottom-big">
        <h2 class="heading-secondary">
          FICHA DOS CANDITADOS
        </h2>
      </div>

      <div class="row">
        <div class="col-1-of-3">
          <div class="card">
            <div class="card__side card__side--front-1">
              <div class="card__title card__title--1">
              <img style ="width:50%" src="img/jonathan.jpg">
                <h4 class="card__heading">Jonathan</h4>
              </div>

              <div class="card__details">
                <ul>
                  <li>2x Ministro da Fazenda</li>
                  <li>7x Deputado Federal</li>
                  <li>1x Prefeito</li>
                </ul>
              </div>
            </div>
            <div class="card__side card__side--back card__side--back-1">
              <div class="card__cta">
                <div class="card__price-box">
                </div>  
                <form name='formulario' action='Controller' method='post'>
					<input type='hidden' name='acao'>                             
					<button type="button" class="btn btn--white" value='jonh' onclick='enviar(4)'>Gerar relatorio</button>
        		</form>

              </div>
            </div>
          </div>
        </div>

        <div class="col-1-of-3">
          <div class="card">
            <div class="card__side card__side--front-2">
              <div class="card__title card__title--2">
                <img style ="width:50%" src="img/mylena.jpg">
                <h4 class="card__heading">Mylena</h4>
              </div>

              <div class="card__details">
                <ul>
                  <li>3x Ministra do meio ambiente</li>
                  <li>5x Deputada Federal</li>
                  <li>2x Prefeita</li>
                </ul>
              </div>
            </div>
            <div class="card__side card__side--back card__side--back-2">
              <div class="card__cta">
                <div class="card__price-box">
                </div>
                  <form name='frm' action='Controller' method='post'>
					<input type='hidden' name='acao'>                             
					<button type="button" class="btn btn--white" value='my' onclick='enviar(5)'>Gerar relatorio</button>
        		</form>
              </div>
            </div>
          </div>
        </div>

        <div class="col-1-of-3">
          <div class="card">
            <div class="card__side card__side--front-3">
              <div class="card__title card__title--3">
              	<img style ="width:50%" src="img/nilton.jpg">
                <h4 class="card__heading">Nylton</h4>
              </div>

              <div class="card__details">
                <ul>
                  <li>4x Ministro da Saude</li>
                  <li>4x Deputado Federal</li>
                  <li>2x Prefeito</li>
                </ul>
              </div>
            </div>
            <div class="card__side card__side--back card__side--back-3">
              <div class="card__cta">
                <div class="card__price-box">
                </div>
                  <form name='frm' action='Controller' method='post'>
					<input type='hidden' name='acao'>                             
					<button type="button" class="btn btn--white" value='nil' onclick='enviar(6)'>Gerar relatorio</button>
        		</form>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div class="u-center-text u-margin-top-huge">
        <form name='f' action='Controller' method='post'>
			<input type='hidden' name='acao'>                             
			<button type="button" class="btn btn--green" value='voltar' onclick='enviar(0)'>Voltar</button>
        </form>
        
      </div>
    </section>
  </body>
</html>