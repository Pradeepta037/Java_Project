public class User {
    private String name;
    private String fatherName;
    private int age;
    private String accountType;
    private String aadhaarNo;
    private String mobileNo;
    private int pin;
    private double balance;

    public User(String name, String fatherName, int age, String accountType, String aadhaarNo, String mobileNo, int pin) {
        this.name = name;
        this.fatherName = fatherName;
        this.age = age;
        this.accountType = accountType;
        this.aadhaarNo = aadhaarNo;
        this.mobileNo = mobileNo;
        this.pin = pin;
        this.balance = 0.0;
    }

    public String getName() {
        return name;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Father's Name: " + fatherName);
        System.out.println("Age: " + age);
        System.out.println("Account Type: " + accountType);
        System.out.println("Aadhaar No.: " + aadhaarNo);
        System.out.println("Mobile No.: " + mobileNo);
        System.out.println("Balance: " + balance);
    }

    public String getAadhaarNo() {
        return aadhaarNo;
    }
}
