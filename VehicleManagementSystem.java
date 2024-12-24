import java.util.Scanner;
public class VehicleManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaintenanceManager maintenanceManager = new MaintenanceManager();
        Sedan sedan = new Sedan(1, "Sedan", "A small passenger car.");
        SUV suv = new SUV(2, "SUV", "A sport utility vehicle.");
        boolean running = true;
        while (running) {
            System.out.println("\nVehicle Management System:");
            System.out.println("1. Schedule Maintenance");
            System.out.println("2. View Maintenance History");
            System.out.println("3. Assign Service Provider");
            System.out.println("4. View Service Providers");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    String vehicleName = "";
                    String vehicleColor = "";
                    String vehicleCategory = "";

                    while (true) {
                        System.out.print("Enter Vehicle Name (must be letters): ");
                        vehicleName = scanner.nextLine();
                        if (vehicleName.matches("[a-zA-Z]+")) {
                            break;
                        } else {
                            System.out.println("Invalid name. Please use letters only.");
                        }
                    }

                    while (true) {
                        System.out.print("Enter Vehicle Color (must be letters): ");
                        vehicleColor = scanner.nextLine();
                        if (vehicleColor.matches("[a-zA-Z]+")) {
                            break;
                        } else {
                            System.out.println("Invalid color. Please use letters only.");
                        }
                    }

                    String[] validCategories = {"Cat A", "Cat B", "Cat S", "Cat N"};
                    while (true) {
                        System.out.print("Enter Vehicle Category (Cat A, Cat B, Cat S, Cat N): ");
                        vehicleCategory = scanner.nextLine();
                        boolean validCategory = false;
                        for (String category : validCategories) {
                            if (vehicleCategory.equalsIgnoreCase(category)) {
                                validCategory = true;
                                break;
                            }
                        }
                        if (validCategory) {
                            break;
                        } else {
                            System.out.println("Invalid category. Please choose from Cat A, Cat B, Cat S, or Cat N.");
                        }
                    }

                    System.out.println("Select Vehicle: 1. Sedan  2. SUV");
                    int vehicleChoice = scanner.nextInt();
                    scanner.nextLine();

                    String vehicleType = "";
                    if (vehicleChoice == 1) {
                        vehicleType = sedan.getName();
                    } else if (vehicleChoice == 2) {
                        vehicleType = suv.getName();
                    } else {
                        System.out.println("Invalid vehicle choice.");
                        break;
                    }

                    System.out.println("Available Maintenance Tasks:");
                    String[] tasks = {
                            "Check tire pressure and rotate tires",
                            "Check the motor oil",
                            "Check other important fluids",
                            "Test the headlights and taillights",
                            "Check and replace windshield wipers",
                            "Check the engine air filter",
                            "Check the cabin air filter",
                            "Test the battery",
                            "Inspect the brakes",
                            "Check belts and hoses",
                            "Wash your car",
                            "Check Fuel Efficiency",
                            "Check Off-road Capability"
                    };

                    for (int i = 0; i < tasks.length; i++) {
                        System.out.println((i + 1) + ". " + tasks[i]);
                    }

                    String task = "";
                    while (true) {
                        System.out.print("Choose a maintenance task by number: ");
                        int taskChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (taskChoice > 0 && taskChoice <= tasks.length) {
                            task = tasks[taskChoice - 1];
                            break;
                        } else {
                            System.out.println("Invalid choice. Please select a valid task.");
                        }
                    }
                    System.out.println("Vehicle Details: ");
                    System.out.println("Name: " + vehicleName);
                    System.out.println("Color: " + vehicleColor);
                    System.out.println("Category: " + vehicleCategory);
                    System.out.println("Vehicle Type: " + vehicleType);

                    maintenanceManager.scheduleMaintenance(vehicleName, task);
                    break;

                case 2:
                    maintenanceManager.viewMaintenanceHistory();
                    break;

                case 3:
                    System.out.print("Enter Service Provider Name: ");
                    String providerName = scanner.nextLine();
                    System.out.print("Enter Service Provider Location: ");
                    String location = scanner.nextLine();
                    maintenanceManager.assignServiceProvider(providerName, location);
                    break;

                case 4:
                    maintenanceManager.viewServiceProviders();
                    break;

                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
