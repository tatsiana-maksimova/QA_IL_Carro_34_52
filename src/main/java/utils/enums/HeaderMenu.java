package utils.enums;

public enum HeaderMenu {
    LOGO("//img[@alt='IlCarro logo'']"),
    SEARCH("//a[text()='Search']"),
    LET_CAR_WORK("//a[@href='/let-car-work']"),
    TERMS_OF_USE("//a[@href='/terms-of-use']"),
    SIGN_UP("//a[@href='/register']"),
    LOGIN("//a[@href='/login']"),
    LOGOUT("//button[text()='Log out']");




    private final String locator;

    HeaderMenu(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
