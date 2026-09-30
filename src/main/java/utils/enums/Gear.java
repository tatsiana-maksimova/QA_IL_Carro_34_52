package utils.enums;

public enum Gear {
    AUTOMATIC("//option[@value='auto']"),
    MANUAL("//option[@value='manual']");

    private String locator;

    Gear(String locator) {
        this.locator = locator;
    }
    public String getLocator() {
        return locator;
    }
}
