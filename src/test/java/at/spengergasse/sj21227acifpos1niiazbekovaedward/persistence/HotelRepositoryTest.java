package at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class HotelRepositoryTest {

    @Autowired
    private HotelRepository hotelRepository;

    @Test
    void ensureSaveWorksProperly() {
        //given
        Address address = Address.builder().streetNumber("Neubaugasse 10").zipCode("1070").city("Wien").build();

        Room rm1 = Room.builder().roomDescription("Room1").price(80).category(RoomCategory.STANDARD)
                       .isRoomAvailable(Boolean.FALSE).checkIn(Boolean.TRUE).checkOut(Boolean.FALSE).build();

        Room rm2 = Room.builder().roomDescription("Room2").price(100).category(RoomCategory.STANDARD)
                       .isRoomAvailable(Boolean.TRUE).checkIn(Boolean.FALSE).checkOut(Boolean.TRUE).build();

        Room rm3 = Room.builder().roomDescription("Room3").price(150).category(RoomCategory.DELUXE)
                       .isRoomAvailable(Boolean.FALSE).checkIn(Boolean.TRUE).checkOut(Boolean.FALSE).build();

        Room rm4 = Room.builder().roomDescription("Room4").price(200).category(RoomCategory.FAMILY_SUITE)
                       .isRoomAvailable(Boolean.FALSE).checkIn(Boolean.TRUE).checkOut(Boolean.FALSE).build();

        Room rm5 = Room.builder().roomDescription("Room5").price(300).category(RoomCategory.FAMILY_SUITE)
                       .isRoomAvailable(Boolean.FALSE).checkIn(Boolean.TRUE).checkOut(Boolean.FALSE).build();

        Room rm6 = Room.builder().roomDescription("Room6").price(250).category(RoomCategory.BUSINESS_SUITE)
                       .isRoomAvailable(Boolean.TRUE).checkIn(Boolean.FALSE).checkOut(Boolean.TRUE).build();


        Hotel hotel = Hotel.builder().hotelDescription("Hotel-City").build()
                .addRoom(rm1).addRoom(rm2).addRoom(rm3)
                .addRoom(rm4).addRoom(rm5).addRoom(rm6);

        //when
        var saved = hotelRepository.save(hotel);

        //Then
        assertThat(saved).isNotNull().isSameAs(hotel);
        assertThat(saved.getId()).isNotNull();
        assertThat(rm1.getId()).isNotNull();
        assertThat(rm2.getId()).isNotNull();
        assertThat(rm3.getId()).isNotNull();
        assertThat(rm4.getId()).isNotNull();
        assertThat(rm5.getId()).isNotNull();
        assertThat(rm6.getId()).isNotNull();
        assertThat(address.getCity()).isNotNull();
        assertThat(address.getZipCode()).isNotNull();
        assertThat(address.getStreetNumber()).isNotNull().isNotEmpty();
    }
}