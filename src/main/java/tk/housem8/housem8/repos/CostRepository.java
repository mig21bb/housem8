/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.repos;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import tk.housem8.housem8.entities.Cost;

/**
 *
 * @author Administrador
 */
@CrossOrigin
public interface CostRepository extends CrudRepository<Cost, Integer> {

    @Query("select c from Cost c where c.mateId.id=:mateId and c.houseId.id=:houseId and c.datetime BETWEEN :startDate AND :endDate"
            )
    public List<Cost> findByMateAndHouse(@Param("mateId") Integer mateId,
                                         @Param("houseId") Integer houseId,
                                         @Param("startDate") Date startDate,
                                         @Param("endDate") Date endDate);
    
}
