package at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence;


import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Administrator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;



@DataJpaTest
public class AdministratorsRepositoryTest {

    @Autowired
    private AdministratorsRepository administratorsRepository;



    @Test
    void ensureSaveWorksProperly(){
        //given
        Administrator administrator = Administrator.builder().code(1478).build();

        //when
        var saved  = administratorsRepository.save(administrator);

        //then
        assertThat(saved).isNotNull().isSameAs(administrator);
        assertThat(saved.getId()).isNotNull();

    }
}
