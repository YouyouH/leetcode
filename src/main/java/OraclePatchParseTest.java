import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OraclePatchParseTest {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("([0-9]+)\\.[0-9]+");

        Matcher m = p.matcher("18.2 AUTO STATS JOB DOESNT FINISH DUE TO SLOW MERGE ON MON_MODS_ALL$");
        if (m.find()) {
            System.out.println(m.group(1));
        }


        Matcher m2 = p.matcher("OJVM RELEASE UPDATE: 19.21.0.0.231017 (35648110)");
        if (m2.find() && 19 == Integer.parseInt(m2.group(1))) {
            System.out.println(m2.group(1));
        }


        Matcher m3 = p.matcher("Database Release Update : 19.21.0.0.231017 (35643107)");
        if (m3.find()) {
            System.out.println(m3.group(1));
        }



    }
}
