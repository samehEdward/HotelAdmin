package at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence;

import at.spengergasse.sj21227acifpos1niiazbekovaedward.domain.Account;
import at.spengergasse.sj21227acifpos1niiazbekovaedward.persistence.Projection.AccountNamePasswordInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNameIs(String accountName);
    List<Account> findByAccountNameLike(String accountName);

    List<AccountNamePasswordInfo> findAllByAccountNameLike(String accountNamePart);

}
