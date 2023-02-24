package at.spengergasse.sj21227acifpos1niiazbekovaedward.controllers;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Roomn;
import at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence.Projection.RoomnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rooms")
public class RoomContoller {

    @Autowired
    RoomnRepo roomnRepo;

    @GetMapping("/new")
    public String displayRoomForm(Model model)
    {
        Roomn aroom = new Roomn();
        model.addAttribute("roomObjekts", aroom);
        return "new-room";
    }

    @PostMapping("/save")
    public String createRoomForm(Roomn roomn, Model model)
    {
        roomnRepo.save(roomn);
        return "redirect:/rooms/new";
    }
}
