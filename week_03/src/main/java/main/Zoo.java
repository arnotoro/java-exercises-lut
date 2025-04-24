package main;

import java.util.ArrayList;

public class Zoo {
    final private String name;
    private ArrayList<Animal> animals;

    public Zoo(String name) {
        animals = new ArrayList<Animal>();
        this.name = name;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void listAnimals() {
        System.out.println(name + " pitää sisällään seuraavat eläimet:");
        for (Animal animal : animals) {
            System.out.println(animal.species + ": " + animal.name + ", " + animal.age + " vuotta");
        }
    }

    public void runAnimals(int rounds) {
        for (Animal animal : animals) {
            animal.run(rounds);
        }
    }
}
