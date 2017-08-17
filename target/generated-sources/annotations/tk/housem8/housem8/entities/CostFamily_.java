package tk.housem8.housem8.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-17T02:13:25")
@StaticMetamodel(CostFamily.class)
public class CostFamily_ { 

    public static volatile SingularAttribute<CostFamily, Integer> period;
    public static volatile SingularAttribute<CostFamily, Date> fechaModificacion;
    public static volatile SingularAttribute<CostFamily, String> name;
    public static volatile SingularAttribute<CostFamily, String> description;
    public static volatile SingularAttribute<CostFamily, Date> fechaCreacion;
    public static volatile SingularAttribute<CostFamily, Integer> id;
    public static volatile SingularAttribute<CostFamily, Date> fechaBorrado;
    public static volatile SingularAttribute<CostFamily, Boolean> activo;

}