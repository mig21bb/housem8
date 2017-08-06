/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.controllers;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import tk.housem8.housem8.delegates.WebDelegate;
import tk.housem8.housem8.entities.Mate;
import tk.housem8.housem8.repos.CostRepository;
import tk.housem8.housem8.repos.HouseRepository;
import tk.housem8.housem8.repos.MateRepository;
import tk.housem8.housem8.repos.OcupationRepository;
import tk.housem8.housem8.repos.RoomRepository;

/**
 *
 * @author Administrador
 */
@Controller
public class WebController {

    @Autowired
    MateRepository mateRepository;
    @Autowired
    CostRepository costRepository;
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    OcupationRepository ocupationRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    WebDelegate WebDelegate;

    /**
     * Get HttpSession and return the user mate
     *
     * @param sess
     * @return
     */
    private Mate getUserMate(HttpSession sess) {

        Mate mate = new Mate();
        try {
            SecurityContextImpl secContext = (SecurityContextImpl) sess.getAttribute("SPRING_SECURITY_CONTEXT");
            if (secContext != null) {
                User user = (User) secContext.getAuthentication().getPrincipal();

                mate = (Mate) mateRepository.findByEmail(user.getUsername());
            } else {
                mate = (Mate) mateRepository.findByEmail("user@example.com");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mate;
    }

    /**
     * Show dashboard from user
     *
     * @param httpSession
     *
     * @param model
     * @return
     */
    @RequestMapping("/myDashboard")
    public String myDashboard(HttpSession httpSession, Model model) {

        String response = "myDashboard";
        Mate mate = new Mate();
        try {

            mate = getUserMate(httpSession);
            model.addAttribute("mate", mate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * Show house parameters to see and edit
     *
     * @param httpSession
     *
     * @param model
     * @return
     */
    @RequestMapping("/myHouse")
    public String myHouse(HttpSession httpSession, Model model) {

        String response = "myHouse";
        Mate mate = new Mate();
        try {

            mate = getUserMate(httpSession);
            model.addAttribute("mate", mate);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * Show house parameters to see and edit
     *
     * @param httpSession
     *
     * @param model
     * @return
     */
    @RequestMapping("/myRoom")
    public String myRoom(HttpSession httpSession, Model model) {

        String response = "myRoom";
        Mate mate = new Mate();
        try {

            mate = getUserMate(httpSession);
            model.addAttribute("mate", mate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * Show Costs list
     *
     * @param httpSession
     *
     * @param model
     * @return
     */
    @RequestMapping("/myCosts")
    public String myCosts(HttpSession httpSession, Model model) {

        String response = "myCosts";
        Mate mate = new Mate();
        try {

            mate = getUserMate(httpSession);
            model.addAttribute("mate", mate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * Show house mates
     *
     * @param httpSession
     *
     * @param model
     * @return
     */
    @RequestMapping("/myMates")
    public String myMates(HttpSession httpSession, Model model) {

        String response = "myMates";
        Mate mate = new Mate();
        try {

            mate = getUserMate(httpSession);
            model.addAttribute("mate", mate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * Form to add a house
     *
     * @param httpSession
     *
     * @param model
     * @return
     */
    @RequestMapping("/newHouse")
    public String newHouse(HttpSession httpSession, Model model) {

        String response = "newHouse";
        Mate mate = new Mate();
        try {

            mate = getUserMate(httpSession);
            model.addAttribute("mate", mate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * Show house parameters to see and edit
     *
     * @param httpSession
     *
     * @param model
     * @return
     */
    @RequestMapping("/newRoom")
    public String newRoom(HttpSession httpSession, Model model) {

        String response = "newRoom";
        Mate mate = new Mate();
        try {

            mate = getUserMate(httpSession);
            model.addAttribute("mate", mate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * Show Costs list
     *
     * @param httpSession
     *
     * @param model
     * @return
     */
    @RequestMapping("/newCost")
    public String newCost(HttpSession httpSession, Model model) {

        String response = "newCost";
        Mate mate = new Mate();
        try {

            mate = getUserMate(httpSession);
            model.addAttribute("mate", mate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * New payment between
     *
     * @param httpSession
     * @param model
     * @return
     */
    @RequestMapping("/newPay")
    public String newPay(HttpSession httpSession, Model model) {

        String response = "newPay";
        Mate mate = new Mate();
        try {

            mate = getUserMate(httpSession);
            model.addAttribute("mate", mate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

}
