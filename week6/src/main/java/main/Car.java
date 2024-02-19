package main;

public class Car extends Vehicle {
    private String manufacturer;
    private String model;
    private int maxSpeed;


    public Car(String manufacturer, String model, int maxSpeed) {
        super("Auto", manufacturer, model, maxSpeed);
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        engines.add(new Engine("V8", 300));
    }

    public void drive() {
        System.out.println(manufacturer + " " + model + " paahtaa tietä eteenpäin!");
    }
}
