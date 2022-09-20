import com.amazonaws.util.Base64;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConvertFileToString {

    @SneakyThrows
    public static void main(String[] args) {
        System.err.println(
                convertFileToBase64(Files.newInputStream(Paths.get("/Users/arsh.baghel/Desktop/temp/some_image.png")))
        );
    }

    @SneakyThrows
    private static String convertFileToBase64(InputStream inputStream) {
        byte[] image = IOUtils.toByteArray(inputStream);
        return new String(Base64.encode(image));
    }
}
