package Menu;

import beans.Check;
import beans.Hotel;

import java.util.Scanner;

public class MenuManagement {
    Scanner sc = new Scanner(System.in);
    DisplayMenu displayMenu = new DisplayMenu();
    Hotel hotel = new Hotel();

    public void Home(){
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
                    hotel.roomDisplay(nbPeople);
                    do {
                        do {
                            System.out.println("Entrer le numéro de chambre voulu");
                            tempRoomNumber = sc.nextLine();
                            cRoomNumber = tempRoomNumber.toCharArray();
                            check = Check.cInt(cRoomNumber);
                        } while (!check);
                        roomNumber = Integer.parseInt(tempRoomNumber);
                        if (roomNumber > 31 || roomNumber < 1){
                            System.out.println("Ce numéro de chambre n'existe pas");
                        }else {
                            hotel.takingRoom(roomNumber);
                        }
                    }while (roomNumber > 31 || roomNumber < 1);

                    break;
                case 2:
                    do {
                        System.out.println("Entrer le numéro de la chambre qui s'est libérer: ");
                        tempRoomNumber = sc.nextLine();
                        cRoomNumber = tempRoomNumber.toCharArray();
                        check = Check.cInt(cRoomNumber);
                    }while (!check);
                    roomNumber = Integer.parseInt(tempRoomNumber);
                    if (roomNumber > 31 || roomNumber < 1 ){
                        System.out.println("Ce numéro de chambre n'existe pas");
                    }else {
                        hotel.roomRelease(roomNumber);
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
