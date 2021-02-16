package adapters;

import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import objects.*;

@Log4j2
public class UserRegresAdapter extends ReqresBaseAdapter {

    private static final String USERS_URL = "users";

    public UsersList getListUsers(int page) {
        String body = get(String.format("%s?page=%s", USERS_URL, page));
        try {
            UsersList list = new Gson().fromJson(body, UsersList.class);
            return list;
        }
        catch (Exception ex){
            log.info("Catch exception: " + ex.getMessage());
            return null;
        }
    }

    public SingleUser getUser(int id) {
        String body = get(String.format("%s/%s", USERS_URL, id));
        try {
            SingleUser user = new Gson().fromJson(body, SingleUser.class);
            return user;
        }
        catch (Exception ex){
            log.info("Catch exception: " + ex.getMessage());
            return null;
        }
    }

    public int getStatusCode(int id) {
        try {
            int code = getStatusCode(String.format("%s/%s", USERS_URL, id));
            return code;

        }
        catch (Exception ex){
            log.info("Catch exception: " + ex.getMessage());
            return -1;
        }
    }

    public String create(CreateUser user){
        return post(USERS_URL, converter.toJson(user))
                .body()
                .path("id");
    }

    public CreateUser updatePut(CreateUser user, int id){
        String body = put(String.format("%s/%s", USERS_URL, id), converter.toJson(user)).body().asPrettyString();
        try {
            CreateUser updateUser = new Gson().fromJson(body, CreateUser.class);
            return updateUser;
        }
        catch (Exception ex){
            log.info("Catch exception: " + ex.getMessage());
            return null;
        }
    }

    public CreateUser updatePatch(CreateUser user, int id){
        String body = patch(String.format("%s/%s", USERS_URL, id), converter.toJson(user)).body().asPrettyString();
        try {
            CreateUser updateUser = new Gson().fromJson(body, CreateUser.class);
            return updateUser;
        }
        catch (Exception ex){
            log.info("Catch exception: " + ex.getMessage());
            return null;
        }
    }

    public int userDelete(int id) {
        try {
            int code = delete(String.format("%s/%s", USERS_URL, id));
            return code;

        }
        catch (Exception ex){
            log.info("Catch exception: " + ex.getMessage());
            return -1;
        }
    }
}
