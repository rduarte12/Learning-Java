public record Clothes(double price) implements TaxCalculator {
    /**
     * Calculates the tax for clothing items.
     * The tax rate for clothing is 2.5%.
     * @param price the price of the clothing item
     * @return the calculated tax
     */
    @Override
    public double calculateTax() {
        return price * 0.025; // 2.5% tax rate for clothing
    }

}
