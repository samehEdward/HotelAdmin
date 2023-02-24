package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "administrators")
public  class Administrator extends Person{
    private Integer code;

    public Administrator(String firstName, String lastName, Address primaryAddress, List<Address> alternativeAddresses, Integer code) {
        super(firstName, lastName, primaryAddress, alternativeAddresses);
        this.code = code;
    }
}
