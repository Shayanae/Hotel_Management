package beans;

import java.util.Scanner;

public class Check {
    static Scanner sc = new Scanner(System.in);
    static boolean check;
    static int i;
    public static boolean cString(String value){
            i=0;
            check=true;
            while (i<value.length()&&check){
                check= !Character.isDigit(value.charAt(i));
                i++;
            }
            if (!check){
                System.out.println("Veuillez entrer uniquement des lettres");
            }
        return check;
    }
    public static boolean cInt(char[] value){
            i=0;
            check=true;
            while (i<value.length&&check) {
                if (!Character.isDigit(value[i])){
                    System.out.println("Veuillez entrer uniquement un ou des nombres");
                    check=false;
                }
                if (check){
                    check = intSize(value);
                }
                i++;
            }
        return check;
    }
    public static boolean intSize(char[] value){
        if (value.length>9) {
            System.out.println("Veuillez entrer uniquement l'un des chiffres proposer.");
            check=false;
        }else if (value.length==0) {
            System.out.println("Veuillez entrer un chiffre avant d'appuyez sur entrer");
            check = false;
        }
        return check;
    }

}
