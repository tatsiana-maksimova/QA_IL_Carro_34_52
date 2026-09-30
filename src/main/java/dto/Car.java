package dto;
import lombok.*;
import lombok.Builder;
import utils.enums.Fuel;
import utils.enums.Gear;
import utils.enums.Wheels;

import java.util.Locale;

@Builder
@Getter
@Data
public class Car {
    private String serialNumber;
    private String manufacture;
    private String model;
    private String year;
    private Fuel fuel;
    private Gear gear;
    private Wheels wheels;
    private Integer seats;
    private String wheelsDrive;
    private Integer doors;
    private String carClass;
    private Double pricePerDay;
    private String about;
    private String city;

}
