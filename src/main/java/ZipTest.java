import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTest {

    public static void main(String[] args) throws IOException {
        String path = "D:\\Users\\huangyou\\cpe case\\OCTIM19U1615142_Probe version not updating on Server - Complete Discovery blockade\\serverlogs_28June\\log\\";

        String file1 = "mam.autodiscovery.results.stat.log";

        String file2 = "mam.autodiscovery.taskgenerator.2.log";

        List<String> fileList = new ArrayList<>();
        fileList.add(path + file1);
        fileList.add(path + file2);

        FileOutputStream out = new FileOutputStream("D:\\Users\\huangyou\\cpe case\\test.zip");
        try (ZipOutputStream zos = new ZipOutputStream(out)) {
            for (String file : fileList) {
                File f = new File(file);
                try (FileInputStream fis = new FileInputStream(f)) {
                    byte[] buffer = new byte[1024 * 1024];
                    int len = 0;
                    zos.putNextEntry(new ZipEntry(f.getName()));
                    System.out.println("Starting writing " + f.getName());
                    while ((len = fis.read(buffer)) > 0) {
                        System.out.println(len + " has been loaded");
                        zos.write(Arrays.copyOf(buffer, len));
                    }
                    zos.flush();
//                    zos.closeEntry();
                }
            }
        }
    }
}
