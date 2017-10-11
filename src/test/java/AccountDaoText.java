package test.java;

import main.java.dao.AccountDao;
import main.java.domain.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

/**
 *
 *
 * Created by Tomecs on 2017/10/11.
 */
public class AccountDaoText extends AbstractTestCase {

    @Autowired
    private AccountDao accountDao;

    /**
     * 只要记得使用注解@Test标识方法即可！
     */
    @Test
    public void test(){
        Account ac = new Account();
        ac.setBirthday(new Date());
        ac.setUsername("spring");
        ac.setPassword("spring");
        ac.setEmail("spring@163.com");

        //创建用户
        accountDao.create(ac);
        //检索
        Account account = new Account();
        //校验
        assertNotNull(account);
    }
}
