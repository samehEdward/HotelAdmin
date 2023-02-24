package at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Room;
import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.RoomCategory;
import at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence.Projection.RoomDescriptionPriceInfo;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class RoomRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;

    @Test
    void ensureSaveWorksProperly() {
        //given
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

        //when
        var saved = roomRepository.saveAll(List.of(rm1, rm2, rm3, rm4, rm5, rm6));
        var foundRoomDescription = roomRepository.findByRoomDescription("Room3");
        var foundRoomDescriptionLike = roomRepository.findByRoomDescriptionLike("Room%");


        //Then
        Assertions.assertThat(foundRoomDescription).isNotEmpty();
        Assertions.assertThat(foundRoomDescriptionLike).isNotEmpty();
        Assertions.assertThat(rm1.getId()).isNotNull();
        Assertions.assertThat(rm2.getId()).isNotNull();
        Assertions.assertThat(rm3.getId()).isNotNull();
        Assertions.assertThat(rm4.getId()).isNotNull();
        Assertions.assertThat(rm5.getId()).isNotNull();
        Assertions.assertThat(rm6.getId()).isNotNull();
    }

    /* ----------------------------- testProjection -----------------------------------------------*/
    @Test
    void ensureProjectionWorksProperly() {
        //given
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

        roomRepository.saveAll(List.of(rm1, rm2, rm3, rm4, rm5, rm6));

        //when
        List<RoomDescriptionPriceInfo> result = roomRepository.findAllByRoomDescriptionLike("Room%");
        List<RoomDescriptionPriceInfo> resultPrice = roomRepository.findAllByPriceEquals(100);
        //var foundAllByPrice = roomRepository.findAllByPriceEquals(100);

        //Then
        Assertions.assertThat(result).isNotEmpty().hasSize(6);
        Assertions.assertThat(resultPrice).isNotNull().isNotEmpty();
        //assertThat(foundAllByPrice).isNotEmpty();
        Assertions.assertThat(result.get(0).roomDescription().startsWith("Room"));
        Assertions.assertThat(result.get(1).roomDescription().startsWith("Room"));
        Assertions.assertThat(result.get(2).roomDescription().startsWith("Room"));
        Assertions.assertThat(result.get(3).roomDescription().startsWith("Room"));
        Assertions.assertThat(result.get(4).roomDescription().startsWith("Room"));
        Assertions.assertThat(result.get(5).roomDescription().startsWith("Room"));
    }

    /* ----------------------------- testCustom -----------------------------------------------*/
    @Test
    void ensureGetBestWorksProperly() {
        assertThat(roomRepository.getBest().isEmpty());
    }

}
