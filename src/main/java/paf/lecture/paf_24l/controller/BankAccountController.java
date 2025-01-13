package paf.lecture.paf_24l.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paf.lecture.paf_24l.service.BankAccountService;


@RestController
@RequestMapping("/api/accounts")
public class BankAccountController {
    @Autowired
    private BankAccountService service;

    @GetMapping("/exists/{id}")
    public String checkAccountExists(@PathVariable String id) {
        return Boolean.toString(service.isExistingAccount(Integer.parseInt(id)));
    }
    
}
