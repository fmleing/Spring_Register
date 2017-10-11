package main.java.dao.impl;

import main.java.dao.AccountDao;
import main.java.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 账户数据库实现
 *
 * 注解@Repository明确这个类是用于持久层的实现类，注意这样的注解不能用于接口，仅适用于实现类！
 * 同时，不再需要继承JdbcDaoSupport类，其而代之的是直接注入JdbcTemplate类！
 * Created by Tomecs on 2017/10/10.
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * (no-javadoc)
     * @see main.java.dao.AccountDao#read(String)
     * @param username
     * @return
     */
    @Override
    public Account read(String username) {
        String sql = "select * from account where username = ?";
        return (Account)jdbcTemplate.queryForObject(sql, new Object[]{username}, accountRowMap);
    }

    @Override
    public Account read(int id) {
        String sql = "select * from account where id = ?";
        return (Account) jdbcTemplate.queryForObject(sql, new Object[]{id}, accountRowMap);
    }

    @Override
    public void create(Account accouont) {
        String sql = "INSERT INTO account(username, password, birthday, email) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{accouont.getUsername(), accouont.getPassword(), accouont.getBirthday(), accouont.getEmail()});
    }

    /**
     * 这里使用 RowMapper 定义了一个用于绑定Account域对象的内部映射类：
     */
    protected RowMapper accountRowMap = new RowMapper() {
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setUsername(rs.getString("username"));
            account.setPassword(rs.getString("password"));
            account.setBirthday(rs.getDate("birthday"));
            account.setEmail(rs.getString("email"));
            return account;
        }
    };
}
