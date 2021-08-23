package Servlet;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "altaUsuario", urlPatterns = {"/altaUsuario"})
public class altaUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Crear_user = request.getParameter("Crear_user");
        String Crear_pass = request.getParameter("Crear_pass");
        
        Controladora control = new Controladora ();
        
        boolean flag = control.comprobarUsuario(Crear_user,Crear_pass);
         if (flag == true){
              response.sendRedirect("Login.jsp");
              control.crearUsuario(Crear_user, Crear_pass);
         }
        else{
            response.sendRedirect("CrearUser.jsp");
            }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
