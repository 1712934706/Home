package dao.intf;

import model.User;
import java.util.List;

public interface UserDaoIntf {
    /**
     * 创建用户
     *
     * @return
     */
    boolean createUserDao(User user);

    /**
     * 更新用户
     *
     * @return
     */
    boolean updateUserDao();

    /**
     * 删除用户
     *
     * @return
     */
    boolean deleteUserDao();

    /**
     * 批量删除用户
     *
     * @return
     */
    boolean deleteBatchUserDao();

    /**
     * 查询用户
     *
     * @return
     */
    User seleteUserDao(int id);

    /**
     * 批量查询用户
     *
     * @return
     */
    List<User> seleteBatchUserDao();
}
