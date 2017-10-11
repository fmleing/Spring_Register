package main.java.service.impl;

import main.java.dao.AccountDao;
import main.java.domain.Account;
import main.java.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户业务
 * Created by Tomecs on 2017/10/10.
 * 注解@Service用于标识这是一个Service层实现，
 * @Transactional 用于控制事务，将事务定位在业务层，这是非常务实的做法！
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account read(String username, String password) {
        Account account = accountDao.read(username);
        if (!password.equals(account.getPassword())) {
            account = null;
        }
        return account;
    }

    @Override
    public Account read(int id) {
        Account account = accountDao.read(id);
        return account;
    }

    /**
     * 注册用户
     *
     * @param account
     * @return  在插入一条记录后获得当前用户的主键，我们还得这么玩!
     */
    @Override
    public Account register(Account account) {
        accountDao.create(account);
        return accountDao.read(account.getUsername());
    }

    /**
     * @see main.java.service.AccountService#verify(java.lang.String,java.lang.String)
     * @param username
     * @param password
     * @return
     */
   /* @Override
    public boolean verify(String username, String password) {
        Account account = accountDao.read(username);
        if (password.equals(account.getPassword())) {
            return true;
        } else {
            return false;
        }
    }*/
}
