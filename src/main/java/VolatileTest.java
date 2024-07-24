import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileTest {

    private volatile static long lastStatsUpdateStamp = 0;

    public static void main(String[] args) {

        Set<Long> set = ConcurrentHashMap.newKeySet();

        ExecutorService users = Executors.newFixedThreadPool(48);

        for (int i = 0; i < 48; i++) {
            users.submit(() -> run(set));
        }

    }

    private static void run(Set<Long> set) {
        System.out.println(Thread.currentThread().getName() + " start");
        for (int i = 0; i < 99999999; i++) {
            long stamp = getStatisticsUpdateStamp();
            if (set.contains(stamp)) {
                System.out.println(stamp);
            } else {
                set.add(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName() + " size: "+set.size());
    }

    public static synchronized long getStatisticsUpdateStamp() {
        long theTimeStamp = System.currentTimeMillis();
        if (theTimeStamp <= lastStatsUpdateStamp) {
            theTimeStamp = (++lastStatsUpdateStamp);
        } else {
            lastStatsUpdateStamp = theTimeStamp;
        }

        return theTimeStamp;
    }

}
