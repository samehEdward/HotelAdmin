package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "persons")
public abstract class Person extends AbstractPersistable<Long> {
    private String firstName;
    private String lastName;

    @Embedded
    private Address primaryAddress;

    @ElementCollection
    @CollectionTable (
            name = "person_address",
            joinColumns=@JoinColumn(name = "person_id"),
    foreignKey = @ForeignKey(name = "FK_person_addresses_2_persons"))
    private List<Address> alternativeAddresses = new ArrayList<>(2);


}
