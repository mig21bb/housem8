package tk.housem8.housem8.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tk.housem8.housem8.entities.Mate;
import tk.housem8.housem8.entities.Room;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-03T23:37:28")
@StaticMetamodel(Ocupation.class)
public class Ocupation_ { 

    public static volatile SingularAttribute<Ocupation, Date> fechaModificacion;
    public static volatile SingularAttribute<Ocupation, Date> endDate;
    public static volatile SingularAttribute<Ocupation, Mate> mate;
    public static volatile SingularAttribute<Ocupation, Date> fechaCreacion;
    public static volatile SingularAttribute<Ocupation, Integer> id;
    public static volatile SingularAttribute<Ocupation, Date> fechaBorrado;
    public static volatile SingularAttribute<Ocupation, Date> startDate;
    public static volatile SingularAttribute<Ocupation, Room> room;
    public static volatile SingularAttribute<Ocupation, Boolean> activo;

}