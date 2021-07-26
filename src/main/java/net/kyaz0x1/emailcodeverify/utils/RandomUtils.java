package net.kyaz0x1.emailcodeverify.utils;

import java.util.Random;

public class RandomUtils {

    public static String randomNumerics(int size){
        final Random random = new Random();
        final StringBuilder builder = new StringBuilder();
        final char[] numbers = "0123456789".toCharArray();
        for(int i = 0; i < size; i++){
            final int randomNumber = random.nextInt(numbers.length);
            builder.append(numbers[randomNumber]);
        }
        return builder.toString();
    }

}