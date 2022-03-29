import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Squelette de classe labyrinthe
 */
class Labyrinthe {

    private boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;
    public static final char MUR = 'X', PJ = 'P', SORTIE = 'S', VIDE = '.';
    public static final String BAS = "bas", HAUT = "haut", GAUCHE = "gauche", DROITE = "droite";

    /**
     * Methode getChar
     * retourne l'objet(mur X, personnage P, sortie S et case vide .) present a la position donner en parametre(x,y)
     *
     * @param x
     * @param y
     * @return le type de l'objet à la position (x,y)
     */
    char getChar(int x, int y) {
        char c = ' ';
        switch (murs[x][y]) {
            case (true):
                c = MUR;//la position est un mur
                break;
            case (false):
                if (personnage.getX == x && personnage.getY == y) {
                    c = PJ;
                } else if (sortie.getX == x && personnage.getY == y) {
                    if (personnage.getX() == x && personnage.getY() == y) {
                        c = PJ;
                    } else if (sortie.getX() == x && personnage.getY() == y) {
                        c = SORTIE;
                    } else {
                        c = VIDE;
                    }
                    break;
                }
        }
        return c;
    }

    /**
     * Methode getSuivant
     * retourne les coordonnées de la case voisine de la position donnée (x , y) selon la direction passée en paramètre ( String action ).
     *
     * @param x      coordonnée x donnée ( numéros des lignes )
     * @param y      coordonnée y donnée ( numéros des colonnes )
     * @param action direction donnée. Par exemple on veut la case à droite de celle à la position x,y (action=droite)
     * @return la position (x,y) de la case voisine dans la direction donnée.
     */
    public static int[] getSuivant(int x, int y, String action) {
        int[] voisine = new int[2];
        switch (action) {
            case (HAUT):
                voisine[0] = x - 1;
                voisine[1] = y;
                break;
            case (BAS):
                voisine[0] = x + 1;
                voisine[1] = y;
                break;
            case (DROITE):
                voisine[0] = x;
                voisine[1] = y + 1;
                break;
            case (GAUCHE):
                voisine[0] = x;
                voisine[1] = y - 1;
                break;
        }
        return voisine;
    }

    /**
     * Methode deplacerPerso
     * Ne retourne rien. Cette méthode modifie les coordonnées du personnage en fonction de l'action faite.
     * Le pesonnage glisse sur le sol et avance dans la direction passée en paramètre jusqu'au prochain mur rencontré.
     *
     * @param action choix de la direction vers laquelle se déplacer
     * @throws ActionInconnueException
     */
    void deplacerPerso(String action) throws ActionInconnueException {
        if (!action.equals(HAUT) && !action.equals(BAS) && !action.equals(DROITE) && !action.equals(GAUCHE)) {
            ActionInconnueException actionInconnueException = new ActionInconnueException();
            throw actionInconnueException;
        }
        int[] nouvEmpladement = new int[2];
        while (getChar(getSuivant(personnage.getX, personnage.getY, action)) != 'X') {
            nouvEmpladement = getSuivant(personnage.getX, personnage.getY, action);
        }
    }

    /**
     * Methode toString
     * retourne une chaîne de caractère écrivant l'état du labyrinthe. Donc affiche le labyrinthe en console.
     * l'affichage se fera à l'aide de getChar qui retourne le caractère d'une case. Ainsi l'affichage sera des caractères cote à cote
     *
     * @return la chaîne représentant le labyrinthe
     */
    public String toString() {
        String etatLabyrinthe = "";
        for (int x = 0; x < murs[0].length; x++) {
            for (int y = 0; y < murs[1].length; y++) {
                etatLabyrinthe += getChar(x, y);
            }
            etatLabyrinthe += "\n";
        }
        return etatLabyrinthe;
    }

    /**
     * Methode etreFini
     * retroune un boolean(true ou false) qui indique si le personnage est sur la sortie ou non.
     *
     * @return True si le personnage se situe sur la sortie, False sinon
     */
    public boolean etreFini() {
        boolean fin = false;
        if (personnage.getX == sortie.getX && personnage.getY = sortie.getY) {
            fin = true;
        }
        return fin;
    }

    /**
     * METHODE A FAIRE
     *
     * @param nom
     * @return
     */
    public static Labyrinthe chargerLabyrinthe(String nom) {
        FileReader fichierLaby = new FileReader(nom);
        throw new Error();
    }

}
