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
        aviso("fsobrenome", "input_sobrenome");
        document.forms.cadastro.fsobrenome.focus(); // foca no campo
    } else if (sobrenome.length <= 2) { // conteudo do campo insuficiente 
        erro("fsobrenome", "input_sobrenome");
        document.forms.cadastro.fsobrenome.focus();
    } else {
        sucesso("fsobrenome", "input_sobrenome");
    }
}

function valida_form() {

    // Testa o valor do campo do nome

    //window.setTimeout('val_nome()', 500); // chamada da função de verificar o nome
    val_nome(); // chamada da função de verificar o nome

    //val_sobrenome();

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
