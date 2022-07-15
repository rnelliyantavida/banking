package com.springBootProject.accountTransaction.repositories;

import com.springBootProject.accountTransaction.beans.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

}
