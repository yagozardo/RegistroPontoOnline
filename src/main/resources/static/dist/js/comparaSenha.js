// JavaScript Document
function comparaSenha() {
    var senha = document.forms["cadastro"]["fsenha"].value; // captura o valor do campo de senha
    var confirmaSenha = document.forms["cadastro"]["fconfirmaSenha"].value; // captura o valor do campo de confirmar a senha

    // testa para ver se os valores de senha e confirmação da senha se estão em branco
    if (senha == "" || confirmaSenha == "") {
        alert("Por favor preencha os campos de Senha!"); // alerta de campos vazios    
    } else {
        var resultado = senha.localeCompare(confirmaSenha); // compara as senha e retorna -1 ou 1 se forem diferentes e 0 se forem iguais
        if (resultado == 0) {
            document.getElementById("senhaIncorreta").innerHTML = ""; // Reset do label
            document.getElementById("senhaIncorreta").style.color = "#34495E"; //reset cor do campo 
            document.getElementById('senha').className = 'form-group has-success'; // muda o estilo do formulário
            document.getElementById('confirmaSenha').className = 'form-group has-feedback has-success'; // muda o estilo do formulário
            document.getElementById('iconConfirmaSenha').className = 'form-control-feedback fui-check'; // muda o simbolo de cross "X" para check "v"

        } else {
            document.getElementById("senhaIncorreta").innerHTML = "As senhas não coincidem!"; // Mostra a mensagem de senha incorreta dentro da label
            document.getElementById("senhaIncorreta").style.color = "#C0392B"; // muda a cor da fonte para vermelho POMEGRANATE
            document.getElementById('confirmaSenha').className = 'form-group has-error'; // muda o estilo do formulário
            document.getElementById('iconConfirmaSenha').className = 'form-control-feedback fui-cross'; // muda o simbolo de check "V" para cross "X"
        }
    }
}
