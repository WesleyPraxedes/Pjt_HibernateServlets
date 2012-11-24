<%-- Document   : index
     Author     : Wesley --%>

<%@page contentType = "text/html" pageEncoding = "UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page CRUD com Hibernate + JSP + Servlet.</title>
    </head>
    <body>
        <h1>Pagina principal - CRUD Cliente com Hibernate + JSP + Servlet</h1>
        <ul><li>
            Escolha a opção de uso de Servlet que deseja acessar<br>
            <br>
            <a href="pagesJsp1_Ind/index.jsp"> 1-Uma servlet para cada caso de uso.</a><br>
            Nesse caso será uma para o cadastro, uma para atualizar e uma para excluir(em todos os casos).<br>
            <br>
            <a href="pagesJsp2_Col/index.jsp">2-Uma servlet para cada CRUD.</a><br>
            Nesse caso será apenas umas para todas as funções do CRUD(Uma para manter cada tabela com todas a operações).<br>
            <br>
            <a href="pagesJsp3_Con/index.jsp">3-Uma servlet para todos os CRUDs.</a><br>
            Nesse caso sera uma servlet para todo aplicativo (utilizando uma servlet controladora).
            <br>
        </li></ul>
    </body>
</html>