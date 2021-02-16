package objects;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Resource {
    int id;
    String name;
    String year;
    String color;
    @SerializedName("pantone_value")
    String pantoneValue;
}
