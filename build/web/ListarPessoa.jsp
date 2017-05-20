<%-- 
    Document   : ListarPessoa
    Created on : 09/05/2017, 15:16:22
    Author     : Huilton
--%>
<%@page import="br.com.model.Pessoa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.Dao.PessoaDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Pessoa</title>  
        <%
           // PessoaDao pessoaDao = new PessoaDao();
           // ArrayList<Pessoa> listaPessoa = pessoaDao.listar();
            ArrayList<Pessoa> listaPessoa = (ArrayList<Pessoa>) request.getAttribute("listaPessoa");
            System.out.println(listaPessoa.size());
        %>

    </head>
    <body>

        <table border="1">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nome</th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (Pessoa pessoa : listaPessoa) {
                        if (pessoa != null) {
                %>
                <tr>
                    <td><%= pessoa.getCodigo()%></td>
                    <td><%= pessoa.getNome()%></td>
                </tr>
                <%
                } else {
                %>
            <script>
                alert("Erro ao retornar Lista de pessoas!!");
            </script>

            <%
                    }
                }
            %>

        </tbody>
    </table>
</body>
</html>
