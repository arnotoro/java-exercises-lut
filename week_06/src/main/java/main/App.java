package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        while (!exit) {
            System.out.println("1) Luo uusi kulkuneuvo, 2) Listaa kulkuneuvot 3) Aja autoja,"
            + " 4) Lennä lentokoneita, 5) Seilaa laivoja, 0) Lopeta ohjelma");

            if (sc.hasNext()) {
                int i = 0;
                String choice = sc.nextLine();
                i = Integer.parseInt(choice);

                switch(i) {
                    case 1:
                        System.out.println("Minkä kulkuneuvon haluat rakentaa?"
                        + " 1) auto, 2) lentokone, 3) laiva");
                        String choice2 = sc.nextLine();
                        int i2 = Integer.parseInt(choice2);

                        if (i2 != 1 && i2 != 2 && i2 != 3) {
                            System.out.println("Virheellinen valinta");
                            break;
                        }

                        System.out.println("Anna kulkuneuvon valmistaja:");
                        String manufacturer = sc.nextLine();

                        System.out.println("Anna kulkuneuvon malli:");
                        String model = sc.nextLine();

                        System.out.println("Anna kulkuneuvon huippunopeus:");
                        String maxSpeedString = sc.nextLine();
                        int maxSpeed = Integer.parseInt(maxSpeedString);

                        switch(i2) {
                            case 1:
                                Car car = new Car(manufacturer, model, maxSpeed);
                                vehicles.add(car);
                                break;
                            case 2:
                                Plane plane = new Plane(manufacturer, model, maxSpeed);
                                vehicles.add(plane);
                                break;
                            case 3:
                                Ship ship = new Ship(manufacturer, model, maxSpeed);
                                vehicles.add(ship);
                                break;
                        }
                        break;
                    case 2:
                        for (Vehicle vehicle : vehicles) {
                            System.out.println(vehicle.type + ": " + vehicle.manufacturer + " " + vehicle.model);
                            System.out.println("Moottori: " + vehicle.getEngineSpecs());
                            System.out.println("Huippunopeus: " + vehicle.maxSpeed + "km/h");
                            System.out.println();
                        }
                        break;
                    case 3:
                        for (Vehicle vehicle : vehicles) {
                            if (vehicle instanceof Car) {
                                Car car = (Car) vehicle;
                                car.drive();
                            }
                        }
                        break;
                    case 4:
                        for (Vehicle vehicle : vehicles) {
                            if (vehicle instanceof Plane) {
                                Plane plane = (Plane) vehicle;
                                plane.fly();
                            }
                        }
                        break;
                    case 5:
                        for (Vehicle vehicle : vehicles) {
                            if (vehicle instanceof Ship) {
                                Ship ship = (Ship) vehicle;
                                ship.sail();
                            }
                        }
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Virheellinen valinta");
                        break;
                }
            }
        }

        System.out.println("Kiitos ohjelman käytöstä.");
        sc.close();
    }
}
