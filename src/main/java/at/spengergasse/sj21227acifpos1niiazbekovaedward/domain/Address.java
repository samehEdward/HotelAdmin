package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Embeddable
public class Address {

    @Size(max=64)
    private String streetNumber;

    @Size(max=8)
    private String zipCode;

    @Size(max=32)
    private String city;

}
