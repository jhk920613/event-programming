package com.poscoict.account.store.maria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountJpo, String> {

}
