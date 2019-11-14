
var cont = 0;

function valor(v){
    cont++;    

    var tela = document.querySelector('#tela')
    var foto = document.querySelector('#foto')
    var nome = document.querySelector('#nome')
    var nomeModal = document.querySelector('#nomeModal')
    
    if(cont <= 2){
        tela.value += v;
        if(tela.value != 52 || tela.value != 22 || tela.value != 13){
			if(cont == 1){
				nome.innerHTML = ""
			}else
				nome.innerHTML = "Inexistente"
            foto.style.display = "none"
            nome.style.display = "block"
            nomeModal.innerHTML = "Anular Voto";
        }
        if(tela.value == 52){
            foto.style.display = "block"
            nome.style.display = "block"
            foto.src = 'img/bob.jpg';
            nome.innerHTML = "Bob Esponja";
            nomeModal.innerHTML = "Bob Esponja <br> 52";
			
        }
        if(tela.value == 22){
            foto.style.display = "block"
            nome.style.display = "block"
            foto.src = 'img/tilapia.jpg';
            nome.innerHTML = "Tilapia"
            nomeModal.innerHTML = "Tilapia"
        }
        if(tela.value == 13){
            nome.style.display = "block"
            foto.style.display = "block"
            foto.src = 'img/pablo.jpg';
            nome.innerHTML = "Pabllo Vittar"
            nomeModal.innerHTML = "Pablo Vitar"
        }
    }
}

function corrigir(){
    var nome = document.querySelector('#nome')
    var nomeModal = document.querySelector('#nomeModal')
    var tela = document.querySelector('#tela')
    var foto = document.querySelector('#foto')
    tela.value ='';
    nome.style.display = "none"
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
