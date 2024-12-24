class Sedan extends VehicleCategory {
    public Sedan(int categoryID, String name, String description) {
        super(categoryID, name, description);
    }

    @Override
    public void displayCategoryInfo() {
        System.out.println("Sedan Category Details:");
        System.out.println("ID: " + getCategoryID());
        System.out.println("Name: " + getName());
        System.out.println("Description: " + getDescription());
    }
}
