package at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BookingRepositoryTest {

    @Autowired
    private BookingRepository roomBookingRepo;

    @Test
    void ensureSaveWorksProperly(){
        //given
        Booking roomBooking = Booking.builder().reservationDescription("2 Pesonen 4 nights").build();

        //when
        var saved = roomBookingRepo.save(roomBooking);

        //then
        assertThat(saved).isNotNull().isSameAs(roomBooking);
        assertThat(saved.getId()).isNotNull();
    }

}
