/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.repos;

import org.springframework.data.repository.CrudRepository;
import tk.housem8.housem8.entities.House;

/**
 *
 * @author Administrador
 */

public interface HouseRepository extends CrudRepository<House, Long> {
    
}