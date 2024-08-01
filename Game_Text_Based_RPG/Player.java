import java.util.Scanner;

class Player extends Character {
    private Scanner scanner;
    
    public Player(String name, int health, int attackPower) {
        super(name, health, attackPower);
        scanner = new Scanner(System.in);
    }
    
    @Override
    public void attack(Character target) {
        System.out.println(name + " attacks " + target.name + "!");
        target.takeDamage(attackPower);
    }
    
    public void heal() {
        health += 10;
        System.out.println(name + " heals for 10 health points!");
    }
    
    public void makeMove(Character target) {
        System.out.println("Choose your action: 1. Attack 2. Heal");
        int choice = scanner.nextInt();
        if (choice == 1) {
            attack(target);
        } else if (choice == 2) {
            heal();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
