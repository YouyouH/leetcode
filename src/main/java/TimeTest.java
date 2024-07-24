import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class TimeTest {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        long currentMill = now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        //fixme: withhour must be 0-23
        LocalDateTime next = now.with(TemporalAdjusters.next(DayOfWeek.of(6))).withHour(0).withMinute(0).withSecond(0);
        long hours = Duration.between(now, next).toHours();
        long days = Duration.between(now, next).toDays();

        System.out.println(hours);
        System.out.println(days);
        System.out.println(next);
        System.out.println(next.atZone(ZoneId.systemDefault()) // timezone
                .toInstant() // Instant object
                .toEpochMilli());
    }

    private static long calculateDelay(int hourOfFirstRun, long currentTimeInMilli) {
        Calendar currCalendar = Calendar.getInstance();
//        long currentTimeInMilli = System.currentTimeMillis();
        currCalendar.setTimeInMillis(currentTimeInMilli);
        int minutesOn24h = (int) TimeUnit.DAYS.toMinutes(1);
        int hourOfFirstRunInMinutes = (int)TimeUnit.HOURS.toMinutes(hourOfFirstRun);

        int hours = currCalendar.get(Calendar.HOUR_OF_DAY);
        int minutes = (int)TimeUnit.HOURS.toMinutes(hours) + currCalendar.get(Calendar.MINUTE);
        int minutesUntil24 = minutesOn24h - minutes;
        int diff = (minutesUntil24 + hourOfFirstRunInMinutes) % minutesOn24h;
        currCalendar.add(Calendar.MINUTE, diff);
        return currCalendar.getTimeInMillis() - currentTimeInMilli;
    }
}
