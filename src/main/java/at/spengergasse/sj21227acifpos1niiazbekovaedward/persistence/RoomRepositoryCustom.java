package at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Room;

import java.util.List;
import java.util.Optional;

interface RoomRepositoryCustom {
    Optional<Room> getBest();
    List<Room> reallyComplexQuery(Integer int1, String string1);
}
