import java.io.File;
import java.math.BigInteger;

public class RSAEncrypt {

	static BigInteger modulus, publicExp;
	public static void main(String[] args) {
		if (args.length == 3) {
			BigInteger message = null;
			BigInteger encryptedMessage = null;
			
			FileHandler inFile = new FileHandler(new File(args[0]));
			FileHandler outFile = new FileHandler(new File(args[1]));
			FileHandler keyFile = new FileHandler(new File(args[2]));
			
			modulus = keyFile.getVariable(0);
			publicExp = keyFile.getVariable(1);
			message = inFile.getBigIntValue("enc");
			encryptedMessage = encrypt(message);
			outFile.writeStringToFile(encryptedMessage.toString());
			System.out.println("The file has been encrypted and can be found in " + args[1]);
		}else {
			System.out.println("Program needs three parameters:\n"
					+ "1. Source File path\n"
					+ "2. Destination File path\n"
					+ "3. Key File path");
		}
	}
	
	private static BigInteger encrypt(BigInteger message) {
		BigInteger result = message.modPow(publicExp, modulus);
		return result;
	}
	
}
