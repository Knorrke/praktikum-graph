import java.util.*;

public class GRAPH_LISTE
{
    // Attribute- ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private ArrayList<KNOTEN_LISTE> knotenfeld;

    GRAPH_LISTE(int maxAnzahlKnoten)
    {
        knotenfeld = new ArrayList<>();
    }

    public void KnotenHinzufuegen(DATENELEMENT inhalt)
    {   
        knotenfeld.add(new KNOTEN_LISTE(inhalt));
    }

    public void KanteHinzufuegen(KNOTEN_LISTE start, KNOTEN_LISTE ziel, int bewertung)
    {
        start.KanteHinzufügen(new KANTE_ZU(ziel, bewertung));
    }

    public void KnotenLoeschen(KNOTEN_LISTE knoten)
    {
        knotenfeld.remove(knoten);
    }

    public void KnotenAusgeben()
    {
        for(int i=0; i<knotenfeld.size(); i++) {
            System.out.printf("[%d]: %s%n", i, knotenfeld.get(i).DatenGeben().BezeichnerGeben());
        }
    }

    public void ListeAusgeben()
    {
        for (KNOTEN_LISTE knoten : knotenfeld) {
            System.out.print(knoten.DatenGeben().BezeichnerGeben() + ": ");
            for (KANTE_ZU kante : knoten.KantenGeben()) {
                System.out.printf(" %s(%d),", kante.ziel.DatenGeben().BezeichnerGeben(), kante.gewicht);
            }
            System.out.println("");
        }
    }

    public void tiefensucheStarten(int startKnotenNr)
    {
        for(KNOTEN_LISTE knoten: knotenfeld){
            knoten.MarkierungSetzen(false);
        }
        if(startKnotenNr>=0 && startKnotenNr < knotenfeld.size()){
            tiefensucheDurchfuehren(knotenfeld.get(startKnotenNr));
        }
        else{
            System.out.println("Knoten mit dieser Nummer ist nicht vorhanden");
        }
    }

    private void tiefensucheDurchfuehren(KNOTEN_LISTE knoten)
    {
        knoten.MarkierungSetzen(true);
        System.out.println("Aktuell besucht: "+ knoten.DatenGeben().BezeichnerGeben());
        for(KANTE_ZU kante: knoten.KantenGeben()){
            if(!(kante.ziel.MarkierungGeben())){
                tiefensucheDurchfuehren(kante.ziel);
            }
        }
    }
}
