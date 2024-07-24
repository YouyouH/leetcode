import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.StringJoiner;

public class TestTLS {
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException, CertificateException, KeyStoreException {
        System.setProperty("javax.net.debug", "all");
        System.setProperty("jdk.tls.client.cipherSuites", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        System.setProperty("jdk.tls.server.cipherSuites", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[] {
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


        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

        SSLSocketFactory socketFactory = sslContext.getSocketFactory();
        System.out.println("supported cipher:"+String.join(",",socketFactory.getDefaultCipherSuites()));
//        System.out.println("default   cipher:"+String.join(",",socketFactory.getSupportedCipherSuites()));

        HttpsURLConnection.setDefaultSSLSocketFactory(socketFactory);

        // Disable hostname verification
        HostnameVerifier allHostsValid = (hostname, session) -> true;
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);



        HttpsURLConnection con = (HttpsURLConnection) new URL(" https://localhost:8445/ping/").openConnection();
//        HttpsURLConnection con = (HttpsURLConnection) new URL(" https://16.155.194.113:8443/").openConnection();
//        HttpsURLConnection con = (HttpsURLConnection) new URL(" https://cms-24-4-128.daily.itom-cms.com/ping/").openConnection();
//        FileInputStream fis = new FileInputStream(args[0]);
//        KeyStore ts = KeyStore.getInstance(KeyStore.getDefaultType());
//        ts.load(fis, args[1].toCharArray());
//        con.setSSLSocketFactory(SSLContexts.custom().setProtocol("TLSv1.2").loadTrustMaterial(ts, null).build().getSocketFactory());
        con.setRequestMethod("GET");
        con.setInstanceFollowRedirects(false);
        int status = con.getResponseCode();
        System.out.println("CMDB COnnectionCode: " + status);
    }
}

