package com.poscoict.account.api;

import com.poscoict.account.domain.entity.Account;
import com.poscoict.account.domain.logic.AccountLogic;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountResource {

    private final AccountLogic accountLogic;

    public AccountResource(AccountLogic accountLogic) {
        this.accountLogic = accountLogic;
    }

    @PostMapping
    public String registerAccount(@RequestBody RegisterAccountCommand command) {

        String newAccountId = accountLogic.registerAccount(command);

        return newAccountId;
    }

    @GetMapping(value = "/{accountId}")
    public Account findAccount(@PathVariable("accountId") String accountId) {

        return accountLogic.findAccount(accountId);
    }

//    @GetMapping
//    public Account findAccount2(@RequestParam("accountId") String accountId) {
//
//        return accountLogic.findAccount(accountId);
//    }


}
