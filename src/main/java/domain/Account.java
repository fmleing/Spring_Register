package main.java.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tomecs on 2017/10/10.
 */

/**
 * 通常，在构建域对象时，需要考虑该对象可能需要进行网络传输，
 * 本地缓存，因此建议实现序列化接口Serializable
 * 域对象与数据库表将完成一一对应绑定关系
 */
public class Account implements Serializable {
    private static final long serialVersionUID = -533698031946372178L;
    /**
     * 主键
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 生日
     */
    private Date birthday;

    /**
     * 邮箱
     */
    private String email;

    public Account() {

    }

    public Account(int id) {
        this.id = id;
    }

    /**
     * @param username
     * @param password
     */
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
