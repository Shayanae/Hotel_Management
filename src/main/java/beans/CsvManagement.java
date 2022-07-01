package beans;

import java.io.File;
import java.io.FileWriter;

public class CsvManagement {

    StringBuilder stringBuilderRooms = new StringBuilder();
    File f;

    public CsvManagement(){
        // Tab Chambre
        stringBuilderRooms.append("Numéro de chambre").append(";").append("Numéro de catégorie").append(";")
                .append("Nombre d'occupant max").append(";").append("Occupé").append("\n");
        stringBuilderRooms.append(1).append(";").append(1).append(";").append(1).append(";").append(false).append("\n");
        stringBuilderRooms.append(2).append(";").append(2).append(";").append(1).append(";").append(false).append("\n");
        stringBuilderRooms.append(3).append(";").append(3).append(";").append(1).append(";").append(false).append("\n");
        stringBuilderRooms.append(4).append(";").append(4).append(";").append(1).append(";").append(false).append("\n");
        stringBuilderRooms.append(5).append(";").append(1).append(";").append(2).append(";").append(false).append("\n");
        stringBuilderRooms.append(6).append(";").append(2).append(";").append(2).append(";").append(false).append("\n");
        stringBuilderRooms.append(7).append(";").append(3).append(";").append(2).append(";").append(false).append("\n");
        stringBuilderRooms.append(8).append(";").append(4).append(";").append(2).append(";").append(false).append("\n");
        stringBuilderRooms.append(9).append(";").append(1).append(";").append(3).append(";").append(false).append("\n");
        stringBuilderRooms.append(10).append(";").append(2).append(";").append(3).append(";").append(false).append("\n");
        stringBuilderRooms.append(11).append(";").append(3).append(";").append(3).append(";").append(false).append("\n");
        stringBuilderRooms.append(12).append(";").append(4).append(";").append(3).append(";").append(false).append("\n");
        stringBuilderRooms.append(13).append(";").append(5).append(";").append(3).append(";").append(false).append("\n");
        stringBuilderRooms.append(14).append(";").append(6).append(";").append(3).append(";").append(false).append("\n");
        stringBuilderRooms.append(15).append(";").append(1).append(";").append(4).append(";").append(false).append("\n");
        stringBuilderRooms.append(16).append(";").append(2).append(";").append(4).append(";").append(false).append("\n");
        stringBuilderRooms.append(17).append(";").append(3).append(";").append(4).append(";").append(false).append("\n");
        stringBuilderRooms.append(18).append(";").append(4).append(";").append(4).append(";").append(false).append("\n");
        stringBuilderRooms.append(19).append(";").append(5).append(";").append(4).append(";").append(false).append("\n");
        stringBuilderRooms.append(20).append(";").append(6).append(";").append(4).append(";").append(false).append("\n");
        stringBuilderRooms.append(21).append(";").append(1).append(";").append(1).append(";").append(false).append("\n");
        stringBuilderRooms.append(22).append(";").append(2).append(";").append(2).append(";").append(false).append("\n");
        stringBuilderRooms.append(23).append(";").append(1).append(";").append(2).append(";").append(false).append("\n");
        stringBuilderRooms.append(24).append(";").append(3).append(";").append(1).append(";").append(false).append("\n");
        stringBuilderRooms.append(25).append(";").append(3).append(";").append(2).append(";").append(false).append("\n");
        stringBuilderRooms.append(26).append(";").append(4).append(";").append(4).append(";").append(false).append("\n");
        stringBuilderRooms.append(27).append(";").append(5).append(";").append(4).append(";").append(false).append("\n");
        stringBuilderRooms.append(28).append(";").append(2).append(";").append(2).append(";").append(false).append("\n");
        stringBuilderRooms.append(29).append(";").append(4).append(";").append(3).append(";").append(false).append("\n");
        stringBuilderRooms.append(30).append(";").append(3).append(";").append(2).append(";").append(false).append("\n");
        stringBuilderRooms.append(31).append(";").append(4).append(";").append(2).append(";").append(false).append("\n");
    }

    public void csvRoom(){
        f = new File("C:\\Users\\59013-36-07\\IdeaProjects\\Hotel_Management\\src\\main\\java\\csv\\Rooms.csv");

        if (!f.exists()) {
            try (FileWriter fileWriter = new FileWriter("C:\\Users\\59013-36-07\\IdeaProjects\\Hotel_Management\\src\\main\\java\\csv\\Rooms.csv")) {
                fileWriter.write(stringBuilderRooms.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
