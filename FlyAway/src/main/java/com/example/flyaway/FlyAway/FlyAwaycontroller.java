package com.example.flyaway.FlyAway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FlyAwaycontroller {

    @Autowired
    private FlyAwayservice flyAwayservice;
    @Autowired
    private FlyAwayrepositaryForAdmin flyAwayrepositaryForAdmin;

    List<Flight> flights = new ArrayList<>();

    @GetMapping("/HomePage")
    public String homepage(Model model) {
        model.addAttribute("user", new Flight());
        return "flightSearch";
    }

    @PostMapping("/submitSearchForm")
    public String registrationform(Model model, Flight flight) {
        List<Flight> Getflights = flyAwayservice.getFlights(flight);
        flights = Getflights;
        model.addAttribute("Getflights", Getflights);
        model.addAttribute("user", new Customer());
        return "available_all_flight";
    }

    @PostMapping("/book_flight")
    public String available_all_flightss(Model model) {
        model.addAttribute("user", new Customer());
        return "registration_form";
    }

    @PostMapping("/saveregistration")
    public String submitSerchForm(Model model, Customer user) {
        user.setFlightId(flights.get(0).getId());
        flyAwayservice.submitsave(user);
        model.addAttribute("Getflights", flights);
        return "availableFlights";
    }

    @PostMapping("/payment")
    public String paymentpage() {
        return "payment_page";
    }

    @GetMapping("/conformationTicket")
    public String ticketConformation() {
        return "conformation_page";
    }

    @GetMapping("/adminLogin")
    public String adminlogin(Model model) {
        model.addAttribute("user", new Admin());
        return "admin_login";
    }

    @GetMapping("/adminRegistration")
    public String adminRegistration(Model model) {
        model.addAttribute("user", new Admin());
        return "admin_registration";
    }

    @PostMapping("/save")
    public String saveAdminDetails(Admin user) {
        flyAwayservice.save(user);
        return "redirect:/adminRegistration";
    }

    @PostMapping("/loginValidation")
    public String loginValidation(Admin user, Model model) {
        boolean isValid = flyAwayservice.validation(user);
        if (isValid) {
            model.addAttribute("valid", "Successfully validated");
            return "after_login_valid";
        } else {
            model.addAttribute("valid", "Entered wrong details");
            return "after_login_notvalid";
        }
    }

    @GetMapping("/changePassword")
    public String changePassword(Model model) {
        model.addAttribute("user", new Admin());
        return "change_password";
    }

    @PostMapping("/newpassword")
    public String newpassword(Admin user) {
        flyAwayservice.update(user);
        return "redirect:/";
    }

    @GetMapping("/addFlight")
    public String addflight(Model model) {
        model.addAttribute("user", new Flight());
        return "add_flight";
    }

    @PostMapping("/saveflight")
    public String saveflight(Flight user) {
        flyAwayservice.saveflight(user);
        return "redirect:/addFlight";
    }

    @GetMapping("/showCustomerDetails")
    public String customerdata(Customer user, Model model) {
        List<Customer> GetcustomerData = flyAwayservice.findcustomerdata(user);
        model.addAttribute("GetcustomerData", GetcustomerData);
        return "all_customer_list";
    }
}

