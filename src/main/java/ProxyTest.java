import java.io.IOException;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.util.Base64;

public class ProxyTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.getProperty("jdk.http.auth.tunneling.disabledSchemes"));
//        https://stackoverflow.com/questions/1626549/authenticated-http-proxy-with-java
//        -Dhttp.proxyHost=myproxy
//        -Dhttp.proxyPort=myport
//        -Dhttp.proxyUser=myuser
//        -Dhttp.proxyPassword=mypass

//        -Dhttps.proxyHost=myproxy
//        -Dhttps.proxyPort=myport
//        -Dhttps.proxyUser=myuser
//        -Dhttps.proxyPassword=mypass


//        E:\UCMDB\UCMDBServer\bin\jre\bin\javac .\ProxyTest.java
//        E:\UCMDB\UCMDBServer\bin\jre\bin\java -cp .  ProxyTest

        disableCertificateValidation();


        String url = "https://google.com";

//        String proxyHost = "web-proxy.sg.softwaregrp.net";
//        String proxyPort = "8080";
//        String proxyUser = "usera";
//        String proxyPassword = "passa";

        String proxyHost = "10.164.82.107";
        String proxyPort = "8081";
        String proxyUser = "youyou";
        String proxyPassword = "683991";

        //access http resources
        System.setProperty("http.proxyHost", proxyHost);
        System.setProperty("http.proxyPort", proxyPort);
        System.setProperty("http.proxyUser", proxyUser);
        System.setProperty("http.proxyPassword", proxyPassword);

        //access https resources
        System.setProperty("https.proxyHost", proxyHost);
        System.setProperty("https.proxyPort", proxyPort);
        System.setProperty("https.proxyUser", proxyUser);
        System.setProperty("https.proxyPassword", proxyPassword);


        Authenticator.setDefault(
                new Authenticator() {
                    public PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
                    }
                }
        );

        String encoded = Base64.getEncoder().encodeToString((proxyUser + ":" + proxyPassword).getBytes());

        int totalCount = 6 * 60 * 24 * 7;

        int success = 0;
        int fail = 0;


        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
//            connection.setRequestProperty("Proxy-Authorization", "Basic " + encoded);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println(url + " response code:" + responseCode);
            connection.disconnect();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                success++;
            } else {
                fail++;
            }
//            Thread.sleep(10000);
        } catch (Exception e) {
            fail++;
            e.printStackTrace();
//            Thread.sleep(10000);
        } finally {
            int sent = success + fail;
            String msg = "Success: " + success + ". Fail: " + fail + ". Total count: " + sent;
            System.out.println(msg);
        }
    }


    private static void disableCertificateValidation() {
        try {
            TrustManager[] trustAllCertificates = {
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() {
                            return null;
                        }

                        public void checkClientTrusted(X509Certificate[] certs, String authType) {
                        }

                        public void checkServerTrusted(X509Certificate[] certs, String authType) {
                        }
                    }
            };

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
