package objects;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;

@Data
public class UsersList {
    int page;
    @SerializedName("per_page")
    int perPage;
    int total;
    @SerializedName("total_pages")
    int totalPages;
    ArrayList<User> data;
    Support support;
}
