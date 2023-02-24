package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.TestFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;


class RoomServiceTest {
    private RoomService service;

    @BeforeEach
    void setup(){
        service = new RoomService();
    }

    /* ----------------------------- testPredicate ------------------------------------------------- */
    @Test
    void ensureFindRoomCategoryWorksProperly(){

        //given
        List<Room> rooms = List.of(rm1(), rm2(), rm3(), rm4(), rm5(), rm6());

        //when
        var standard = service.findStandard(rooms);
        var deluxe  = service.findDeluxe(rooms);
        var familySuite = service.findFamilySuite(rooms);
        var businessSuite = service.findBusinessSuite(rooms);

        //then
        assertThat(standard).containsExactlyInAnyOrder(rm1(),rm2());
        assertThat(deluxe).contains(rm3());
        assertThat(familySuite).hasSize(2);
        assertThat(businessSuite).containsExactly(rm6());
    }

    /* ----------------------------- testSort ------------------------------------------------------ */
    @Test
    void ensureSortRoomsWorksProperly(){

        //given
        List<Room> rooms = List.of(rm1(), rm2(), rm3(), rm4(), rm5(), rm6());

        //when
        var sorted = service.sort(rooms);

        //then
        assertThat(sorted).containsExactly( rm1(), rm2(), rm3(), rm4(), rm5(), rm6());
    }

}