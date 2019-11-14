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
            foto.style.display = "none"
            nome.style.display = "block"
            nome.innerHTML = "Nulo"
            nomeModal.innerHTML = "Anular Voto";
        }
        if(tela.value == 52){
            foto.style.display = "block"
            nome.style.display = "block"
            foto.src = 'img/nilton.jpg';
            nome.innerHTML = "Nilton Fraga";
            nomeModal.innerHTML = "Nilton Fraga";
        }
        if(tela.value == 22){
            foto.style.display = "block"
            nome.style.display = "block"
            foto.src = 'img/jonathan.jpg';
            nome.innerHTML = "Jonathan Langa"
            nomeModal.innerHTML = "Jonathan Langa"
        }
        if(tela.value == 13){
            nome.style.display = "block"
            foto.style.display = "block"
            foto.src = 'img/mylena.jpg';
            nome.innerHTML = "Mylena Costa"
            nomeModal.innerHTML = "Mylena Costa"
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