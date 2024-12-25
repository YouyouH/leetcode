import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Base64;

public class HashCalc {

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("D:\\Users\\huangyou\\Downloads\\kkk.tar 1\\kkk\\itom-ucmdb-1\\253718825\\probeUpgradeLogs\\11.8.5to11.9.2\\FAILED\\_{DefaultDomain}\\UCMDB_DataFlowProbe_11.9.2.package")) {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            int n = 0;
            byte[] buffer = new byte[4096000];
            while (n != -1) {
                n = in.read(buffer);
                if (n > 0) {
                    digest.update(buffer, 0, n);
                }
            }

            System.out.println(Base64.getMimeEncoder().encodeToString(digest.digest()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
