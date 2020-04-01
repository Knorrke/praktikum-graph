
public class KNOTEN
{
    // Attribute- ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private DATENELEMENT daten;
    //Markierung für Tiefensuche
    private boolean markierung;

    /**
     * Konstruktor für Objekte der Klasse KNOTEN
     */
    KNOTEN(DATENELEMENT daten)
    {
        this.daten = daten;
    }

    public DATENELEMENT DatenGeben()
    {
        return daten;
    }

    public void MarkierungSetzen(boolean set){
        markierung=set;
    }

    public boolean MarkierungGeben(){
        return markierung;
    }
}
