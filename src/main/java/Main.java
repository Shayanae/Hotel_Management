import beans.Descript;
import beans.Prix;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Prix prix = new Prix();
        Descript descript = new Descript();

        int nbPers;
        int category;
        int price;

        System.out.println("Entrez le nombre de personne");
        nbPers = sc.nextInt() - 1;
        System.out.println("Entrez le numéro de la catégorie voulue");
        category = sc.nextInt() - 1;
        price = prix.displayPrice(nbPers, category);
        if (price!=0){
            System.out.println("Le prix de la chambre est " + price + " €");
            System.out.println("Contenue de la chambre: " + descript.display(category));
        }else {
            System.out.println("Il n'y a pas de chambre correspondant à votre demande.");
        }
    }
}
