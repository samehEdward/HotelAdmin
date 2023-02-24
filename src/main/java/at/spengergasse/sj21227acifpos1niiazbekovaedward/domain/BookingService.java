package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;
import java.util.List;
import java.util.stream.Collectors;


public class BookingService {

    /* ----------------------------- predicate ----------------------------------------------------- */

    public List<Booking> findPending(List<Booking> bookings) {
        return bookings.stream()
                .filter(booking -> BookingStatus.PENDING.equals(booking.getStatusBooking()))
                .collect(Collectors.toList());
    }

    public List<Booking> findConfirmed(List<Booking> bookings) {
        return bookings.stream()
                .filter(booking -> BookingStatus.CONFIRMED.equals(booking.getStatusBooking()))
                .collect(Collectors.toList());
    }

    public List<Booking> findCanceled(List<Booking> bookings) {
        return bookings.stream()
                .filter(booking -> BookingStatus.CANCELED.equals(booking.getStatusBooking()))
                .collect(Collectors.toList());
    }

    public List<Booking> findCheckIn(List<Booking> bookings) {
        return bookings.stream()
                .filter(booking -> BookingStatus.CHECKED_IN.equals(booking.getStatusBooking()))
                .collect(Collectors.toList());
    }

    public List<Booking> findCheckOut(List<Booking> bookings) {
        return bookings.stream()
                .filter(booking -> BookingStatus.CHECKED_OUT.equals(booking.getStatusBooking()))
                .collect(Collectors.toList());
    }

    /* ----------------------------- sort ---------------------------------------------------------- */

    public List<Booking> sort(List<Booking> bookings) {
        return bookings.stream()
                .sorted(Booking.defaultSortOrder)
                .collect(Collectors.toList());
    }
}

