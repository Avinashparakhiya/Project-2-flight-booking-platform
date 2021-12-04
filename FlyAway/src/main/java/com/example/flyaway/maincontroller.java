package com.example.flyaway;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class maincontroller {

    @GetMapping("/")
    public String showHomePage()
    {
        return "index";
    }

}
