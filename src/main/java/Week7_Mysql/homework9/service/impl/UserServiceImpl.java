package Week7_Mysql.homework9.service.impl;

import Week7_Mysql.homework9.entity.User;
import Week7_Mysql.homework9.mapper.UserMapper;
import Week7_Mysql.homework9.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * user_id 用户ID， user_name 用户名， password 密码， mail 邮箱， phone_number 手机号 user_address 用户地址， create_timestamp 创建时间， update_timestamp 更新时间 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-12-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
