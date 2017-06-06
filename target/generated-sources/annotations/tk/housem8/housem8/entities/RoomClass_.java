package tk.housem8.housem8.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tk.housem8.housem8.entities.Room;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T01:19:55")
@StaticMetamodel(RoomClass.class)
public class RoomClass_ { 

    public static volatile SingularAttribute<RoomClass, String> description;
    public static volatile SingularAttribute<RoomClass, Integer> id;
    public static volatile SingularAttribute<RoomClass, String> category;
    public static volatile ListAttribute<RoomClass, Room> roomList;

}