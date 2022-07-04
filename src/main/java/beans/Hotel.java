package beans;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hotel {
//    private Room[] rooms = new Room[31];
    private Room room = new Room();
    private Statement stmt;
    private ResultSet res;
    public void roomDisplay(Statement stmt, int nbPeople){
        try {
            res = stmt.executeQuery("SELECT rooms.noroom, rooms.nocategory, rooms.nbpeople " +
                    "FROM rooms " +
                    "WHERE taken = false AND rooms.nbpeople = " + nbPeople + " " +
                    "ORDER BY rooms.noroom;");
            while (res.next()){
                System.out.print("N° "+ res.getInt("noroom"));
                System.out.print(", Catégorie "+ res.getInt("nocategory"));
                System.out.print(", Description: " + room.takeDescript(res.getInt("nocategory") - 1));
                System.out.println(", Prix :" + room.takePrice(nbPeople-1, res.getInt("nocategory") - 1) + " €");
            }

        }catch (Exception e){
            System.out.println("erreur");
        }
    }

    public boolean roomRelease(int roomNumber){
        int i = 0;
        boolean flag = false, check = false;

//        while (i < rooms.length && !flag){
//            if (roomNumber == rooms[i].getNumber() && rooms[i].isTaken()){
//                rooms[i].setTaken(false);
//                check = true;
//            } else if (roomNumber == rooms[i].getNumber() && !rooms[i].isTaken()) {
//                System.out.println("Cette chambre est déjà vide.");
//            }
//            i++;
//        }
        return check;
    }

    public boolean takingRoom(Statement stmt, int roomNumber, int nbPeople){
        boolean check = false, ok = false;

//        while (i < rooms.length && !flag){
//            if (roomNumber == rooms[i].getNumber() && !rooms[i].isTaken() && nbPeople == rooms[i].getNbPeople()){
//                rooms[i].setTaken(true);
//                flag = true;
//                check = true;
//            } else if (roomNumber == rooms[i].getNumber() && !rooms[i].isTaken() && nbPeople != rooms[i].getNbPeople()) {
//                System.out.println("Veuillez selectionner l'une des chambres proposer.");
//            } else if (roomNumber == rooms[i].getNumber() && rooms[i].isTaken()) {
//                System.out.println("Cette chambre est déjà prise.");
//            }
//            i++;
//        }
        try{
            res = stmt.executeQuery("SELECT taken FROM rooms WHERE noroom = " + roomNumber + " " +
                    "AND nbpeople = " + nbPeople + ";");
            while (res.next() && !check) {
                if (res.getBoolean("taken")) {
                    System.out.println("Cette chambre est déjà prise, veuillez prendre une des chambres proposer plus haut");
                } else {
                    res.close();
                    System.out.println("test");
                    check = true;
                    res = stmt.executeQuery("UPDATE rooms SET taken = true WHERE noroom = " + roomNumber + " " +
                            "AND nbpeople = " + nbPeople + ";");

                }
            }
        }catch (Exception e){
            System.out.println("TEST");
        }
        return check;
    }

    public boolean cRoomTaken(){
//        int i = 0;
        boolean flag = false;
//        while (i < rooms.length && !flag){
//            if (rooms[i].isTaken()){
//                flag = true;
//            }
//            i++;
//        }
        return flag;
    }
}