package tk.housem8.housem8.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tk.housem8.housem8.entities.Pictures;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-05T20:10:20")
@StaticMetamodel(TableName.class)
public class TableName_ { 

    public static volatile ListAttribute<TableName, Pictures> picturesList;
    public static volatile SingularAttribute<TableName, Integer> id;
    public static volatile SingularAttribute<TableName, String> tableName;

}