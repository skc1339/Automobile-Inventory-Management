public class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    public Automobile() {
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
    }

    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }

    public String getMake() {
        return this.make;
    }
    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return this.year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return this.mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String listVehicleInformation() {
        return String.format(
                "\tMake: %s\n\tModel: %s\n\tColor: %s\n\tYear: %d\n\tMileage: %d",
                make, model, color, year, mileage
        );
    }


}
