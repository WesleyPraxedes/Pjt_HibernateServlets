package servlet2Col;

import dao.DAOTbCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.TbCliente;

public class ServletManterCliente extends HttpServlet{
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();
        
        try {
            
            String metodo = request.getParameter("metodo");
            
            //  Cadastrar  /////////////////////////////////////////////////////
            if (metodo.equals("cadastrar")){
        
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
                cliente.setDatanascimento(new java.sql.Date( new java.text.SimpleDateFormat("dd/mm/yyyy").parse(dataEmTexto).getTime())); // Assim dispensa usar o import para ParseException

                //Grave nessa conexão!!!
                DAOTbCliente dao = new DAOTbCliente();
                if (dao.adicionar(cliente)) {
                    //Imprime messagem comfirmando o cadastro
                    out.println("<html>");
                    out.println("<body>");
                    out.println("<h1>O cadastro foi concluido!</h1></br>");
                    out.println("Cliente " + cliente.getNome() + " adicionado com sucesso</br>");
                    out.println("<br><br><a href='../pagesJsp2_Col/index.jsp'>Voltar para CRUD Hibernate + JSP + Servlet 'coletiva'</a>");
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
            }// Fim Cadastrar
                
            //  Preecheer formulário  //////////////////////////////////////////
            else if (metodo.equals("preencherForm")){
           
                //Pegando os parametros do request
                Integer id = Integer.parseInt(request.getParameter("id_cliente"));

                //Pesquisando cliente para preecher o form
                DAOTbCliente dao = new DAOTbCliente();
                TbCliente cliente = dao.consultarPorId(id);

                //Convertendo data SQL para String
                String dataString = new java.text.SimpleDateFormat("dd/MM/yyyy").format(cliente.getDatanascimento());

                
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
                out.println("<br><a href='../pagesJsp2_Col/index.jsp'>Cancelar</a>");
                out.println("</body>");
                out.println("</html>");
            }// Fim Preecheer
                
            //  Atualizar  /////////////////////////////////////////////////////
            else if (metodo.equals("atualizar")){
        
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
                    out.println("<html>");
                    out.println("<body>");
                    out.println("<h1>O cadastro foi atualizado!</h1></br>");
                    out.println("Cliente " + cliente.getNome() + " atualizado com sucesso</br>");
                    out.println("<br><br><a href='../pagesJsp2_Col/index.jsp'>Voltar para CRUD Hibernate + JSP + Servlet 'coletiva'</a>");
                    out.println("</body>");
                    out.println("</html>");
                } else{
                    //Exibe mensagem de erro.
                    out.println("<html>");
                    out.println("<body>");
                    out.println("Erro ao realizar a atualização!</br>");
                    out.println("Tente novamente");
                    out.println("</body>");
                    out.println("</html>");
                }
            }// Fim Atualizar
                
            //  Excluir  ///////////////////////////////////////////////////////
            else if (metodo.equals("excluir")){
                //Id do cliente a ser deletado
                Integer id = Integer.parseInt(request.getParameter("id_cliente"));
                
                //Busca o cliente e monta vo
                DAOTbCliente dao = new DAOTbCliente();
                TbCliente cliente = dao.consultarPorId(id);

                //Envia vo do cliente para o método exclir
                if (dao.deletar(cliente)) {
                    //Imprime messagem comfirmando exclusão
                    out.println("<html>");
                    out.println("<body>");
                    out.println("<h1>O cliente foi deletado!</h1></br>");
                    out.println("Cliente " + cliente.getNome() + " deletado com sucesso</br>");
                    out.println("<br><br><a href='../pagesJsp2_Col/index.jsp'>Voltar para CRUD Hibernate + JSP + Servlet 'coletiva'</a>");
                    out.println("</body>");
                    out.println("</html>");
                } else{
                    //Exibe mensagem de erro.
                    out.println("<html>");
                    out.println("<body>");
                    out.println("Erro ao deletar cliente!</br>");
                    out.println("Tente novamente");
                    out.println("</body>");
                    out.println("</html>");
                }
            }// Fim Excluir
            
        } catch (Exception e) {
            out.print("Erro" + e.getMessage());
        }
    }
}