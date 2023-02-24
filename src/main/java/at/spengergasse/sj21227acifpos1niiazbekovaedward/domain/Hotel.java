package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "hotels")
public class Hotel extends AbstractPersistable<Long> {

    private String hotelDescription;

    @Builder.Default
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "hotel")
    private List<Room> rooms = new ArrayList<>();

    public Hotel addRooms(Room... rooms) {
        Arrays.stream(rooms).filter(Room.NOT_NULL).forEach(this::addRoom);
        return this;
    }

    public Hotel addRoom(Room room) {
        Objects.requireNonNull(room);

        if (room.hasHotel()) {
            room.getHotel().removeRoom(room);
        }
        room.setHotel(this);
        rooms.add(room);
        return this;
    }

    public Hotel removeRooms(Room... rooms) {
        Arrays.stream(rooms).filter(Room.NOT_NULL).forEach(this::removeRoom);
        return this;
    }

    public Hotel removeRoom(Room room) {
        Objects.requireNonNull(room);

        room.clearHotel();
        rooms.remove(room);
        return this;
    }
}
