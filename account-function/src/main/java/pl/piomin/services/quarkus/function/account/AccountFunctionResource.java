package pl.piomin.services.quarkus.function.account;

import com.microsoft.azure.functions.annotation.FunctionName;
import io.quarkus.funqy.Funq;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import pl.piomin.services.quarkus.function.account.model.Account;

public class AccountFunctionResource {

    @Inject
    Logger log;

//    @FunctionName("add-account")
    @Funq("add-account")
    @Transactional
    public Account addAccount(Account account) {
        log.info(account);
        Account.persist(account);
        return account;
    }

//    @FunctionName("find-by-number")
    @Funq("by-number")
    public Account findByNumber(Account account) {
        log.info(account.number);
        return Account
                .find("number", account.number)
                .singleResult();
    }
}
