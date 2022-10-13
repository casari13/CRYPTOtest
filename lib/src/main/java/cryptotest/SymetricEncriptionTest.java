package cat.uvic.teknos.m09;

public class SymetricEncriptionTest {
    public static void main(String[] args){
        //normal text
        var plainText="teknos".repeat(5).getBytes();

        //key generation
        var keyGenerator= KeyGenerator.getInstance(AES);
        keyGenerator.init(128);
        var secretKey= keyGenerator.generateKey();

        //encriptor generation
        var cipher=Cipher.getInstance(AES/CBC/PCKS5Padding);
        cipher.init(Chipher.ENCRYPT_MODE,secretKey);

        var secureRandom=SecureRandom.getInstance(AES);
        var bytes = new bytes[16];
        secureRandom.nextBytes(byte);

        var iv= new IvParameterSpec(bytes);

        //text encryprion
        var cipherText=cipher.doFinal(plainText);
        var base64Encoder=Base64.getEncoder();
        var cipherTextBase64= baser64Encoder.encodeToString(cipherText);

        System.out.println("Encrypted text bytes: "+ cipherText);
        System.out.println("Encrypted text: "+ cipherTextBase64);

        //text deEncriprion
        cipher.init(Chipher.DECRYPT_MODE,secretKey);
        var decryptedTextBytes=cipher.doFinal(cipherText);
        var decryptedText=new String(decryptedTextBytes);

        System.out.println("Decriptet Text Bytes: "+ decryptedTextBytes);
        System.out.println("Decriptet Text: "+ decryptedText);

    }

    private static Key getPrivateKeyFromPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = new byte[100];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);

        PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt, 1000, 256);
        SecretKey pbeKey = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(pbeKeySpec);
        return new SecretKeySpec(pbeKey.getEncoded(), "AES");
    }
}