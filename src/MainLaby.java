import java.io.IOException;
import java.util.Scanner;

public class MainLaby {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean labycharger = false;
        Labyrinthe laby = null;
        while (!labycharger) {
            try {
                laby = Labyrinthe.chargerLabyrinthe(args[0]);
                labycharger = true;
            } catch (IOException io) {
                io.printStackTrace();
                System.out.println("veulliez rentrer un nom de ficher existant: ");
                args[0] = sc.next();
            }
        }
        System.out.println(laby);
        System.out.println("veuillez entrer l'action voulu du personnage en respectant les majuscules (\"HAUT\",\"BAS\",\"DROITE\" ou \"GAUCHE\") :");
        String action = sc.next();
        while (action != "exit") {
            boolean actionexistante = false;
            while (!actionexistante) {
                try {
                    laby.deplacerPerso(action);
                    actionexistante = true;
                } catch (ActionInconnueException a) {
                    a.printStackTrace();
                    System.out.println("veuillez entrer une action valide, existante, en respectant les majuscules (\"HAUT\",\"BAS\",\"DROITE\" ou \"GAUCHE\") :");
                    action = sc.next();
                }
            }
            System.out.println(laby);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("veuillez entrer l'action voulu du personnage en respectant les majuscules (\"HAUT\",\"BAS\",\"DROITE\" ou \"GAUCHE\") :");
                action = sc.next();
            }


        }
    }
}