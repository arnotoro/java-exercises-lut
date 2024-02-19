package main;

import java.util.ArrayList;

public class Vehicle {
    protected String type;
    protected String manufacturer;
    protected String model;
    protected int maxSpeed;
    protected ArrayList<Engine> engines = new ArrayList<Engine>();


    public Vehicle(String type, String manufacturer, String model, int maxSpeed) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public String getEngineSpecs() {
        String specs = "";
        for (Engine engine : engines) {
            specs += engine.getSpecs() + "";
    }
        return specs;
    }
}
