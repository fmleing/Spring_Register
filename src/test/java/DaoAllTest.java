package test.java;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 *
 * @RunWith(Suite.class)集合测试
 * @SuiteClasses( { AccountDaoTest.class })集合，包括AccountDaoTest类，多个测试类可使用逗号分隔！
 * 这个测试类可用于Dao层集合测试，与Spring无关！
 *
 * Created by Tomecs on 2017/10/11.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({AccountDaoText.class})
public class DaoAllTest {
}
