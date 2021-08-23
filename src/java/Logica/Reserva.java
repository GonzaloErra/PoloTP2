
package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)        
    int id_reserva;
    
    @Temporal(TemporalType.DATE)
    Date dia;
    
    @Temporal(TemporalType.DATE)
    Date inn;
    
    @Temporal(TemporalType.DATE)
    Date outt;

    public Reserva() {
    }

    public Reserva(int id_reserva, Date dia, Date inn, Date outt) {
        this.id_reserva = id_reserva;
        this.dia = dia;
        this.inn = inn;
        this.outt = outt;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Date getInn() {
        return inn;
    }

    public void setInn(Date inn) {
        this.inn = inn;
    }

    public Date getOutt() {
        return outt;
    }

    public void setOutt(Date outt) {
        this.outt = outt;
    }
    

}