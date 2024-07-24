import java.net.InetAddress;
import java.net.UnknownHostException;


public class DNSTest {

    public static void main(String[] args) {
        InetAddress address = null;
        long start = System.currentTimeMillis();
        System.out.println("Start to resolve host name");
        try {
            address = InetAddress.getByName("psql-smax-cms-stg.postgres.database.azure.com");
            System.out.println(address.getHostAddress());
            long end = System.currentTimeMillis();
            System.out.println("Took " + (end - start) + " mill seconds");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}
