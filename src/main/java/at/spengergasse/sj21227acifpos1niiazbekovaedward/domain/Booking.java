package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "bookings")
public class Booking extends AbstractPersistable<Long> {

    private String reservationDescription;
    private Integer durationOfNights;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    @Enumerated(EnumType.STRING)
    private BookingStatus statusBooking;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name= "room_booking", joinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "booking_id", referencedColumnName = "id"))

    private List<Room> rooms = new ArrayList<>();

    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_persons_2_bookings"))
    private Person person;

    /* ----------------------------- constructor ------------------------------------------------- */

    public Booking(String reservationDescription, Integer durationOfNights, LocalDateTime checkIn, LocalDateTime checkOut, BookingStatus statusBooking) {
        setReservationDescription(reservationDescription);
        setDurationOfNights(durationOfNights);
        setCheckIn(checkIn);
        setCheckIn(checkOut);
        setStatusBooking(statusBooking);
    }

    /* ----------------------------- predicate ----------------------------------------------------- */

    public static Predicate<Booking> isPending = booking -> BookingStatus.PENDING.equals(booking.getStatusBooking());
    public static Predicate<Booking> isConfirmed = b -> BookingStatus.CONFIRMED.equals(b.getStatusBooking());
    public static Predicate<Booking> isCanceled = b -> BookingStatus.CANCELED.equals(b.getStatusBooking());
    public static Predicate<Booking> isCheckIN = b -> BookingStatus.CHECKED_IN.equals(b.getStatusBooking());
    public static Predicate<Booking> isCheckOut = b -> BookingStatus.CHECKED_OUT.equals(b.getStatusBooking());
    public static Predicate<Booking> isNotPending = isPending.negate();
    public static Predicate<Booking> isNotConfirmed = isConfirmed.negate();
    public static Predicate<Booking> isNotCanceled = isCanceled.negate();
    public static Predicate<Booking> isNotCheckIN = isCheckIN.negate();
    public static Predicate<Booking> isNotCheckOut = isCheckOut.negate();

    /* ----------------------------- sort ---------------------------------------------------------- */

    public static Comparator<Booking> byReservationDescription = Comparator.comparing(Booking::getReservationDescription);
    public static Comparator<Booking> byDurationInDays = Comparator.comparing(Booking::getDurationOfNights);
    public static Comparator<Booking> byCheckIn = Comparator.comparing(Booking::getCheckIn);
    public static Comparator<Booking> byCheckOut = Comparator.comparing(Booking::getCheckOut);
    public static Comparator<Booking> defaultSortOrder = byReservationDescription.thenComparing(byDurationInDays)
                                                                                 .thenComparing(byCheckIn)
                                                                                 .thenComparing(byCheckOut.reversed());
}
