
public class ORTSCHAFT implements DATENELEMENT
{
    // Attribute- ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String ortsname;

    /**
     * Konstruktor für Objekte der Klasse ORTSCHAFT
     */
    ORTSCHAFT(String ortsname)
    {
        // Instanzvariable initialisieren
        this.ortsname= ortsname;
    }

    public String BezeichnerGeben(){
        return ortsname;
    }

    public void Ausgeben(){
        System.out.println("Willkommen! Im Ort " + ortsname + ".");
    }

    public boolean IstGleich(DATENELEMENT vergleichsDaten){
        ORTSCHAFT vergleichsOrtschaft = (ORTSCHAFT) vergleichsDaten;
        if (ortsname.equals(vergleichsOrtschaft.BezeichnerGeben()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
