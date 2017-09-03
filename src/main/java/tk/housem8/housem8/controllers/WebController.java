/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.housem8.housem8.controllers;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.housem8.housem8.delegates.WebDelegate;
import tk.housem8.housem8.entities.Commerce;
import tk.housem8.housem8.entities.Cost;
import tk.housem8.housem8.entities.CostFamily;
import tk.housem8.housem8.entities.House;
import tk.housem8.housem8.entities.Mate;
import tk.housem8.housem8.pojos.Period;
import tk.housem8.housem8.repos.CommerceRepository;
import tk.housem8.housem8.repos.CostFamilyRepository;
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
    CostFamilyRepository costFamilyRepository;
    @Autowired
    CommerceRepository commerceRepository;
    @Autowired
    WebDelegate webDelegate;

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
            House userHouse = houseRepository.findByMate(mate.getId());
            
            List<House> userHouses = houseRepository.findAllActiveByMaker(mate.getId());
            
            if(!userHouses.contains(userHouse)){
                userHouses.add(userHouse);
            }

            model.addAttribute("mate", mate);
            model.addAttribute("userHouse", userHouse);
            model.addAttribute("userHouses", userHouses);

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
     * @param startDate
     * @param period
     * @param endDate
     * @return
     */
    @RequestMapping("/myCosts/{period}/{selectedMate}/{selectedCostFamily}")
    public String myCosts(HttpSession httpSession,
            @RequestParam(value = "startDate", required = false) Date startDate,
            @RequestParam(value = "endDate", required = false) Date endDate,
            @PathVariable("period") String period,
            @PathVariable("selectedMate") Integer sMate,
            @PathVariable("selectedCostFamily") Integer sCostFamily,
            Model model) {

        String response = "myCosts";
        Mate mate = new Mate();
        List<String> fullYear = new ArrayList<>();
        try {

            mate = getUserMate(httpSession);
            if (mate.isActivo()) {
                House userHouse = houseRepository.findByMate(mate.getId());
                LocalDate today = LocalDate.now();

                if (!period.equals("now")) {
                    fullYear = new Period().fillFullYear(period);
                    today = new Period().getDateFromPeriod(period);
                } else {
                    period = new Period().getPeriodFromDate();
                    fullYear = new Period().fillFullYear(period);
                }

                if (startDate == null) {
                    startDate = Date.from(today.with(ChronoField.DAY_OF_MONTH, 1).atStartOfDay().toInstant(ZoneOffset.UTC));
                }
                today = today.plusMonths(1);
                if (endDate == null) {
                    endDate = Date.from(today.with(ChronoField.DAY_OF_MONTH, 1).atStartOfDay().toInstant(ZoneOffset.UTC));
                }
                List<Cost> costs = new ArrayList<>();
                if (sMate == 0 && sCostFamily == 0) {
                    costs = costRepository.findByHouse(userHouse.getId(), startDate, endDate);
                } else if (sMate == 0) {
                    costs = costRepository.findByHouseAndCostFamily(sCostFamily, userHouse.getId(), startDate, endDate);
                } else if (sCostFamily == 0) {
                    costs = costRepository.findByMateAndHouse(sMate, userHouse.getId(), startDate, endDate);
                } else {
                    costs = costRepository.findByHouseAndMateAndCostFamily(sMate, sCostFamily, userHouse.getId(), startDate, endDate);
                }

                List<CostFamily> costFamily = costFamilyRepository.findAllActive();
                List<Commerce> commerce = commerceRepository.findAllActive();
                List<Mate> houseOfMates = mateRepository.findByHouse(userHouse.getId());

                CostFamily selectedCostFamily = costFamilyRepository.findOne(sCostFamily);
                if (selectedCostFamily == null) {
                    selectedCostFamily = new CostFamily();
                    selectedCostFamily.setId(0);
                    selectedCostFamily.setName("All");
                }

                Mate selectedMate = mateRepository.findOne(sMate);
                if (selectedMate == null) {
                    selectedMate = new Mate();
                    selectedMate.setId(0);
                    selectedMate.setName("All");
                }

                model.addAttribute("mate", mate);
                model.addAttribute("selectedCostFamily", selectedCostFamily);
                model.addAttribute("selectedMate", selectedMate);
                model.addAttribute("houseOfMates", houseOfMates);
                model.addAttribute("userHouse", userHouse);
                model.addAttribute("costs", costs);
                model.addAttribute("costFamily", costFamily);
                model.addAttribute("commerce", commerce);
                model.addAttribute("cost", new Cost());
                model.addAttribute("period", period);
                model.addAttribute("fullYear", fullYear);
            } else {
                response = "login";
            }

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
    public @ResponseBody
    Integer newHouse(HttpSession httpSession,
            @ModelAttribute House newHouse,
            Model model) {

        
        Mate mate = new Mate();
        Integer response =-1;
        try {

            mate = getUserMate(httpSession);
             if (mate.isActivo()) {

            newHouse.setFechaCreacion(new Date());
            newHouse.setFechaModificacion(new Date());
            newHouse.setActivo(true);
            newHouse.setMaker(mate);
            
            houseRepository.save(newHouse);
            
            response=newHouse.getId();

             } else {
                response = new Integer(-1);
            }
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
    public @ResponseBody
    Integer newCost(HttpSession httpSession, Model model,
            @ModelAttribute Cost newCost) {

        Integer response = new Integer(-1);
        Mate mate = new Mate();
        try {

            mate = getUserMate(httpSession);
            if (mate.isActivo()) {

                newCost.setFechaCreacion(new Date());
                newCost.setFechaModificacion(new Date());
                newCost.setMateId(mate);
                newCost.setActivo(true);
                newCost.setHouseId(houseRepository.findByMate(mate.getId()));

                costRepository.save(newCost);

                response = newCost.getId();

            } else {
                response = new Integer(-1);
            }
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
    @RequestMapping("/newCommerce")
    public String newCommerce(HttpSession httpSession, Model model,
            @ModelAttribute Commerce newCommerce) {

        String response = "commerceSelect";
        Mate mate = new Mate();
        try {

            mate = getUserMate(httpSession);
            model.addAttribute("mate", mate);
            if (mate.isActivo()) {
                newCommerce.setFechaCreacion(new Date());
                newCommerce.setFechaModificacion(new Date());
                newCommerce.setActivo(true);

                commerceRepository.save(newCommerce);

                List<Commerce> commerce = commerceRepository.findAllActive();
                model.addAttribute("commerce", commerce);
                model.addAttribute("newCommerce", newCommerce);
            }

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
