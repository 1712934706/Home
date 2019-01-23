package service;

import model.User;

/**
 * 用户服务类
 */
public interface UserService {

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    User getUserInfoByID(int id);
}
