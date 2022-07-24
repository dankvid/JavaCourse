import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizFragen extends JFrame {

    static QuizFragen fenster;


    int count = 0;
    int ergebnis = 0;

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JLabel label = new JLabel();

    JButton b1 = new JButton();
    JButton b2 = new JButton();

    JButton b3 = new JButton();

    public static void main(String[] args) {
        fenster = new QuizFragen("David's Quiz");
        fenster.pack();
        fenster.setSize(400,150);
        fenster.setResizable(false);
        fenster.setVisible(true);
    }

    QuizFragen(String titel)  {
        super(titel);

        setLayout(new BorderLayout());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel1.add("Center",label);

        panel2.setLayout(new FlowLayout());
        panel2.add(b1);
        panel2.add(b2);

        b1.setText("Richtig");
        b2.setText("Falsch");

        add("Center", panel1);
        add("South", panel2);

        String[] fragen = new String[10]; // 10 Fragen
        fragen[0] = "Bismarck wurde 1971 Reichskanzler"; // Richtig
        fragen[1] = "Flächenmäßig ist Kanada das 2. Größte Land der Erde"; // Richtig
        fragen[2] = "Der Alligator hat im Tierreich die stärkste Beißkraft."; // Falsch
        fragen[3] = "In 100 Gramm Bananen stecken 8 Gramm Zucker."; // Falsch
        fragen[4] = "Die Bahamas liegen näher an Florida als Jamaika."; // Richtig
        fragen[5] = "Leonardo DiCaprio heißt mit zweitem Vornamen Wilhelm. "; // Richtig
        fragen[6] = "Hamburg hat ca. 2.500 Brücken."; // Richtig
        fragen[7] = "Bis zu 3.000 Menschen erkranken jährlich an der Pest."; // Richtig
        fragen[8] = "Champagner kommt immer aus Champagne im nordöstlichen Frankreich."; // Richtig
        fragen[9] = "";

        JOptionPane.showMessageDialog(fenster, "Willkommen zu David's Quiz \n Die besten Quizfragen vom Experten!");

        label.setText("Drücken Sie auf eine Schaltfläche um das Quiz zu starten");

        class Lauscher implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String antwort;
                label.setText(fragen[count]);

                antwort = e.getActionCommand();

                if (antwort.equals("Richtig") && count != -1) {
                    if (count != 3 && count != 4) {
                        ergebnis++;
                        //b1.setBackground(Color.GREEN);
                    }
                    else {
                        //b1.setBackground(Color.RED);
                    }
                    count++;
                }
                if (antwort.equals("Falsch") && count != -1) {
                    if (count == 3 || count == 4) {
                        ergebnis++;
                        //b2.setBackground(Color.GREEN);
                    }
                    else {
                        //b2.setBackground(Color.RED);
                    }
                    count++;
                }

                if (count == 10) {
                    label.setText("Auswertung");

                    b3.setText("Ok");

                    double loesung = (((double)fenster.ergebnis)/10) * 100;

                    JOptionPane.showMessageDialog(fenster, "Sie haben " + loesung + "% der Antworten richtig");

                    System.exit(0);
                }
            }
        }
        b1.addActionListener(new Lauscher());
        b2.addActionListener(new Lauscher());
        b3.addActionListener(new Lauscher());
    }
}
