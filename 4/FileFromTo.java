import org.apache.commons.io.FileUtils;

import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

  private static void stringToFile(String fullDocument) throws IOException {

    FileUtils.writeStringToFile(new File("/some/dir/filename.txt"), fullDocument, StandardCharsets.UTF_8);

  }
	
  private static String fileToString(String fileName)  throws IOException  {	
  
    return FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);
  
  }

private static byte[] fileToByteArray(String fileName) throws IOException  {
	return FileUtils.readFileToByteArray(new File(fileName));
}
