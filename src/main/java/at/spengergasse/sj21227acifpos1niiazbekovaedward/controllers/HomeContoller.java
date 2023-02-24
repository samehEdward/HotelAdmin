package at.spengergasse.sj21227acifpos1niiazbekovaedward.controllers;


import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Roomn;
import at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence.Projection.RoomnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeContoller {

    @Autowired
    RoomnRepo roomnRepo;

    @GetMapping("/")
    public String displayHome(Model model)
    {
        List<Roomn> roomns = roomnRepo.findAll();
        model.addAttribute("roomns" , roomns);

        return "home";
    }
}
