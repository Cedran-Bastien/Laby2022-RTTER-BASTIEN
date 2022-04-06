import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestLabyEtudiant {

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
