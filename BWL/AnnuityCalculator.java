
public class AnnuityCalculator {

	public static void main(String[] args) {
		// Annuitätsformel:
		// A = K * (i * (1 + i)^n) / ((1 + i)^n - 1)
		// A = Annuität, K = Kreditbetrag, i = Zinssatz pro Periode, n = Anzahl an Perioden

		double kreditbetrag = 10000;
		double zinssatz = 0.03;
		int anzahlPerioden = 10;

		double annuitaet = kreditbetrag * (zinssatz * Math.pow((1 + zinssatz), anzahlPerioden)) / (Math.pow((1 + zinssatz), anzahlPerioden) - 1);

		System.out.println("Die Annuität beträgt: " + annuitaet);
	}

}
