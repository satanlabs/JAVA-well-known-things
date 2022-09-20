import org.apache.commons.io.FileUtils;

  private static void stringToFile(String fileUrl, String fullDocument) throws IOException {
    FileUtils.writeStringToFile(new File(fileUrl), fullDocument, StandardCharsets.UTF_8);
  }
	
  private static String fileToString(String fileUrl)  throws IOException  {	
    return FileUtils.readFileToString(new File(fileUrl));
  }

private static byte[] fileToByteArray(String fileUrl) throws IOException  {
	return FileUtils.readFileToByteArray(new File(fileUrl));
}
