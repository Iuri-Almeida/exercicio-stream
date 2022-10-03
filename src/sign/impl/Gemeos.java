package sign.impl;

import sign.Sign;

import java.time.Month;
import java.time.MonthDay;
import java.util.HashMap;
import java.util.Map;

public class Gemeos extends Sign {

    @Override
    public MonthDay getStartDate() {
        return MonthDay.of(Month.MAY, 21);
    }

    @Override
    public MonthDay getEndDate() {
        return MonthDay.of(Month.JUNE, 20);
    }

    @Override
    protected Map<Integer, String> getSortedRisingSign() {
        return new HashMap<>() {{
            put(0, "Áries");
            put(2, "Touro");
            put(4, "Gêmeos");
            put(6, "Câncer");
            put(8, "Leão");
            put(10, "Virgem");
            put(12, "Libra");
            put(14, "Escorpião");
            put(16, "Sagitário");
            put(18, "Capricórnio");
            put(20, "Aquário");
            put(22, "Peixes");
        }};
    }

    @Override
    public String toString() {
        return "Gêmeos";
    }
}
