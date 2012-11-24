package servlet3Con.ServletController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletController extends HttpServlet{
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        String parametro = request.getParameter("encaminhar");
        String nomeDaClasse = "servlet3Con.Action." + parametro;
        
        try {
            
            Class classe = Class.forName(nomeDaClasse);
            EncaminharDados servlet = (EncaminharDados) classe.newInstance();
            servlet.executa(request, response);
            
        } catch (Exception e) {
            throw new ServletException("A logica de negócios causou uma exceção", e);
        }
    }
}