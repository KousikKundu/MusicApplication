package com.stackroute.accountmanager.repository;

import com.stackroute.accountmanager.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {

    public UserAccount findByUserNameAndPassword(String userName, String password);

}
