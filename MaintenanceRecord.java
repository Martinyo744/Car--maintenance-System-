import java.util.Random;
class MaintenanceRecord {
    private String vehicleName;
    private String task;

    public MaintenanceRecord(String vehicleName, String task) {
        this.vehicleName = vehicleName;
        this.task = task;
    }

    @Override
    public String toString() {
        return "Vehicle: " + vehicleName + ", Task: " + task;
    }
}