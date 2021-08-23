package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Empleado extends Persona implements Serializable {
    
@Basic
String cargo;
@OneToOne
Usuario user;

    public Empleado() {
    }

    public Empleado(String cargo, Usuario user, int id_alumno, String dni, String nombre, String apellido, Date fechaNacimiento, String direccion) {
        super(id_alumno, dni, nombre, apellido, fechaNacimiento, direccion);
        this.cargo = cargo;
        this.user = user;
    }
    
   
@Override
    public int getId_alumno() {
        return id_alumno;
    }

@Override
    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
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
