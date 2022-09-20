import org.apache.commons.io.FileUtils;
import lombok.SneakyThrows;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

private static void stringToFile(String fileUrl, String fullDocument) throws IOException {
	FileUtils.writeStringToFile(new File(fileUrl), fullDocument, StandardCharsets.UTF_8);
}

private static String fileToString(String fileUrl)  throws IOException  {	
	return FileUtils.readFileToString(new File(fileUrl));
}

private static byte[] fileToByteArray(String fileUrl) throws IOException  {
	return FileUtils.readFileToByteArray(new File(fileUrl));
}

/*
This is without using any external libraries.
*/
@SneakyThrows
public static String fileToString(final String fileUrl) {
	File file = new File(fileUrl);
	StringBuilder fileData = new StringBuilder();
	BufferedReader br = new BufferedReader(new FileReader(file));

	String stringLine;
	while ((stringLine = br.readLine()) != null) {
	    fileData.append(stringLine);
	}
	br.close();

	return fileData.toString();
}
