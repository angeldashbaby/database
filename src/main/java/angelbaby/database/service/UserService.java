package angelbaby.database.service;

import angelbaby.database.model.Product;
import angelbaby.database.model.User;
import angelbaby.database.repository.ProductRepository;
import angelbaby.database.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

}
