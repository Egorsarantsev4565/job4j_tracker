package ru.job4j.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
     users.putIfAbsent(user, new ArrayList<Account>());
        }
    public void addAccount(String passport, Account account) {
List<Account>accounts = users.get(findByPassport(passport));
if(!accounts.contains(account)) {
        accounts.add(account);
}
}

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> accounts = users.get(findByPassport(passport));
        if (accounts != null) {
            for (Account ac : accounts) {
                if (ac.getRequisite().equals(requisite)) {
                    ;
                    return ac;
                }
            }

        }
        return null;
    }
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport,srcRequisite);
        Account destAccount = findByRequisite(destPassport,destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}