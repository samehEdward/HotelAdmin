package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Comparator;
import java.util.function.Predicate;
//

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "accounts")
public class Account extends Person {

    private String accountName;
    private String password;
    private boolean resetPassword;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    /* ----------------------------- predicate ----------------------------------------------------- */

    public static Predicate<Account> isGuest = account -> AccountType.GUEST.equals(account.accountType);
    public static Predicate<Account> isMember = account -> AccountType.MEMBER.equals(account.accountType);
    public static Predicate<Account> isAdmin = account -> AccountType.ADMIN.equals(account.accountType);
    public static Predicate<Account> isNotGuest = isGuest.negate();
    public static Predicate<Account> isNotMember = isMember.negate();
    public static Predicate<Account> isNotAdmin = isAdmin.negate();

    /* ----------------------------- sort ---------------------------------------------------------- */

    public static Comparator<Account> byAccountName = Comparator.comparing(Account::getAccountName);
    public static Comparator<Account> byPassword = Comparator.comparing(Account::getPassword);
    public static Comparator<Account> defaultSortOrder = byAccountName.thenComparing(byPassword.reversed());
}
