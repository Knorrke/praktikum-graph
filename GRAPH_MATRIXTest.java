
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Die Test-Klasse GRAPH_MATRIXTest.
 *
 * @author  (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class GRAPH_MATRIXTest
{
    GRAPH_MATRIX testGraph;

    /**
     * Konstruktor fuer die Test-Klasse GRAPH_MATRIXTest
     */
    public GRAPH_MATRIXTest()
    {
    }

    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @Before
    public void setUp()
    {
        KNOTEN[] knotenfeld = {new KNOTEN(new ORTSCHAFT("Altdorf")),new KNOTEN(new ORTSCHAFT("Fischbach")),
                new KNOTEN(new ORTSCHAFT("Weiler")),new KNOTEN(new ORTSCHAFT("Ziegelstein")),
                new KNOTEN(new ORTSCHAFT("Burg")),new KNOTEN(new ORTSCHAFT("Neustadt")),new KNOTEN(new ORTSCHAFT("Rain"))}; 
        int[][] adjazenzmatrix = {  { 0, 20, 15, -1, -1, -1, -1},
                {10,  0, 10, -1, -1, -1, -1},
                {-1, 25 , 0,  5, -1, -1, -1},
                {-1, 15, -1,  0, 20, 15, -1},
                {-1, 15, -1,  5,  0, -1, -1},
                {-1, -1, -1, -1, -1,  0, 20},
                {-1, -1, -1, -1, 25, -1,  0}};
        testGraph= new GRAPH_MATRIX(knotenfeld, adjazenzmatrix);
    }

    @Test
    public void testTiefensuche(){
        System.out.println("Tiefensuche:");
        testGraph.tiefensucheStarten(0);
        System.out.println("______________");
    }

    @Test
    public void testKnotenHinzufuegen(){
        GRAPH_MATRIX testGraphNeu= new GRAPH_MATRIX(1);
        ORTSCHAFT testOrt = new ORTSCHAFT("München");
        testGraphNeu.KnotenHinzufuegen(testOrt);
        System.out.println("Knoten hinzufügen");
        testGraphNeu.KnotenAusgeben();
        System.out.println("_______________");
    }

    @Test
    public void testKantenHinzufuegen(){
        GRAPH_MATRIX testGraphNeu= new GRAPH_MATRIX(2);
        ORTSCHAFT testOrt = new ORTSCHAFT("München");
        ORTSCHAFT testOrt2= new ORTSCHAFT("Berlin");
        testGraphNeu.KnotenHinzufuegen(testOrt);
        testGraphNeu.KnotenHinzufuegen(testOrt2);
        testGraphNeu.KanteHinzufuegen(0 , 1, 15);
        System.out.println("Kante hinzufügen");
        testGraphNeu.MatrixAusgeben();
        System.out.println("_______________");
    }

    @After
    public void tearDown()
    {
    }
}
