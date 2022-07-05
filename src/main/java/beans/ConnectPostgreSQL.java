package beans;

import Menu.MenuManagement;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class ConnectPostgreSQL {
    MenuManagement menuManagement = new MenuManagement();
    public void connect(){
        try{
            // étape 1: charger la classe de driver
            Class.forName("org.postgresql.Driver");

            // étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "MS_JAVA$06/2022");

            // étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();


            // étape 4: exécuter la requête
            menuManagement.Home(stmt);

            // étape 5: fermez l'objet de connexion
            conn.close();
        }catch (Exception e){System.out.println("beug");}
    }

}
