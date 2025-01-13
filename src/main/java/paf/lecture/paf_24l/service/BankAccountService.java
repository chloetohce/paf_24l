package paf.lecture.paf_24l.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.lecture.paf_24l.repository.BankAccountRepository;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository repository;

    public boolean isExistingAccount(int id) {
        return repository.isExistingAccount(id);
    }
}
