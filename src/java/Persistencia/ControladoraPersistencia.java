package Persistencia;

import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
  
    EmpleadoJpaController empleadoJPA = new EmpleadoJpaController();
    HabitacionJpaController habitacionJPA = new HabitacionJpaController();
    HuespedJpaController huespedJPA = new HuespedJpaController();
    ReservaJpaController reservaJPA = new ReservaJpaController();
    UsuarioJpaController usuarioJPA = new UsuarioJpaController();

    public void crearReserva(Reserva reserv) {
        try {
            reservaJPA.create(reserv);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void crearHuesped(Huesped hues) {
        huespedJPA.create(hues);
    }
    
    public List<Usuario> getUsuario(){
        
        return usuarioJPA.findUsuarioEntities();
    }

    public void crearUsuario(Usuario user) {
            usuarioJPA.create(user);
    }

    public List<Habitacion> traerHabitaciones() {
        return habitacionJPA.findHabitacionEntities();
    }

    public List<Reserva> traerReservas() {
    return reservaJPA.findReservaEntities();    
    }

    public List<Huesped> traerHuespedes() {
    return huespedJPA.findHuespedEntities();        
    }

    public Huesped buscarHuesped(int id_huesped) {
        return huespedJPA.findHuesped(id_huesped);        
    }

    public Reserva buscarReserva(int num_res_final) {
    return reservaJPA.findReserva(num_res_final);            
    }

    public Habitacion BuscarHabitacionid(int id_hab) {
        return habitacionJPA.findHabitacion(id_hab);
    }
    
    public void ModificarHabitacion(Habitacion hab) throws Exception {
         habitacionJPA.edit(hab);        
    }

    public void ModificarHuesped(Huesped hues) throws Exception {
        huespedJPA.edit(hues);
    }

    public void borrarHuesped(int id) {
        try {
            huespedJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    