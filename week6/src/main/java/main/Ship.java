package main;

public class Ship extends Vehicle {
    private String manufacturer;
    private String model;
    private int maxSpeed;

    public Ship(String manufacturer, String model, int maxSpeed) {
        super("Laiva", manufacturer, model, maxSpeed);
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        engines.add(new Engine("Wärtsilä Super", 1000));
    }

    public void sail() {
        System.out.println(manufacturer + " " + model + " seilaa merten ääriin!");
    }
}
