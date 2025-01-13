package paf.lecture.paf_24l.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import paf.lecture.paf_24l.exception.AccountNotFoundException;
import paf.lecture.paf_24l.model.BankAccount;

@Repository
public class BankAccountRepository {
    @Autowired
    private JdbcTemplate template;

    public boolean isExistingAccount(int id) {
        try {
            template.queryForObject(Query.SELECT_ACCOUNT,
                    BeanPropertyRowMapper.newInstance(BankAccount.class), id);
            return true;
        } catch (DataAccessException e) {
            throw new AccountNotFoundException("The account you are querying does not exist.");
        }
        // int count = template.queryForObject(Query.CHECK_EXISTING_ACCOUNT, Integer.class, id);
        // return count >= 1;
    }

    public BankAccount getAccountById(int id) {
        try {
            return template.queryForObject(Query.SELECT_ACCOUNT, BeanPropertyRowMapper.newInstance(BankAccount.class), id);
        } catch (DataAccessException e) {
            throw new AccountNotFoundException("The account associated with id %s does not exist.".formatted(id));
        }
    }

    public boolean updateAccountById(BankAccount account) {
        int accountUpdated = template.update(Query.UPDATE_ACCOUNT, account.getBalance(), account.getId());
        return accountUpdated > 0;
    }
}
