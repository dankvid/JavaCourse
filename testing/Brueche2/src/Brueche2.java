public class Brueche2
{
    // Attribute
    public double zaehler;
    public double nenner;
    // Methoden
    public void showGGT()
    {
        double rest, ggt;
        rest = zaehler%nenner;
        ggt = 1;
        while(rest != 0)
        {
            ggt = rest;
            rest = nenner%rest;
        }
        System.out.println("Der GGT beträgt: "+ggt);
    }
    public void kuerzen()
    {
        double rest, ggt, nennerk, zaehlerk;
        rest = zaehler%nenner;
        ggt = 1;
        while(rest != 0)
        {
            ggt = rest;
            rest = nenner%rest;
        }
        nennerk = nenner/ggt;
        zaehlerk = zaehler/ggt;
        System.out.println("Der gekürzte Bruch lautet "+zaehlerk+"/"+nennerk);
    }
    public void showBruch()
    {
        System.out.println("Der Bruch lautet: "+zaehler+"/"+nenner);
    }
}
