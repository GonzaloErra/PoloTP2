package Logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Habitacion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)        
    int id_habitacion;
    
    @Basic
    String piso;
    String nombre;
    String tipo;
    int precio;
    
    @OneToMany
    List <Reserva> listaReserva;

    public Habitacion() {
    }

    public Habitacion(int id_habitacion, String piso, String nombre, String tipo, int precio, List<Reserva> listaReserva) {
        this.id_habitacion = id_habitacion;
        this.piso = piso;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.listaReserva = listaReserva;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }
    

}