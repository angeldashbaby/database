package angelbaby.database.controller;

import angelbaby.database.model.LoginCheck;
import angelbaby.database.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    @ResponseBody
    public LoginCheck loginView(@RequestBody String payload) {
        return service.login(payload);
    }
}
