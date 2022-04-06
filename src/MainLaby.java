import java.io.IOException;
import java.util.Scanner;

public class MainLaby {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean labycharger = false;
        Labyrinthe laby = null;
        String labyOK = "OK";
        while (!labycharger) {
            try {
                laby = Labyrinthe.chargerLabyrinthe(args[0]);
                labycharger = true;
            } catch (FichierIncorrectException f) {
                labyOK = f.getMessage();
                labycharger = true;
            } catch (IOException io) {
                io.printStackTrace();
                System.out.println("veulliez rentrer un nom de ficher existant: ");
                args[0] = sc.next();
            }
        }
        if (!labyOK.equals(new FichierIncorrectException().getMessage())) {
            System.out.println(laby);
            System.out.println("veuillez entrer l'action voulu du personnage en respectant les minuscules (\"haut\",\"bas\",\"droite\" ou \"gauche\") :");
            String action = sc.next();
            while (!action.equals("exit") && !laby.etreFini()) {
                boolean actionexistante = false;
                while (!actionexistante) {
                    try {
                        laby.deplacerPerso(action);
                        actionexistante = true;
                    } catch (ActionInconnueException a) {
                        a.printStackTrace();
                        System.out.println("veuillez entrer une action valide, existante, en respectant les minuscules (\"haut\",\"bas\",\"droite\" ou \"gauche\") :");
                        action = sc.next();
                    }
                    boolean o = !action.equals("exit") && !laby.etreFini();
                    boolean labyeee = !laby.etreFini();
                    boolean exit = !action.equals("exit");
                }
                System.out.println(laby);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("veuillez entrer l'action voulu du personnage en respectant les majuscules (\"HAUT\",\"BAS\",\"DROITE\" ou \"GAUCHE\") :");
                    action = sc.next();
                }
                if (!action.equals("exit") && !laby.etreFini()) {
                    System.out.println("veuillez entrer une action valide, existante, en respectant les minuscules (\"haut\",\"bas\",\"droite\" ou \"gauche\") :");
                    action = sc.next();
                } else if (action.equals("exit")) {
                    System.out.println("jeu arrété par le joueur");
                } else if (laby.etreFini()) {
                    System.out.println("BRAVO! VOUS AVEZ FINI LE LABYRINTHE");
                }
            }
        }else {
            System.out.println("Fichier mal construit");
        }
    }
}