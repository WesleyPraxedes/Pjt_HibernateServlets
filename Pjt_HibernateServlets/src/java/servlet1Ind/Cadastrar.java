package servlet1Ind;

import dao.DAOTbCliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.TbCliente;

/**
 * @author Wesley
 */
public class Cadastrar extends HttpServlet {
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
            
        java.sql.Date dtSQL = new java.sql.Date(System.currentTimeMillis());
        
        //Pegando os parametros do request
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        Long telefone = Long.parseLong(request.getParameter("telefone"));
        String dataEmTexto = request.getParameter("data");
        
        //Fazendo converção da data
        try {
            dtSQL = new java.sql.Date( new java.text.SimpleDateFormat("dd/mm/yyyy").parse(dataEmTexto).getTime());
        } catch (ParseException e) {
            out.println("Erro de converção da data." +e);
        }
            
        //Monta um objeto contato
        TbCliente cliente = new TbCliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setDatanascimento(dtSQL);
        
        //Grave nessa conexão!!!
        DAOTbCliente dao = new DAOTbCliente();
        if (dao.adicionar(cliente)) {
            //Imprime messagem comfirmando o cadastro
            out.println("<html>");
            out.println("<body>");
            out.println("<h3>O cadastro foi concluido!<h3></br>");
            out.println("Cliente " + cliente.getNome() + " adicionado com sucesso</br>");
            out.println("<br><br><a href='../pagesJsp1_Ind/index.jsp'>Voltar para CRUD Hibernate + JSP + Servlet 'individual'</a>");
            out.println("</body>");
            out.println("</html>");
        } else{
            //Exibe mensagem de erro.
            out.println("<html>");
            out.println("<body>");
            out.println("Erro ao realizar cadastro!</br>");
            out.println("Tente novamente");
            out.println("</body>");
            out.println("</html>");
        }
    }    
}
