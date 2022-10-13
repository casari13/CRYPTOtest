package cat.uvic.teknos.m09;

public class HashTest {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        var salt12 = getSalt();
        var salt3 = getSalt();

        /*var digest1 = getDigestNoSalt("teknos");
        var digest2 = getDigestNoSalt("teknos");
        var digest3 = getDigestNoSalt("teknos1");*/

        var digest1 = getDigest("teknos", salt12);
        var digest2 = getDigest("teknos", salt12);
        var digest3 = getDigest("teknos", salt3);

        System.out.println("digest1: " + digest1);
        System.out.println("digest2: " + digest2);
        System.out.println("digest2: " + digest3);

    }

    public static String getDigestNoSalt(String data) throws NoSuchAlgorithmException {
        var dataBytes = data.getBytes();

        var messageDigest = MessageDigest.getInstance("SHA-256");

        var digest = messageDigest.digest(dataBytes);

        var base64Encoder = Base64.getEncoder();

        return base64Encoder.encodeToString(digest);
    }

    public static String getDigest(String data, byte[] salt) throws NoSuchAlgorithmException {
        var dataBytes = data.getBytes();

        var messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(salt);

        var digest = messageDigest.digest(dataBytes);

        var base64Encoder = Base64.getEncoder();

        return base64Encoder.encodeToString(digest);
    }

    public static byte[] getSalt() {
        var secureRandom = new SecureRandom();

        var salt = new byte[16];
        secureRandom.nextBytes(salt);

        return salt;
    }


}