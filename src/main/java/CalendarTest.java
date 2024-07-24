import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.DAYS;

public class CalendarTest {

    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
//
//        System.out.println(calendar.getFirstDayOfWeek());
//        System.out.println(calendar.getTime());

        LocalDate today = LocalDate.now();

        DayOfWeek dayOfWeek = today.getDayOfWeek();
//
//        System.out.println("Day of the Week :: " + dayOfWeek);
//        System.out.println("Day of the Week - in Number :: "
//                + dayOfWeek.getValue());
//        System.out.println("Day of the Week - Formatted FULL :: "
//                + dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault()));
//        System.out.println("Day of the Week - Formatted SHORT :: "
//                + dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault()));

        LocalDate nextSat = today.with(TemporalAdjusters.next(DayOfWeek.of(4)));
        System.out.println("Next SATURDAY: " + nextSat);

        System.out.println("Days diff: " + DAYS.between(today, nextSat));

        long diffHours = (DAYS.between(today, nextSat) -1) * 24;


        long currentTimeMillis = System.currentTimeMillis();
        //monday =1
        //Sat = 6
        //sun = 7

        long delay = calculateDelay(16,currentTimeMillis) + TimeUnit.HOURS.toMillis(diffHours);
        System.out.println(currentTimeMillis +delay);
        System.out.println(Instant.ofEpochMilli(currentTimeMillis +delay).atZone(ZoneId.systemDefault()).toLocalDate());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(new Date(currentTimeMillis + delay)));


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
