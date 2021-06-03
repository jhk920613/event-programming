package com.poscoict.account.store;

import com.poscoict.account.domain.entity.Account;
import com.poscoict.account.store.maria.AccountJpo;
import com.poscoict.account.store.maria.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class AccountStore {

    private final AccountRepository accountRepository;

    public AccountStore(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(Account account) {
        this.accountRepository.save(new AccountJpo(account));
    }

    public Account retrieveAccount(String accountId) {
        Optional<AccountJpo> jpo = this.accountRepository.findById(accountId);

        if(!jpo.isPresent()) {
            throw new NoSuchElementException(String.format("Account(%s) is not found.", accountId));
        } else {
            return jpo.get().toDomain();

        }
    }
}
