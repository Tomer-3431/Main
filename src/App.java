

public class App {

    // creating inteface Vehicles with maxSpeed function
    interface Vehicles {
        double maxSpeed();
    }

    // creating class Car with interface Vehicles
    public static class Car implements Vehicles {
        private double max;

        public Car(double max) {
            this.max = max;
        }

        public double maxSpeed() {
            return max;
        }
    }

    // creating the class Toyota with the extends of class Car
    public static class Toyota extends Car {
        public Toyota() {
            super(180);
        }
    }

    // creating class airplane with interface Vehicles
    public static class Airplane implements Vehicles {
        private double max;

        public Airplane(double max) {
            this.max = max;
        }

        public double maxSpeed() {
            return max;
        }
    }

    // creating class VehiclesManager to manage all of the vehicles classes
    public static class VehiclesManager {
        private Vehicles[] vehicles;

        public VehiclesManager(Vehicles[] vehicles) {
        this.vehicles = vehicles;
        }

        // making a function for highest and smallest speed
        public double highestSpeed() {
            double highestSpeed = vehicles[0].maxSpeed();
            for (int i = 0; i < vehicles.length; i++) {
                if (highestSpeed < vehicles[i].maxSpeed()) {
                    highestSpeed = vehicles[i].maxSpeed();
                }
            }
            return highestSpeed;
        }

        public double smallestSpeed() {
            double smallestSpeed = vehicles[0].maxSpeed();
            for (int i = 0; i < vehicles.length; i++) {
                if (smallestSpeed > vehicles[i].maxSpeed()) {
                    smallestSpeed = vehicles[i].maxSpeed();
                }
            }
            return smallestSpeed;
        }
    }


    public static void main(String[] args) throws Exception {

        // creating objects for all of the classes
        Car car = new Car(Double.parseDouble(System.console().readLine("enter the car max speed: ")));
        Toyota toyota = new Toyota();
        Airplane airplane = new Airplane(Double.parseDouble(System.console().readLine("enter the airplane max speed: ")));

        // manage all of the classes in the vehiclesManager object
        VehiclesManager vehiclesManager = new VehiclesManager(new Vehicles[]{car, toyota, airplane});
        
        // prints the highest and smallest speeds
        System.out.println("Highest speed: " + vehiclesManager.highestSpeed());
        System.out.println("Smallest speed: " + vehiclesManager.smallestSpeed());
    }
}
