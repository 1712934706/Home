package controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;
import utils.JsonData;

/**
 * 用户相关信息控制类
 */
@Api(value = "/user", tags = "用户接口模块")
@RestController
@RequestMapping(path = "/user")
public class UserController {

  /**
   * 日志工具
   */
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  private UserService userService;

  //使用spring推荐的构造器注入
  @Autowired
  UserController(UserService userService) {
    this.userService = userService;
  }

  @ApiOperation(value = "根据id查询用户信息", notes = "查询用户信息")
  @GetMapping("/getUserInfo")
  public JsonData<User> getUserInfoByID(@RequestParam(name = "id") int id) {
    logger.info("开始获取用户信息，id is {}", id);
    return userService.getUserInfoByID(id);
  }

  @ApiOperation(value = "添加用户", notes = "添加用户,id会自增")
  @PostMapping("/addUser")
  public JsonData addUser(@RequestBody User user) {
    logger.info("开始添加用户信息");
    return userService.addUser(user);
  }

}
