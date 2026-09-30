package pages;

import dto.Car;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utils.enums.Fuel;
import utils.enums.Gear;
import utils.enums.Wheels;

import java.io.File;

public class LetTheCarWorkPage extends BasePage {
        public LetTheCarWorkPage (WebDriver driver) {
            PageFactory.initElements
                    (new AjaxElementLocatorFactory(driver, 10), this);
        }


        @FindBy(xpath = "//button[@type='submit']")
        WebElement submitBtn;
        @FindBy(id = "city")
        WebElement cityInput;
    // 1. Марка (Manufacture)
    @FindBy(name = "manufacture")
    WebElement manufactureInput;

    // 2. Модель (Model)
    @FindBy(name = "model")
    WebElement modelInput;

    // 3. Год (Year)
    @FindBy(name = "year")
    WebElement yearInput;

    // 4. Выпадающий список: Топливо (Fuel)
    @FindBy(name = "fuel")
    WebElement fuelSelect;

    // Выпадающий список: Коробка передач (Gear)
    @FindBy(name = "gear")
    WebElement gearSelect;

    // 5. Выпадающий список: Привод (Wheels Drive)
    @FindBy(name = "wheelsDrive")
    WebElement wheelsDriveSelect;

    // Количество дверей (Doors)
    @FindBy(name = "doors")
    WebElement doorsInput;


    // 6. Количество мест (Seats)
    @FindBy(name = "seats")
    WebElement seatsInput;

    // 7. Класс автомобиля (Car Class)
    @FindBy(name = "carClass")
    WebElement carClassInput;

    // 8. Серийный номер (Serial Number)
    @FindBy(name = "serialNumber")
    WebElement serialNumberInput;

    // 9. Цена за день (Price per day)
    @FindBy(name = "pricePerDay")
    WebElement pricePerDayInput;

    // 10. Описание (About)
    @FindBy(name = "about")
    WebElement aboutTextarea;

    // 11. Ссылка на фото (Image URL)
    @FindBy(name = "image")
    WebElement imageUrlInput;

    // 12. Загрузка файла фото (Photo File)
    @FindBy(id = "photo-file")
    WebElement photoFileInput;




    public void typeAddNewCarForm(Car car){
        cityInput.sendKeys(car.getCity());
        manufactureInput.sendKeys(car.getManufacture());
        modelInput.sendKeys(car.getModel());
        yearInput.sendKeys(car.getYear());
        chooseFuel(car.getFuel());
        chooseGear(car.getGear());
        chooseWheels(car.getWheels());
       // seatsInput.sendKeys(car.getSeats().toString());
        //  seatsInput.sendKeys(String.valueOf(car.getSeats()));
       // seatsInput.sendKeys(car.getSeats()+"");
        doorsInput.sendKeys(car.getDoors().toString());
        seatsInput.sendKeys(Integer.toString(car.getSeats()));
        carClassInput.sendKeys(car.getCarClass());
        serialNumberInput.sendKeys(car.getSerialNumber());
        pricePerDayInput.sendKeys(car.getPricePerDay().toString());
        aboutTextarea.sendKeys(car.getAbout());



//        gearSelect.sendKeys(car.getGear());
//        wheelsDriveSelect.sendKeys(car.getWheelsDrive());
//        doorsInput.sendKeys(car.getDoors().toString());
//        seatsInput.sendKeys(car.getSeats().toString());
//        carClassInput.sendKeys(car.getCarClass());
//        serialNumberInput.sendKeys(car.getSerialNumber());
//        pricePerDayInput.sendKeys(car.getPricePerDay().toString());
//        aboutTextarea.sendKeys(car.getAbout());
//        imageUrlInput.sendKeys();





    }

    private void chooseFuel(Fuel fuel){
        fuelSelect.click();
        driver.findElement(By.xpath(fuel.getLocator())).click();
    }


    private void chooseGear(Gear gear){
        gearSelect.click();
        driver.findElement(By.xpath(gear.getLocator())).click();
    }

    private void chooseWheels(Wheels wheels){
        wheelsDriveSelect.click();
        driver.findElement(By.xpath(wheels.getLocator())).click();
    }

    public void downloadImage(String fileName){
        imageUrlInput.sendKeys(new File("src/test/resources/"+fileName)
                .getAbsolutePath());

    }








    public void clickBtnSignUpWithJS() {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector(\"button[type='submit']\").removeAttribute('disabled')");
            submitBtn.click();
        }

    }
