package JFT11;

public class Exercise2 {

    public static void main(String[] args) {

        Car car1 = new Car("Subaru Hatchback", 53.45f, "89C4545", true);

        Car car2 = new Car();
        car2.setManufacturer("Toyota Corola");
        car2.setEngineSize(45.44f);
        car2.setRegistrationNo("90C4343");
        car2.setNCT(true);

        System.out.println(car1.toString());
        System.out.println(car1.accelerate());
        System.out.println(car1.brake());
        System.out.println();
        System.out.println(car2.toString());
        System.out.println(car2.accelerate());
        System.out.println(car2.brake());
        System.out.println();
        System.out.println(Car.getInstances() + " cars have been produced.");

        Truck truck1 = new Truck("Ford Transit");
        truck1.setIsTrailer(false);
        Truck truck2 = new Truck();
        truck2.setManufacturer("Hyundai Pick-Up");
        truck2.setEngineSize(89.45f);
        truck2.setRegistrationNo("99C5344");
        truck2.setNCT(true);
        truck2.setIsTrailer(false);

        System.out.println();
        System.out.println(truck1.toString());
        System.out.println(truck1.brake());
        System.out.println(truck1.accelerate());

        System.out.println();
        System.out.println(truck2.toString());
        System.out.println(truck2.brake());
        System.out.println(truck2.accelerate());
    }
    
    
}

class Vehicle {
    private String manufacturer;
    private float engineSize;
    private String registrationNo;
    private Boolean nct;

    public Vehicle(String _manufacturer, float _engineSize, String _registrationNo, Boolean _nct){
        this.manufacturer = _manufacturer;
        this.engineSize = _engineSize;
        this.registrationNo = _registrationNo;
        this.nct = _nct;
    }

    public Vehicle(String _manufacturer, float _engineSize, String _registrationNo){
        this.manufacturer = _manufacturer;
        this.engineSize = _engineSize;
        this.registrationNo = _registrationNo;
        this.nct = false;
    }

    public Vehicle(String _manufacturer, float _engineSize){
        this.manufacturer = _manufacturer;
        this.engineSize = _engineSize;
        this.registrationNo = "not specified";
        this.nct = false;
    }

    public Vehicle(String _manufacturer){
        this.manufacturer = _manufacturer;
        this.engineSize = 0;
        this.registrationNo = "not specified";
        this.nct = false;
    }

    public Vehicle(){
        this.manufacturer = "not specified";
        this.engineSize = 0;
        this.registrationNo = "not specified";
        this.nct = false;
    }

    // Setters

    public void setManufacturer(String _manufacturer){
        this.manufacturer = _manufacturer;
    }

    public void setEngineSize(float _engineSize){
        this.engineSize = _engineSize;
    }

    public void setRegistrationNo(String _registrationNo){
        this.registrationNo = _registrationNo;
    }

    public void setNCT(Boolean _isNCT){
        this.nct = _isNCT;
    }

    // Getters

    public String getManufacturer(){
        return this.manufacturer;
    }

    public float getEngineSize(){
        return this.engineSize;
    }

    public String getRegistrationNo(){
        return this.registrationNo;
    }

    public Boolean getIsNCT(){
        return this.nct;
    }

    // Actions

    public String accelerate(){
        return "Accelerating...";
    }

    public String brake(){
        return "Vehicle braking...";
    }

    // Methods

    public String toString(){
        return "Manufacturer: " + this.getManufacturer() + "\nEngine Size: " + this.getEngineSize() + 
        "\nRegistrationNo: " + this.getRegistrationNo() + "\nNCT: " + this.getIsNCT();
    }
}

class Car extends Vehicle {

    private static int carsInstancesCreated = 0;

    public Car(String _manufacturer, float _engineSize, String _registrationNo, boolean _isNCT){
        super.setManufacturer(_manufacturer);
        super.setEngineSize(_engineSize);
        super.setRegistrationNo(_registrationNo);
        super.setNCT(_isNCT);
        Car.increment();
    }

    public Car(String _manufacturer, float _engineSize, String _registrationNo){
        super.setManufacturer(_manufacturer);
        super.setEngineSize(_engineSize);
        super.setRegistrationNo(_registrationNo);
        Car.increment();
    }

    public Car(String _manufacturer, float _engineSize){
        super.setManufacturer(_manufacturer);
        super.setEngineSize(_engineSize);
        Car.increment();
    }

    public Car(String _manufacturer){
        super.setManufacturer(_manufacturer);
        Car.increment();
    }

    public Car(){
        Car.increment();
    };

    public static int getInstances(){
        return Car.carsInstancesCreated;
    }

    // Static

    private static void increment(){
        Car.carsInstancesCreated++;
    }

    // Actions

    public String brake(){
        return "Car braking...";
    }
}

class Truck extends Vehicle {

    private Boolean isTrailer;

    public Truck(String _manufacturer, float _engineSize, String _registrationNo, boolean _isNCT){
        super.setManufacturer(_manufacturer);
        super.setEngineSize(_engineSize);
        super.setRegistrationNo(_registrationNo);
        super.setNCT(_isNCT);
    }

    public Truck(String _manufacturer, float _engineSize, String _registrationNo){
        super.setManufacturer(_manufacturer);
        super.setEngineSize(_engineSize);
        super.setRegistrationNo(_registrationNo);
    }

    public Truck(String _manufacturer, float _engineSize){
        super.setManufacturer(_manufacturer);
        super.setEngineSize(_engineSize);
    }

    public Truck(String _manufacturer){
        super.setManufacturer(_manufacturer);
    }

    public Truck(){
    };

    // Setters

    public void setIsTrailer(Boolean _isTrailer){
        this.isTrailer = _isTrailer;
    }

    // Getters

    public Boolean getIsTrailer(){
        return this.isTrailer;
    }

    // Actions

    public String brake(){
        return "Truck braking...";
    }

    // Method
    public String toString(){
        return super.toString() + "\nHas Trailer: " + this.getIsTrailer();
    }
}