abstract class Character {
    protected String name;
    protected int health;
    protected int attackPower;
    
    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    
    public abstract void attack(Character target);
    
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }
    
    public boolean isAlive() {
        return this.health > 0;
    }
    
    public String getStatus() {
        return name + " - Health: " + health + ", Attack Power: " + attackPower;
    }
}
