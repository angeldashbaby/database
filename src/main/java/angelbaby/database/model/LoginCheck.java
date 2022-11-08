package angelbaby.database.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class LoginCheck {

    private boolean success;
    private String error;
    private long userId;
}
