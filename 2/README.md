# Get Base64-data from file and convert it into the file.

------------------------------------------------------------------

## Steps :

### 1. Get data from file and store it in 'STRING'.

### 2. Convert base64-string to 'FILE'.

-------------------------------------------------------------------

## Code :

// Read string-data from file and store it in a String

import java.io.BufferedReader;

import java.io.File;

import java.io.FileReader;

import java.io.IOException;

		{
    
			File file = new File(SOURCE_FILE_LOCATION);

			BufferedReader br = new BufferedReader(new FileReader(file));

			String stringLine = "";
      
			while ((stringLine = br.readLine()) != null) {
      
				base64String = stringLine;
        
			}
      
			br.close();
      
		}


// Convert base64 data to file

import java.util.Base64;

import java.util.Base64.Decoder;

import java.nio.file.Files;

import java.nio.file.Path;

import java.nio.file.Paths;

import java.nio.charset.StandardCharsets;

		{
    
			Decoder decoder = Base64.getDecoder();
      
			byte[] decodedImg = decoder.decode(base64String.getBytes(StandardCharsets.UTF_8));
      
			Path destinationFile = Paths.get(DESTINATION_FILE_DIR, FINAL_FILE_NAME);
      
			Files.write(destinationFile, decodedImg);
      
		}
