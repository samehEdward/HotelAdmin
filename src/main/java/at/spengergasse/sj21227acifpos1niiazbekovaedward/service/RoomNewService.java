package at.spengergasse.sj21227acifpos1niiazbekovaedward.service;


import at.spengergasse.sj21227acifpos1niiazbekovaedward.controllers.MutatingRoomCommand;
import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.RoomNew;
import at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence.RoomNewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@Service

@Transactional
public class RoomNewService {

    private final RoomNewRepo roomNewRepo;


    public List<RoomNew> getRoomsNew() {
        return roomNewRepo.findAll();
    }

    public Optional<RoomNew> getRoomNew(Long id) {
        return roomNewRepo.findById(id);
    }

    public RoomNew create(MutatingRoomCommand command) {
        return roomNewRepo.save(RoomNew.builder()
                .roomNewNumber(command.getRoomNewNumber())
                .adults(command.getAdults())
                .build());
    }


    public RoomNew replace(Long id, MutatingRoomCommand command) {

        Optional<RoomNew> roomNew = roomNewRepo.findById(id);

        if (roomNew.isPresent()) {
            RoomNew entity = roomNew.get();
            entity.setRoomNewNumber(command.getRoomNewNumber());
            entity.setAdults(command.getAdults());
            return roomNewRepo.save(entity);
        }
        throw new IllegalStateException("Room with id=" + id + " ist not existing anymor!");
    }


    public RoomNew update(Long id, MutatingRoomCommand command) {

        Optional<RoomNew> roomNew = roomNewRepo.findById(id);

        if (roomNew.isPresent()) {
            RoomNew entity = roomNew.get();
            if (command.getRoomNewNumber() != null) {
                entity.setRoomNewNumber(command.getRoomNewNumber());
            }
            if (command.getAdults() != 0) {
                entity.setAdults(command.getAdults());
            }
            entity.setRoomNewNumber(command.getRoomNewNumber());
            entity.setAdults(command.getAdults());
            return roomNewRepo.save(entity);
        }
        throw new IllegalStateException("Room with id=" + id + " ist not existing anymor!");
    }


    public void delete(Long id) {
        roomNewRepo.deleteById(id);
    }
}
