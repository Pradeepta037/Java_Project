public class PasswordManager {
    private static final int MAX_PASSWORDS = 10;
    private EncryptedPassword[] passwords;
    private int count;

    public PasswordManager() {
        this.passwords = new EncryptedPassword[MAX_PASSWORDS];
        this.count = 0;
    }

    public void addPassword(String password) {
        if (count < MAX_PASSWORDS) {
            passwords[count++] = new EncryptedPassword(password);
        } else {
            System.out.println("Password storage is full.");
        }
    }

    public String getPassword(int index) {
        if (index >= 0 && index < count) {
            return EncryptedPassword.decrypt(passwords[index].getPassword());
        }
        return null;
    }

    public void listPasswords() {
        for (int i = 0; i < count; i++) {
            System.out.println("Index " + i + ": " + EncryptedPassword.decrypt(passwords[i].getPassword()));
        }
    }
}
