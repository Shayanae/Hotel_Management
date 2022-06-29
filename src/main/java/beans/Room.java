package beans;

public class Room {
    private int number, category, nbPeople;
    private boolean taken;

    public Room (int number, int category, int nbPeople){
        this.number = number;
        this.category = category;
        this.nbPeople = nbPeople;
        this.taken = false;
    }

    public int getNumber(){return number;}
    public int getCategory(){return category;}
    public int getNbPeople(){return nbPeople;}
    public boolean isTaken(){return taken;}

    public void setTaken(boolean taken){this.taken = taken;}
    public int takePrice(int nbPeople, int nbCategory){
        int[][] tabPrix = {
                {100, 120, 130, 150, 0, 0},
                {130, 160, 170, 190, 0, 0},
                {170, 200, 210, 230, 270, 350},
                {200, 230, 240, 260, 300, 400}
        };
        return tabPrix[nbPeople][nbCategory];
    }
    public String takeDescript(int category){
        String[] tabDescript = {"Lavabo", "WC, Télévision", "Cabine Douche, Télévision", "WC, Cabine Douche, Télévison",
                "WC, Salle de bain + Douche, Télévision", "2 pièces, Salle de bain + douche, WC, Télévision"};
        return tabDescript[category];
    }

    @Override
    public String toString() {
        return "Numéro de chamre: " + number + " Catégorie: " + category + " Description: " + takeDescript(category-1) +
                ". Prix :" + takePrice(nbPeople-1,category-1) + " €";
    }
}
