package utils.enums;

public enum Fuel {
    DIESEL("//option[@value='diesel']"),
    PETROL("//option[@value='petrol']"),
    HYBRID("//option[@value='hybrid']"),
    ELECTRIC("//option[@value='electric']");

    private String locator;

    Fuel(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
