package tk.housem8.housem8.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tk.housem8.housem8.entities.Mate;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-17T02:13:25")
@StaticMetamodel(Compensation.class)
public class Compensation_ { 

    public static volatile SingularAttribute<Compensation, Float> amount;
    public static volatile SingularAttribute<Compensation, Date> datetime;
    public static volatile SingularAttribute<Compensation, String> notes;
    public static volatile SingularAttribute<Compensation, Date> fechaModificacion;
    public static volatile SingularAttribute<Compensation, Mate> receiver;
    public static volatile SingularAttribute<Compensation, Date> fechaCreacion;
    public static volatile SingularAttribute<Compensation, Integer> id;
    public static volatile SingularAttribute<Compensation, Date> fechaBorrado;
    public static volatile SingularAttribute<Compensation, Mate> payer;
    public static volatile SingularAttribute<Compensation, Boolean> activo;

}