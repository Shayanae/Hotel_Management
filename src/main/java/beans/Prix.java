package beans;

public class Prix {
    int[][] tabPrix = {
            {100, 120, 130, 150, 0, 0},
            {130, 160, 170, 190, 0, 0},
            {170, 200, 210, 230, 270, 350},
            {200, 230, 240, 260, 300, 400}
    };
    public int displayPrice(int nbPeople, int nbCategory){
        return tabPrix[nbPeople][nbCategory];
    }
}
