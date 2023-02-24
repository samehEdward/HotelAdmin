package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


@Data

@AllArgsConstructor
@Builder
@Entity
@Table(name = "roomsalt")
public class Room extends AbstractPersistable<Long> {

    private int roomNumber;
    private int adults;
    private int children;
    private String roomDescription;
    private Integer price;
    private Boolean isRoomAvailable;
    private Boolean checkIn;
    private Boolean checkOut;


    @Enumerated(EnumType.STRING)
    private RoomCategory category;

    public Room(String room1, int i, boolean b, boolean b1, boolean b2, RoomCategory standard) {
    }

    public Boolean hasHotel() {
        return hotel != null;
    }

    public void clearHotel() {
        hotel = null;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_rooms_2_hotels"))
    private Hotel hotel;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name= "room_booking", joinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"))

    private List<Booking> bookings = new ArrayList<>();

    /* ----------------------------- constructor --------------------------------------------------- */
    public Room(){}
    public Room(String roomDescription, Integer price, Boolean isRoomAvailable, Boolean checkIn, Boolean checkOut, RoomCategory category,int adults,int children,int roomNumber) {
        this.roomDescription = roomDescription;
        this.price = price;
        this.isRoomAvailable = isRoomAvailable;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.category = category;
        this.adults = adults;
        this.children = children;
        this.roomNumber = roomNumber;
    }

    /* ----------------------------- predicate ----------------------------------------------------- */

    public static final Predicate<Room> NOT_NULL = (r) -> r!= null;

    public static Predicate<Room> isStandard = room -> RoomCategory.STANDARD.equals(room.getCategory());
    public static Predicate<Room> isDeluxe = r -> RoomCategory.DELUXE.equals(r.getCategory());
    public static Predicate<Room> isFamilySuite = r -> RoomCategory.FAMILY_SUITE.equals(r.getCategory());
    public static Predicate<Room> isBusinessSuite = r -> RoomCategory.BUSINESS_SUITE.equals(r.getCategory());
    public static Predicate<Room> isNotStandard = isStandard.negate();
    public static Predicate<Room> isNotDeluxe = isDeluxe.negate();
    public static Predicate<Room> isNotFamilySuite = isFamilySuite.negate();
    public static Predicate<Room> isNotBusinessSuite = isBusinessSuite.negate();

    /* ----------------------------- sort ---------------------------------------------------------- */

    public static Comparator<Room> byRoomDescription = Comparator.comparing(Room::getRoomDescription);
    public static Comparator<Room> byPrice = Comparator.comparing(Room::getPrice);
    public static Comparator<Room> defaultSortOrder = byRoomDescription.thenComparing(byPrice.reversed());

}