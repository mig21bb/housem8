package tk.housem8.housem8.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import tk.housem8.housem8.entities.Room;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-06T01:19:55")
@StaticMetamodel(House.class)
public class House_ { 

    public static volatile SingularAttribute<House, String> country;
    public static volatile SingularAttribute<House, Integer> number;
    public static volatile SingularAttribute<House, String> other;
    public static volatile SingularAttribute<House, Float> squareMeters;
    public static volatile SingularAttribute<House, String> city;
    public static volatile SingularAttribute<House, String> street;
    public static volatile SingularAttribute<House, Integer> id;
    public static volatile SingularAttribute<House, Integer> floor;
    public static volatile SingularAttribute<House, String> cp;
    public static volatile SingularAttribute<House, String> apartment;
    public static volatile ListAttribute<House, Room> roomList;

}