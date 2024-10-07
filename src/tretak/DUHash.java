package tretak;

import java.util.Random;

public class DUHash {
    public static int mujHash(String str) {
        int out = 1;
        for (char ch: str.toCharArray()) {
            out = (out * (int)ch) % 9973;
        }
        return out;
    }
    public static String rndString(int length){
        
        //65 A .. 90 Z, 97 a .. 122 z
        int lowerBound1 = 65;
        int upperBound1 = 90;
        int lowerBound2 = 97;
        int upperBound2 = 122;

        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            boolean isUppeCase = random.nextBoolean();

            int randomInt;
            if (isUppeCase){
                randomInt = lowerBound1 + random.nextInt(upperBound1-lowerBound1);
            }else {
                randomInt = lowerBound2 + random.nextInt(upperBound2 - lowerBound2);
            }
            char rndChar = (char) randomInt;
            stringBuilder.append(rndChar);
        }

        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String msg = "ProgramovaT";
        int foundOutputs = 0;
        for (;;){
            String potencialOut = rndString(3); //kratsi se mi nepodarilo najit
            if ((mujHash(potencialOut) == mujHash(msg)) && (foundOutputs < 5)){
                System.out.println(potencialOut);
                foundOutputs++ ;
            }
        }
    }
}
