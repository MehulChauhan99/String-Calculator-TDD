package src;

public class StringCalculator {

    public static int add(String stringNumber) {

        if (stringNumber.equals("")) {
            System.out.println("It is an empty string");
            return 0;
        } else if (stringNumber.length() >= 1) {
            String delimiter = ",";
            if (stringNumber.matches("//(.*)\n(.*)")) {
                delimiter = Character.toString(stringNumber.charAt(2));
                stringNumber = stringNumber.substring(4);
            }

            String numList[] = splitNumbers(stringNumber, delimiter + "|\n");
            return sum(numList);
        }
        return 1;
    }

    private static int toInt(String number) {
        return Integer.parseInt(number);
    }

    private static int sum(String[] arrayOfNumbers) {
        int sumofStringNumber = 0;
        String negativeString = "";

        for (String number : arrayOfNumbers) {
            if (toInt(number) < 0) {
                if (negativeString.equals(""))
                    negativeString = number;
                else
                    negativeString += ("," + number);
            }
            if (toInt(number) <= 1000)
                sumofStringNumber += toInt(number);
        }

        if (!negativeString.equals("")) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeString);
        }
        return sumofStringNumber;
    }

    public static String[] splitNumbers(String stringNumber, String divider) {
        return stringNumber.split(divider);
    }

    /*
     * public static void convertStringIntoNumber(String stringNumber)
     * {
     * char[] ch = stringNumber.toCharArray();
     * System.out.println(ch);
     * for(char c : ch){
     * int temp = (int)c;
     * int temp_integer = 96; //for lower case
     * if(temp<=122 & temp>=97)
     * {
     * int convert = temp-temp_integer;
     * System.out.print(convert);
     * }
     * }
     * System.out.println();
     * 
     * }
     */

    public static void main(String[] args) {
        int number = add("10001,1,2,3,4,5,6,7");
        System.out.println(number);
        // convertStringIntoNumber("1,b,c,a");
    }
}
