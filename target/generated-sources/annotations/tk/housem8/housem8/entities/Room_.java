package tk.housem8.housem8.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tk.housem8.housem8.entities.House;
import tk.housem8.housem8.entities.Ocupation;
import tk.housem8.housem8.entities.RoomClass;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-06T23:05:07")
@StaticMetamodel(Room.class)
public class Room_ { 

    public static volatile SingularAttribute<Room, Float> squareMeters;
    public static volatile SingularAttribute<Room, House> houseId;
    public static volatile SingularAttribute<Room, Integer> id;
    public static volatile SingularAttribute<Room, Boolean> windows;
    public static volatile ListAttribute<Room, Ocupation> ocupationList;
    public static volatile SingularAttribute<Room, RoomClass> roomClass;

}