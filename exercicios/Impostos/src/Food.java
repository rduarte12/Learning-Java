public record Food(double price)implements TaxCalculator {
    /**
     * Calculates the tax for food items.
     * The tax rate for food is 1%.
     * @param price the price of the food item
     * @return the calculated tax
     */
    @Override
    public double calculateTax() {
        return price * 0.01; // 1% tax rate for food
    }
}
