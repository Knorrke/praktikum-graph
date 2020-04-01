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
        anzahlKnoten = maxAnzahlKnoten;
        knotenfeld = new KNOTEN[maxAnzahlKnoten];
        adjazenzmatrix = new int[maxAnzahlKnoten][maxAnzahlKnoten];
        
        for(int i=0; i < maxAnzahlKnoten; i++)
        {
            for(int j=0; j < maxAnzahlKnoten; j++)
            {
               if(j==i)
               {
                   adjazenzmatrix[i][j] = 0;
               }
               else
               {
                   adjazenzmatrix[i][j] = -1;
               }
            }
            
        }
    }

    GRAPH_MATRIX(KNOTEN[] initKnotenfeld, int[][] initAdjazenzmatrix){
        anzahlKnoten= initKnotenfeld.length;
        knotenfeld= initKnotenfeld;
        adjazenzmatrix = initAdjazenzmatrix;
    } 

    public void KnotenHinzufuegen(DATENELEMENT inhalt)
    {
        //TODO
    }

    public void KanteHinzufuegen(int start, int ziel, int bewertung)
    {
        //TODO
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
