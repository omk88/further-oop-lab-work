import java.util.*;

import java.util.Scanner;
import java.util.Random;

interface Account
{
    String getName(); // Returns the customer name
    int getNumber(); // Returns the account number
    int getBalance(); // Returns the current balance
    boolean withdraw(int amount); // Reduces the balance by amount
    // and returns true or leaves it unchanged and returns false
    boolean deposit(int amount); // Increases the balance by amount
// and returns true or leaves it unchanged and returns false
}

class BasicAccount implements Account {
    private String name;
    private int number;
    private int balance;
    private Customer customer;
    private int pin;

    public BasicAccount(String name, int number, int pin) {
        this.customer = new Customer();
        this.name = name;
        this.number = number;
        this.pin = pin;
        this.balance = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getBalance() {
        if (customer.getPin(this) == pin) {
            return balance;
        } else {
            return 0;
        }

    }

    @Override
    public boolean withdraw(int amount) {
        if (getBalance() - amount < 0 || customer.getPin(this) != pin) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    @Override
    public boolean deposit(int amount) {
        if (amount > 0 && customer.getPin(this) == pin) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }
}

class CreditAccount extends BasicAccount {
    private int limit;
    private Customer customer;
    private int pin;

    public CreditAccount(String name, int number, int pin) {
        super(name, number, pin);
        this.customer = new Customer();
    }

    public boolean withdraw(int amount) {
        if (amount < limit && customer.getPin(this) != pin) {
            return true;
        } else {
            return false;
        }
    }

    public void setLimit(int newLimit) {
        limit = newLimit;
    }

}

class SavingAccount extends BasicAccount {
    private int balance = getBalance();
    private int withdrawLimit;
    private int withdrawCount;
    private double interest;
    private Customer customer;
    private int pin;

    public SavingAccount(String name, int number, int pin) {
        super(name, number, pin);
        this.customer = new Customer();
    }

    public boolean withdraw(int amount) {
        if (withdrawCount != withdrawLimit && customer.getPin(this) != pin) {
            if (getBalance() - amount < 0) {
                return false;
            } else {
                withdrawCount += 1;
                return true;
            }
        } else {
            return false;
        }
    }

    public void addInterest() {
        balance += (balance/100)*interest;
    }

    public void setInterest(double newInterest) {
        interest = newInterest;
    }

    public void setWithdrawLimit(int newWithdrawLimit) {
        withdrawLimit = newWithdrawLimit;
    }
}

class Bank {
    private BasicAccount Account;
    Set<BasicAccount> accounts = new HashSet<BasicAccount>();

    public BasicAccount createAccount(String name, int accountType){
        Random rand = new Random();

        if (accountType == 1) {
            BasicAccount Account = new BasicAccount(name, rand.nextInt(100), rand.nextInt(9999));
        } else if (accountType == 2) {
            CreditAccount Account = new CreditAccount(name, rand.nextInt(100), rand.nextInt(9999));
        } else if (accountType == 3) {
            SavingAccount Account = new SavingAccount(name, rand.nextInt(100), rand.nextInt(9999));
        }
        accounts.add(Account);
        return Account;
    }

    public Set<BasicAccount> getAccounts(String name) {
        Set<BasicAccount> returnAccounts = null;

        for (Iterator<BasicAccount> i = accounts.iterator(); i.hasNext();) {
            BasicAccount acc = i.next();
            if (acc.getName().equals(name)) {
                returnAccounts.add(acc);
            }
        }

        return returnAccounts;
    }
}

class Customer {
    public int getPin(Account acc) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter pin: ");
        String pin = scanner.nextLine();

        return Integer.parseInt(pin);
    }
}
