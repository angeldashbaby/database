package angelbaby.database.controller;

import angelbaby.database.model.Location;
import angelbaby.database.model.User;
import angelbaby.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @PostMapping
    public User create(@RequestBody String payload) {
        return service.create(payload);
    }

    @PutMapping
    public User update(@RequestBody String payload) {
        return service.update(payload);
    }

    @GetMapping("/{id}")
    public User findByID(@PathVariable Long id) {
        return service.findByID(id);
    }
}
