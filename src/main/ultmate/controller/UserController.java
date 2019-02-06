package controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;
import utils.JsonData;

/**
 * 用户相关信息控制类
 */
@Api(value="/user", tags="用户接口模块")
@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    //使用spring推荐的构造器注入
    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value="根据id查询用户信息", notes = "查询用户信息")
    @GetMapping("/getUserInfo")
    public JsonData<User> getUserInfoByID(@RequestParam(name = "id") int id) {
        User user = userService.getUserInfoByID(id);
        return new JsonData<>(true, "成功", user);
    }

}
