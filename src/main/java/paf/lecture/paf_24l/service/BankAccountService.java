package paf.lecture.paf_24l.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import paf.lecture.paf_24l.exception.AccountInactiveException;
import paf.lecture.paf_24l.model.BankAccount;
import paf.lecture.paf_24l.repository.BankAccountRepository;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository repository;

    public boolean isExistingAccount(int id) {
        return repository.isExistingAccount(id);
    }

    public BankAccount getAccountById(int id) {
        return repository.getAccountById(id);
    }

    @Transactional
    public void transfer(int transfererId, int transfereeId, float amt) {
        // Retrieve both accounts
        BankAccount transferer = repository.getAccountById(transfererId);
        BankAccount transferee = repository.getAccountById(transfereeId);

        // Check if account is active
        boolean boolTransferer = transferer.isAccountActive();
        boolean boolTransferee = transferee.isAccountActive();

        // Check tranferer has sufficient balance to transfer the amount
        boolean boolBalance = transferer.hasSufficientBalance(amt);

        if (boolTransferer && boolTransferee && boolBalance) {
            transferer.setBalance(transferer.getBalance() - amt);
            transferee.setBalance(transferee.getBalance() + amt);
            repository.updateAccountById(transferee);
            repository.updateAccountById(transferer);
        }
    }
}
