package at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Account;
import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.AccountType;
import at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence.Projection.AccountNamePasswordInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    void ensureSaveWorksProperly() {
        //given
        Account bc = Account.builder().accountName("Brietta_Cord").password("b5665c").resetPassword(false)
                .accountType(AccountType.GUEST).build();
        Account jh = Account.builder().accountName("Jame_Host").password("j1221h").resetPassword(false)
                .accountType(AccountType.GUEST).build();
        Account se = Account.builder().accountName("Sabina_Eden").password("s3443e").resetPassword(false)
                .accountType(AccountType.GUEST).build();
        Account gb = Account.builder().accountName("Gardie_Brehat").password("gb1002").resetPassword(true)
                .accountType(AccountType.MEMBER).build();
        Account lh = Account.builder().accountName("Leola_Husset").password("lh8998").resetPassword(true)
                .accountType(AccountType.MEMBER).build();
        Account sd = Account.builder().accountName("Steffen_Dillingston").password("sd9009").resetPassword(true)
                .accountType(AccountType.MEMBER).build();
        Account bg = Account.builder().accountName("Bernadene_Gardner").password("B8778G").resetPassword(true)
                .accountType(AccountType.ADMIN).build();
        Account jr = Account.builder().accountName("Justin_Roan").password("J7887R").resetPassword(true)
                .accountType(AccountType.ADMIN).build();

        //when
        var saved = accountRepository.saveAll(List.of(bc, jh, se, gb, lh, sd, bg, jr));
        var foundName = accountRepository.findByAccountNameIs("Bernadene_Gardner");
        var foundByNamePart = accountRepository.findByAccountNameLike("%_%");

        //Then
        assertThat(foundName).isNotEmpty();
        assertThat(foundByNamePart).isNotEmpty().hasSize(8);
        assertThat(bc.getId()).isNotNull();
        assertThat(jh.getId()).isNotNull();
        assertThat(se.getId()).isNotNull();
        assertThat(gb.getId()).isNotNull();
        assertThat(lh.getId()).isNotNull();
        assertThat(sd.getId()).isNotNull();
        assertThat(bg.getId()).isNotNull();
        assertThat(jr.getId()).isNotNull();
    }

    /* ----------------------------- testProjection -----------------------------------------------*/
    @Test
    void ensureProjectionWorksProperly() {

        //given
        Account bc = Account.builder().accountName("Brietta_Cord").password("b5665c").resetPassword(false)
                .accountType(AccountType.GUEST).build();
        Account jh = Account.builder().accountName("Jame_Host").password("j1221h").resetPassword(false)
                .accountType(AccountType.GUEST).build();
        Account se = Account.builder().accountName("Sabina_Eden").password("s3443e").resetPassword(false)
                .accountType(AccountType.GUEST).build();
        Account gb = Account.builder().accountName("Gardie_Brehat").password("gb1002").resetPassword(true)
                .accountType(AccountType.MEMBER).build();
        Account lh = Account.builder().accountName("Leola_Husset").password("lh8998").resetPassword(true)
                .accountType(AccountType.MEMBER).build();
        Account sd = Account.builder().accountName("Steffen_Dillingston").password("sd9009").resetPassword(true)
                .accountType(AccountType.MEMBER).build();
        Account bg = Account.builder().accountName("Bernadene_Gardner").password("B8778G").resetPassword(true)
                .accountType(AccountType.ADMIN).build();
        Account jr = Account.builder().accountName("Justin_Roan").password("J7887R").resetPassword(true)
                .accountType(AccountType.ADMIN).build();

        accountRepository.saveAll(List.of(bc, jh, se, gb, lh, sd, bg, jr));

        //when
        List<AccountNamePasswordInfo> result = accountRepository.findAllByAccountNameLike("%_%");

        //Then
        assertThat(result).isNotEmpty().hasSize(8);
        assertThat(result.get(0).accountName().startsWith("_"));
        assertThat(result.get(1).accountName().startsWith("_"));
        assertThat(result.get(2).accountName().startsWith("_"));
        assertThat(result.get(3).accountName().startsWith("_"));
        assertThat(result.get(5).accountName().startsWith("_"));
        assertThat(result.get(6).accountName().startsWith("_"));
        assertThat(result.get(7).accountName().startsWith("_"));

        result.forEach(r -> log.info("{} {})", r.accountName(), r.password()));
    }

}