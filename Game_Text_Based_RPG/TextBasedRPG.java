import java.util.Scanner;

public class TextBasedRPG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create player and enemy
        Player player = new Player("Hero", 100, 20);
        Enemy enemy = new Enemy("Goblin", 50, 15);
        
        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n" + player.getStatus());
            System.out.println(enemy.getStatus());
            
            // Player's turn
            player.makeMove(enemy);
            
            if (enemy.isAlive()) {
                // Enemy's turn
                enemy.takeTurn(player);
            }
        }
        
        // Game result
        if (player.isAlive()) {
            System.out.println("You defeated the enemy!");
        } else {
            System.out.println("You were defeated by the enemy...");
        }
        
        scanner.close();
    }
}
