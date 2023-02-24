package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import org.junit.jupiter.api.Test;

import static at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.TestFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;


public class BookingTest {

    /* ----------------------------- testPredicate ------------------------------------------------- */
    @Test
    void ensureBookingPredicateImplementationIsCorrect() {      // CheckerPredicateImplementation

        assertThat(Booking.isPending.test(bk1())).isTrue();
        assertThat(Booking.isConfirmed.test(bk2())).isTrue();
        assertThat(Booking.isCheckIN.test(bk3())).isFalse();
        assertThat(Booking.isCanceled.test(bk4())).isTrue();
    }

    /* ----------------------------- testSort ------------------------------------------------------ */
    @Test
    void ensureBookingComparatorIsCorrect() {
        assertThat(Booking.byReservationDescription.compare(bk1(), bk3())).isLessThan(0);
        assertThat(Booking.byDurationInDays.compare(bk2(), bk1())).isGreaterThan(0);
        assertThat(Booking.byCheckIn.compare(bk3(), bk4())).isGreaterThan(0);
        assertThat(Booking.defaultSortOrder.compare(bk1(), bk2())).isLessThanOrEqualTo(0);
    }
}
