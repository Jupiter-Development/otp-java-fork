package com.bastiaanjansen.otp;

public class ExampleApp {
    public static void main(String[] args) {

        // Generate a secret, if you don't have one already
        byte[] secret = SecretGenerator.generate();

        // Create a TOTPGenerate instance
        TOTP.Builder builder = new TOTP.Builder(secret);
        TOTP totp = builder
                .withPasswordLength(4)
                .withAlgorithm(HMACAlgorithm.SHA1)
                .build();

        try {
            String code = totp.now();
            System.out.println("Generated code: " + code);

            // To verify a codes
            Boolean verified = totp.verify(code); // true
            System.out.println("Verified: " + verified);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
