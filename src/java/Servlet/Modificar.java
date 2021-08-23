package Servlet;

import Logica.Controladora;
import Logica.Huesped;
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


@WebServlet(name = "Modificar", urlPatterns = {"/Modificar"})
public class Modificar extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter ("direccion");
        String profeccion = request.getParameter ("profeccion");
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
        
        int id;	
        id = Integer.parseInt(request.getParameter("id"));
        
        Controladora control = new Controladora ();
        
        Huesped hues = control.buscarHuesped(id);
        
        hues.setNombre(nombre);
        hues.setApellido(apellido);
        hues.setDireccion(direccion);
        hues.setDni(dni);
        hues.setFechaNacimiento(fechaNacimiento4);
        hues.setProfesion(profeccion);
        
        try {
            control.ModificarHuesped(hues);
        } catch (Exception ex) {
            Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getSession().setAttribute("listaHuesped", control.traerHuespedes());
        response.sendRedirect("ConsultarH.jsp");
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        int id;	
        id = Integer.parseInt(request.getParameter("id"));
        
        Controladora control = new Controladora();	
        Huesped hues = control.buscarHuesped(id);
        
        request.getSession().setAttribute("huesped", hues);	
        response.sendRedirect("modificarHuesped.jsp");
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
