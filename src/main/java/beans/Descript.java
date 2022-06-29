package beans;

public class Descript {
    String[] tabDescript = {"Lavabo", "WC, Télévision", "Cabine Douche, Télévision", "WC, Cabine Douche, Télévison",
            "WC, Salle de bain + Douche, Télévision", "2 pièces, Salle de bain + douche, WC, Télévision"};
    public String display(int category){
        return tabDescript[category];
    }
}
