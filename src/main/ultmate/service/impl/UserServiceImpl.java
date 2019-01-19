package service.impl;

import dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private UserDaoImpl userDao;

    /**
     * 用户登录
     */
    public void userLoginService()
    {

    }

    /**
     * 创建用户
     */
    public void createUserService()
    {

    }

    /**
     * 更新用户信息
     * @param
     */
    public void updateUserService()
    {

    }

    /**
     * 注销用户
     */
    public void deleteUserService()
    {

    }

}
