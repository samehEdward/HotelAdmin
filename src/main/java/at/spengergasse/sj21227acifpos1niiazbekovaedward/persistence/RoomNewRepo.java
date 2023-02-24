package at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence;


import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.RoomNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomNewRepo extends JpaRepository<RoomNew, Long> {
}
