package Menu;

import beans.Check;
import beans.Hotel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MenuManagement {
    Scanner sc = new Scanner(System.in);
    DisplayMenu displayMenu = new DisplayMenu();
    Hotel hotel = new Hotel();

    public void Home(Statement stmt){
        String tempChoice, tempNbPeople, tempRoomNumber;
        int choice, nbPeople, roomNumber;
        boolean check;
        char[] cRoomNumber;

        do {
            do {
                displayMenu.Home();
                tempChoice = sc.nextLine();
                char[] cChoice = tempChoice.toCharArray();
                check = Check.cInt(cChoice);
            } while (!check);
            choice = Integer.parseInt(tempChoice);
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Pour combien de personne voulez vous une chambre?");
                        tempNbPeople = sc.nextLine();
                        char[] cNbPeople = tempNbPeople.toCharArray();
                        check = Check.cInt(cNbPeople);
                    }while (!check);
                    nbPeople = Integer.parseInt(tempNbPeople);
                    hotel.roomDisplay(stmt, nbPeople);
                    if (nbPeople < 1 || nbPeople > 4){
                        System.out.println("Aucune chambre ne correspond");
                    }else {
                        do {
                            do {
                                System.out.println("Entrer le numéro de chambre voulue");
                                tempRoomNumber = sc.nextLine();
                                cRoomNumber = tempRoomNumber.toCharArray();
                                check = Check.cInt(cRoomNumber);
                            } while (!check);
                            roomNumber = Integer.parseInt(tempRoomNumber);
                            if (roomNumber > 31 || roomNumber < 1) {
                                System.out.println("Ce numéro de chambre n'existe pas");
                            } else {
                                check = hotel.takingRoom(stmt, roomNumber, nbPeople);
                            }
                        } while (roomNumber > 31 || roomNumber < 1 || !check);
                    }
                    break;
                case 2:
                    if (!hotel.cRoomTaken()){
                        System.out.println("Aucune chambre n'est occuper");
                    }else {
                        do {
                            do {
                                System.out.println("Entrer le numéro de la chambre qui s'est libérer: ");
                                tempRoomNumber = sc.nextLine();
                                cRoomNumber = tempRoomNumber.toCharArray();
                                check = Check.cInt(cRoomNumber);
                            } while (!check);
                            roomNumber = Integer.parseInt(tempRoomNumber);
                            if (roomNumber > 31 || roomNumber < 1) {
                                System.out.println("Ce numéro de chambre n'existe pas");
                            } else {
                                check = hotel.roomRelease(roomNumber);
                                System.out.println("La chambre est maintenant libre");
                            }
                        } while (!check);
                    }
                    break;
                case 3:
                    System.out.println("Aurevoir");
                    break;
                default:
                    System.out.println("Veuillez entrer l'un des chiffres proposer.");
            }
        }while (choice!=3);
    }
}
