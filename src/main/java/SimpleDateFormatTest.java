import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {

    public static void main(String[] args) throws ParseException {
        System.out.println(new SimpleDateFormat("yyyyMMddHHmm").format(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse("2022-02-10 00:00")));
    }
}
