package at.spengergasse.sj21227acifpos1niiazbekovaedward.service;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Room;
import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.RoomCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service

public class RoomService {



    /* ----------------------------- predicate ----------------------------------------------------- */

    public List<Room> findStandard(List<Room> rooms) {
        return rooms.stream()
                .filter(room -> RoomCategory.STANDARD.equals(room.getCategory()))
                .collect(Collectors.toList());
    }

    public List<Room> findDeluxe(List<Room> rooms) {
        return rooms.stream()
                .filter(r -> RoomCategory.DELUXE.equals(r.getCategory()))
                .collect(Collectors.toList());
    }

    public List<Room> findFamilySuite(List<Room> rooms) {
        return rooms.stream()
                .filter(r -> RoomCategory.FAMILY_SUITE.equals(r.getCategory()))
                .collect(Collectors.toList());
    }

    public List<Room> findBusinessSuite(List<Room> rooms) {
        return rooms.stream()
                .filter(r -> RoomCategory.BUSINESS_SUITE.equals(r.getCategory()))
                .collect(Collectors.toList());
    }

    /* ----------------------------- sort ---------------------------------------------------------- */

    public List<Room> sort(List<Room> rooms) {
        return rooms.stream()
                .sorted(Room.defaultSortOrder)
                .collect(Collectors.toList());
    }


}
