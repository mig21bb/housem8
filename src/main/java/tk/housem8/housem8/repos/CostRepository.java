/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.repos;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import tk.housem8.housem8.entities.Cost;

/**
 *
 * @author Administrador
 */
@CrossOrigin
public interface CostRepository extends CrudRepository<Cost, Integer> {

    @Query("SELECT h FROM House h "
            + "left JOIN h.roomList r JOIN r.ocupationList o JOIN o.mate m "
            + "WHERE o.startDate < CURRENT_DATE and (o.endDate > CURRENT_DATE or o.endDate is null) and  m.id= :mateId"
            )
    public List<Cost> findByMate(Integer id);
    
}
