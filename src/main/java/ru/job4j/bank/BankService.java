package ru.job4j.bank;

import java.util.*;

public class BankService {

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {

        users.putIfAbsent(user, new ArrayList<Account>());
        }

    public void addAccount(String passport, Account account) {
        Optional <User> opt = findByPassport(passport);

            if (opt.isPresent()) {
                List<Account> accounts = users.get(opt.get());
                if (!accounts.contains(account)) {
                    accounts.add(account);
                }
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> opt = findByPassport(passport);
        Optional<Account> b = Optional.empty();
        if (opt.isPresent()) {
            return users.get(opt.get()).stream()
                    .filter(r -> r.getRequisite().equals(requisite))
                    .findAny();
        }
        return b;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
       Optional <Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
       Optional <Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
            && destAccount.isPresent()
                && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}