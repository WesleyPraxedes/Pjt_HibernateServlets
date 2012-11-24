package servlet1Ind;

import dao.DAOTbCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.TbCliente;

/**
 * @author Wesley
 */
public class PreencheFormAtu extends HttpServlet {
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        //Pegando os parametros do request
        Integer id = Integer.parseInt(request.getParameter("id_cliente"));
        
        //Pesquisando cliente para preecher o form
        DAOTbCliente dao = new DAOTbCliente();
        TbCliente cliente = dao.consultarPorId(id);
        
        //Convertendo data para String
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        String dataString = sdf.format(cliente.getDatanascimento());

        out.println("<html>");
        out.println("<body>");
        out.println("<h4>Formulário para atualização de dados<br/>");
        out.println("Deve-se preencher todos os campos.</h4>");
        out.println("<form method='post' action='atualizar'>"
                    + "Cod. Cliente: <input type='text' name='id_cliente' value='"+cliente.getIdCliente()+"' readonly='readonly' /> <br/>"
                    + "Nome: <input type='text' name='nome' value='"+cliente.getNome()+"' /> <br/>"
                    + "Email: <input type='text' name='email' value='"+cliente.getEmail()+"' /> <br/>"
                    + "Telefone: <input type='text' name='telefone' value='"+cliente.getTelefone()+"' />(Apenas numeros) <br/>"
                    + "Data de nascimento: <input type='text' name='data' value='"+dataString+"' />dd/mm/yyyy (Formado da data) <br/>"
                    + "<input type='submit' value='Atualizar'/>"
                    + "</form>");
        out.println("<br><a href='../pagesJsp1_Ind/index.jsp'>Cancelar</a>");
        out.println("</body>");
        out.println("</html>");
    }
}