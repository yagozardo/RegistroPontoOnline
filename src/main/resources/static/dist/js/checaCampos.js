// JavaScript Document
var val = 1; // variável para chegar se ocorreu alguma irregularidade

/******************************** Módulos de Aviso **********************************/
// função de aviso 
function aviso(span, input) {
    document.getElementById(span).style.color = "#F1C40F"; // muda a cor da fonte do aviso
    document.getElementById(span).innerHTML = " Vazio!"; // muda o estilo do formulário
    document.getElementById(input).className = 'form-group has-warning'; // muda o estilo do formulário
    val++;
}

function erro(span, input) {
    document.getElementById(span).style.color = "#E74C3C"; // muda a cor da fonte do aviso
    document.getElementById(span).innerHTML = " Muito pequeno!"; // muda o estilo do formulário
    document.getElementById(input).className = 'form-group has-error'; // muda o estilo do formulário
    val++;
}

function sucesso(span, input) {
    document.getElementById(span).style.color = "#2ECC71"; // muda a cor da fonte do aviso
    document.getElementById(span).innerHTML = " OK!"; // muda o estilo do formulário
    document.getElementById(input).className = 'form-group has-success'; // muda o estilo do formulário
}
/************************************************************************************/

// Verifica a validade do nome
function val_nome() {
    var nome = document.forms.cadastro.fnome.value; // passa o valor do campo
    if (nome === "") { // campo vazio
        aviso("snome", "input_nome");
        document.forms.cadastro.fnome.focus(); // foca no campo
    } else if (nome.length <= 2) { // conteudo do campo insuficiente 
        erro("snome", "input_nome");
        document.forms.cadastro.fnome.focus();
    } else {
        sucesso("snome", "input_nome");
    }
}

// Verifica a validade do sobrenome
function val_sobrenome() {
    var sobrenome = document.forms.cadastro.fsobrenome.value; // passa o valor do campo
    if (sobrenome === "") { // campo vazio
        aviso("ssobrenome", "input_sobrenome");
        document.forms.cadastro.fsobrenome.focus(); // foca no campo
    } else if (sobrenome.length <= 2) { // conteudo do campo insuficiente 
        erro("ssobrenome", "input_sobrenome");
        document.forms.cadastro.fsobrenome.focus();
    } else {
        sucesso("ssobrenome", "input_sobrenome");
    }
}

// Verifica a validade da data
function val_data() {
    var data = document.forms.cadastro.fdataNasc.value; // passa o valor do campo
    if (data === "") { // campo vazio
        aviso("sdataNascimento", "input_dataNascimento");
        document.forms.cadastro.fdataNasc.focus(); // foca no campo
    } else if (data.length <= 8) { // conteudo do campo insuficiente 
        erro("sdataNascimento", "input_dataNascimento");
        document.forms.cadastro.fdataNasc.focus();
    } else {
        var ano_input = parseInt(data.slice(0, 4)); // captura apenas o ano da data digitada
        var a = new Date();
        var ano_atual = parseInt(a.getFullYear());
        var idade = ano_atual - ano_input;
        if (idade >= 14 && idade <= 100) {
            sucesso("sdataNascimento", "input_dataNascimento");
        } else {
            document.getElementById('sdataNascimento').style.color = "#E74C3C"; // muda a cor da fonte do aviso
            document.getElementById('sdataNascimento').innerHTML = " Idade Errada!"; // muda o estilo do formulário
            document.getElementById('input_dataNascimento').className = 'form-group has-error'; // muda o estilo do formulário
            val++;
        }
    }
}

// Verifica a validade do RG
function val_rg() {
    var rg = document.forms.cadastro.frg.value; // passa o valor do campo
    if (rg === "") { // campo vazio
        aviso("srg", "input_rg");
        document.forms.cadastro.frg.focus(); // foca no campo
    } else if (rg.length <= 5) { // conteudo do campo insuficiente 
        erro("srg", "input_rg");
        document.forms.cadastro.frg.focus();
    } else {
        sucesso("srg", "input_rg");
    }
}

// Verifica a validade do CPF
function val_cpf() {
    var cpf = document.forms.cadastro.fcpf.value; // passa o valor do campo
    if (cpf === "") { // campo vazio
        aviso("scpf", "input_cpf");
        document.forms.cadastro.fcpf.focus(); // foca no campo
    } else if (cpf.length < 11) { // conteudo do campo insuficiente 
        erro("scpf", "input_cpf");
        document.forms.cadastro.fcpf.focus();
    } else {
        sucesso("scpf", "input_cpf");
    }
}

// Verifica a validade do Estado Civil
function val_estado_civil() {
    var estado_civil = document.forms.cadastro.festadoCivil.value; // passa o valor do campo
    if (estado_civil === "") { // campo vazio
        aviso("sestadoCivil", "input_estadoCivil");
        document.forms.cadastro.festadoCivil.focus(); // foca no campo
    } else if (estado_civil.length < 11) { // conteudo do campo insuficiente 
        erro("sestadoCivil", "input_estadoCivil");
        document.forms.cadastro.festadoCivil.focus();
    } else {
        sucesso("sestadoCivil", "input_estadoCivil");
    }
}

// Verifica a validade do Departamento
function val_departamento() {
    var derpa = document.forms.cadastro.fdepartamento.value; // passa o valor do campo
    if (derpa === "") { // campo vazio
        aviso("sdepartamento", "input_departamento");
        document.forms.cadastro.fdepartamento.focus(); // foca no campo
    } else if (derpa.length < 2) { // conteudo do campo insuficiente 
        erro("sdepartamento", "input_departamento");
        document.forms.cadastro.fdepartamento.focus();
    } else {
        sucesso("sdepartamento", "input_departamento");
    }
}

// Verifica a validade do Tipo de Acesso
function val_tipo_acesso() {
    var TA = document.forms.cadastro.ftipoAcesso.value; // passa o valor do campo
    if (TA === "") { // campo vazio
        aviso("stipoAcesso", "input_tipoAcesso");
        document.forms.cadastro.ftipoAcesso.focus(); // foca no campo
    } else if (TA.length < 11) { // conteudo do campo insuficiente 
        erro("stipoAcesso", "input_tipoAcesso");
        document.forms.cadastro.ftipoAcesso.focus();
    } else {
        sucesso("stipoAcesso", "input_tipoAcesso");
    }
}

// Verifica a validade do carteira de trabalho
function val_carteira_trabalho() {
    var ct = document.forms.cadastro.fct.value; // passa o valor do campo
    if (ct === "") { // campo vazio
        aviso("scarteiraTrabalho", "input_carteiraDeTrabalho");
        document.forms.cadastro.fct.focus(); // foca no campo
    } else if (ct.length < 5) { // conteudo do campo insuficiente 
        erro("scarteiraTrabalho", "input_carteiraDeTrabalho");
        document.forms.cadastro.fct.focus();
    } else {
        sucesso("scarteiraTrabalho", "input_carteiraDeTrabalho");
    }
}

// Verifica a validade do cargo
function val_cargo() {
    var cargo = document.forms.cadastro.fcargo.value; // passa o valor do campo
    if (cargo === "") { // campo vazio
        aviso("scargo", "input_cargo");
        document.forms.cadastro.fcargo.focus(); // foca no campo
    } else if (cargo.length < 10) { // conteudo do campo insuficiente 
        erro("scargo", "input_cargo");
        document.forms.cadastro.fcargo.focus();
    } else {
        sucesso("scargo", "input_cargo");
    }
}

// Verifica a validade do telefone email
function val_email() {
    var email = document.forms.cadastro.femail.value; // passa o valor do campo
    if (email === "") { // campo vazio
        aviso("semail", "input_email");
        document.forms.cadastro.femail.focus(); // foca no campo
    } else if (email.length < 10) { // conteudo do campo insuficiente 
        erro("semail", "input_email");
        document.forms.cadastro.femail.focus();
    } else {
        sucesso("semail", "input_email");
    }
}

// Verifica a validade do telefone celular
function val_fixo() {
    var fixo = document.forms.cadastro.ffixo.value; // passa o valor do campo
    if (fixo === "") { // campo vazio
        aviso("sfixo", "input_fixo");
        document.forms.cadastro.ffixo.focus(); // foca no campo
    } else if (fixo.length < 10) { // conteudo do campo insuficiente 
        erro("sfixo", "input_fixo");
        document.forms.cadastro.ffixo.focus();
    } else {
        sucesso("sfixo", "input_fixo");
    }
}

// Verifica a validade do telefone celular
function val_celular() {
    var celular = document.forms.cadastro.fcelular.value; // passa o valor do campo
    if (celular === "") { // campo vazio
        aviso("scelular", "input_celular");
        document.forms.cadastro.fcelular.focus(); // foca no campo
    } else if (celular.length < 10) { // conteudo do campo insuficiente 
        erro("scelular", "input_celular");
        document.forms.cadastro.fcelular.focus();
    } else {
        sucesso("scelular", "input_celular");
    }
}


// Verifica a validade do CEP
function val_cep() {
    var cep = document.forms.cadastro.fcep.value; // passa o valor do campo
    if (cep === "") { // campo vazio
        aviso("scep", "input_cep");
        document.forms.cadastro.fcep.focus(); // foca no campo
    }
}

// Verifica a validade do numero
function val_numero() {
    var numero = document.forms.cadastro.fnumero.value; // passa o valor do campo
    if (numero === "") { // campo vazio
        aviso("snumero", "input_numero");
        document.forms.cadastro.fnumero.focus(); // foca no campo
    } else if (numero.length === 0) { // conteudo do campo insuficiente 
        erro("snumero", "input_numero");
        document.forms.cadastro.fnumero.focus();
    } else {
        sucesso("snumero", "input_numero");
    }
}

// Verifica a validade do numero
function val_complemento() {
    var numero = document.forms.cadastro.fcomplemento.value; // passa o valor do campo
    if (numero === "") { // campo vazio
        aviso("scomplemento", "input_complemento");
        document.forms.cadastro.fcomplemento.focus(); // foca no campo
    } else if (numero.length < 5) { // conteudo do campo insuficiente 
        erro("scomplemento", "input_complemento");
        document.forms.cadastro.fcomplemento.focus();
    } else {
        sucesso("scomplemento", "input_complemento");
    }
}

function valida_form() {

    val_nome(); // chamada da função de verificar o nome

    val_sobrenome(); // chama a função de verificar o sobrenome

    val_data(); // chama a função de verifiar a data

    val_rg(); // chama a função de verificar o RG

    val_cpf(); // chama a função de vereficar o CPF

    val_estado_civil(); // chama a função de verificar o estado civil

    val_departamento(); // chama a função de verificar o departamento

    val_tipo_acesso(); // chama a função de verificar o tipo de acesso

    val_carteira_trabalho(); // chama a função de verificar a carteira de trabalho

    val_cargo(); // chama a função de verificar o cargo

    val_email(); // chama a função de verificar o email

    val_celular(); // chama a função de verificar o celular

    val_cep(); // chama a função de verificar o CEP

    val_numero(); // chama a função de verificar o número

    val_complemento(); // chama a função de verificar o complemento

    // verifica se tem erros
    if (val > 1) {
        swal('Erros foram encontrados!');
        return false;
    } else {
        return true;
    }

}


/*function val_data() {
    if (document.forms.cadastro.fdataNasc.value == "") {
        document.forms.cadastro.fdataNasc.focus();
        document.getElementById('input_dataNascimento').className = 'form-group has-warning'; // muda o estilo do formulário
        return false;
    } else {
        var ano_nascimento = document.forms.cadastro.fdataNasc.value;
        // captura apanas os 4 primeiros caracteres
        ano_nascimento = ano_nascimento.slice(0, 4);
        // pega o ano atual
        var Data = new Date();
        var ano_atual = Data.getFullYear();
        // calcula a diferença para descobrir a idade
        var idade = ano_atual - ano_nascimento;
        if (idade >= 90 || idade <= 12) {
            document.getElementById('input_dataNascimento').className = 'form-group has-error'; // muda o estilo do formulário
            return false;
        } else {
            document.getElementById('input_dataNascimento').className = 'form-group has-success'; // muda o estilo do formulário
            return true;
        }
    }
}*/

/*
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
}*/
