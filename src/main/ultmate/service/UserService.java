package service;

import model.User;
import utils.JsonData;

/**
 * 用户服务类
 */
public interface UserService {

    /**
     * 根据用户id获取用户信息
     *
     * @param id 用户id
     * @return 返回结果
     */
    JsonData<User> getUserInfoByID(int id);

    /**
     * 新增用户
     *
     * @param id 用户id
     * @return 返回结果
     */
    JsonData addUser(User user);
}
