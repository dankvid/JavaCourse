public class Main
{

    public static void main(String[] args)
    {
	Brueche2 b1,b2;

    b1 = new Brueche2();
    b2 = new Brueche2();

    b1.zaehler = 27;
    b1.nenner = 12;
    b2.zaehler = 27;
    b2.nenner = 12;

    System.out.println("Objekt b1(Zähler): "+b1.zaehler);
    System.out.println("Objekt b1(Nenner): "+b1.nenner);
    b1.showGGT();
    b1.kuerzen();
    b1.showBruch();

    System.out.println("Objekt b2(Zähler): "+b2.zaehler);
    System.out.println("Objekt b2(Nenner): "+b2.nenner);
    b2.showGGT();
    b2.kuerzen();
    b2.showBruch();
    }
}
