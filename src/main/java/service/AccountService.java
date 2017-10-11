package main.java.service;

import main.java.domain.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户业务接口
 * 细化一下AccountService接口方法
 * Created by Tomecs on 2017/10/10.
 * 接口不需要任何Spring注解相关的东西，它就是一个简单的接口！
 * 重要的部分在于实现层
 */
public interface AccountService {

    /**
     * 改造后
     */

    /**
     * 获得账户
     * @param username
     * @param password
     * @return
     */
    @Transactional(readOnly = true)
    Account read(String username, String password);

    /**
     * 获得账户
     * @Transactional(readOnly = true)只读属性
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    Account read(int id);


    /**
     * 注册用户
     * 第三次修改后添加的代码
     * @Transactional(readOnly = false, rollbackFor = DataAccessException.class)只读关闭，
     * 遇到DataAccessException异常回滚！如果不对异常进行处理，该异常将一直向上层抛出，直至抛出到页面！
     * @param account
     * @return
     */
    @Transactional(readOnly = true, rollbackFor = DataAccessException.class)
    Account register(Account account);
    /**
     * 改造前
     */
//    boolean verify(String username, String password);
}
