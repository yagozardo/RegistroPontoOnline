$(document).ready(function () {

    function limpa_formulário_cep() {
        // Limpa valores do formulário de cep.
        $("#flogradouro").val("");
        $("#fcidade").val("");
        $("#fuf").val("");
    }

    //Quando o campo cep perde o foco.
    $("#fcep").blur(function () {

        //Nova variável "cep" somente com dígitos.
        var cep = $(this).val().replace(/\D/g, '');

        //Verifica se campo cep possui valor informado.
        if (cep !== "") {

            //Expressão regular para validar o CEP.
            var validacep = /^[0-9]{8}$/;

            //Valida o formato do CEP.
            if (validacep.test(cep)) {

                //Preenche os campos com "..." enquanto consulta webservice.
                $("#flogradouro").val("...");
                $("#fcidade").val("...");
                $("#fuf").val("...");

                //Consulta o webservice viacep.com.br/
                $.getJSON("//viacep.com.br/ws/" + cep + "/json/?callback=?", function (dados) {

                    if (!("erro" in dados)) {
                        //Atualiza os campos com os valores da consulta.
                        $("#flogradouro").val(dados.logradouro);
                        $("#bairro").val(dados.bairro);
                        $("#fcidade").val(dados.localidade);
                        $("#fuf").val(dados.uf);
                        document.getElementById('scep').style.color = "#2ECC71"; // muda a cor da fonte do aviso
                        document.getElementById('scep').innerHTML = " OK!"; // muda o estilo do formulário
                        document.getElementById('input_logradouro').className = 'form-group has-success'; // muda o estilo do formulário
                        document.getElementById('input_cidade').className = 'form-group has-success'; // muda o estilo do formulário
                        document.getElementById('input_uf').className = 'form-group has-success'; // muda o estilo do formulário
                        document.getElementById('input_cep').className = 'form-group has-success'; // muda o estilo do formulário
                    } //end if.
                    else {
                        //CEP pesquisado não foi encontrado.
                        limpa_formulário_cep();
                        alert("CEP não encontrado.");
                        document.getElementById('input_cep').className = 'form-group has-warning'; // muda o estilo do formulário
                    }
                });
            } //end if.
            else {
                //cep é inválido.
                limpa_formulário_cep();
                alert("Formato de CEP inválido.");
                document.getElementById('input_cep').className = 'form-group has-error'; // muda o estilo do formulário
            }
        } //end if.
        else {
            //cep sem valor, limpa formulário.
            limpa_formulário_cep();
        }
    });
});