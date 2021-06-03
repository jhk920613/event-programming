package com.poscoict.account.handler;

import com.poscoict.account.event.AccountRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccountEventHandler {

    @EventListener
    public void on(AccountRegisteredEvent event) {
        System.out.println("AccountEventHandler.on(AccountRegisteredEvent)");
        System.out.println(event.getAccountId());
    }

}
