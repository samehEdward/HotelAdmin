package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "RoomsNew")
public class RoomNew extends AbstractPersistable<Long> {

    @Version
    private Integer version;

    private String roomNewNumber;
    private int adults;


}
