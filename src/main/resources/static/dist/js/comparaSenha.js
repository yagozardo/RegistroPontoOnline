// JavaScript Document
function comparaSenha() {
    var senha = document.forms["cadastro"]["fsenha"].value; // captura o valor do campo de senha
    var confirmaSenha = document.forms["cadastro"]["fconfirmaSenha"].value; // captura o valor do campo de confirmar a senha

    // testa para ver se os valores de senha e confirmação da senha estão em branco
    if (senha == "" || confirmaSenha == "") {
        if (senha == "") {
            alert("Por favor preencha os campos de Senha!");
        }
    } else {
        var resultado = senha.localeCompare(confirmaSenha); // compara as senha e retorna -1 se forem diferentes
        if(resultado == -1){
           alert("Senhas não coincidem!"); 
        }
       // document.getElementById("demo").innerHTML = n;
    }

}
