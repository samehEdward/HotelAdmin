package at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Room;
import at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence.Projection.RoomDescriptionPriceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long>, RoomRepositoryCustom {
    Optional<Room> findByRoomDescription(String roomDescription);
    List<Room> findByRoomDescriptionLike(String roomDescription);

    List<RoomDescriptionPriceInfo> findAllByRoomDescriptionLike(String roomDescription_part);
    List<RoomDescriptionPriceInfo> findAllByPriceEquals(Integer price_equals);
}