
/*
	This file can be used to get Base64-data from a file
	and
	convert it to a file.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Base64.Decoder;

public class Example {
	private static final String SOURCE_FILE_LOCATION = "/location/of/source/file.txt";
	private static final String DESTINATION_FILE_DIR = "/directory/of/destination/file/";
	private static final String FINAL_FILE_NAME = "final.pdf";

	public static void main(String[] args) throws IOException {
		String base64String = "";

		/* read string-data from file */
		{
			File file = new File(SOURCE_FILE_LOCATION);

			BufferedReader br = new BufferedReader(new FileReader(file));

			String stringLine = "";
			while ((stringLine = br.readLine()) != null) {
				base64String = stringLine;
			}
			br.close();
		}

		/* convert base64 data to file */
		{
			Decoder decoder = Base64.getDecoder();
			byte[] decodedImg = decoder.decode(base64String.getBytes(StandardCharsets.UTF_8));
			Path destinationFile = Paths.get(DESTINATION_FILE_DIR, FINAL_FILE_NAME);
			Files.write(destinationFile, decodedImg);
		}
	}
}
