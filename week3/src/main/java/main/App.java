package main;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Anna eläintarhalle nimi: ");
        String zooName = sc.nextLine();

        Zoo zoo = new Zoo(zooName);

        while (!exit) {
            System.out.println("1) Luo uusi eläin, 2) Listaa kaikki eläimet, 3) Juoksuta eläimiä, 0) Lopeta ohjelma");

            if (sc.hasNext()) {
                int selection = 0;
                
                selection = Integer.parseInt(sc.nextLine());

                switch (selection) {
                    case 1:
                        System.out.println("Mikä laji?");
                        String species = sc.nextLine();
                        System.out.println("Anna eläimen nimi:");
                        String name = sc.nextLine();
                        System.out.println("Anna eläimen ikä:");
                        int age = Integer.parseInt(sc.nextLine());
                        Animal animal = new Animal(species, name, age);
                        zoo.addAnimal(animal);
                        break;
                    case 2:
                        zoo.listAnimals();
                        break;
                    case 3:
                        System.out.println("Kuinka monta kierrosta?");
                        int rounds = Integer.parseInt(sc.nextLine());
                        zoo.runAnimals(rounds);
                        break;
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default:    
                        System.out.println("Syöte oli väärä");
                }
            }
        }
        sc.close();
    }
}
