package com.poscoict.account.store.maria;

import com.poscoict.account.domain.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_ACCOUNT")
public class AccountJpo {

    @Id
    @Column
    private String id;
    @Column(name = "E_MAIL")
    private String email;
    @Column(name = "NM")
    private String name;

    public AccountJpo(Account account) {
//        BeanUtils.copyProperties(this, account);
        this.id = account.getId();
        this.email = account.getEmail();
        this.name = account.getName();
    }

    public Account toDomain() {
        return new Account(id, email, name);
    }
}
