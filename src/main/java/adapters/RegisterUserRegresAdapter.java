package adapters;

import io.restassured.response.ResponseBody;
import lombok.extern.log4j.Log4j2;
import objects.User;

@Log4j2
public class RegisterUserRegresAdapter extends ReqresBaseAdapter{
    private static final String USERS_REGISTER_URL = "register";

    public String register(User user){
        ResponseBody body = post(USERS_REGISTER_URL, converter.toJson(user))
                .body();
        try {
            if(!body.path("error").toString().isEmpty()){
                return body.path("error");
            }
            else{
                return body.path("token");
            }
        }
        catch (Exception ex){
            log.info("Catch exception: " + ex.getMessage());
            return null;
        }
    }
}
