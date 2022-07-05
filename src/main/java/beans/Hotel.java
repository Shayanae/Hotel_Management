package beans;

import java.sql.ResultSet;
import java.sql.Statement;

public class Hotel {
    private Room room = new Room();
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

    public boolean roomRelease(Statement stmt, int roomNumber){
        boolean check = false;

        try {
            res = stmt.executeQuery("SELECT taken from rooms WHERE noroom = " + roomNumber + ";");
            while (res.next() && !check){
                if (res.getBoolean("taken")){
                    check = true;
                    res = stmt.executeQuery("UPDATE rooms SET taken = false WHERE noroom = " + roomNumber + ";");
                }
            }
        }catch (Exception e){
            // beug à résoudre
        }

        return check;
    }

    public boolean takingRoom(Statement stmt, int roomNumber, int nbPeople){
        boolean check = false;

        try{
            res = stmt.executeQuery("SELECT taken FROM rooms WHERE noroom = " + roomNumber + " " +
                    "AND nbpeople = " + nbPeople + ";");
            while (res.next() && !check) {
                if (res.getBoolean("taken")) {
                    System.out.println("Cette chambre est déjà prise, veuillez prendre une des chambres proposer plus haut");
                } else {
                    check = true;
                    res = stmt.executeQuery("UPDATE rooms SET taken = true WHERE noroom = " + roomNumber + " " +
                            "AND nbpeople = " + nbPeople + ";");
                }
            }
        }catch (Exception e){
            // Beug à résoudre
        }
        return check;
    }

    public boolean cRoomTaken(Statement stmt){
        boolean flag = false;

        try{
            res = stmt.executeQuery("SELECT taken FROM rooms");
            while (res.next() && !flag) {
                if (res.getBoolean("taken")) {
                    flag = true;
                }
            }
        }catch (Exception e){
        }

        return flag;
    }
}