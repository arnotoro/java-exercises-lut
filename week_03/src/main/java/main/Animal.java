package main;

public class Animal {
    String species;
    String name;
    int age;

    public Animal(String species, String name, int age) {
        this.species = species;
        this.name = name;
        this.age = age;
    }

    public void run(int rounds) {
        for (int i = 0; i < rounds; i++) {
            System.out.println(this.name + " juoksee kovaa vauhtia!");
        }
    }

}
