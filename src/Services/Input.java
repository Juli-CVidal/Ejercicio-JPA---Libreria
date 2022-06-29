/*
// Curso Egg FullStack
 */
package Services;

// @author JulianCVidal
import Constants.Constants;
import java.util.Scanner;

public class Input {

    private static final Scanner INPUT = new Scanner(System.in).useDelimiter("\n");

    public static String askString(String message) {
        System.out.print(message);
        return INPUT.next();
    }
    
    public static boolean askBoolean(String message){
        System.out.print(message);
        String res = INPUT.next().substring(0,1);
        return "Y".equalsIgnoreCase(res);
    }

    public static Integer askInteger(String message) {
        System.out.print(message);
        return INPUT.nextInt();
    }
 
    public static Integer askPositiveInteger(String message){
        Integer value;
        System.out.println(Constants.ASK_POSITIVE_VALUE);
        do {
            value = askInteger(message);
            
        } while (0 >= value);
        return value;
    }

    public static Double askDouble(String message) {
        System.out.print(message);
        return INPUT.nextDouble();
    }
    
    public static Double askPositiveDouble(String message){
        Double value;
        System.out.println(Constants.ASK_POSITIVE_VALUE);
        do {
            value = askDouble(message);
            
        } while (0 >= value);
        return value;
    }

}
