package at.spengergasse.sj21227acifpos1niiazbekovaedward.domain;

import java.util.List;
import java.util.stream.Collectors;

public class AccountService {

    /* ----------------------------- predicate ----------------------------------------------------- */

    public List<Account> findGuests(List<Account> accounts) {
        return accounts.stream()
                .filter(a -> AccountType.GUEST.equals(a.getAccountType()))
                .collect(Collectors.toList());
    }

    public List<Account> findMembers(List<Account> accounts) {
        return accounts.stream()
                .filter(a -> AccountType.MEMBER.equals(a.getAccountType()))
                .collect(Collectors.toList());
    }

    public List<Account> findAdmins(List<Account> accounts) {
        return accounts.stream()
                .filter(a -> AccountType.ADMIN.equals(a.getAccountType()))
                .collect(Collectors.toList());
    }

    /* ----------------------------- sort ---------------------------------------------------------- */

    public List<Account> sort(List<Account> accounts) {
        return accounts.stream()
                       .sorted(Account.defaultSortOrder)
                       .collect(Collectors.toList());
    }
}
