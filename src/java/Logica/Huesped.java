package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Huesped extends Persona implements Serializable {
   
    @Basic
    String profesion;
    
    @OneToMany
    List <Reserva> listaReserva;

    public Huesped() {
    }

    public Huesped(String profesion, List<Reserva> listaReserva, int id_alumno, String dni, String nombre, String apellido, Date fechaNacimiento, String direccion) {
        super(id_alumno, dni, nombre, apellido, fechaNacimiento, direccion);
        this.profesion = profesion;
        this.listaReserva = listaReserva;
    }
    
    
    @Override
    public int getId_alumno() {
        return id_alumno;
    }

    @Override
    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }
 
    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String getApellido() {
        return apellido;
    }
    @Override
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    @Override
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    @Override
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    @Override
    public String getDireccion() {
        return direccion;
    }
    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

        
}
