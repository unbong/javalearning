package Week7_Mysql.homework9.mapper;

import Week7_Mysql.homework9.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * user_id 用户ID， user_name 用户名， password 密码， mail 邮箱， phone_number 手机号 user_address 用户地址， create_timestamp 创建时间， update_timestamp 更新时间 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2021-12-20
 */
public interface UserMapper extends BaseMapper<User> {

}
