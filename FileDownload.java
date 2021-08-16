
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownload {
    public static void downloadFile(URL url, String fileName) throws IOException {
        try (InputStream in = url.openStream();
             BufferedInputStream bis = new BufferedInputStream(in);
             FileOutputStream fos = new FileOutputStream(fileName)) {

            byte[] data = new byte[1024];
            int count;
            while ((count = bis.read(data, 0, 1024)) != -1) {
                fos.write(data, 0, count);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // call to `downloadFile()` method
        URL url_path = new URL("https://mirrors.estointernet.in/apache//commons/math/binaries/commons-math3-3.6.1-bin.zip");
        String filename = "apache_commons_math.zip";
        downloadFile(url_path, filename);

    }
}