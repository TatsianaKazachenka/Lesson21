package tests;

import adapters.*;
import lombok.extern.log4j.Log4j2;
import objects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Integer.parseInt;

@Log4j2
public class UserReqresTest {

    @Test(description = "checking the user list query page")
    public void checkPageListUserTest(){
        int page = 2;
        UsersList list = new UserRegresAdapter().getListUsers(page);
        int getNumberPage = list.getPage();
        log.info(String.format("get users on %s page", getNumberPage));
        Assert.assertEquals(page, getNumberPage);
    }

    @Test(description = "checking the called user by")
    public void checkUserByIdTest(){
        int id = 2;
        SingleUser user = new UserRegresAdapter().getUser(id);
        int getUserId = user.getData().getId();
        log.info(String.format("get users id = ", id));
        Assert.assertEquals(id, getUserId);
    }

    @Test(description = "checking user not found")
    public void checkUserNotFoundTest(){
        int id = 23;
        int code = 404;
        int statusCode = new UserRegresAdapter().getStatusCode(id);
        Assert.assertEquals(code, statusCode);
    }


    @Test(description = "user creation")
    public void createUserTest(){
        CreateUser user = CreateUser.builder()
                .name("morpheus")
                .job("leader")
                .build();
        int id = parseInt(new UserRegresAdapter().create(user));
        log.info("created id = " + id);
        Assert.assertTrue(id >= 0);
    }

    @Test(description = "user update with put")
    public void updatePutUserTest(){
        String name = "morpheus_put";
        CreateUser user = CreateUser.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        int id = parseInt(new UserRegresAdapter().create(user));
        user = CreateUser.builder()
                .name(name)
                .job("leader")
                .build();
        String nameUpdate  = new UserRegresAdapter().updatePut(user, id).getName();
        Assert.assertEquals(name, nameUpdate);
    }

    @Test(description = "user update with patch")
    public void updatePatchUserTest(){
        String name = "morpheus_patch";
        CreateUser user = CreateUser.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        int id = parseInt(new UserRegresAdapter().create(user));
        user = CreateUser.builder()
                .name(name)
                .job("leader")
                .build();
        String nameUpdate  = new UserRegresAdapter().updatePatch(user, id).getName();
        Assert.assertEquals(name, nameUpdate);
    }

    @Test(description = "delete user")
    public void deleteUserTest(){
        CreateUser user = CreateUser.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        int id = parseInt(new UserRegresAdapter().create(user));
        int code = 204;
        int statusCode = new UserRegresAdapter().userDelete(id);
        Assert.assertEquals(code, statusCode);
    }
}
