package main;

public class Plane extends Vehicle {
    private String manufacturer;
    private String model;
    private int maxSpeed;


    public Plane(String manufacturer, String model, int maxSpeed) {
        super("Lentokone", manufacturer, model, maxSpeed);
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        engines.add(new Engine("Suihkumoottori", 500));
    }

    public void fly() {
        System.out.println(manufacturer + " " + model + " lentää kohteeseen!");
    }
}
