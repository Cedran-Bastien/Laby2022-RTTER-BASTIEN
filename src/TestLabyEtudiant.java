import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestLabyEtudiant {

    /**
     * Test du constructeur de la classe Labyrinthe
     * @throws FichierIncorrectException
     * @throws IOException
     */
    @Test
    public void test_constructeur() throws FichierIncorrectException, IOException {
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        boolean[][] mur = new boolean[5][7];
        mur[0] = new boolean[]{true,true,true,true,true,true,true};
        mur[1] = new boolean[]{true,false,false,false,false,false,true};
        mur[2] = new boolean[]{true,false,false,false,false,false,true};
        mur[3] = new boolean[]{true,false,false,false,false,false,true};
        mur[4] = new boolean[]{true,true,true,true,true,true,true};
        Sortie s = new Sortie(1,1);
        Personnage p = new Personnage(2,3);
        Labyrinthe l2 = new Labyrinthe(mur,p,s);

        //vérfication de la bonne construction du mur
        for (int i = 0 ; i < 5 ; i++){
            for (int j = 0 ; j < 7 ; j++){
                assertEquals(l2.getChar(i,j),l.getChar(i,j),"le mur doit être bien construit");
            }
        }
        //verification des coordonnées du personnage et de la sortie
        assertEquals(p.getX(),l.getPersonnage().getX(),"Le labyrinthe a la bonne coordonnée X pour le personnage ");
        assertEquals(s.getX(),l.getSortie().getX(),"Le labyrinthe a la bonne coordonnée X pour la sortie");
        assertEquals(p.getY(),l.getPersonnage().getY(),"Le labyrinthe a la bonne coordonnée X pour le personnage");
        assertEquals(s.getY(),l.getSortie().getY(),"Le labyrinthe a la bonne coordonnée X pour la sortie");

    }

    /**
     * Test de la methode getChar
     * @throws FichierIncorrectException
     * @throws IOException
     */
    @Test
    public void test_methode_getChar() throws FichierIncorrectException, IOException {
        //on utilise le labyrinthe donné
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        //vérification de la methode getChar
        assertEquals('X',l.getChar(0,0));
        assertEquals('S',l.getChar(1,1));
        assertEquals('P',l.getChar(2,3));
        assertEquals('.',l.getChar(3,5));
    }

    /**
     * Test de la methode getSuivant
     * @throws FichierIncorrectException
     * @throws IOException
     */
    @Test
    public void test_methode_getSuivant() throws FichierIncorrectException, IOException {
        //On utlise la labyrinthe donné
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        int[] case1 = {1,3};
        int[] caseVoisine = Labyrinthe.getSuivant(l.getPersonnage().getX(),l.getPersonnage().getY(),Labyrinthe.HAUT);

        //vérification des coordonnée de la case suivante d'en haut
        assertEquals(case1[0],caseVoisine[0],"la coordonnée X de la case suivante devrait être la bonne");
        assertEquals(case1[1],caseVoisine[1],"la coordonnée Y de la case suivante devrait être la bonne");

        case1 = new int[]{2,4};
        caseVoisine = Labyrinthe.getSuivant(l.getPersonnage().getX(),l.getPersonnage().getY(),Labyrinthe.DROITE);
        //vérification des coordonnée de la case suivante d'en haut
        assertEquals(case1[0],caseVoisine[0],"la coordonnée X de la case suivante devrait être la bonne");
        assertEquals(case1[1],caseVoisine[1],"la coordonnée Y de la case suivante devrait être la bonne");

        case1 = new int[]{3,3};
        caseVoisine = Labyrinthe.getSuivant(l.getPersonnage().getX(),l.getPersonnage().getY(),Labyrinthe.BAS);
        //vérification des coordonnée de la case suivante d'en haut
        assertEquals(case1[0],caseVoisine[0],"la coordonnée X de la case suivante devrait être la bonne");
        assertEquals(case1[1],caseVoisine[1],"la coordonnée Y de la case suivante devrait être la bonne");

        case1 = new int[]{2,2};
        caseVoisine = Labyrinthe.getSuivant(l.getPersonnage().getX(),l.getPersonnage().getY(),Labyrinthe.GAUCHE);
        //vérification des coordonnée de la case suivante d'en haut
        assertEquals(case1[0],caseVoisine[0],"la coordonnée X de la case suivante devrait être la bonne");
        assertEquals(case1[1],caseVoisine[1],"la coordonnée Y de la case suivante devrait être la bonne");
    }

    /**
     * Test de la methode deplacerPerso
     * @throws FichierIncorrectException
     * @throws IOException
     * @throws ActionInconnueException
     */
    @Test
    public void test_methode_deplacerPerso() throws FichierIncorrectException, IOException, ActionInconnueException {
        //On utilise le labyrinthe donné
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        //vérification du déplacement correct du joueur
        //on déplace le joueur en haut
        int[] case1 = {1,3};
        Labyrinthe lH = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        lH.deplacerPerso(Labyrinthe.HAUT);
        int[] deplacement = {lH.getPersonnage().getX(),lH.getPersonnage().getY()};
        assertEquals(case1[0],deplacement[0],"la coordonnée X du joueur est bien placé");
        assertEquals(case1[1],deplacement[1],"la coordonnée Y du joueur est bien placé");

        //on déplace le joueur à droite
        case1 = new int[]{2,5};
        Labyrinthe lD = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        lD.deplacerPerso(Labyrinthe.DROITE);
        deplacement = new int[]{lD.getPersonnage().getX(),lD.getPersonnage().getY()};
        assertEquals(case1[0],deplacement[0],"la coordonnée X du joueur est bien placé");
        assertEquals(case1[1],deplacement[1],"la coordonnée Y du joueur est bien placé");

        //on déplace le joueur en bas
        case1 = new int[]{3,3};
        Labyrinthe lB = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        lB.deplacerPerso(Labyrinthe.BAS);
        deplacement = new int[]{lB.getPersonnage().getX(),lB.getPersonnage().getY()};
        assertEquals(case1[0],deplacement[0],"la coordonnée X du joueur est bien placé");
        assertEquals(case1[1],deplacement[1],"la coordonnée Y du joueur est bien placé");

        //on déplace le joueur à gauche
        case1 = new int[]{2,1};
        Labyrinthe lG = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        lG.deplacerPerso(Labyrinthe.GAUCHE);
        deplacement = new int[]{lG.getPersonnage().getX(),lG.getPersonnage().getY()};
        assertEquals(case1[0],deplacement[0],"la coordonnée X du joueur est bien placé");
        assertEquals(case1[1],deplacement[1],"la coordonnée Y du joueur est bien placé");

        // verifie leve une ActionInconnueException
        ActionInconnueException exception = assertThrows(
                ActionInconnueException.class,
                () -> {l.deplacerPerso("ACTION");}
        );
    }

    /**
     * Test de la methode toString
     * @throws FichierIncorrectException
     * @throws IOException
     */
    @Test
    public void test_methode_toString() throws FichierIncorrectException, IOException {
        //on utilise le labyrinthe donné
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        String structLaby = "XXXXXXX\n"+"XS....X\n"+"X..P..X\n"+"X.....X\n"+"XXXXXXX\n";

        //vérification du bon affichage du labyrinthe
        assertEquals(structLaby,l.toString(),"La structure du labyrinthe doit être coorectement affichée");
    }

    /**
     * Test de la methode etreFini
     * @throws FichierIncorrectException
     * @throws IOException
     * @throws ActionInconnueException
     */
    @Test
    public void test_methode_etreFini() throws FichierIncorrectException, IOException, ActionInconnueException {
        //on utilise le labyrinthe donné
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");
        l.deplacerPerso(Labyrinthe.HAUT);
        l.deplacerPerso(Labyrinthe.GAUCHE);

        //vérification que le labyrinthe soit bien fini
        assertTrue(l.etreFini(),"Le labyrinthe doit etre fini");

        //verification que le labyrinthe ne soit pas fini
        l.deplacerPerso(Labyrinthe.BAS);
        assertFalse(l.etreFini(),"Le labyrinthe ne doit pas etre fini");
    }

    /**
     * test de chargement du fichier laby0.txt
     * @throws Exception
     */
    @Test
    public void test_charger_laby0() throws Exception {
        // utilise laby0.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        // verifie labyrinthe
        assertEquals(l.getChar(0, 0), Labyrinthe.MUR);
        assertEquals(l.getChar(1, 1), Labyrinthe.SORTIE);
        assertEquals(l.getChar(2, 3), Labyrinthe.PJ);
        assertEquals(l.getChar(2, 1), Labyrinthe.VIDE);
    }

    /**
     * test de chargement du fichier laby1.txt
     * @throws Exception
     */
    @Test
    public void test_charger_laby1() throws Exception {
        // utilise laby1.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby1.txt");

        // verifie labyrinthe
        assertEquals(l.getChar(0, 0), Labyrinthe.MUR);
        assertEquals(l.getChar(2, 3), Labyrinthe.SORTIE);
        assertEquals(l.getChar(5, 5), Labyrinthe.PJ);
        assertEquals(l.getChar(2, 1), Labyrinthe.VIDE);
    }

    /**
     * test de chargement du fichier laby2.txt
     * @throws Exception
     */
    @Test
    public void test_charger_laby2() throws Exception {
        // utilise laby2.txt fourni
        Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby2.txt");

        // verifie labyrinthe
        assertEquals(l.getChar(0, 0), Labyrinthe.MUR);
        assertEquals(l.getChar(4, 17), Labyrinthe.SORTIE);
        assertEquals(l.getChar(12, 17), Labyrinthe.PJ);
        assertEquals(l.getChar(1, 2), Labyrinthe.VIDE);
    }

    /**
     * test de lever d'exception quand il y a deux sorties ou plus
     */
    @Test
    public void test_charger_laby_deuxSortie(){
        // verifie leve une FichierInccorectException
        FichierIncorrectException exception = assertThrows(
                FichierIncorrectException.class,
                () -> {Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby_deuxSortie.txt");}
        );
    }

    /**
     * test de lever d'exception quand le fichier ne contient pas de sortie
     */
    @Test
    public void test_charger_laby_pasSortie(){
        // verifie leve une FichierInccorectException
        FichierIncorrectException exception = assertThrows(
                FichierIncorrectException.class,
                () -> {Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby_pasSortie.txt");}
        );
    }

    /**
     * test de lever d'exception quand le fichier contient deux joueurs
     */
    @Test
    public void test_charger_laby_deuxJoueurs(){
        // verifie leve une FichierInccorectException
        FichierIncorrectException exception = assertThrows(
                FichierIncorrectException.class,
                () -> {Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby1_deuxJoueur.txt");}
        );
    }

    /**
     * test de lever d'exception quand le fichier ne contient pas de joueur
     */
    @Test
    public void test_charger_laby_pasJoueur(){
        // verifie leve une FichierInccorectException
        FichierIncorrectException exception = assertThrows(
                FichierIncorrectException.class,
                () -> {Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby0_pasJoueur.txt");}
        );
    }

}
