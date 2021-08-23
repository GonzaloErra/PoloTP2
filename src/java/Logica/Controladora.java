package Logica;

import Persistencia.ControladoraPersistencia;
import Persistencia.exceptions.NonexistentEntityException;
import Servlet.altaHuesped;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Nexo servlet y ControladoraPersistencia */
public class Controladora {
    ControladoraPersistencia ControlPersist = new ControladoraPersistencia();
    
   
    public void crearHuesped(String dni, String nombre, String apellido, Date fechaNacimiento, String direccion, String profeccion) {
        Huesped hues = new Huesped();
        
        hues.setDni(dni);
        hues.setNombre(nombre);
        hues.setApellido(apellido);
        hues.setFechaNacimiento(fechaNacimiento);
        hues.setDireccion(direccion);
        hues.setProfesion(profeccion);
        
        ControlPersist.crearHuesped(hues);
    }

    public boolean comprobarIngreso(String user, String pass) {
                
        List<Usuario> listaUsuario = ControlPersist.getUsuario();
        
        if(listaUsuario != null){ 
            for(Usuario usu : listaUsuario){
                if (usu.getUser().equals(user) && usu.getPass().equals(pass)){
                
                return true;
                }
            }
        }
       return false;   
    }
     
    public boolean comprobarUsuario(String Crear_user, String Crear_pass) {
                
        List<Usuario> listaUsuario = ControlPersist.getUsuario();
        
        if(listaUsuario != null){ 
            for(Usuario usu : listaUsuario){
                if (usu.getUser().equals(Crear_user) && usu.getPass().equals(Crear_pass)){
                return false;
                }
            }
            return true;   
        }
       return false;
    }
    
    public void crearUsuario(String Crear_user, String Crear_pass) {
       Usuario user = new Usuario();
        
        user.setUser(Crear_user);
        user.setPass(Crear_pass);
               
        ControlPersist.crearUsuario(user);
    }
    
    public List<Habitacion> verificarDisponibilidad(String checkin, String checkout) {

    List<Habitacion> listaHabitaciones = ControlPersist.traerHabitaciones();
    List<Reserva> listaReservas = ControlPersist.traerReservas();
    
        
        //CAMBIO DE FECHA

        String anio = checkin.split("-")[0];
        String mes = checkin.split("-")[1];
        String dia = checkin.split("-")[2];
        String checkin1 = dia+"/"+ mes+"/"+anio;
        Date checkin2 = null;
        try {
        checkin2 = new SimpleDateFormat("dd/MM/yyyy").parse(checkin1);
        } catch (ParseException ex) {
        Logger.getLogger(altaHuesped.class.getName()).log(Level.SEVERE, null, ex);
        }

        String anio2 = checkout.split("-")[0];
        String mes2 = checkout.split("-")[1];
        String dia2 = checkout.split("-")[2];
        String checkout1 = dia2+"/"+ mes2+"/"+anio2;
        Date checkout2 = null;
    try {
    checkout2 = new SimpleDateFormat("dd/MM/yyyy").parse(checkout1);
    } catch (ParseException ex) {
    Logger.getLogger(altaHuesped.class.getName()).log(Level.SEVERE, null, ex);
    }
    List <Integer> habitaciones_nodisp = new ArrayList<>();
    
    System.out.println("OUT " + checkout2);
    System.out.println("IN " + checkin2);

        for(Habitacion hab : listaHabitaciones){
            if ((hab.getListaReserva()).size()>= 1) {

                for(Reserva res : listaReservas){
                if((checkin2.before(res.getOutt())) && (checkin2.after(res.getInn()))){ // Ocupada
                habitaciones_nodisp.add(hab.getId_habitacion()) ;
                break;
                }
                else if((checkout2.after(res.getInn())) && (checkout2.before(res.getOutt()))){ // Ocupada
                habitaciones_nodisp.add(hab.getId_habitacion()) ;
                break;
                }
                else if (checkin2.equals(res.getInn())){
                habitaciones_nodisp.add(hab.getId_habitacion()) ;
                break;
                }
                else if ((checkin2.before(res.getInn())) && (checkout2.after(res.getOutt())))
                habitaciones_nodisp.add(hab.getId_habitacion()) ;
                }
            }
        }
        List<Habitacion> listaDisponibles = new ArrayList<>();
        System.out.println("LISTAS NO DISPONIBLES " + habitaciones_nodisp);   
        for(Habitacion hab : listaHabitaciones){
            if (habitaciones_nodisp.size()>= 1) {
                if(!habitaciones_nodisp.contains(hab.getId_habitacion())){
                listaDisponibles.add(hab);
                }}
                else{
                listaDisponibles.add(hab);
                }
        }
        
        System.out.println("LISTAS DISPONIBLES " + listaDisponibles);
        return listaDisponibles;

}

    public void crear_Reserva(String checkin, String checkout, int NUM_Reserva) {
        
    Reserva res = new Reserva();

    //CAMBIO DE FECHA
    String anio = checkin.split("-")[0];
    String mes = checkin.split("-")[1];
    String dia = checkin.split("-")[2];
    String checkin1 = dia+"/"+ mes+"/"+anio;
    Date checkin2 = null;
    try {
    checkin2 = new SimpleDateFormat("dd/MM/yyyy").parse(checkin1);
    } catch (ParseException ex) {
    Logger.getLogger(altaHuesped.class.getName()).log(Level.SEVERE, null, ex);
    }

    String anio2 = checkout.split("-")[0];
    String mes2 = checkout.split("-")[1];
    String dia2 = checkout.split("-")[2];
    String checkout1 = dia2+"/"+ mes2+"/"+anio2;
    Date checkout2 = null;

    try {
    checkout2 = new SimpleDateFormat("dd/MM/yyyy").parse(checkout1);
    } catch (ParseException ex) {
    Logger.getLogger(altaHuesped.class.getName()).log(Level.SEVERE, null, ex);
    }

    res.setInn(checkin2);
    res.setOutt(checkout2);
    res.setId_reserva(NUM_Reserva);
    ControlPersist.crearReserva(res);    
    }

    public int NUM_Reserva() {
        
    List<Reserva> listareservas = ControlPersist.traerReservas();
    int id_max = 0;
    if(listareservas != null){
    for (Reserva res: listareservas){
        if (id_max < res.getId_reserva()){
        id_max = res.getId_reserva();
        }
    }
    return id_max;    
    }
    return id_max + 1;
    }
    public int Relacion_Reserva_Huesped(String dnihuesp) {
        List<Huesped> listahuespedes = ControlPersist.traerHuespedes();

        for(Huesped hues : listahuespedes){
        if (hues.getDni().equals(dnihuesp)) {
        return hues.getId_alumno();
        }
        }
        return -1;}
    
    public Huesped buscarHuesped(int id_huesped) {
        return ControlPersist.buscarHuesped(id_huesped);
    }

    public Reserva buscarReserva(int num_res_final) {
        return ControlPersist.buscarReserva(num_res_final);    }

    public void ModificarHuesped(Huesped hues) throws Exception {
        ControlPersist.ModificarHuesped(hues);  
    }

    public int BuscarHabitacion(String nombrehab) {
        List<Habitacion> listahabitacion = ControlPersist.traerHabitaciones();

        for(Habitacion hab : listahabitacion){
            if (hab.getNombre().equals(nombrehab)) {
            return hab.getId_habitacion();
            }
        }
        return -1;    
    }

    public Habitacion BuscarHabitacionid(int id_hab) {
        return ControlPersist.BuscarHabitacionid(id_hab);
    }

    public void ModificarHabitacion(Habitacion hab) throws Exception {
        ControlPersist.ModificarHabitacion(hab);      
    }
    
    public List<Huesped> traerHuespedes() {
        return ControlPersist.traerHuespedes();
    }
    public List<Reserva> traerReservas() {
        return ControlPersist.traerReservas();
    }
    public List<Habitacion> traerHabitacion() {
        return ControlPersist.traerHabitaciones();
    }
    public void borrarHuesped(int id) throws NonexistentEntityException {
        ControlPersist.borrarHuesped(id);
    }
    
}