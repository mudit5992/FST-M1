package Activities;

public class Car {

    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    Car()
    {
        tyres=4;
        doors=4;

    }

    public void displayCharacteristics() {
        System.out.println("Color of the Car is " + color);
        System.out.println("Make of the Car is " + make);
        System.out.println("Trans of the Car is " + transmission);
        System.out.println("Number of doors on the car are " + doors);
        System.out.println("Number of tyres on the car are " + tyres);
    }

    public void accelarate() {
        System.out.println("Car is moving forward.");
    }

    public void brake() {
        System.out.println("Car has stopped.");

    }



}
