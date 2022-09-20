
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64DecodeEncodeWithoutExternalLibrary {

    /*
    This is WITHOUT using any external libraries
    */

    private static byte[] decodeBase64String(final String base64String) {
        Decoder decoder = Base64.getDecoder();
        return decoder.decode(base64String.getBytes(StandardCharsets.UTF_8));
    }

    private static byte[] encodeStringToBase64(final String someString) {
        Encoder encoder = Base64.getEncoder();
        return encoder.encode(someString.getBytes());
    }
}
