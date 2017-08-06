package tk.housem8.housem8.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tk.housem8.housem8.entities.TableName;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-05T20:10:20")
@StaticMetamodel(Pictures.class)
public class Pictures_ { 

    public static volatile SingularAttribute<Pictures, TableName> tABLENAMEid;
    public static volatile SingularAttribute<Pictures, Date> datetime;
    public static volatile SingularAttribute<Pictures, Integer> dataId;
    public static volatile SingularAttribute<Pictures, byte[]> active;
    public static volatile SingularAttribute<Pictures, Integer> id;
    public static volatile SingularAttribute<Pictures, String> url;

}