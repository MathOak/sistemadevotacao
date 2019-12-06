
var cont = 0;

function valor(v){
    cont++;    
	
	var numero = document.querySelector('#numero')
    var tela = document.querySelector('#tela')
    var foto = document.querySelector('#foto')
    var nome = document.querySelector('#nome')
    var nomeModal = document.querySelector('#nomeModal')
    
    if(cont <= 2){
        tela.value += v;
        if(tela.value != 11 || tela.value != 22 || tela.value != 33 || tela.value != 44 || tela.value != 55){
			if(cont == 1){
				nome.innerHTML = ""
			}else
				nome.innerHTML = "Inexistente"
            foto.style.display = "none"
            nome.style.display = "block"
            nomeModal.innerHTML = "Anular Voto";
        }
        if(tela.value == 11){
			numero.style.display = "block"
            foto.style.display = "block"
            nome.style.display = "block"
            foto.src = 'img/bob.jpg';
            nome.innerHTML = "Bob Esponja";
			numero.innerHTML = "11";
            nomeModal.innerHTML = "Bob Esponja <br> 11";
			
        }
        if(tela.value == 22){
			numero.style.display = "block"
            foto.style.display = "block"
            nome.style.display = "block"
            foto.src = 'img/lula.jpg';
            nome.innerHTML = "Lula Molusco";
			numero.innerHTML = "22";
            nomeModal.innerHTML = "Lula Molusco <br> 22"
        }
        if(tela.value == 33){
			numero.style.display = "block"
            nome.style.display = "block"
            foto.style.display = "block"
            foto.src = 'img/patrick.jpg';
            nome.innerHTML = "Patrick Estrela";
			numero.innerHTML = "33";
            nomeModal.innerHTML = "Patrick Estrela <br> 33"
        }
		if(tela.value == 44){
			numero.style.display = "block"
            nome.style.display = "block"
            foto.style.display = "block"
            foto.src = 'img/siri.jpg';
            nome.innerHTML = "Sirigueijo";
			numero.innerHTML = "44";
            nomeModal.innerHTML = "Sirigueijo <br> 44"
        }
		if(tela.value == 55){
			numero.style.display = "block"
            nome.style.display = "block"
            foto.style.display = "block"
            foto.src = 'img/gary.jpg';
            nome.innerHTML = "Gary";
			numero.innerHTML = "55";
            nomeModal.innerHTML = "Gary <br> 55"
        }
    }
}

function corrigir(){
	var numero = document.querySelector('#numero')
    var nome = document.querySelector('#nome')
    var nomeModal = document.querySelector('#nomeModal')
    var tela = document.querySelector('#tela')
    var foto = document.querySelector('#foto')
    tela.value ="";
    nome.style.display = "none"
	numero.style.display = "none"
    foto.style.display = "none"
    nomeModal.style.display = "";
	
    cont = 0;
}

function validarBranco(){
	foto.style.display = "none"
    nome.style.display = "block"
    nome.innerHTML = "Nulo"
    nomeModal.innerHTML = "Em Branco";

}

function validar(){
}

/*$function() {
    $('#pai').hide();

    $('#select').change(function() {
        if ($(this).val() === 'div1') {
            $('div1').show();
            $('div2').hide();
        }
    });
	});*/
	
/*function Esconde(){
    $('#select').onload('change',function(){
        var selectValor = '#' +$(this).val();
        $('#pai').children('div').hide();
        $('#pai').children(selectValor).show();
})}*/

//Funções após a leitura do documento
$(document).ready(function() {
	 $('#pai').hide();
    //Select para mostrar e esconder divs
    $('#select').on('change',function(){
		if($('#pai').hide())
			$('#pai').show();
        var selectValor = '#' +$(this).val();
        $('#pai').children('div').hide();
        $('#pai').children(selectValor).show();
    });
});


//Abrir Modal Mesario
$(function(){
	$("#ExemploModalCentralizado1").click(function(){
	$("#ExemploModalCentralizado11").modal();
	});
});

$(function(){
	$("#ExemploModalCentralizado2").click(function(){
	$("#ExemploModalCentralizado22").modal();
	});
});

$(function(){
	$("#ExemploModalCentralizado3").click(function(){
	$("#ExemploModalCentralizado33").modal();
	});
});

$(function(){
	$("#ExemploModalCentralizado4").click(function(){
	$("#ExemploModalCentralizado44").modal();
	});
});