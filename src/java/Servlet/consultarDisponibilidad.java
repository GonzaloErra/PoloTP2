package Servlet;

import Logica.Controladora;
import Logica.Habitacion;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "consultarDisponibilidad", urlPatterns = {"/consultarDisponibilidad"})
public class consultarDisponibilidad extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
	
@Override	
protected void doPost(HttpServletRequest request, HttpServletResponse response)	
throws ServletException, IOException {	
        processRequest(request, response);	

        
        String checkin =request.getParameter("checkin");	
        String checkout = request.getParameter("checkout");	

        Controladora control = new Controladora ();	
      
        List<Habitacion> HabitacionNOocupadas = control.verificarDisponibilidad(checkin,checkout);
              
        request.setAttribute("HabitacionNOocupadas", HabitacionNOocupadas);	
        request.getRequestDispatcher("ConsultarR.jsp").forward(request,response);	
        response.sendRedirect("Reserva.jsp");
}
@Override
public String getServletInfo() {
    return "Short description";
}
}
