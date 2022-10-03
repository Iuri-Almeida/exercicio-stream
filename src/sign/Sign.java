package sign;

import java.time.LocalTime;
import java.time.MonthDay;
import java.util.Map;

public abstract class Sign {

    public abstract MonthDay getStartDate();

    public abstract MonthDay getEndDate();

    protected abstract Map<Integer, String> getSortedRisingSign();

    public String getRisingSign(LocalTime time) {
        Map<Integer, String> sortedRisingSigns = this.getSortedRisingSign();

        for (Map.Entry<Integer, String> risingSign : sortedRisingSigns.entrySet()) {
            int currentHour = risingSign.getKey();
            int nextHour = currentHour + 2;

            if (nextHour == 24) {
                nextHour = 0;
            }

            if (!(time.isBefore(LocalTime.of(currentHour, 31, 0)) || time.isAfter(LocalTime.of(nextHour, 30, 0)))) {
                return risingSign.getValue();
            }
        }

        throw new IllegalArgumentException("Wasn't able to find a sign with the date = " + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());

    }

}
