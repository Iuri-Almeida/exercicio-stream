package sign.impl;

import sign.Sign;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Libra extends Sign {

    @Override
    public MonthDay getStartDate() {
        return MonthDay.of(Month.SEPTEMBER, 23);
    }

    @Override
    public MonthDay getEndDate() {
        return MonthDay.of(Month.OCTOBER, 22);
    }

    @Override
    protected Map<Integer, String> getSortedRisingSign() {
        return new HashMap<>() {{
            put(0, "Leão");
            put(2, "Virgem");
            put(4, "Libra");
            put(6, "Escorpião");
            put(8, "Sagitário");
            put(10, "Capricórnio");
            put(12, "Aquário");
            put(14, "Peixes");
            put(16, "Áries");
            put(18, "Touro");
            put(20, "Gêmeos");
            put(22, "Câncer");
        }};
    }

    @Override
    public String toString() {
        return "Libra";
    }
}
