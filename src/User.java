package src;

public class User {
    private String firstname;
    private String lastname;
    private String email;
    private double balance;
    private String accountNumber;
    private String userpassword;

    public User(String firstname, String lastname, String email, double balance, String userpassword) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.balance = balance;
        this.accountNumber = "ACCT" + (int) (Math.random() * 1000000); // Random account number
        this.userpassword = userpassword;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getUserPassword() {
        return userpassword;
    }

    public void deposit(double amount) {
        if (amount > 0)
            balance += amount;
        else
            System.out.println("Deposit amount must be positive.");
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance)
            balance -= amount;
        else
            System.out.println("Invalid withdrawal amount.");
    }
}
