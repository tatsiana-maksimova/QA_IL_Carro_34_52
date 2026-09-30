package utils.enums;

public enum Wheels {
FWD("//option[@value='FWD']"),
RWD("//option[@value='RWD']") ,
AWD("//option[@value='AWD']");

private String locator;
  Wheels(String locator) {
      this.locator = locator;
  }
  public String getLocator() {
      return locator;
  }
}
