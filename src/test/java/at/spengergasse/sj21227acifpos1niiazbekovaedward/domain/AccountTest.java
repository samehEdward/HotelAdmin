package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import org.junit.jupiter.api.Test;

import static at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.TestFixtures.jh;
import static at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.TestFixtures.*;
import static org.assertj.core.api.Assertions.assertThat;


public class AccountTest {

    /* ----------------------------- testPredicate ------------------------------------------------- */
    @Test
    void ensureAccountPredicateImplementationIsCorrect() {      // CheckerPredicateImplementation

        assertThat(Account.isGuest.test(bc())).isTrue();
        assertThat(Account.isNotGuest.test(jh())).isFalse();
        assertThat(Account.isGuest.test(se())).isTrue();

        assertThat(Account.isMember.test(lh())).isTrue();
        assertThat(Account.isNotMember.test(sd())).isFalse();
        assertThat(Account.isAdmin.test(gb())).isFalse();

        assertThat(Account.isAdmin.test(jr())).isTrue();
        assertThat(Account.isNotAdmin.test(bg())).isFalse();
    }

    /* ----------------------------- testSort ------------------------------------------------------ */
    @Test
    void ensureAccountComparatorIsCorrect() {
        assertThat(Account.byAccountName.compare(bc(), jh())).isLessThan(0);
        assertThat(Account.byAccountName.compare(se(), lh())).isGreaterThan(0);
        assertThat(Account.defaultSortOrder.compare(sd(), gb())).isGreaterThanOrEqualTo(0);
        assertThat(Account.defaultSortOrder.compare(bg(), jr())).isLessThanOrEqualTo(0);
    }
}


