import java.util.Random;

class Enemy extends Character {
    private Random random;
    
    public Enemy(String name, int health, int attackPower) {
        super(name, health, attackPower);
        random = new Random();
    }
    
    @Override
    public void attack(Character target) {
        System.out.println(name + " attacks " + target.name + "!");
        target.takeDamage(attackPower);
    }
    
    public void takeTurn(Character target) {
        if (random.nextBoolean()) {
            attack(target);
        } else {
            System.out.println(name + " does nothing this turn.");
        }
    }
}
