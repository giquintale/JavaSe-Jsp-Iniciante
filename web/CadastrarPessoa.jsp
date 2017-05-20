<%-- 
    Document   : CadastrarPessoa
    Created on : 09/05/2017, 17:00:18
    Author     : Huilton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Pessoa</title>
        <link rel="stylesheet" type="text/css" href="EstiloJsp.css">
    </head>
    <body style="text-align: center">
        <form action="CadastrarPessoaServlet" method="POST">
            <div class="body">
                <label>Nome</label>
                <input type="text" name="nome"/>
                <input type="submit" value="Cadastrar"/>
            </div>
        </form>
        <script>
            if (window.location.href.indexOf("sucesso=true") !== -1) {
                alert('Cadastrado do Sucesso');
            } else {
                alert('Cadastro não efetuado');
            }

        </script>
    </body>
</html>
