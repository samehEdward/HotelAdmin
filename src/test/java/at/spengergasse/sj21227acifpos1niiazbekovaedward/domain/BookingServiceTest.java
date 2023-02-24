package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.TestFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;


public class BookingServiceTest {

    private BookingService service;

    @BeforeEach
    void setup(){
        service = new BookingService();
    }

    /* ----------------------------- testPredicate ------------------------------------------------- */
    @Test
    void ensureFindBookingStatusWorksProperly(){

        //given
        List<Booking> bookings = List.of(bk1(), bk2(), bk3(), bk4());

        //when
        var pending = service.findPending(bookings);
        var confirmed = service.findConfirmed(bookings);
        var canceled = service.findCanceled(bookings);

        //then
        assertThat(pending).hasSize(2);
        assertThat(confirmed).containsExactly(bk2());
        assertThat(canceled).contains(bk4());
    }

    /* ----------------------------- testSort ------------------------------------------------------ */
    @Test
    void ensureSortBookingWorksProperly(){

        //given
        List<Booking> bookings = List.of(bk1(), bk2(), bk3(), bk4());

        //when
        var sorted= service.sort(bookings);

        //then
        assertThat(sorted).containsExactlyInAnyOrder(bk1(), bk2(), bk3(), bk4());
    }
}