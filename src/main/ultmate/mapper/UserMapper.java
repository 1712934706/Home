package mapper;

import constants.TablesInfo;
import model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select({"select",TablesInfo.USER_TABLE_SELECT_COLUMNS,"from", TablesInfo.USER_TABLE_NAME, "where id=#{id}"})
    User selectUserById(int id);

    @Insert({"insert into",TablesInfo.USER_TABLE_NAME,"(",TablesInfo.USER_TABLE_INSERT_COLUMNS,")"," values(#{name},#{alias},#{password},#{email},#{mobilePhone},#{sex},#{age})"})
    boolean addUser(User user);
}
