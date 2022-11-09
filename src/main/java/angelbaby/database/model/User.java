package angelbaby.database.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @SequenceGenerator(name="user_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
    private Long userID;

    private String username;
    private String password;

    public User(Long userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }
}
