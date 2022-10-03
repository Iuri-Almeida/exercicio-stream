package sign.service;

import model.enums.Generation;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class SignService {

    public Integer getAge(LocalDateTime localDateTime) {
        return Period.between(localDateTime.toLocalDate(), LocalDate.now()).getYears();
    }

    public boolean isLeapYear(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate().isLeapYear();
    }

    public String format(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public ZoneOffset timeZone(LocalDateTime localDateTime, String zone) {
        Set<String> zones = ZoneId.getAvailableZoneIds();

        for (String z : zones) {
            if (z.contains(zone)) {
                ZoneId zoneId = ZoneId.of(z);
                return zoneId.getRules().getOffset(localDateTime);
            }
        }

        throw new IllegalArgumentException("Zone not found for zone = " + zone);
    }

    public Generation generation(Year year) {
        if (year.isBefore(Year.of(1946))) {
            return Generation.TRADICIONALISTA;
        } else if (year.isAfter(Year.of(1946)) && year.isAfter(Year.of(1964))) {
            return Generation.BABY_BOOMER;
        } else if (year.isAfter(Year.of(1964)) && year.isBefore(Year.of(1981))) {
            return Generation.X;
        } else if (year.isAfter(Year.of(1981)) && year.isBefore(Year.of(1990))) {
            return Generation.Y;
        } else if (year.isAfter(Year.of(1990)) && year.isBefore(Year.of(2010))) {
            return Generation.Z;
        } else {
            return Generation.ALPHA;
        }
    }

}
