<%-- Document   : index
     Author     : Wesley --%>

<%@page contentType = "text/html" pageEncoding="ISO-8859-9"%>
<%@page import = "java.text.SimpleDateFormat"%>
<%@page import = "dao.DAOTbCliente"%>
<%@page import = "vo.TbCliente"%>
<%@page import = "java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD Hibernate + JSP + Servlet "coletiva".</title>
    </head>
    <body>
        <a href="../index.jsp">Home</a>
        <br/>
        <h1>CRUD Hibernate + JSP + Servlet "coletiva"</h1>
        
        <h4>Formulário de cadastro de clientes<br/>
            Deve-se preencher todos os campos.</h4>
        
        <form method="post" action="manterCliente">
            <input type="hidden" name="metodo" value="cadastrar"/>
            Nome: <input type="text" name="nome" value="" /> <br/>
            Email: <input type="text" name="email" value="" /> <br/>
            Telefone: <input type="text" name="telefone" value="" />(Apenas numeros)<br/>
            Data de nascimento: <input type="text" name="data" value="" />dd/mm/yyyy (Formado da data)<br/>

            <input type="submit" value="Cadastrar Cliente"/><br/>
            <input type="reset" value="Limpar campos"/>
        </form>
        <br/>
        <br/>
        <h2>Lista de clientes</h2>
        <table width="100%" border="1">
            <tr>
                <td>Código cliente</td>
                <td>Nome</td>
                <td>Email</td>
                <td>Fone</td>
                <td>Data</td>
                <td>Atualizar</td>
                <td>Excluir</td>
            </tr>
            <%
                try{
                    String dtString = null;
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    DAOTbCliente dao = new DAOTbCliente();
                    List<TbCliente>lista = dao.listarClientes();
                    for(TbCliente cliente : lista){
            %>
            <tr>
                <td><%= cliente.getIdCliente() %></td>
                <td><%= cliente.getNome() %></td>
                <td><%= cliente.getEmail() %></td>
                <td><%= cliente.getTelefone() %></td>
                <td><%
                       try{
                           dtString = null;
                           dtString = sdf.format(cliente.getDatanascimento());
                           out.println(dtString);
                       }catch(NullPointerException e){
                           out.print("Value " + e.getMessage());
                       }

                        %></td>
                <td><% out.print("<a href=manterCliente?metodo=preencherForm&id_cliente="+cliente.getIdCliente()+" style='text-decoration:none'><input type='submit' value='Atualizar'/></a>"); %></td>
                <td><% out.print("<a href=manterCliente?metodo=excluir&id_cliente="+cliente.getIdCliente()+" style='text-decoration:none'><input type='submit' value='Excluir'/></a>"); %></td>

            </tr>
            <%
                    }
                }catch(Exception e){
                    out.print("Erro "+e);
                }
            %>
        </table>
    </body>
</html>