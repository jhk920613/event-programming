package com.poscoict.account.domain.logic;

import com.poscoict.account.api.RegisterAccountCommand;
import com.poscoict.account.domain.entity.Account;
import com.poscoict.account.event.AccountRegisteredEvent;
import com.poscoict.account.store.AccountStore;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountLogic {

    private final AccountStore accountStore;
    private final ApplicationEventPublisher eventPublisher;

    public AccountLogic(
            AccountStore accountStore,
            ApplicationEventPublisher eventPublisher
    ) {
        this.accountStore = accountStore;
        this.eventPublisher = eventPublisher;
    }

    public String registerAccount(RegisterAccountCommand command) {

        // id generate
        String newAccountId = UUID.randomUUID().toString();

        // new Account
        Account account = new Account(newAccountId, command.getEmail(), command.getName());

        // insert
        accountStore.createAccount(account);

        // event publish
        eventPublisher.publishEvent(new AccountRegisteredEvent(newAccountId));

        return newAccountId;
    }

    public Account findAccount(String accountId) {

        return accountStore.retrieveAccount(accountId);
    }

}
