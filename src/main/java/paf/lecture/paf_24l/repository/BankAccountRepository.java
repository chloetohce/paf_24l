package paf.lecture.paf_24l.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import paf.lecture.paf_24l.model.BankAccount;

@Repository
public class BankAccountRepository {
    @Autowired
    private JdbcTemplate template;

    public boolean isExistingAccount(int id) {
        // try {
        //     BankAccount acct = template.queryForObject(Query.SELECT_ACCOUNT,
        //             BeanPropertyRowMapper.newInstance(BankAccount.class), id);
        //     return true;
        // } catch (DataAccessException e) {
        //     return false;
        // }
        int count = template.queryForObject(Query.CHECK_EXISTING_ACCOUNT, Integer.class, id);
        return count >= 1;
    }
}
