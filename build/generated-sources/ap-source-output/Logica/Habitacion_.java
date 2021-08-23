package Logica;

import Logica.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-08T20:54:57")
@StaticMetamodel(Habitacion.class)
public class Habitacion_ { 

    public static volatile SingularAttribute<Habitacion, String> piso;
    public static volatile SingularAttribute<Habitacion, String> tipo;
    public static volatile SingularAttribute<Habitacion, Integer> precio;
    public static volatile ListAttribute<Habitacion, Reserva> listaReserva;
    public static volatile SingularAttribute<Habitacion, Integer> id_habitacion;
    public static volatile SingularAttribute<Habitacion, String> nombre;

}