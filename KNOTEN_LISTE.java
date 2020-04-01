import java.util.*;
public class KNOTEN_LISTE
{
    private ArrayList<KANTE_ZU> kanten;
    // Attribute- ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private DATENELEMENT daten;
    //Markierung für Tiefensuche
    private boolean markierung;

    /**
     * Konstruktor für Objekte der Klasse KNOTEN
     */
    KNOTEN_LISTE(DATENELEMENT daten)
    {
        this.daten = daten;
    }

    public DATENELEMENT DatenGeben()
    {
        return daten;
    }
    
    public void KanteHinzufügen(KANTE_ZU kante) {
        kanten.add(kante);
    }
    
    public void KanteLöschen(KANTE_ZU kante) {
        kanten.remove(kante);
    }

    public void MarkierungSetzen(boolean set){
        markierung=set;
    }

    public boolean MarkierungGeben(){
        return markierung;
    }
    
    public ArrayList<KANTE_ZU> KantenGeben() {
        return kanten;
    }
}
