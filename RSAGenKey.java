import java.io.File;
import java.math.BigInteger;
import java.util.Random;

public class RSAGenKey {
	
	public static void main(String[] args) {
		if (args.length == 1) {
			FileHandler keyFile = new FileHandler(new File(args[0]));
			
			BigInteger primeP = new BigInteger(513, 100, new Random());
			BigInteger primeQ = new BigInteger(513, 100, new Random());
			BigInteger modulus = primeP.multiply(primeQ);
			BigInteger totient = (primeQ.subtract(BigInteger.ONE)).multiply((primeP.subtract(BigInteger.ONE)));
			BigInteger publicExp = new BigInteger("65537");
			BigInteger privateExp = publicExp.modInverse(totient);
			
			String fileContents = modulus + "\n" + publicExp + "\n" + privateExp;
			keyFile.writeStringToFile(fileContents);
			
			System.out.println("The key has been generated and can be found in " + args[0]);
		}else {
			System.out.println("Program needs one parameter: File path where key file should be stored");
		}
		
	}
}