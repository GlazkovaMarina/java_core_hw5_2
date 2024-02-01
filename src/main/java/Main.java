import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static String to2Bits(int decimalNumber) {
            if (decimalNumber < 0 || decimalNumber > 3) {
                throw new RuntimeException("Некорректное значение! Доступный диапазон: 0 - 3!");
            } else if (decimalNumber == 0) {
                return "00";
            } else if (decimalNumber == 1) {
                return "01";
            } else if (decimalNumber == 2) {
                return "1";
            }
            return "11";
    }

    public static int toDecimal(String binaryNumber) {
        //напишите тут ваш код
        if(binaryNumber == null) {
            return 0;
        }
        int bin = Integer.parseInt(binaryNumber);
        int decimal = 0;

        for(int i = 0; i < binaryNumber.length(); i++) {
            int b = bin % 10;
            bin = bin / 10;
            decimal += b * Math.pow(2, i);
        }
        return decimal;
    }



    public static void main(String[] args) {
        int[]array = {3,3,3,3,3,3,3,3,3};
        try(FileOutputStream fos=new FileOutputStream("notes.txt"))
        {
            fos.write(array[0]);
            String validString = "";
            for (int i = 1; i < array.length; i++) {
                validString += to2Bits(array[i]);
                if (i % 4 == 0){
                    fos.write(toDecimal(validString));
                    validString = "";
                }
            }
            System.out.println(validString);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }
}
