import java.util.Random;
public class MaintenanceManager {
    private MaintenanceRecord[] maintenanceHistory = new MaintenanceRecord[100];
    private String[] serviceProviders = new String[50];
    private String[] providerIDs = new String[50];
    private String[] providerLocations = new String[50];
    private int maintenanceCount = 0;
    private int providerCount = 0;

    public void scheduleMaintenance(String vehicleName, String task) {
        if (maintenanceCount < maintenanceHistory.length) {
            maintenanceHistory[maintenanceCount++] = new MaintenanceRecord(vehicleName, task);
            System.out.println(vehicleName + " maintenance task ('" + task + "') has been scheduled.");
        } else {
            System.out.println("Maintenance history is full.");
        }
    }

    public void viewMaintenanceHistory() {
        System.out.println("Maintenance History:");
        for (int i = 0; i < maintenanceCount; i++) {
            System.out.println(maintenanceHistory[i]);
        }
    }

    public void assignServiceProvider(String serviceProvider, String location) {
        if (serviceProvider.matches(".\\d.")) {
            System.out.println("Forbidden name. Please enter a valid name without numbers.");
            return;
        }

        if (providerCount < serviceProviders.length) {
            serviceProviders[providerCount] = serviceProvider;
            providerLocations[providerCount] = location;
            providerIDs[providerCount] = generateRandomID();
            System.out.println(serviceProvider + " has been assigned as a service provider.");
            System.out.println("Location: " + location);
            System.out.println("Assigned ID: " + providerIDs[providerCount]);
            providerCount++;
        } else {
            System.out.println("Service provider list is full.");
        }
    }

    public void viewServiceProviders() {
        System.out.println("Registered Service Providers:");
        for (int i = 0; i < providerCount; i++) {
            System.out.println("Name: " + serviceProviders[i] + ", ID: " + providerIDs[i] + ", Location: " + providerLocations[i]);
        }
    }

    private String generateRandomID() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder randomID = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(characters.length());
            randomID.append(characters.charAt(randomIndex));
        }
        return randomID.toString();
    }
}

