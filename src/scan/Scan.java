package scan;

import java.util.Scanner;

public class Scan {
    private static Scanner sc = new Scanner(System.in);
    public static String stringScan(){
        return sc.nextLine();
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