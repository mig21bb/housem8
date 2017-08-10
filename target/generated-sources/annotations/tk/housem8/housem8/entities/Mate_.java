package tk.housem8.housem8.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tk.housem8.housem8.entities.Compensation;
import tk.housem8.housem8.entities.Cost;
import tk.housem8.housem8.entities.Ocupation;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-10T02:06:12")
@StaticMetamodel(Mate.class)
public class Mate_ { 

    public static volatile SingularAttribute<Mate, Date> fechaModificacion;
    public static volatile SingularAttribute<Mate, String> pass;
    public static volatile ListAttribute<Mate, Cost> costList;
    public static volatile SingularAttribute<Mate, Date> fechaBorrado;
    public static volatile SingularAttribute<Mate, Date> birthDate;
    public static volatile ListAttribute<Mate, Ocupation> ocupationList;
    public static volatile SingularAttribute<Mate, String> surname1;
    public static volatile SingularAttribute<Mate, String> surname2;
    public static volatile SingularAttribute<Mate, String> nationality;
    public static volatile SingularAttribute<Mate, String> name;
    public static volatile SingularAttribute<Mate, Date> fechaCreacion;
    public static volatile SingularAttribute<Mate, Integer> id;
    public static volatile ListAttribute<Mate, Compensation> compensationList1;
    public static volatile SingularAttribute<Mate, String> user;
    public static volatile SingularAttribute<Mate, String> email;
    public static volatile SingularAttribute<Mate, Boolean> activo;
    public static volatile ListAttribute<Mate, Compensation> compensationList;

}