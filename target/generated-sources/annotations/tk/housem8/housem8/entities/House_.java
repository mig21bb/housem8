package tk.housem8.housem8.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tk.housem8.housem8.entities.Cost;
import tk.housem8.housem8.entities.Room;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-11T01:44:27")
@StaticMetamodel(House.class)
public class House_ { 

    public static volatile SingularAttribute<House, String> country;
    public static volatile SingularAttribute<House, String> other;
    public static volatile SingularAttribute<House, Float> squareMeters;
    public static volatile SingularAttribute<House, Date> fechaModificacion;
    public static volatile SingularAttribute<House, String> city;
    public static volatile ListAttribute<House, Cost> costList;
    public static volatile SingularAttribute<House, Date> fechaBorrado;
    public static volatile SingularAttribute<House, String> cp;
    public static volatile SingularAttribute<House, Integer> number;
    public static volatile SingularAttribute<House, String> street;
    public static volatile SingularAttribute<House, Date> fechaCreacion;
    public static volatile SingularAttribute<House, Integer> id;
    public static volatile SingularAttribute<House, Integer> floor;
    public static volatile SingularAttribute<House, String> apartment;
    public static volatile ListAttribute<House, Room> roomList;
    public static volatile SingularAttribute<House, Boolean> activo;

}