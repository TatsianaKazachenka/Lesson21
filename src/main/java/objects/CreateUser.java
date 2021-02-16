package objects;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateUser {
    String name;
    String job;
    String id;
    String createdAt;
}
