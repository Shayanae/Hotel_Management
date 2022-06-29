import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] tabPrix = {
                {100, 120, 130, 150, 0, 0},
                {130, 160, 170, 190, 0, 0},
                {170, 200, 210, 230, 270, 350},
                {200, 230, 240, 260, 300, 400}
        };
        String[] tabDescript = {"Lavabo", "WC, Télévision", "Cabine Douche, Télévision", "WC, Cabine Douche, Télévison",
                                "WC, Salle de bain + Douche, Télévision", "2 pièces, Salle de bain + douche, WC, Télévision"};
        int nbPers;
        int category;

        System.out.println("Entrez le nombre de personne");
        nbPers = sc.nextInt();
        System.out.println("Entrez le numéro de la catégorie voulue");
        category = sc.nextInt();
        if (tabPrix[nbPers-1][category-1]!=0){
            System.out.println("Le prix de la chambre est " + tabPrix[nbPers-1][category-1] + " €");
            System.out.println("Contenue de la chambre: " + tabDescript[category-1]);
        }else {
            System.out.println("Il n'y a pas de chambre correspondant à votre demande.");
        }
    }
}
