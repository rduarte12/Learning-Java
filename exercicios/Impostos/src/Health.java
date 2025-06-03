public record Health(double price) implements TaxCalculator {
    /**
     * Calculates the tax for healthcare and well-being items.
     * The tax rate for healthcare and well-being is 1.5%.
     * @param price the price of the healthcare or well-being item
     * @return the calculated tax
     */
    @Override
    public double calculateTax() {
        return price * 0.015; // 1.5% tax rate for healthcare and well-being
    }
}
