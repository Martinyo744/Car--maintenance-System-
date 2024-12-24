class SUV extends VehicleCategory {
    public SUV(int categoryID, String name, String description) {
        super(categoryID, name, description);
    }

    @Override
    public void displayCategoryInfo() {
        System.out.println("SUV Category Details:");
        System.out.println("ID: " + getCategoryID());
        System.out.println("Name: " + getName());
        System.out.println("Description: " + getDescription());
    }
}
