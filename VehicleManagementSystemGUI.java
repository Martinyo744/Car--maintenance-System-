import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleManagementSystemGUI extends JFrame {
    private JTextArea outputArea;
    private MaintenanceManager maintenanceManager;

    public VehicleManagementSystemGUI() {
        maintenanceManager = new MaintenanceManager();


        setTitle("Vehicle Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        setLayout(new BorderLayout());


        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));


        JButton scheduleMaintenanceButton = new JButton("Schedule Maintenance");
        JButton viewHistoryButton = new JButton("View Maintenance History");
        JButton assignProviderButton = new JButton("Assign Service Provider");
        JButton viewProvidersButton = new JButton("View Service Providers");
        JButton exitButton = new JButton("Exit");


        buttonPanel.add(scheduleMaintenanceButton);
        buttonPanel.add(viewHistoryButton);
        buttonPanel.add(assignProviderButton);
        buttonPanel.add(viewProvidersButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.WEST);


        scheduleMaintenanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showScheduleMaintenanceDialog();
            }
        });

        viewHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maintenanceManager.viewMaintenanceHistory();
            }
        });

        assignProviderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAssignProviderDialog();
            }
        });

        viewProvidersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maintenanceManager.viewServiceProviders();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void showScheduleMaintenanceDialog() {

        JTextField vehicleNameField = new JTextField();
        JTextField vehicleColorField = new JTextField();
        String[] categories = {"Cat A", "Cat B", "Cat S", "Cat N"};
        JComboBox<String> categoryComboBox = new JComboBox<>(categories);
        String[] tasks = {
                "Check tire pressure", "Check the motor oil", "Check other fluids",
                "Test headlights", "Check wipers", "Check air filter", "Test battery"
        };
        JComboBox<String> taskComboBox = new JComboBox<>(tasks);


        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Vehicle Name:"));
        panel.add(vehicleNameField);
        panel.add(new JLabel("Vehicle Color:"));
        panel.add(vehicleColorField);
        panel.add(new JLabel("Vehicle Category:"));
        panel.add(categoryComboBox);
        panel.add(new JLabel("Maintenance Task:"));
        panel.add(taskComboBox);

        int option = JOptionPane.showConfirmDialog(this, panel, "Schedule Maintenance", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String vehicleName = vehicleNameField.getText();
            String vehicleColor = vehicleColorField.getText();
            String category = (String) categoryComboBox.getSelectedItem();
            String task = (String) taskComboBox.getSelectedItem();

            maintenanceManager.scheduleMaintenance(vehicleName, task);
            outputArea.append("Scheduled maintenance for " + vehicleName + " (" + vehicleColor + ", " + category + "): " + task + "\n");
        }
    }

    private void showAssignProviderDialog() {
        JTextField providerNameField = new JTextField();
        JTextField providerLocationField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Provider Name:"));
        panel.add(providerNameField);
        panel.add(new JLabel("Provider Location:"));
        panel.add(providerLocationField);

        int option = JOptionPane.showConfirmDialog(this, panel, "Assign Service Provider", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String providerName = providerNameField.getText();
            String location = providerLocationField.getText();
            maintenanceManager.assignServiceProvider(providerName, location);
            outputArea.append("Assigned service provider: " + providerName + " at " + location + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VehicleManagementSystemGUI().setVisible(true);
            }
        });
    }
}
