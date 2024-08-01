public class WaterGun {
    private int waterCapacity;
    private int waterPerShot;

    public WaterGun(int capacity, int perShot) {
        this.waterCapacity = capacity;
        this.waterPerShot = perShot;
    }

    public int getWaterPerShot() {
        return waterPerShot;
    }

    public void shootWater(Player opponent) {
        if (waterCapacity >= waterPerShot) {
            waterCapacity -= waterPerShot;
            // For simplicity, we just print a message. You can add more functionality.
            System.out.println("Water shot at " + opponent.getName());
        } else {
            System.out.println("Not enough water in the gun!");
        }
    }
}
