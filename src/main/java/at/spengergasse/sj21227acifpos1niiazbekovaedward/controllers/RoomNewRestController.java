package at.spengergasse.sj21227acifpos1niiazbekovaedward.controllers;


import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.RoomNew;
import at.spengergasse.sj21227acifpos1niiazbekovaedward.service.RoomNewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/rooms")
public class RoomNewRestController {

    private final RoomNewService roomNewService;

    @GetMapping({"", "/"})
    public HttpEntity<List<RoomNew>> index() {
        return ResponseEntity.ok(roomNewService.getRoomsNew());
    }


    @GetMapping({"/{id}"})
    public HttpEntity<RoomNew> getOne(@PathVariable Long id) {

        return roomNewService.getRoomNew(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping({"", "/"})
    public HttpEntity<RoomNew> create(@RequestBody MutatingRoomCommand command) {

        RoomNew roomNew = roomNewService.create(command);
        URI uri = UriComponentsBuilder.fromPath("/api/rooms/{id}").uriVariables(Map.of("id", roomNew.getId())).build().toUri();
        return ResponseEntity.created(uri).body(roomNew);
    }


    @PutMapping({"/{id}"})
    public HttpEntity<RoomNew> replace(@PathVariable Long id, @RequestBody MutatingRoomCommand command) {

        RoomNew roomNew = roomNewService.replace(id, command);
        URI uri = UriComponentsBuilder.fromPath("/api/rooms/{id}").uriVariables(Map.of("id", roomNew.getId())).build().toUri();
        return ResponseEntity.created(uri).body(roomNew);
    }

    @PatchMapping({"/{id}"})
    public HttpEntity<RoomNew> update(@PathVariable Long id, @RequestBody MutatingRoomCommand command) {

        RoomNew roomNew = roomNewService.update(id, command);
        URI uri = UriComponentsBuilder.fromPath("/api/rooms/{id}").uriVariables(Map.of("id", roomNew.getId())).build().toUri();
        return ResponseEntity.created(uri).body(roomNew);
    }

    @DeleteMapping({"/{id}"})
    public HttpEntity<Void> delet(@PathVariable Long id) {

        roomNewService.delete(id);

        return ResponseEntity.ok().build();
    }

}