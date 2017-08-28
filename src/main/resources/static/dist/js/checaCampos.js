// JavaScript Document
function valida_form() {

    var nome = document.forms.cadastro.fnome.value; // captura o valor do campo do nome
    if (nome == "") {
        Alert.render('<h6><b>Preencha o campo com seu Nome!</b></h6>');
        // alert('Preencha o campo com seu Nome');
        cadastro.fnome.focus();
        document.getElementById('input_nome').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    var sobrenome = document.forms.cadastro.fsobreNome.value; // captura o valor do campo do sobrenome
    if (sobrenome == "") {
        Alert.render('<h6><b>Preencha o campo com seu Sobrenome!</b></h6>');
        cadastro.fsobreNome.focus();
        document.getElementById('input_sobreNome').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    var dataNascimento = document.forms.cadastro.fdataNasc.value; // captura o valor do campo de data
    if (dataNascimento == "") {
        Alert.render('<h6><b>Preencha o campo com sua Data Nascimento!</b></h6>');
        cadastro.fdataNasc.focus();
        document.getElementById('input_dataNascimento').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    var rg = document.forms.cadastro.frg.value; // captura o valor do campo de RG
    if (rg == "") {
        Alert.render('<h6><b>Preencha o campo com seu RG!</b></h6>');
        cadastro.frg.focus();
        document.getElementById('input_rg').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    var cpf = document.forms.cadastro.fcpf.value; // captura o valor do campo de CPF
    if (cpf == "") {
        Alert.render('<h6><b>Preencha o campo com seu CPF!</b></h6>');
        cadastro.fcpf.focus();
        document.getElementById('input_cpf').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    var carteiraT = document.forms.cadastro.fct.value; // captura o valor do campo de Carteira de Trabalho
    if (carteiraT == "") {
        Alert.render('<h6><b>Preencha o campo com sua Carteira de  Trabalho!</b></h6>');
        cadastro.fct.focus();
        document.getElementById('input_carteiraDeTrabalho').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    /*
    var estadoCivil = document.forms.cadastro.festadoCivil.value; // captura o valor do campo de Estado Civil
    if (estadoCivil == "") {
        Alert.render('<h6><b>Preencha o campo com seu Estado Civil!</b></h6>');
        cadastro.festadoCivil.focus();
        document.getElementById('input_estadoCivil').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    var tipoAcesso = document.forms.cadastro.ftipoAcesso.value; // captura o valor do campo de Tipo de Acesso
    if (tipoAcesso == "") {
        Alert.render('<h6><b>Preencha o campo com seu Tipo de Acesso!</b></h6>');
        cadastro.ftipoAcesso.focus();
        document.getElementById('input_tipoAcesso').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

*/
    var celular = document.forms.cadastro.fcelular.value; // captura o valor do campo do Celular
    if (celular == "") {
        Alert.render('<h6><b>Preencha o campo com seu Número de Celular!</b></h6>');
        cadastro.fcelular.focus();
        document.getElementById('input_celular').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    var cep = document.forms.cadastro.fcep.value; // captura o valor do campo do CEP
    if (cep == "") {
        Alert.render('<h6><b>Preencha o campo com seu CEP!</b></h6>');
        cadastro.fcep.focus();
        document.getElementById('input_cep').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    var logradouro = document.forms.cadastro.flogradouro.value; // captura o valor do campo do Logradouro
    if (logradouro == "") {
        Alert.render('<h6><b>Preencha o campo com seu Logradouro!</b></h6>');
        cadastro.flogradouro.focus();
        document.getElementById('input_logradouro').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    var complemento = document.forms.cadastro.fcomplemento.value; // captura o valor do campo do Complemento
    if (logradouro == "") {
        Alert.render('<h6><b>Preencha o campo com seu Complemento!</b></h6>');
        cadastro.fcomplemento.focus();
        document.getElementById('input_complemeno').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    var numero = document.forms.cadastro.fnumero.value; // captura o valor do campo do Número
    if (numero == "") {
        Alert.render('<h6><b>Preencha o campo com seu Logradouro!</b></h6>');
        cadastro.fcomplemento.focus();
        document.getElementById('input_complemeno').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    var cidade = document.forms.cadastro.fcidade.value; // captura o valor do campo do Cidade
    if (cidade == "") {
        Alert.render('Preencha o campo com seu Cidade!</b></h6>');
        cadastro.fcidade.focus();
        document.getElementById('input_cidade').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

    /*var uf = document.forms.cadastro.fuf.value; // captura o valor do campo do Estado
    if (uf == "") {
        Alert.render('<h6><b>Preencha o campo com seu Estado!</b></h6>');
        cadastro.fuf.focus();
        document.getElementById('input_uf').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }*/

    var matricula = document.forms.cadastro.fmatricula.value; // captura o valor do campo do Matricula
    if (matricula == "") {
        Alert.render('<h6><b>Preencha o campo com seu Matrícula!</b></h6>');
        cadastro.fmatricula.focus();
        document.getElementById('input_matricula').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }
    
   var senha = document.forms.cadastro.fsenha.value; // captura o valor do campo de senha
    if (senha == "") {
        Alert.render('<h6><b>Preencha o campo com sua Senha!</b></h6>');
        cadastro.fsenha.focus();
        document.getElementById('input_senha').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }
    
      var confirmaSenha = document.forms.cadastro.fconfirmaSenha.value; // captura o valor do campo de confirmar a senha
    if (confirmaSenha == "") {
        Alert.render('<h6><b>Preencha o campo com sua Confirmação da Senha!</b></h6>');
        cadastro.fsenha.focus();
        document.getElementById('input_senha').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }

}

function comparaSenha(){
    
    var senha = document.forms.cadastro.fsenha.value; // captura o valor do campo de senha
    var confirmaSenha = document.forms.cadastro.fconfirmaSenha.value; // captura o valor do campo de confirmar a senha

    // testa para ver se os valores de senha e confirmação da senha se estão em branco
    if (senha === "" || confirmaSenha === "") {
        Alert.render("Por favor preencha os campos de Senha!</b></h6>"); // alerta de campos vazios    
    } else {
        var resultado = senha.localeCompare(confirmaSenha); // compara as senha e retorna -1 ou 1 se forem diferentes e 0 se forem iguais
        if (resultado === 0) {
            document.getElementById("senhaIncorreta").innerHTML = ""; // Reset do label
            document.getElementById("senhaIncorreta").style.color = "#34495E"; //reset cor do campo 
            document.getElementById('senha').className = 'form-group has-success'; // muda o estilo do formulário
            document.getElementById('confirmaSenha').className = 'form-group has-success'; // muda o estilo do formulário
            document.getElementById('iconConfirmaSenha').className = 'form-control-feedback fui-check'; // muda o simbolo de cross "X" para check "v"

        } else {
            document.getElementById("senhaIncorreta").innerHTML = "As senhas não coincidem!"; // Mostra a mensagem de senha incorreta dentro da label
            document.getElementById("senhaIncorreta").style.color = "#C0392B"; // muda a cor da fonte para vermelho POMEGRANATE
            document.getElementById('confirmaSenha').className = 'form-group has-error'; // muda o estilo do formulário
            document.getElementById('iconConfirmaSenha').className = 'form-control-feedback fui-cross'; // muda o simbolo de check "V" para cross "X"
            document.fconfirmaSenha.focus();
        }
    }

}

function CustomAlert() {
    this.render = function (dialog) {
        var winW = window.innerWidth;
        var winH = window.innerHeight;
        var dialogoverlay = document.getElementById('dialogoverlay');
        var dialogbox = document.getElementById('dialogbox');
        dialogoverlay.style.display = "block";
        dialogoverlay.style.height = winH + "px";
        dialogbox.style.left = (winW / 2) - (550 * .5) + "px";
        dialogbox.style.top = "100px";
        dialogbox.style.display = "block";
        document.getElementById('dialogboxhead').innerHTML = '<h6><b>Campo Obrigatório!</b></h6>';
        document.getElementById('dialogboxbody').innerHTML = dialog;
        document.getElementById('dialogboxfoot').innerHTML = '<button  class="btn btn-info" onclick="Alert.ok()"><b>OK</b></button>';
    }
    this.ok = function () {
        document.getElementById('dialogbox').style.display = "none";
        document.getElementById('dialogoverlay').style.display = "none";
    }
}
var Alert = new CustomAlert();
