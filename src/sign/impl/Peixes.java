package sign.impl;

import sign.Sign;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Peixes extends Sign {

    @Override
    public MonthDay getStartDate() {
        return MonthDay.of(Month.FEBRUARY, 19);
    }

    @Override
    public MonthDay getEndDate() {
        return MonthDay.of(Month.MARCH, 20);
    }

    @Override
    protected Map<Integer, String> getSortedRisingSign() {
        return new HashMap<>() {{
            put(0, "Capricórnio");
            put(2, "Aquário");
            put(4, "Peixes");
            put(6, "Áries");
            put(8, "Touro");
            put(10, "Gêmeos");
            put(12, "Câncer");
            put(14, "Leão");
            put(16, "Virgem");
            put(18, "Libra");
            put(20, "Escorpião");
            put(22, "Sagitário");
        }};
    }

    @Override
    public String toString() {
        return "Peixes";
    }
}
