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
        anzahlKnoten = 0;
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

        // ungerichtet, da beide Richtungen in Adjazenzmatrix mit gleicher Gewichtung eingetragen werden
        adjazenzmatrix[start][ziel] = bewertung;
        adjazenzmatrix[ziel][start] = bewertung;
    }

    public void KanteLoeschen(int start, int ziel)
    {
        adjazenzmatrix[start][ziel] = -1;
        adjazenzmatrix[ziel][start] = -1;
    }

    public void KnotenLoeschen(int knotenIndex)
    {
        int i = anzahlKnoten;
        if (knotenfeld[knotenIndex] != null){
            knotenfeld[knotenIndex] = null;
            anzahlKnoten--;
        }
        while (knotenIndex - anzahlKnoten > 0){
            knotenfeld[knotenIndex] = knotenfeld[knotenIndex-1];
            knotenIndex++;
        }
    }

    public void KnotenAusgeben()
    {
        for(int i=0; i<anzahlKnoten; i++) {
            System.out.printf("[%d]: %s%n", i, knotenfeld[i].DatenGeben().BezeichnerGeben());
        }
    }

    public void MatrixAusgeben()
    {
        String ortFormat = " %5.5s";
        System.out.printf(ortFormat,"");
        for (int i=0; i<anzahlKnoten; i++) {
            System.out.printf(ortFormat,knotenfeld[i].DatenGeben().BezeichnerGeben());
        }
        System.out.println("");
        for(int i=0; i<anzahlKnoten; i++) {
            System.out.printf(ortFormat, knotenfeld[i].DatenGeben().BezeichnerGeben());
            for (int j=0; j<anzahlKnoten; j++) {
                System.out.printf("%6d", adjazenzmatrix[i][j]);
            }
            System.out.println("");
        }
    }

    public void tiefensucheStarten(int startKnotenNr)
    {
        for(int i=0; i< anzahlKnoten; i++){
            knotenfeld[i].MarkierungSetzen(false);
        }
        if(startKnotenNr>=0 && startKnotenNr <anzahlKnoten){
            tiefensucheDurchfuehren(startKnotenNr);
        }
        else{
            System.out.println("Knoten mit dieser Nummer ist nicht vorhanden");
        }
    }

    private void tiefensucheDurchfuehren(int knotenNr)
    {
        knotenfeld[knotenNr].MarkierungSetzen(true);
        System.out.println("Aktuell besucht: "+ knotenfeld[knotenNr].DatenGeben().BezeichnerGeben());
        for(int i=0; i< anzahlKnoten; i++){
            if(adjazenzmatrix[knotenNr][i]>0 && !(knotenfeld[i].MarkierungGeben())){
                tiefensucheDurchfuehren(i);
            }
        }
    }
}
