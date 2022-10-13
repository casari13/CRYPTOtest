package cat.uvic.teknos.m09;

public class SignatureTest{
    public static void main(String[] args){
        var message=Files.readAllBytes(Path.get("app/src/main/resources/message.txt"));

        var keyStore=KeyStore.getInstace("PKS12");
        keyStore.load(new FileInputStream("app/src/main/resources/message.txt"),"Teknos01.".toCharArray());
        var privateKey=keyStore.getKey("self_signed_ca","Teknos01.".toCharArray());

        var signer=Signature.getInstance("SHA256withRSA");
        signer.initSign((PrivateKey) privateKey);
        signer.update(message);

        var signature=signer.sign();

        var base64Encoder=Base64.gerEncoder();
        var cipherTextBase64=nase64Encoder.encodeToString(signature);

        var certificateFactoru= CertificateFactory.getInstance("X.509");
        var certificate = certificateFactory.generateCertificate(new FileInputStream("pp/src/main/"));
        var publicKey= certificate.getPublicKey();
        signer.initSign((PrivateKey) publicKey);
        signer.update(message);
        var isValid=signer.verify(signature)

    }
}