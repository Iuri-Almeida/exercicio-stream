package sign.impl;

import sign.Sign;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Leao extends Sign {

    @Override
    public MonthDay getStartDate() {
        return MonthDay.of(Month.JULY, 23);
    }

    @Override
    public MonthDay getEndDate() {
        return MonthDay.of(Month.AUGUST, 22);
    }

    @Override
    protected Map<Integer, String> getSortedRisingSign() {
        return new HashMap<>() {{
            put(0, "Gêmeos");
            put(2, "Câncer");
            put(4, "Leão");
            put(6, "Virgem");
            put(8, "Libra");
            put(10, "Escorpião");
            put(12, "Sagitário");
            put(14, "Capricórnio");
            put(16, "Aquário");
            put(18, "Peixes");
            put(20, "Áries");
            put(22, "Touro");
        }};
    }

    @Override
    public String toString() {
        return "Leão";
    }
}
