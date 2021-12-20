package Week7_Mysql.homework9.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * user_id 用户ID， user_name 用户名， password 密码， mail 邮箱， phone_number 手机号 user_address 用户地址， create_timestamp 创建时间， update_timestamp 更新时间
 * </p>
 *
 * @author jobob
 * @since 2021-12-20
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer user_id;

    private String user_name;

    private String password;

    private String mail;

    private String phone_number;

    private String user_address;

    private LocalDateTime create_timestamp;

    private LocalDateTime update_timestamp;


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public LocalDateTime getCreate_timestamp() {
        return create_timestamp;
    }

    public void setCreate_timestamp(LocalDateTime create_timestamp) {
        this.create_timestamp = create_timestamp;
    }

    public LocalDateTime getUpdate_timestamp() {
        return update_timestamp;
    }

    public void setUpdate_timestamp(LocalDateTime update_timestamp) {
        this.update_timestamp = update_timestamp;
    }

    @Override
    public String toString() {
        return "User{" +
        "user_id=" + user_id +
        ", user_name=" + user_name +
        ", password=" + password +
        ", mail=" + mail +
        ", phone_number=" + phone_number +
        ", user_address=" + user_address +
        ", create_timestamp=" + create_timestamp +
        ", update_timestamp=" + update_timestamp +
        "}";
    }
}
