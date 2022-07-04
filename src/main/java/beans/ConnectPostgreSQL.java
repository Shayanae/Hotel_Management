package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectPostgreSQL {
    static ResultSet res;

    public static void setRes(ResultSet res) {
        ConnectPostgreSQL.res = res;
    }

    public void connect(){
        try{
            // étape 1: charger la classe de driver
            Class.forName("org.postgresql.Driver");

            // étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres", "postgres", "MS_JAVA$06/2022");

            // étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            setRes(stmt.executeQuery("SELECT * FROM rooms"));

            // étape 4: exécuter la requête
            while (res.next()){
                System.out.println(res.getInt(1)+" "+res.getInt(2)+" "+res.getInt(3)+""+res.getBoolean(4));
            }

            // étape 5: fermez l'objet de connexion
            conn.close();
        }catch (Exception e){System.out.println(e);}
    }

}
