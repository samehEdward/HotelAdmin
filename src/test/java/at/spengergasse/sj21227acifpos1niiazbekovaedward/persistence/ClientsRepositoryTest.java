package at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ClientsRepositoryTest {

    @Autowired
    private ClientsRepository clientsRepository;

    @Test
    void ensureSaveWorksProperly(){
        //given
        Client client = Client.builder().Birthday(1-7-1978).build();

        //when
        var saved = clientsRepository.save(client);

        //then
        assertThat(saved).isNotNull().isSameAs(client);
        assertThat(saved.getId()).isNotNull();
    }


}
