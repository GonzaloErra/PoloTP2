
package Servlet;

import Logica.Controladora;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "altaHuesped", urlPatterns = {"/altaHuesped"})
public class altaHuesped extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        
        String fechaNacimiento = request.getParameter("fechaNacimiento");

        String anio = fechaNacimiento.split("-")[0];
        String mes = fechaNacimiento.split("-")[1];
        String dia = fechaNacimiento.split("-")[2];
        
        System.out.println("Dia "+dia +"Mes "+mes + "Anio "+anio);
        
        String fecha2 = dia+"/"+ mes+"/"+anio;
        System.out.println("esta es la fecha " + fecha2);
        
        Date fechaNacimiento3 = new Date (fecha2);
        System.out.println("Segunda Fecha "+fechaNacimiento3);
        
        Date fechaNacimiento4 = null;
        try {
            fechaNacimiento4 = new SimpleDateFormat("dd/MM/yyyy").parse(fecha2);
        } catch (ParseException ex) {
            Logger.getLogger(altaHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("tercera fecha " + fechaNacimiento4 );
        
        
        String direccion = request.getParameter ("direccion");
        String profeccion = request.getParameter ("profeccion");
        Controladora control = new Controladora ();
        
        
        control.crearHuesped(dni,nombre,apellido,fechaNacimiento4,direccion,profeccion);
        response.sendRedirect("Main.jsp");
    }

    /**
     
     
    
     
    
    
    */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
