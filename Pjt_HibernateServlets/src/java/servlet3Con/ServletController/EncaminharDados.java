package servlet3Con.ServletController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface EncaminharDados {
    void executa(HttpServletRequest request, HttpServletResponse response)
            throws Exception;
}