public record Culture(double price)implements TaxCalculator {
    /**
     * Calculates the tax for cultural items.
     * The tax rate for cultural items is 4%.
     * @param price the price of the cultural item
     * @return the calculated tax
     */
    @Override
    public double calculateTax() {
        return price * 0.04; // 4% tax rate for cultural items
    }

}
