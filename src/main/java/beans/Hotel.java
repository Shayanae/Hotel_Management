package beans;

import java.sql.ResultSet;
import java.sql.Statement;

public class Hotel {
    private ResultSet res;
    public void roomDisplay(Statement stmt, int nbPeople){
        try {
            res = stmt.executeQuery("SELECT r.noroom, r.nocategory, r.nbpeople , d.contain, p.price " +
                    "FROM rooms r, price p, descript d " +
                    "WHERE r.taken = false " +
                    "AND r.nbpeople = " + nbPeople + " " +
                    "AND r.nocategory = p.nocategory " +
                    "AND r.nocategory = d.nocategory " +
                    "AND p.nocategory = d.nocategory " +
                    "AND p.nopers = r.nbpeople " +
                    "ORDER BY r.noroom;");
            while (res.next()){
                System.out.print("N° "+ res.getInt("noroom"));
                System.out.print(", Catégorie "+ res.getInt("nocategory"));
                System.out.print(", Description: " + res.getString("contain"));
                System.out.println(", Prix :" + res.getInt("price"));
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
            System.out.println("BEUG");
        }

        return flag;
    }
}