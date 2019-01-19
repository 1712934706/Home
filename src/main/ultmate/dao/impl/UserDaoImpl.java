package dao.impl;

import dao.intf.UserDaoIntf;
import mapper.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户DAO层
 */
@Repository
public class UserDaoImpl implements UserDaoIntf {

    @Autowired
    private UserMapper userMapper;

    public UserDaoImpl() {
        super();
    }

    @Override
    public boolean createUserDao(User user) {

        userMapper.addUser(user);
        return true;
    }

    @Override
    public boolean updateUserDao() {
        return false;
    }

    @Override
    public boolean deleteUserDao() {
        return false;
    }

    @Override
    public boolean deleteBatchUserDao() {
        return false;
    }

    @Override
    public User seleteUserDao(int id) {
        User user=userMapper.selectUserById(id);
        return user;
    }

    @Override
    public List<User> seleteBatchUserDao() {
        return null;
    }
}
