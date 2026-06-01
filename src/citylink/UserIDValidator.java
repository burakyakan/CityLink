/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package citylink;

/**
 *
 * @author burak
 */
public class UserIDValidator {

    public static boolean isValid(String userID) {
        if (userID == null || userID.length() != 11 || userID.startsWith("0") || !userID.matches("\\d+")) {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Character.getNumericValue(userID.charAt(i));
        }

        int sumOdd = digits[0] + digits[2] + digits[4] + digits[6] + digits[8];
        int sumEven = digits[1] + digits[3] + digits[5] + digits[7];

        int checkDigit10 = ((sumOdd * 7) - sumEven) % 10;
        if (checkDigit10 < 0) {
            checkDigit10 += 10;
        }

        int sumFirst10 = 0;
        for (int i = 0; i < 10; i++) {
            sumFirst10 += digits[i];
        }
        int checkDigit11 = sumFirst10 % 10;

        if (digits[9] == checkDigit10 && digits[10] == checkDigit11) {
            return true; 
        } else {
            return false; 
        }
    }
}
