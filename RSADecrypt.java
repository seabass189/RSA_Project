import java.io.File;
import java.math.BigInteger;

public class RSADecrypt {

	static BigInteger modulus, privateExp;
	public static void main(String[] args) {
		if (args.length == 3) {
			BigInteger ciphertext = null;
			BigInteger decryptedMessage = null;
					
			FileHandler inFile = new FileHandler(new File(args[0]));
			FileHandler outFile = new FileHandler(new File(args[1]));
			FileHandler keyFile = new FileHandler(new File(args[2]));
			
			modulus = keyFile.getVariable(0);
			privateExp = keyFile.getVariable(2);
			ciphertext = inFile.getBigIntValue("dec");
			decryptedMessage = decrypt(ciphertext);
			outFile.writeBigIntToFile(decryptedMessage);
			
			System.out.println("The file has been decrypted and can be found in " + args[1]);
		}else {
			System.out.println("Program needs three parameters:\n"
					+ "1. Destination File path\n"
					+ "2. Source File path\n"
					+ "3. Key File path");
		}
	}
	
	private static BigInteger decrypt(BigInteger ciphertext) {
		BigInteger result = ciphertext.modPow(privateExp, modulus);
		return result;
	}
	
}
