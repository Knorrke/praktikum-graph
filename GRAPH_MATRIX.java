public class GRAPH_MATRIX
{
    // Attribute- ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private KNOTEN[] knotenfeld;
    // Bei gewichteteten Graphen: -1 kein Weg, 0 Knoten selbst, sonst Distanz
    // Bei ungewichteten Graphen: -1 kein Weg, 1 Weg
    private int[][] adjazenzmatrix;
    private int anzahlKnoten;

    GRAPH_MATRIX(int maxAnzahlKnoten)
    {
        // Instanzvariable initialisieren

        //TODO
    }

    GRAPH_MATRIX(KNOTEN[] initKnotenfeld, int[][] initAdjazenzmatrix){
        anzahlKnoten= initKnotenfeld.length;
        knotenfeld= initKnotenfeld;
        adjazenzmatrix = initAdjazenzmatrix;
    } 

    public void KnotenHinzufuegen(DATENELEMENT inhalt)
    {   
        if (anzahlKnoten == knotenfeld.length) {
            System.err.println("Knoten konnte nicht hinzugefügt werden, da das Knotenfeld voll ist.");
            return;
        }
        knotenfeld[anzahlKnoten] = new KNOTEN(inhalt);
        // Entfernung zu sich selbst ist 0
        adjazenzmatrix[anzahlKnoten][anzahlKnoten] = 0;
        anzahlKnoten++;
    }

    public void KanteHinzufuegen(int start, int ziel, int bewertung)
    {
        if (start < 0 || ziel < 0 || start >= anzahlKnoten || ziel >=anzahlKnoten) {
            System.err.println("Kante konnte nicht hinzugefügt werden, da Knoten nicht existiert");
            return;
        }
        adjazenzmatrix[start][ziel] = bewertung;
    }

    public void KanteLoeschen(int start, int ziel)
    {
        //TODO
    }

    public void KnotenLoeschen(int knotenIndex)
    {
        //TODO
    }

    public void KnotenAusgeben()
    {
        //TODO
    }

    public void MatrixAusgeben()
    {
        //TODO
    }

    public void tiefensucheStarten(int startKnotenNr)
    {
        //TODO
    }

    private void tiefensucheDurchfuehren(int knotenNr)
    {
        //TODO
    }
}
