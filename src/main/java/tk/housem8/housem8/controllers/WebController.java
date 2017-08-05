/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.controllers;

import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import tk.housem8.housem8.entities.Mate;
import tk.housem8.housem8.repos.MateRepository;

/**
 *
 * @author Administrador
 */

@Controller
public class WebController {
    
    @Autowired
    MateRepository mateRepository;

    @RequestMapping("/")
    public String index( Model model) {
        
        List<Mate> mates = (List<Mate>) mateRepository.findAll();
        
        model.addAttribute("date", Calendar.getInstance().getTime().toString());
        model.addAttribute("mates", mates);
        
        return "index";
    }
    
    @RequestMapping("/login")
    public String logPage( Model model) {
        
        return "login";
                
    }
    /*
    @RequestMapping("/logIn")
    public String logIn( Model model, String user, String Password) {
        
        System.out.println("Logging in");
        
        return "logPage";
    }
*/

}
