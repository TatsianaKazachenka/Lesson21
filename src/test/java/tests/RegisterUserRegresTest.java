package tests;

import adapters.RegisterUserRegresAdapter;
import objects.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterUserRegresTest {

    @Test(description = "successful registration")
    public void registerUserTest(){
        User user = User.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();
        String token = new RegisterUserRegresAdapter().register(user);
        Assert.assertFalse(token.isEmpty());
    }

    @Test(description = "unsuccessful registration")
    public void registerUserUnsuccessfulTest(){
        User user = User.builder()
                .email("sydney@fife")
                .build();
        String error = new RegisterUserRegresAdapter().register(user);
        Assert.assertFalse(error.isEmpty());
    }
}
