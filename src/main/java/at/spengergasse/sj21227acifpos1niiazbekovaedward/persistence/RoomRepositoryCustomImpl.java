package at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Room;

import java.util.List;
import java.util.Optional;

public class RoomRepositoryCustomImpl implements RoomRepositoryCustom {
    @Override
    public Optional<Room> getBest() {
        return Optional.empty();
    }

    @Override
    public List<Room> reallyComplexQuery(Integer int1, String string1) {
        return null;
    }
}
