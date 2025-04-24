package main;

public class Engine {
    private String type;
    private int power;

    public Engine(String type, int power) {
        this.type = type;
        this.power = power;
    }

    public String getSpecs() {
        return type + " " + power + "kW";
    }
}
