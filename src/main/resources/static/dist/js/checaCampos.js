// JavaScript Document
function checaCampos() {
    var campos = []; // declaração do vetor que guarda os valores dos campos

    campos[0] = document.forms.cadastro.fnome.value; // captura o valor do campo do nome
    /* var sobrenome = document.forms["cadastro"]["fsobrenome"].value; // captura o valor do campo do sobrenome
     var dataNasc = document.forms["cadastro"]["fdataNascimento"].value; // captura o valor do campo da data
     var dataNasc = document.forms["cadastro"]["fdataNascimento"].value; // captura o valor do campo da data*/

    var i;
    for (i = 0; i < campos.length; i++) {
        alert(campos[i]);
    }

}
