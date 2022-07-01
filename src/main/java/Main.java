import Menu.MenuManagement;
import beans.CsvManagement;
import beans.Hotel;
import beans.Room;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MenuManagement menuManagement = new MenuManagement();
        CsvManagement csvManagement = new CsvManagement();

        csvManagement.csvRoom();
        menuManagement.Home();
    }
}
