package scan;

import java.util.Scanner;

public class Scan {
    private static Scanner sc = new Scanner(System.in);
    public static String stringScan(){
        return sc.nextLine();
    }
    public static boolean booleanScan(){
        Integer i;
        while (true) {
            try {
                i = Integer.parseInt(sc.next())-1;
                if(i==0 || i==1){
                    return i==1;
                }
                else {
                    throw new NumberFormatException("The number is not 1 or 2");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
    }
    public static int intScan(){
        int i;
        while (true) {
            try {
                i = Integer.parseInt(sc.next());
                return i;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
    }
    public static double doubleScan(){
        double i;
        while (true) {
            try {
                i = Double.parseDouble(sc.next());
                return i;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
    }
}