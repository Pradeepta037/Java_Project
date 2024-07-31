public class Bank {
    private User[] userAccounts;
    private int userCount;

    public Bank(int maxUsers) {
        userAccounts = new User[maxUsers];
        userCount = 0;
    }

    public void createAccount(String name, String fatherName, int age, String accountType, String aadhaarNo, String mobileNo, int pin) {
        if (userCount >= userAccounts.length) {
            System.out.println("Cannot create more accounts, maximum limit reached.");
            return;
        }

        // Check if the Aadhaar number already exists
        for (int i = 0; i < userCount; i++) {
            if (userAccounts[i].getAadhaarNo().equals(aadhaarNo)) {
                System.out.println("Account already exists with this Aadhaar number.");
                return;
            }
        }

        User newUser = new User(name, fatherName, age, accountType, aadhaarNo, mobileNo, pin);
        userAccounts[userCount++] = newUser;
        System.out.println("Account created successfully.");
    }

    public User authenticate(String aadhaarNo, int pin) {
        for (int i = 0; i < userCount; i++) {
            if (userAccounts[i].getAadhaarNo().equals(aadhaarNo) && userAccounts[i].getPin() == pin) {
                return userAccounts[i];
            }
        }
        System.out.println("Invalid Aadhaar number or PIN.");
        return null;
    }
}
