package beans;

public class Hotel {
    private Room[] rooms = new Room[31];

    public Hotel(){
        rooms[0] = new Room(1, 1, 1); rooms[1] = new Room(2, 2, 1);
        rooms[2] = new Room(3, 3, 1); rooms[3] = new Room(4, 4, 1);
        rooms[4] = new Room(5, 1, 2); rooms[5] = new Room(6, 2, 2);
        rooms[6] = new Room(7, 3, 2); rooms[7] = new Room(8, 4, 2);
        rooms[8] = new Room(9, 1, 3); rooms[9] = new Room(10, 2, 3);
        rooms[10] = new Room(11, 3, 3); rooms[11] = new Room(12, 4, 3);
        rooms[12] = new Room(13, 5, 3); rooms[13] = new Room(14, 6, 3);
        rooms[14] = new Room(15, 1, 4); rooms[15] = new Room(16, 2, 4);
        rooms[16] = new Room(17, 3, 4); rooms[17] = new Room(18, 4, 4);
        rooms[18] = new Room(19, 5, 4); rooms[19] = new Room(20, 6, 4);
        rooms[20] = new Room(21, 1, 1); rooms[21] = new Room(22, 2, 2);
        rooms[22] = new Room(23, 1, 2); rooms[23] = new Room(24, 3, 1);
        rooms[24] = new Room(25, 3, 2); rooms[25] = new Room(26, 4, 4);
        rooms[26] = new Room(27, 5, 4); rooms[27] = new Room(28, 2, 2);
        rooms[28] = new Room(29, 4, 3); rooms[29] = new Room(30, 3, 2);
        rooms[30] = new Room(31, 4, 2);
    }

    public void roomDisplay(int nbPeople){
        for (Room room: rooms){
            if (nbPeople == room.getNbPeople() && !room.isTaken()){
                System.out.println(room);
                System.out.println();
            }
        }
    }

    public void roomRelease(int roomNumber){
        int i = 0;
        boolean flag = false;

        while (i < rooms.length && !flag){
            if (roomNumber == rooms[i].getNumber() && rooms[i].isTaken()){
                rooms[i].setTaken(false);
            } else if (roomNumber == rooms[i].getNumber() && !rooms[i].isTaken()) {
                System.out.println("Cette chambre est déjà vide.");
            }
            i++;
        }
    }

    public void takingRoom(int roomNumber){
        int i = 0;
        boolean flag = false;

        while (i < rooms.length && !flag){
            if (roomNumber == rooms[i].getNumber() && !rooms[i].isTaken()){
                rooms[i].setTaken(true);
                flag = true;
            } else if (roomNumber == rooms[i].getNumber() && rooms[i].isTaken()) {
                System.out.println("Cette chambre est déjà prise.");
            }
            i++;
        }
    }
}
