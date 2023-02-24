package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name = "rooms")
public class Roomn extends AbstractPersistable<Long> {

    public int roomNumber;
    private int adults;
    private int children;
    private String roomDescription;
    private Integer price;
    private Boolean isRoomAvailable;
    private Boolean checkIn;
    private Boolean checkOut;




}
