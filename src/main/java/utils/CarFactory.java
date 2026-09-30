package utils;

import dto.Car;
import lombok.Builder;
import lombok.Data;
import net.datafaker.Faker;
import utils.enums.Fuel;
import utils.enums.Gear;
import utils.enums.Wheels;


import java.time.LocalDate;
import java.util.Locale;

public class CarFactory {
    static Faker faker = new Faker();

    public static Car positiveCar(){
        return Car.builder()
                .serialNumber(faker.vehicle().licensePlate())
                .city("Haifa")
                .manufacture(faker.vehicle().manufacturer())
                .model(faker.vehicle().model())
                .year(Integer.toString(faker.number().numberBetween(0, LocalDate.now().getYear())))
                .fuel(faker.options().option(Fuel.values()))
                .gear(faker.options().option(Gear.values()))
                .wheels(faker.options().option(Wheels.values()))
                .doors(faker.number().numberBetween(2, 20))
                .seats(faker.number().numberBetween(2, 20))
                .carClass(faker.vehicle().carType())
                .pricePerDay(faker.number().randomDouble(2,0, 1000))
                .about(faker.text().text(0,500))
                .build();
    }
}
