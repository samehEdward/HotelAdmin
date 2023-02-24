package at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence.Projection;


import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Roomn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomnRepo extends JpaRepository<Roomn, Long> {
}
