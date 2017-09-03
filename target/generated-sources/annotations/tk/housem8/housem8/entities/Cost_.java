package tk.housem8.housem8.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tk.housem8.housem8.entities.Commerce;
import tk.housem8.housem8.entities.CostFamily;
import tk.housem8.housem8.entities.House;
import tk.housem8.housem8.entities.Mate;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-03T23:37:28")
@StaticMetamodel(Cost.class)
public class Cost_ { 

    public static volatile SingularAttribute<Cost, Integer> period;
    public static volatile SingularAttribute<Cost, Float> amount;
    public static volatile SingularAttribute<Cost, Date> fechaModificacion;
    public static volatile SingularAttribute<Cost, House> houseId;
    public static volatile SingularAttribute<Cost, String> description;
    public static volatile SingularAttribute<Cost, Date> fechaBorrado;
    public static volatile SingularAttribute<Cost, Commerce> commerce;
    public static volatile SingularAttribute<Cost, Mate> mateId;
    public static volatile SingularAttribute<Cost, Date> datetime;
    public static volatile SingularAttribute<Cost, Date> fechaCreacion;
    public static volatile SingularAttribute<Cost, Integer> id;
    public static volatile SingularAttribute<Cost, CostFamily> costFamily;
    public static volatile SingularAttribute<Cost, Boolean> activo;

}