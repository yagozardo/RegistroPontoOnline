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
        if (validarRG(rg)) {
            sucesso("srg", "input_rg");
        } else {
            document.getElementById('srg').style.color = "#E74C3C"; // muda a cor da fonte do aviso
            document.getElementById('srg').innerHTML = " RG Inválido!"; // muda o estilo do formulário
            document.getElementById('input_rg').className = 'form-group has-error'; // muda o estilo do formulário
            val++;
        }

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
        if (validarCPF(cpf)) {
            sucesso("scpf", "input_cpf");
        } else {
            document.getElementById('scpf').style.color = "#E74C3C"; // muda a cor da fonte do aviso
            document.getElementById('scpf').innerHTML = " CPF Inválido!"; // muda o estilo do formulário
            document.getElementById('input_cpf').className = 'form-group has-error'; // muda o estilo do formulário
            val++;
        }

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
    } else if (email.length < 7) { // conteudo do campo insuficiente 
        erro("semail", "input_email");
        document.forms.cadastro.femail.focus();
    } else {

        // função para validar se contem "@", "." e no minino dois caracteres entre eles
        function validarEmail(email) {
            e = /^[a-zA-Z0-9][a-zA-Z0-9\._-]+@([a-zA-Z0-9\._-]+\.)[a-zA-Z-0-9]{2}/;

            if (e.exec(email)) {
                return true;
            } else {
                return false;
            }
        }

        // Verifica o retorno da função da validação de emal
        if (!validarEmail(email)) {
            document.getElementById('semail').style.color = "#E74C3C"; // muda a cor da fonte do aviso
            document.getElementById('semail').innerHTML = " E-mail Inválido!"; // muda o estilo do formulário
            document.getElementById('input_email').className = 'form-group has-error'; // muda o estilo do formulário
            val++;
        } else {
            sucesso("semail", "input_email");
        }

    }
}


// Verifica a validade do telefone celular
function val_fixo() {
    var fixo = document.forms.cadastro.ffixo.value; // passa o valor do campo
    if (fixo === "") { // campo vazio
        aviso("sfixo", "input_fixo");
        document.forms.cadastro.ffixo.focus(); // foca no campo
    } else if (fixo.length < 14) { // conteudo do campo insuficiente 
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
        swal("Usuário cadastrado com sucesso!");
        return true;
    }

}

// Função que valida o cpf
function validarCPF(cpf) {
    cpf = cpf.replace(/[^\d]+/g, '');
    if (cpf == '') return false;
    // Elimina CPFs invalidos conhecidos    
    if (cpf.length != 11 ||
        cpf == "00000000000" ||
        cpf == "11111111111" ||
        cpf == "22222222222" ||
        cpf == "33333333333" ||
        cpf == "44444444444" ||
        cpf == "55555555555" ||
        cpf == "66666666666" ||
        cpf == "77777777777" ||
        cpf == "88888888888" ||
        cpf == "99999999999")
        return false;
    // Valida 1o digito 
    add = 0;
    for (i = 0; i < 9; i++)
        add += parseInt(cpf.charAt(i)) * (10 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
        rev = 0;
    if (rev != parseInt(cpf.charAt(9)))
        return false;
    // Valida 2o digito 
    add = 0;
    for (i = 0; i < 10; i++)
        add += parseInt(cpf.charAt(i)) * (11 - i);
    rev = 11 - (add % 11);
    if (rev == 10 || rev == 11)
        rev = 0;
    if (rev != parseInt(cpf.charAt(10)))
        return false;
    return true;
}

// Função para validar RG
function validarRG(numero) {
    numero = numero.replace(/[^\d]+/g, '');
    var numero = numero.split("");
    tamanho = numero.length;
    vetor = new Array(tamanho);

    if (tamanho >= 1) {
        vetor[0] = parseInt(numero[0]) * 2;
    }
    if (tamanho >= 2) {
        vetor[1] = parseInt(numero[1]) * 3;
    }
    if (tamanho >= 3) {
        vetor[2] = parseInt(numero[2]) * 4;
    }
    if (tamanho >= 4) {
        vetor[3] = parseInt(numero[3]) * 5;
    }
    if (tamanho >= 5) {
        vetor[4] = parseInt(numero[4]) * 6;
    }
    if (tamanho >= 6) {
        vetor[5] = parseInt(numero[5]) * 7;
    }
    if (tamanho >= 7) {
        vetor[6] = parseInt(numero[6]) * 8;
    }
    if (tamanho >= 8) {
        vetor[7] = parseInt(numero[7]) * 9;
    }
    if (tamanho >= 9) {
        vetor[8] = parseInt(numero[8]) * 100;
    }

    total = 0;

    if (tamanho >= 1) {
        total += vetor[0];
    }
    if (tamanho >= 2) {
        total += vetor[1];
    }
    if (tamanho >= 3) {
        total += vetor[2];
    }
    if (tamanho >= 4) {
        total += vetor[3];
    }
    if (tamanho >= 5) {
        total += vetor[4];
    }
    if (tamanho >= 6) {
        total += vetor[5];
    }
    if (tamanho >= 7) {
        total += vetor[6];
    }
    if (tamanho >= 8) {
        total += vetor[7];
    }
    if (tamanho >= 9) {
        total += vetor[8];
    }


    resto = total % 11;
    if (resto != 0) {
        return false;
    } else {
        return true;
    }
}

/**************** Máscaras *******************/
// máscara para telefones
function mask(e, id, mask) {
    var tecla = (window.event) ? event.keyCode : e.which;
    if ((tecla > 47 && tecla < 58)) {
        mascara(id, mask);
        return true;
    } else {
        if (tecla == 8 || tecla == 0) {
            mascara(id, mask);
            return true;
        } else return false;
    }
}

function mascara(id, mask) {
    var i = id.value.length;
    var carac = mask.substring(i, i + 1);
    var prox_char = mask.substring(i + 1, i + 2);
    if (i == 0 && carac != '#') {
        insereCaracter(id, carac);
        if (prox_char != '#') insereCaracter(id, prox_char);
    } else if (carac != '#') {
        insereCaracter(id, carac);
        if (prox_char != '#') insereCaracter(id, prox_char);
    }

    function insereCaracter(id, char) {
        id.value += char;
    }
}

/**************** FIM Máscaras *******************/

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
