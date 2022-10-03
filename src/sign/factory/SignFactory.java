package sign.factory;

import sign.Sign;
import sign.impl.*;

import java.time.MonthDay;
import java.util.Arrays;
import java.util.List;

public class SignFactory {

    private final static List<Sign> signs = Arrays.asList(
        new Aquario(),
        new Peixes(),
        new Aries(),
        new Touro(),
        new Gemeos(),
        new Cancer(),
        new Leao(),
        new Virgem(),
        new Libra(),
        new Escorpiao(),
        new Sagitario(),
        new Capricornio()
    );

    public Sign create(MonthDay date) {
        for (Sign sign : signs) {
            if (!(date.isBefore(sign.getStartDate()) || date.isAfter(sign.getEndDate()))) {
                return sign;
            }
        }
        throw new IllegalArgumentException("Wasn't able to find a sign with the date = " + date.getMonth() + "/" + date.getDayOfMonth());
    }

}
