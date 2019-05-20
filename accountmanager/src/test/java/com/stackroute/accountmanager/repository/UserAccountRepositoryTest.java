package com.stackroute.accountmanager.repository;

import com.stackroute.accountmanager.model.UserAccount;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserAccountRepositoryTest {

    @Autowired
    private UserAccountRepository userRepository;

    private UserAccount user;

    @Before
    public void setUp()  {
        user = new UserAccount();
        user.setUserName("kousik");
        user.setPassword("kousik");
    }

    @After
    public void tearDown()  {
        userRepository.deleteAll();
        user = null;
    }

    @Test
    public void testSaveUserSuccess(){
        userRepository.save(user);
        UserAccount userObj = userRepository.findById(user.getUserId()).get();
        Assert.assertEquals(userObj.getUserName(), user.getUserName());
        userRepository.delete(user);
    }

    @Test
    public void testUserLoginSuccess(){
        userRepository.save(user);
        UserAccount userObj = userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword());
        Assert.assertEquals(userObj.getUserName(), user.getUserName());
        userRepository.delete(user);
    }
}
