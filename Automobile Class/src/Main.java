import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AutomobileInventory inventory = new AutomobileInventory();
        boolean isExit = false;

        System.out.println("Welcome dear customer.");
        while (!isExit) {
            System.out.println("Select an option:");
            System.out.println("[1] Add a vehicle");
            System.out.println("[2] Remove a vehicle");
            System.out.println("[3] Show all vehicles");
            System.out.println("[4] Update a vehicle");
            System.out.println("[q] Quit");
            System.out.print("> ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    String make = "", model = "", color = "";
                    int year = 0, mileage = 0;
                    boolean validInput;

                    System.out.println("\n**********************************");
                    System.out.println("Please insert vehicle information:");

                    // Make
                    do {
                        try {
                            System.out.print("Make: ");
                            make = scanner.nextLine().trim();
                            if (make.isEmpty()) throw new IllegalArgumentException("Make cannot be empty.");
                            validInput = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            validInput = false;
                        }
                    } while (!validInput);

                    // Model
                    do {
                        try {
                            System.out.print("Model: ");
                            model = scanner.nextLine().trim();
                            if (model.isEmpty()) throw new IllegalArgumentException("Model cannot be empty.");
                            validInput = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            validInput = false;
                        }
                    } while (!validInput);

                    // Color
                    do {
                        try {
                            System.out.print("Color: ");
                            color = scanner.nextLine().trim();
                            if (color.isEmpty()) throw new IllegalArgumentException("Color cannot be empty.");
                            validInput = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            validInput = false;
                        }
                    } while (!validInput);

                    // Year
                    do {
                        try {
                            System.out.print("Year: ");
                            year = Integer.parseInt(scanner.nextLine().trim());
                            if (year < 1886 || year > java.time.Year.now().getValue())
                                throw new IllegalArgumentException("Year must be between 1886 and the current year.");
                            validInput = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format. Please enter a valid integer for year.");
                            validInput = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            validInput = false;
                        }
                    } while (!validInput);

                    // Mileage
                    do {
                        try {
                            System.out.print("Mileage: ");
                            mileage = Integer.parseInt(scanner.nextLine().trim());
                            if (mileage < 0) throw new IllegalArgumentException("Mileage cannot be negative.");
                            validInput = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid number format. Please enter a valid integer for mileage.");
                            validInput = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            validInput = false;
                        }
                    } while (!validInput);

                    Automobile newVehicle = new Automobile(make, model, color, year, mileage);
                    inventory.addAutomobile(newVehicle);
                    System.out.println("Vehicle added successfully!");
                    System.out.println("**********************************\n");
                    break;
                case "2":
                    System.out.print("Enter the index of the vehicle to remove: ");
                    int index = -1;
                    try {
                        index = Integer.parseInt(scanner.nextLine().trim());
                        if (index < 0 || index >= inventory.getAvailableAutomobiles()) {
                            System.out.println("Invalid index. Please enter a valid integer within the range.");
                            break;
                        }
                        // Confirm before removing
                        System.out.print("Are you sure you want to remove this vehicle? (Y/N): ");
                        String confirm = scanner.nextLine().trim();
                        if (confirm.equalsIgnoreCase("Y")) {
                            inventory.removeAutomobile(index);
                            System.out.println("Vehicle removed successfully!");
                        } else {
                            System.out.println("Vehicle removal canceled.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid index. Please enter a valid integer.");
                    }
                    break;
                case "3":
                    System.out.println("\nAll vehicles:");
                    System.out.println(inventory.showAllVehiclesInformation());
                    break;

                case "4":
                    System.out.print("Enter the index of the vehicle you wish to update: ");
                    try {
                        int updateIndex = Integer.parseInt(scanner.nextLine().trim());
                        if (updateIndex < 0 || updateIndex >= inventory.getAvailableAutomobiles()) {
                            System.out.println("Invalid index. Please enter a valid integer within the range.");
                            break;
                        }
                        Automobile vehicleToUpdate = inventory.getAutomobile(updateIndex);
                        System.out.println("Current details of the vehicle:");
                        System.out.println(vehicleToUpdate.listVehicleInformation());

                        System.out.print("Update make (current: " + vehicleToUpdate.getMake() + ", leave blank to keep current): ");
                        String newMake = scanner.nextLine().trim();
                        if (!newMake.isEmpty()) {
                            vehicleToUpdate.setMake(newMake);
                        }

                        System.out.print("Update model (current: " + vehicleToUpdate.getModel() + ", leave blank to keep current): ");
                        String newModel = scanner.nextLine().trim();
                        if (!newModel.isEmpty()) {
                            vehicleToUpdate.setModel(newModel);
                        }

                        // Assuming color is mutable for demonstration purposes
                        System.out.print("Update color (current: " + vehicleToUpdate.getColor() + ", leave blank to keep current): ");
                        String newColor = scanner.nextLine().trim();
                        if (!newColor.isEmpty()) {
                            vehicleToUpdate.setColor(newColor);
                        }

                        System.out.print("Update year (current: " + vehicleToUpdate.getYear() + "): ");
                        String newYearString = scanner.nextLine().trim();
                        if (!newYearString.isEmpty()) {
                            int newYear = Integer.parseInt(newYearString);
                            vehicleToUpdate.setYear(newYear);
                        }

                        System.out.print("Update mileage (current: " + vehicleToUpdate.getMileage() + "): ");
                        String newMileageString = scanner.nextLine().trim();
                        if (!newMileageString.isEmpty()) {
                            int newMileage = Integer.parseInt(newMileageString);
                            vehicleToUpdate.setMileage(newMileage);
                        }

                        System.out.println("Vehicle updated successfully!");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter valid data.");
                    }
                    break;

                // If the input is either 'q' or 'Q' it will accept.
                case "q":
                case "Q":
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
        scanner.close();
        System.out.println("Goodbye!");
    }
}
