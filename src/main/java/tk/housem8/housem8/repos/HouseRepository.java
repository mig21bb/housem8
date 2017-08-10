/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.repos;

import java.util.Date;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import tk.housem8.housem8.entities.House;

/**
 *
 * @author Administrador
 */
@CrossOrigin
public interface HouseRepository extends CrudRepository<House, Integer> {
    /*
    @Query("select h from House as h "
            + "join h.room as room join room.ocupation as oc join oc.mate mate"
            + "where mate.mateId = :mateId and oc.startDate < :date and oc.endDate > :date")
    public House findByMate(@Param("mateId") Integer mateId,@Param("date") Date date);
    */
}
