package com.stackroute.accountmanager.service;

import com.stackroute.accountmanager.exception.UserNotFoundException;
import com.stackroute.accountmanager.model.UserAccount;
import com.stackroute.accountmanager.repository.UserAccountRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class UserAccountServiceTest {

    @Mock
    private UserAccountRepository userRepository;
    private UserAccount user;

    @InjectMocks
    private UserAccountServiceImpl userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new UserAccount();
        user.setUserName("kousik");
        user.setPassword("kousik");

    }

    @Test
    public void testSaveUserSuccess(){

        Mockito.when(userRepository.save(user)).thenReturn(user);
        UserAccount fetchuser = userService.saveUser(user);
        Assert.assertEquals(user, fetchuser);
        verify(userRepository, times(1)).save(user);

    }
    @Test
    public void testFindByUserNameAndPassword() throws UserNotFoundException {
        Mockito.when(userRepository.findByUserNameAndPassword(user.getUserName(),user.getPassword())).thenReturn(user);
        UserAccount fetchedUser = userService.findByUserNameAndPassword(user.getUserName(),user.getPassword());
        Assert.assertEquals(user, fetchedUser);
        verify(userRepository, times(1)).findByUserNameAndPassword(user.getUserName(),user.getPassword());

    }
}
