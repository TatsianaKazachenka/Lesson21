package tests;

import adapters.*;
import objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUserReqresTest {

    @Test(description = "login successful")
    public void loginUserTest(){
        User user = User.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();
        String tokenRegister = new RegisterUserRegresAdapter().register(user);
        String tokenLogin = new LoginUserRegresAdapter().login(user);

        Assert.assertEquals(tokenRegister, tokenLogin);
    }

    @Test(description = "unsuccessful login")
    public void loginUserUnsuccessfulTest(){
        User user = User.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();
        new RegisterUserRegresAdapter().register(user);
        user = User.builder()
                .email("eve.holt@reqres.in")
                .build();
        String error = new LoginUserRegresAdapter().login(user);
        Assert.assertFalse(error.isEmpty());
    }
}
