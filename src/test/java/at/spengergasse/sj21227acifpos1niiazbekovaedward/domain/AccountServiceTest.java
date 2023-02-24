package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.TestFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;


public class  AccountServiceTest {

    private AccountService service;

    @BeforeEach
    void setup(){
        service = new AccountService();
    }

    /* ----------------------------- testPredicate ------------------------------------------------- */
    @Test
    void ensureFindAccountTypesWorksProperly(){

        //given
        List<Account> accounts = List.of(jh(), se(), bc(), lh(), sd(), gb(), bg(), jr());

        //when
        var quests= service.findGuests(accounts);
        var members= service.findMembers(accounts);
        var admins= service.findAdmins(accounts);

        //then
        assertThat(quests).containsExactlyInAnyOrder(jh(), se(), bc());
        assertThat(members).containsExactlyInAnyOrder(lh(), sd(), gb());
        assertThat(admins).containsExactlyInAnyOrder(bg(), jr());
    }

    /* ----------------------------- testSort ------------------------------------------------------ */
    @Test
    void ensureSortAccountsWorksProperly(){

        //given
        List<Account> accounts = List.of(bc(), jh(), se(), gb(), lh(), sd(), bg(), jr());
        //List<Account> accounts = Arrays.asList(jh(), se(), bc(), lh(), sd(),gb(), bg(), jr());

        //when
        var sorted= service.sort(accounts);

        //then
        assertThat(sorted).containsExactlyInAnyOrder(bc(), jh(), se(), gb(), lh(), sd(), bg(), jr());
    }
}