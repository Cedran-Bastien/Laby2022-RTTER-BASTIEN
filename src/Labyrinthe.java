import javax.lang.model.util.ElementScanner6;
import javax.swing.*;
import java.awt.desktop.AboutEvent;
import java.io.*;
import java.util.PropertyPermission;


/**
 * Squelette de classe labyrinthe
 */
class Labyrinthe {

    private boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;
    public static final char MUR = 'X', PJ = 'P', SORTIE = 'S', VIDE = '.';
    public static final String BAS = "bas", HAUT = "haut", GAUCHE = "gauche", DROITE = "droite";



    public Labyrinthe(boolean[][] mur, Personnage per, Sortie sort){
        this.murs=mur;
        this.personnage= per;
        this.sortie=sort;
    }
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


        if (murs[x][y]) {
            //la position est un mur
            c = MUR;
        } else {
            if (personnage.getX() == x && personnage.getY() == y) {
                c = PJ;
            } else if (sortie.getX() == x && personnage.getY() == y) {
                c = SORTIE;
            } else {
                c = VIDE;
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
        int[] positionsuiv = getSuivant(personnage.getX(), personnage.getY(), action);
        while (getChar(positionsuiv[0],positionsuiv[1]) != 'X') {
            nouvEmpladement = positionsuiv;
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
        return (personnage.getX() == sortie.getX() && personnage.getY() == sortie.getY());
    }

    /**
     * METHODE A FAIRE
     *
     * @param nom
     * @return
     */
    public static Labyrinthe chargerLabyrinthe(String nom) throws IOException {
        FileReader fichierLaby = new FileReader(nom);
        BufferedReader bf = new BufferedReader(fichierLaby);
        int nbligne=0;
        int nbcolone=0;
        for (int i= 1; i<3;i++){
            nbcolone = Integer.parseInt(bf.readLine());
            if (i==1){
                nbligne = nbcolone;
            }
        }
        boolean[][] posmurs = new boolean[nbcolone][nbligne];
        nbligne=0;
        nbcolone=0;
        boolean r = true;
        Personnage pos = null;
        Sortie s = null;
        while (r){
            try {
                while (true){
                    int c=fichierLaby.read();
                    if (MUR==c){
                        posmurs[nbligne][nbcolone]=true;
                    }else if (SORTIE==c){
                        posmurs[nbligne][nbcolone]=false;
                        s = new Sortie(nbligne,nbcolone);
                    }
                    else if (PJ==c){
                        pos = new Personnage(nbligne,nbcolone);
                        posmurs[nbligne][nbcolone]=false;
                    }
                    nbcolone+=1;
                }
            }
            catch (ArrayIndexOutOfBoundsException a){
                nbligne+=1;
            }
            catch (EOFException eof){
                r=false;
            }

        }
        Labyrinthe labi =new Labyrinthe(posmurs,pos, s);
        return (labi);


    }

}
