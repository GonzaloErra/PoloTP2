package Servlet;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "servletLogin", urlPatterns = {"/servletLogin"})
public class servletLogin extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        Controladora control = new Controladora();
        boolean flag = control.comprobarIngreso(user,pass);
        
        if (flag == true){
            HttpSession misession = request.getSession(true);
            misession.setAttribute("user", user);
            misession.setAttribute("pass", pass);
            response.sendRedirect("Main.jsp");
        }
        else{
            response.sendRedirect("Login.jsp");    
                    }
    }

  
    
    
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
