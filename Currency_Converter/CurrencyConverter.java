public class CurrencyConverter {
    private Currency[] currencies;

    public CurrencyConverter() {
        // Initialize with some currencies
        currencies = new Currency[] {
            new Currency("USD", 1.0),
            new Currency("EUR", 0.85),
            new Currency("JPY", 110.0),
            new Currency("GBP", 0.75)
        };
    }

    private Currency findCurrency(String name) {
        for (Currency currency : currencies) {
            if (currency.getName().equalsIgnoreCase(name)) {
                return currency;
            }
        }
        return null; // Currency not found
    }

    public double convert(double amount, String fromCurrency, String toCurrency) {
        Currency from = findCurrency(fromCurrency);
        Currency to = findCurrency(toCurrency);
        if (from == null || to == null) {
            throw new IllegalArgumentException("Currency not supported");
        }
        double amountInUSD = amount / from.getRateToUSD();
        return amountInUSD * to.getRateToUSD();
    }

    public void addCurrency(String name, double rateToUSD) {
        Currency[] newCurrencies = new Currency[currencies.length + 1];
        System.arraycopy(currencies, 0, newCurrencies, 0, currencies.length);
        newCurrencies[currencies.length] = new Currency(name, rateToUSD);
        currencies = newCurrencies;
    }
}
