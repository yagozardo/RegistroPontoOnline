// JavaScript Document

function val_nome() {
    var nome = document.forms.cadastro.fnome.value; // captura o valor do campo do nome
    if (nome == "") {
        cadastro.fnome.focus();
        document.getElementById('input_nome').className = 'form-group has-warning'; // muda o estilo do formulário
    } else {
        document.getElementById('input_nome').className = 'form-group has-success'; // muda o estilo do formulário
    }
}

function val_sobrenome() {
    var sobrenome = document.forms.cadastro.fsobreNome.value; // captura o valor do campo do sobrenome
    if (sobrenome == "") {
        cadastro.fsobreNome.focus();
        document.getElementById('input_sobreNome').className = 'form-group has-warning'; // muda o estilo do formulário
    } else {
        document.getElementById('input_sobreNome').className = 'form-group has-success'; // muda o estilo do formulário
    }
}

function val_data() {
    document.forms.cadastro.fdataNasc.value; // captura o valor do campo de data
    if (dataNascimento == "") {
        cadastro.fdataNasc.focus();
        document.getElementById('input_dataNascimento').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    } else {
        document.getElementById('input_dataNascimento').className = 'form-group has-success'; // muda o estilo do formulário
    }
}

function val_rg() {
    var rg = document.forms.cadastro.frg.value; // captura o valor do campo de RG
    if (rg == "") {
        cadastro.frg.focus();
        document.getElementById('input_rg').className = 'form-group has-warning'; // muda o estilo do formulário
    } else {
        document.getElementById('input_rg').className = 'form-group has-success'; // muda o estilo do formulário
    }
}

function val_cpf() {
    var cpf = document.forms.cadastro.fcpf.value; // captura o valor do campo de CPF
    if (cpf == "") {
        cadastro.fcpf.focus();
        document.getElementById('input_cpf').className = 'form-group has-warning'; // muda o estilo do formulário
    } else {
        document.getElementById('input_cpf').className = 'form-group has-success'; // muda o estilo do formulário
    }
}

function valida_form() {

    var nome = document.forms.cadastro.fnome.value; // captura o valor do campo do nome
    if (nome == "") {
        bootbox.alert('<h6><b>Preencha o seu Nome!</b></h6>');
        cadastro.fnome.focus();
        document.getElementById('input_nome').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    var sobrenome = document.forms.cadastro.fsobreNome.value; // captura o valor do campo do sobrenome
    if (sobrenome == "") {
        bootbox.alert('<h6><b>Preencha o seu Sobrenome!</b></h6>');
        cadastro.fsobreNome.focus();
        document.getElementById('input_sobreNome').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    var dataNascimento = document.forms.cadastro.fdataNasc.value; // captura o valor do campo de data
    if (dataNascimento == "") {
        bootbox.alert('<h6><b>Preencha o sua Data Nascimento!</b></h6>');
        cadastro.fdataNasc.focus();
        document.getElementById('input_dataNascimento').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    var rg = document.forms.cadastro.frg.value; // captura o valor do campo de RG
    if (rg == "") {
        bootbox.alert('<h6><b>Preencha o seu RG!</b></h6>');
        cadastro.frg.focus();
        document.getElementById('input_rg').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    var cpf = document.forms.cadastro.fcpf.value; // captura o valor do campo de CPF
    if (cpf == "") {
        bootbox.alert('<h6><b>Preencha o seu CPF!</b></h6>');
        cadastro.fcpf.focus();
        document.getElementById('input_cpf').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    var carteiraT = document.forms.cadastro.fct.value; // captura o valor do campo de Carteira de Trabalho
    if (carteiraT == "") {
        bootbox.alert('<h6><b>Preencha o sua Carteira de Trabalho!</b></h6>');
        cadastro.fct.focus();
        document.getElementById('input_carteiraDeTrabalho').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    /*
        var estadoCivil = document.forms.cadastro.festadoCivil.value; // captura o valor do campo de Estado Civil
        if (estadoCivil == "") {
            bootbox.alert('<h6><b>Preencha o campo com seu Estado Civil!</b></h6>');
            cadastro.festadoCivil.focus();
            document.getElementById('input_estadoCivil').className = 'form-group form-control'; // muda o estilo do formulário
            return false;
        }

        var tipoAcesso = document.forms.cadastro.ftipoAcesso.value; // captura o valor do campo de Tipo de Acesso
        if (tipoAcesso == "") {
            bootbox.alert('<h6><b>Preencha o campo com seu Tipo de Acesso!</b></h6>');
            cadastro.ftipoAcesso.focus();
            document.getElementById('input_tipoAcesso').className = 'form-group form-control'; // muda o estilo do formulário
            return false;
        }

    */
    var celular = document.forms.cadastro.fcelular.value; // captura o valor do campo do Celular
    if (celular == "") {
        bootbox.alert('<h6><b>Preencha o seu Número de Celular!</b></h6>');
        cadastro.fcelular.focus();
        document.getElementById('input_celular').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    var cep = document.forms.cadastro.fcep.value; // captura o valor do campo do CEP
    if (cep == "") {
        bootbox.alert('<h6><b>Preencha o seu CEP!</b></h6>');
        cadastro.fcep.focus();
        document.getElementById('input_cep').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    var logradouro = document.forms.cadastro.flogradouro.value; // captura o valor do campo do Logradouro
    if (logradouro == "") {
        bootbox.alert('<h6><b>Preencha o seu Logradouro!</b></h6>');
        cadastro.flogradouro.focus();
        document.getElementById('input_logradouro').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    var complemento = document.forms.cadastro.fcomplemento.value; // captura o valor do campo do Complemento
    if (logradouro == "") {
       bootbox.alert('<h6><b>Preencha o seu Complemento!</b></h6>');
        cadastro.fcomplemento.focus();
        document.getElementById('input_complemeno').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    var numero = document.forms.cadastro.fnumero.value; // captura o valor do campo do Número
    if (numero == "") {
        bootbox.alert('<h6><b>Preencha o seu Logradouro!</b></h6>');
        cadastro.fcomplemento.focus();
        document.getElementById('input_complemeno').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    var cidade = document.forms.cadastro.fcidade.value; // captura o valor do campo do Cidade
    if (cidade == "") {
        bootbox.alert('Preencha o seu Cidade!</b></h6>');
        cadastro.fcidade.focus();
        document.getElementById('input_cidade').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    /*var uf = document.forms.cadastro.fuf.value; // captura o valor do campo do Estado
    if (uf == "") {
       bootbox.alert('<h6><b>Preencha o campo com seu Estado!</b></h6>');
        cadastro.fuf.focus();
        document.getElementById('input_uf').className = 'form-group form-control'; // muda o estilo do formulário
        return false;
    }*/

    var matricula = document.forms.cadastro.fmatricula.value; // captura o valor do campo do Matricula
    if (matricula == "") {
        bootbox.alert('<h6><b>Preencha o seu Matrícula!</b></h6>');
        cadastro.fmatricula.focus();
        document.getElementById('input_matricula').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    var senha = document.forms.cadastro.fsenha.value; // captura o valor do campo de senha
    if (senha == "") {
        bootbox.alert('<h6><b>Preencha o sua Senha!</b></h6>');
        cadastro.fsenha.focus();
        document.getElementById('input_senha').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

    var confirmaSenha = document.forms.cadastro.fconfirmaSenha.value; // captura o valor do campo de confirmar a senha
    if (confirmaSenha == "") {
       bootbox.alert('<h6><b>Preencha o sua Confirmação da Senha!</b></h6>');
        cadastro.fsenha.focus();
        document.getElementById('input_senha').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    }

}

function comparaSenha() {

    var senha = document.forms.cadastro.fsenha.value; // captura o valor do campo de senha
    var confirmaSenha = document.forms.cadastro.fconfirmaSenha.value; // captura o valor do campo de confirmar a senha

    // testa para ver se os valores de senha e confirmação da senha se estão em branco
    if (senha === "" || confirmaSenha === "") {
       bootbox.alert("Preencha com sua Senha e a Confirmação de Senha!</b></h6>"); // alerta de campos vazios    
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

function validaData() {
    var dataNascimento = document.forms.cadastro.fdataNasc.value; // captura o valor do campo de data
    if (dataNascimento != "") { // virefica se a data nascimento tem menos de 10 anos ou mais de 100
        var data = new Date();
        var anoAtual = parseInt(data.getFullYear());
        var dataNascimento = parseInt(dataNascimento).slice(0, 4);
        var diferenca = anoAtual - dataNascimento;
        alert(diferenca);
        alert(diferenca);
        if (diferenca >= 100 || diferenca <= 10) {
            bootbox.alert('<h6><b>Data de Nascimento inválida!</b></h6>');
        }
    }
}


