import java.util.Random;

public class Generator {

    static private Random rand;

    private void getRandom(){ rand = new Random();}

    public String generateString(boolean isLowerCase,boolean isUpperCase,
                                boolean isDigits, boolean isSimvols, int len){

        String lowerCase = "abcdefghjklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String simvols = "!@#$%*";

        StringBuilder validString = new StringBuilder();

        if(isLowerCase) {validString.append(lowerCase);}
        if(isUpperCase) {validString.append(upperCase);}
        if(isDigits) {validString.append(digits);}
        if(isSimvols) {validString.append(simvols);}

        if(validString.length()>0){

            getRandom();

            StringBuilder generateString = new StringBuilder();

            //generate
            for(int i = 0;i < len; i++) {

                int randonPosition = rand.nextInt(validString.length());
                generateString.append(validString.charAt(randonPosition));
            }

            String print = generateString.toString();

            return print;
        }
        return "";
    }

}
