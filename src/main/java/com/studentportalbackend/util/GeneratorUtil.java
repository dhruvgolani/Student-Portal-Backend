package com.studentportalbackend.util;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneratorUtil {

    private static final Integer OTP_LENGTH = 5;
    private static final Integer TOKEN_LENGTH = 20;

    static final String alphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static final String numbers = "0123456789";
    static SecureRandom random = new SecureRandom();

    public static String getToken(){
        return IntStream.range(0, TOKEN_LENGTH).mapToObj(i -> String.valueOf(alphaNumeric.charAt(random.nextInt(alphaNumeric.length())))).collect(Collectors.joining("", String.valueOf(TOKEN_LENGTH), ""));
    }

    public static  String getOtp() {
        return IntStream.range(0, OTP_LENGTH).mapToObj(i -> String.valueOf(numbers.charAt(random.nextInt(numbers.length())))).collect(Collectors.joining("", String.valueOf(OTP_LENGTH), ""));
    }
}
