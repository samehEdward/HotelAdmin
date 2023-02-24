package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import org.junit.jupiter.api.Test;

import static at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.TestFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;


class RoomTest {

    /* ----------------------------- testPredicate ------------------------------------------------- */
    @Test
    void ensureRoomPredicateImplementationIsCorrect() {         // CheckerPredicateImplementation

        assertThat(Room.NOT_NULL.test(null)).isFalse();
        assertThat(Room.NOT_NULL.test(Room.builder().build())).isTrue();

        assertThat(Room.isStandard.test(rm1())).isTrue();
        assertThat(Room.isNotStandard.test(rm2())).isFalse();
        assertThat(Room.isDeluxe.test(rm3())).isTrue();

        assertThat(Room.isFamilySuite.test(rm4())).isTrue();
        assertThat(Room.isBusinessSuite.test(rm5())).isFalse();
        assertThat(Room.isBusinessSuite.test(rm6())).isTrue();
    }

    /* ----------------------------- testSort ------------------------------------------------------ */
    @Test
    void ensureRoomComparatorIsCorrect() {
        assertThat(Room.byRoomDescription.compare(rm1(), rm2())).isLessThanOrEqualTo(0);
        assertThat(Room.byPrice.compare(rm3(), rm6())).isLessThan(0);
        assertThat(Room.defaultSortOrder.compare(rm5(), rm4())).isGreaterThanOrEqualTo(0);
        assertThat(Room.byPrice.compare(rm5(), rm6())).isGreaterThan(0);
    }

}