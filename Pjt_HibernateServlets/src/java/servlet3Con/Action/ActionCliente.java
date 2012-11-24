package servlet3Con.Action;

import servlet3Con.ServletController.EncaminharDados;
import dao.DAOTbCliente;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.TbCliente;

/**
 *
 * @author Wesley
 */
public class ActionCliente implements EncaminharDados{
    public void executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=ISO-8859-9");
        PrintWriter out = response.getWriter();
        
        try {
            String metodo = request.getParameter("metodo");      
            
            if (metodo.equals("cadastrar")) {
                out.println(cadastrar(request));                
            } else if (metodo.equals("preencherForm")) {
                out.println(preencherForm(new Integer (request.getParameter("id_cliente"))));                
            } else if (metodo.equals("atualizar")) {
                out.println(atualizar(request));                
            } else if (metodo.equals("excluir")) {
                out.println(excluir(new Integer (request.getParameter("id_cliente"))));                
            }
        } finally {
            out.close();
        }
    }
    
    //  Cadastrar  /////////////////////////////////////////////////////////////
    private String cadastrar (HttpServletRequest request) throws ParseException{
        StringBuilder sb = new StringBuilder();
        
        //Pegando os parametros do request
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        Long telefone = Long.parseLong(request.getParameter("telefone"));
        String dataEmTexto = request.getParameter("data");

        //Monta um objeto contato
        TbCliente cliente = new TbCliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setDatanascimento(new java.sql.Date( new java.text.SimpleDateFormat("dd/mm/yyyy").parse(dataEmTexto).getTime()));

        //Grave nessa conexão!!!
        DAOTbCliente dao = new DAOTbCliente();
        if (dao.adicionar(cliente)) {
            //Imprime messagem comfirmando o cadastro
            sb.append("<h1>O cadastro foi concluido!</h1></br>");
            sb.append("Cliente ").append(cliente.getNome()).append(" adicionado com sucesso<br>");
            sb.append("<br/><br/><a href='../pagesJsp3_Con/index.jsp'>Voltar para CRUD Hibernate + JSP + Servlet 'controladora'</a>");
        } else{
            //Exibe mensagem de erro.
            sb.append("Erro ao realizar cadastro!<br/>");
            sb.append("Tente novamente");
        }
        return sb.toString();
    }
    
    //  Preecheer formulário  //////////////////////////////////////////////////
    private String preencherForm (Integer id){
        StringBuilder sb = new StringBuilder();
        
        //Pesquisando cliente para preecher o form
        DAOTbCliente dao = new DAOTbCliente();
        TbCliente cliente = dao.consultarPorId(id);

        //Convertendo data SQL para String
        String dataString = new java.text.SimpleDateFormat("dd/MM/yyyy").format(cliente.getDatanascimento());
        sb.append("<h4>Formulário para atualização de dados<br/>");
        sb.append("\nDeve-se preencher todos os campos.</h4>");  //'\n' e '\t' Para formatar a saída do código em html,
        sb.append("\n<form method='post' action='servletController'>"  //'\n' e '\t' para conferir de um CTRL+U na pagina do formulário de atualização.
                    + "\n\t<input type='hidden' name='encaminhar' value='ActionCliente'/>"
                    + "\n\t<input type='hidden' name='metodo' value='atualizar'/>"
                    + "\n\tCod. Cliente: <input type='text' name='id_cliente' value='"+cliente.getIdCliente()+"' readonly='readonly' /> <br/>"
                    + "\n\tNome: <input type='text' name='nome' value='"+cliente.getNome()+"' /> <br/>"
                    + "\n\tEmail: <input type='text' name='email' value='"+cliente.getEmail()+"' /> <br/>"
                    + "\n\tTelefone: <input type='text' name='telefone' value='"+cliente.getTelefone()+"' />(Apenas numeros) <br/>"
                    + "\n\tData de nascimento: <input type='text' name='data' value='"+dataString+"' />dd/mm/yyyy (Formado da data) <br/>"
                    + "\n\t<input type='submit' value='Atualizar'/>"
                    + "\n</form>");
        sb.append("\n<br/>\n<a href='../pagesJsp3_Con/index.jsp'>Cancelar</a>");
        return sb.toString();
    }
    
    //  Atualizar  /////////////////////////////////////////////////////////////
    private String atualizar (HttpServletRequest request) throws ParseException{
        StringBuilder sb = new StringBuilder();
        
        //Pegando os parametros do request
        Integer id = Integer.parseInt(request.getParameter("id_cliente"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        Long telefone = Long.parseLong(request.getParameter("telefone"));
        String dataEmTexto = request.getParameter("data");

        //Monta um objeto contato
        TbCliente cliente = new TbCliente();
        cliente.setIdCliente(id);//Id do cliente a ser alterado
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setDatanascimento(new java.sql.Date( new java.text.SimpleDateFormat("dd/mm/yyyy").parse(dataEmTexto).getTime()));

        DAOTbCliente dao = new DAOTbCliente();
        if (dao.alterar(cliente)) {
            //Imprime messagem comfirmando atualização
            sb.append("<h1>O cadastro foi atualizado!</h1><br/>");
            sb.append("Cliente " + cliente.getNome() + " atualizado com sucesso<br/>");
            sb.append("<br/><br/><a href='../pagesJsp3_Con/index.jsp'>Voltar para CRUD Hibernate + JSP + Servlet 'mapeamento coletivo'</a>");
        } else{
            //Exibe mensagem de erro.
            sb.append("Erro ao realizar a atualização!<br/>");
            sb.append("Tente novamente");
        }
        return sb.toString();
    }
    
    //  Excluir  ///////////////////////////////////////////////////////////////
    private String excluir (Integer id){
        StringBuilder sb = new StringBuilder();

        //Busca o cliente e monta vo
        DAOTbCliente dao = new DAOTbCliente();
        TbCliente cliente = dao.consultarPorId(id);

        //Envia vo do cliente para o método exclir
        if (dao.deletar(cliente)) {
            //Imprime messagem comfirmando exclusão
            sb.append("<h1>O cliente foi deletado!</h1><br/>");
            sb.append("Cliente " + cliente.getNome() + " deletado com sucesso</br>");
            sb.append("<br/><br/><a href='../pagesJsp3_Con/index.jsp'>Voltar para CRUD Hibernate + JSP + Servlet 'mapeamento coletivo'</a>");
        } else{
            //Exibe mensagem de erro.
            sb.append("Erro ao deletar cliente!<br/>");
            sb.append("Tente novamente");
        }
        return sb.toString();
    }
}