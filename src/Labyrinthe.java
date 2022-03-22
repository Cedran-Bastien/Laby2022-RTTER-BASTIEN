import javax.swing.*;


/**
 * Squelette de classe labyrinthe
 */
class Labyrinthe{

    private boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;
    public static final char MUR='X',PJ='P',SORTIE='S',VIDE='.';
    public static final String BAS="bas",HAUT="haut",GAUCHE="gauche",DROITE="droite";

    /**
     * Methode getChar
     *      retourne l'objet(mur X, personnage P, sortie S et case vide .) present a la position donner en parametre(x,y)
     * @param x
     * @param y
     * @return le type de l'objet à la position (x,y)
     */
    char getChar(int x, int y) {
        char c=' ';
        switch (murs[x][y]) {
            case (true):
                c=MUR;//la position est un mur
            case (false):
                if (personnage.getX==x && personnage.getY==y) {
                    c = PJ;
                }
                else if (sortie.getX==x && personnage.getY==y){
                    c = SORTIE;
                }else {
                    c = VIDE;
                }
        }
        return c;
    }


    static int[] getSuivant(int x, int y, String action) {
        throw new Error("TODO");
    }


    void deplacerPerso(String action) throws ActionInconnueException {
        throw new Error("TODO");
    }


    public String toString() {
        throw new Error("TODO");
    }


    public boolean etreFini() {
        throw new Error("TODO");
    }

    public static Labyrinthe chargerLabyrinthe(String nom) {
        throw new Error("TODO");
    }

}
