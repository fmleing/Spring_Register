package main.java.dao;

import main.java.domain.Account;

/**
 * Created by Tomecs on 2017/10/10.
 */
public interface AccountDao {
    /**
     * 读取账户信息
     * @param username
     * @return
     */
    Account read(String username);

    /**
     * 读取账户信息
     * @param id
     * @return
     */
    Account read(int id);

    /**
     * 构建用户记录
     * @param accouont
     */
    void create(Account accouont);
}
