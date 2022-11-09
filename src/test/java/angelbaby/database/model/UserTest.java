package angelbaby.database.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getUserID() {
        User user = new User(1L, "user01", "userpass");
        assertEquals(user.getUserID(), 1L);
    }

    @Test
    void getUsername() {
        User user = new User(1L, "user01", "userpass");
        assertEquals(user.getUsername(), "user01");
    }

    @Test
    void getPassword() {
        User user = new User(1L, "user01", "userpass");
        assertEquals(user.getPassword(), "userpass");
    }

    @Test
    void setUserID() {
        User user = new User(1L, "user01", "userpass");
        user.setUserID(2L);
        assertEquals(user.getUserID(), 2L);
    }

    @Test
    void setUsername() {
        User user = new User(1L, "user01", "userpass");
        user.setUsername("user02");
        assertEquals(user.getUsername(), "user02");
    }

    @Test
    void setPassword() {
        User user = new User(1L, "user01", "userpass");
        user.setPassword("userpass");
        assertEquals(user.getPassword(), "userpass");
    }
}