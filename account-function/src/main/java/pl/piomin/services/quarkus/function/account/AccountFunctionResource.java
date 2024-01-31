package pl.piomin.services.quarkus.function.account;

import io.quarkus.funqy.Funq;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import pl.piomin.services.quarkus.function.account.model.Account;

public class AccountFunctionResource {

    @Inject
    Logger log;

    @Funq("add-account")
    @Transactional
    public Account addAccount(Account account) {
        log.infof("Add: %s", account);
        Account.persist(account);
        return account;
    }

    @Funq("by-number")
    public Account findByNumber(Account account) {
        log.infof("Find: %s", account.number);
        return Account
                .find("number", account.number)
                .singleResult();
    }
}
