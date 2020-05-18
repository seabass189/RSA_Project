import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileHandler {
	
	private File file;
	private List<String> variables = null;
	
	public FileHandler(File file) {
		this.file = file;
	}

	public BigInteger getVariable(int index) {
		if (variables == null) readKeyFileIntoVariables();
		return new BigInteger(variables.get(index));
	}
	
	private void readKeyFileIntoVariables() { 
	    try
	    { 
	    	variables = Files.readAllLines(Paths.get(file.toString()), StandardCharsets.UTF_8); 
	    } 
	    catch (IOException e) 
	    { 
	    	System.out.println("ERROR: Key file path points to a file that does not exist.");
	    }
	}
	
	public BigInteger getBigIntValue(String method) {
	    String fileString = "";
	    try
	    {
	        fileString = new String (Files.readAllBytes(Paths.get(file.toString())));
	    } 
	    catch (IOException e) 
	    {
	    	System.out.println("ERROR: Input file path points to a file that does not exist.");
	    }
	    BigInteger fileBigInt = null;
	    if (method.equals("enc")) {
	    	byte[] fileBytes = fileString.getBytes(StandardCharsets.UTF_8);
		    fileBigInt = new BigInteger(fileBytes);
		}else if (method.equals("dec")) {
			fileBigInt = new BigInteger(fileString);
		}else {
			System.out.println("ERROR: Invalid method string entered into getBigIntValue method.");
		}
	    return fileBigInt;
	}
	
	public void writeBigIntToFile(BigInteger message) {
		String fileContents = "";
		for(byte b: message.toByteArray()){
			fileContents += (char) b;
		}
		writeStringToFile(fileContents);
	}
	
	public void writeStringToFile(String contents) {
		if(file.getParentFile() != null) file.getParentFile().mkdirs();
		
		byte[] fileBytes = contents.getBytes(StandardCharsets.UTF_8);

		try (FileOutputStream fos = new FileOutputStream(file)) {
			fos.write(fileBytes);
			fos.close();
		}
		catch (IOException e) {
			System.out.println("ERROR: Destination file path cannot be created.");
		}
	}

}
