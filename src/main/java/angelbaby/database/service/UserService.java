package angelbaby.database.service;

import angelbaby.database.model.LoginCheck;
import angelbaby.database.model.User;
import angelbaby.database.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User create(String payload) {
        JSONObject obj = new JSONObject(payload);
        User user = new User();
        user.setUsername((String) obj.get("username"));
        user.setPassword((String) obj.get("password"));
        return userRepository.save(user);
    }

    public User update(String payload) {
        JSONObject obj = new JSONObject(payload);
        User user = userRepository.findById(Long.valueOf((Integer) obj.get("userID"))).get();
        if (obj.has("username")) user.setUsername((String) obj.get("username"));
        if (obj.has("password")) user.setPassword((String) obj.get("password"));
        return userRepository.save(user);
    }

    public User findByID(Long id) {
        return userRepository.findById(id).get();
    }

    public LoginCheck login(String payload) {
        JSONObject obj = new JSONObject(payload);
        LoginCheck response = new LoginCheck();
        String username = null;
        String password = null;
        if (obj.has("username")) username = (String) obj.get("username");
        if (obj.has("password")) password = (String) obj.get("password");

        if (username == null) {
            response.setSuccess(false);
            response.setError("Missing input \"username\"");
            return response;
        }
        if (password == null) {
            response.setSuccess(false);
            response.setError("Missing input \"password\"");
            return response;
        }

        User user = userRepository.findByUsername(username);

        if (user == null) {
            response.setSuccess(false);
            response.setError("User not found");
            return response;
        }
        if (!user.getPassword().equals(password)) {
            response.setSuccess(false);
            response.setError("Password doesn't match");
            return response;
        }

        response.setSuccess(true);
        response.setError("");
        return response;
    }

}
