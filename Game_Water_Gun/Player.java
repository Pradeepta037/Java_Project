public class Player {
    private String name;
    private int waterLevel;

    public Player(String name, int initialWaterLevel) {
        this.name = name;
        this.waterLevel = initialWaterLevel;
    }

    public String getName() {
        return name;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void shoot(WaterGun gun, Player opponent) {
        if (waterLevel > 0) {
            gun.shootWater(opponent);
            waterLevel -= gun.getWaterPerShot();
            System.out.println(name + " shoots water at " + opponent.getName());
        } else {
            System.out.println(name + " has no water left!");
        }
    }

    public void refill(int amount) {
        waterLevel += amount;
        System.out.println(name + " refills water to " + waterLevel);
    }
}
