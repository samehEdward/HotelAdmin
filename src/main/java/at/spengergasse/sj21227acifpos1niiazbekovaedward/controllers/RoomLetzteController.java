package at.spengergasse.sj21227acifpos1niiazbekovaedward.controllers;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.service.RoomNewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(RoomLetzteController.BASE_URL)
public class RoomLetzteController {

    private final RoomNewService roomNewService;

    public static final String BASE_URL = "/rooms";
    public static final String PATH_INDEX = "/";
    public static final String PATH_VAR_ID = "/{id}";

    public RoomLetzteController(RoomNewService roomNewService) {
        this.roomNewService = roomNewService;
    }

    public String index(Model model) {
        var rooms = roomNewService.getRoomsNew();
        model.addAttribute("rooms", rooms);
        return "roomns/index";
    }

    @GetMapping(PATH_VAR_ID)
    public String show(Model model, @PathVariable Long id) {
        return roomNewService.getRoomNew(id)
                .map(roomNew -> model.addAttribute("room", roomNew))
                .map(__ -> "rooms/show")
                .orElse("roomns/index");

    }
}

