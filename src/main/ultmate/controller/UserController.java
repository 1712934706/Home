package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import service.UserService;
import utils.JsonData;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public JsonData<User> getUserInfoByID() {
        User user = userService.getUserInfoByID(1);
        return new JsonData<>(true, "成功", user);
    }

}
