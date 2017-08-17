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
import tk.housem8.housem8.entities.CostFamily;

/**
 *
 * @author Administrador
 */

@CrossOrigin
public interface CostFamilyRepository extends CrudRepository<CostFamily, Integer> {

    @Query("select f from CostFamily f where f.activo='A' and f.fechaBorrado is null"            )
    public List<CostFamily> findAllActive();
    
}