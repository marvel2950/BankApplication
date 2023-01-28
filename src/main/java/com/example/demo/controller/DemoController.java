package com.example.demo.controller;

import com.example.demo.database.CurrentAccount;
import com.example.demo.database.Details;
import com.example.demo.database.SavingsAccount;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DemoController {

    ArrayList<CurrentAccount> accountsList;

    public DemoController() {

        //Demo data
        this.accountsList = new ArrayList<>();

        CurrentAccount currentAccount1 = new CurrentAccount("Akarsh", 2345,
                420, new SavingsAccount(2345,0));
        CurrentAccount currentAccount2 = new CurrentAccount("Doraemon", 6789,
                30, new SavingsAccount(6789,0));

        this.accountsList.add(currentAccount1);
        this.accountsList.add(currentAccount2);
    }

    @GetMapping("/testing")
    public String test() {
        return "Akarsh";
    }

    @PostMapping("/transfer")
    public String transaction(@RequestBody Details details){

        int accountNumber = details.getAccountNumber();
        double amount = details.getAmount();

        //Instead of primary key
        for(CurrentAccount i : accountsList){
            if(i.getAccountNumber() == accountNumber){
                double roundOff = Math.ceil(amount)-amount;
                i.setBalance(i.getBalance()-Math.ceil(amount));
                i.getSavingsAccount().setBalance(i.getSavingsAccount().getBalance()+roundOff);
            }
        }

        System.out.println(accountsList);

        return "Transaction successful !";
    }
}

