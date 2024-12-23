import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DBPassDecryptor {

    public static void main(String[] args) throws IOException, InterruptedException {


        String[] cmd = {"E:\\UCMDB\\DataFlowProbe_24_2\\bin\\jre\\bin\\java",
                "-Ducmdb.lib.home=E:\\UCMDB\\DataFlowProbe_24_2",
                "-Ducmdb.home=E:\\UCMDB\\DataFlowProbe_24_2",
                "-cp", "\"E:\\UCMDB\\DataFlowProbe_24_2\\conf;E:\\UCMDB\\DataFlowProbe_24_2\\lib\\*\"",
                "com.hp.ucmdb.discovery.probe.agents.probegw.DBPassDecryptor",
                "E:\\UCMDB\\DataFlowProbe_24_2"};

        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb = pb.redirectErrorStream(true);
        Process process = pb.start();

        StringBuilder sb = new StringBuilder();
        String line = null;
        String lastLine = null;
        try (BufferedReader r = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            while ((line = r.readLine()) != null) {
                sb.append("\n").append(line);
                lastLine = line;
            }
            System.out.println("process output:" + sb);
        } catch (IOException e) {
            System.out.println(e);
        }

        process.waitFor(3600000, TimeUnit.SECONDS);

        System.out.println("last line:");
        System.out.println(lastLine);
        System.out.println(process.exitValue());

        System.out.println(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date(System.currentTimeMillis())));


    }

}
