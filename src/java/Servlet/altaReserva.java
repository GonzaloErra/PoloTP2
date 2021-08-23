package Servlet;

import Logica.Controladora;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import java.io.IOException;
import static java.time.Instant.now;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "altaReserva", urlPatterns = {"/altaReserva"})
public class altaReserva extends HttpServlet {

  
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
        String dnihuesp = request.getParameter("dni");
        String nombrehab = request.getParameter("Habitacion");
        Controladora control = new Controladora ();
        
        //        Creo Reserva, luego la busco
        int IdReserva = control.NUM_Reserva();
        int NumeroReserva = IdReserva+1;
        control.crear_Reserva(checkin,checkout,NumeroReserva);


        int id_huesped = control.Relacion_Reserva_Huesped(dnihuesp);
        Huesped hues = control.buscarHuesped(id_huesped);
        if (id_huesped == -1){
        response.sendRedirect("Huesped.jsp");
        }
        //        Modifico la lista reserva del huesped
        List<Reserva> listaReservas = hues.getListaReserva();
        Reserva res = control.buscarReserva(NumeroReserva);
        listaReservas.add(res);
        hues.setListaReserva(listaReservas);
        
        try {
            control.ModificarHuesped(hues);
        } catch (Exception ex) {
            Logger.getLogger(altaReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        //        Modifico la habitacion
        int id_hab = control.BuscarHabitacion(nombrehab);
        
        Habitacion hab = control.BuscarHabitacionid(id_hab);
        
        if (id_huesped == -1){
        response.sendRedirect("Main.jsp");
        }
        
        List<Reserva> listaReservas2 = hab.getListaReserva();
        
        Reserva res2 = control.buscarReserva(NumeroReserva);
        listaReservas2.add(res2);

        System.out.println("Reservas de la habitaicon que trajo " + listaReservas2);

        hab.setListaReserva(listaReservas2);
        
        try {
            control.ModificarHabitacion(hab);
        } catch (Exception ex) {
            Logger.getLogger(altaReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("Main.jsp");
       
    }
        
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
