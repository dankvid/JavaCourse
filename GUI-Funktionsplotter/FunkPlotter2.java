import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FunkPlotter2 extends JFrame {
    Leinwand m_malflaeche;
    int aktFunktion = 0;

    public static void main(String[] args) {
        FunkPlotter2 fenster = new FunkPlotter2("David's Funktionsplotter");
        fenster.pack();
        fenster.setSize(450,450);
        fenster.setResizable(false);
        fenster.setVisible(true);
    }

    // Im Konstruktor werden die Malfläche und
    // Schaltflächen zur Auswahl der Funktionen angelegt
    FunkPlotter2(String titel) {
        super(titel);

        // Einen Layout-Manager einrichten
        setLayout(new FlowLayout());

        // Die Malfläche aufnehmen
        m_malflaeche = new Leinwand();
        add(m_malflaeche);

        // Panel-Container für Schaltflächen anlegen
        JPanel panel = new JPanel();
        // Gitter mit 2 Zeilen, 1 Spalte
        panel.setLayout(new GridLayout(2,1,20,20));

        // Schaltflächen anlegen und in Panel aufnehmen
        JButton f1 = new JButton("tan(x)");
        JButton f2 = new JButton("x³");
        panel.add(f1);
        panel.add(f2);

        add(panel);


        // ActionListener für die Schaltflächen
        class MeinAktionsLauscher implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String  label;

                label = actionEvent.getActionCommand();

                if (label.equals("tan(x)"))
                    aktFunktion = 1;
                else
                    aktFunktion = 2;

                // Neuzeichnen veranlassen
                m_malflaeche.repaint();
            }
        }

        // Die Lausch-Objekte anlegen
        f1.addActionListener(new MeinAktionsLauscher());
        f2.addActionListener(new MeinAktionsLauscher());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    class Leinwand extends JPanel {
        // Konstruktor
        Leinwand() {
            setBackground(Color.black);
            // Vordergrund (=Zeichenfarbe) auf Blau setzen
            setForeground(Color.blue);
        }
        // Die wichtigste Methode: hier wird gezeichnet!
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            double x,y;
            int xpos,ypos;

            // Ursprung umsetzen
            g.translate(150,150);

            //Koordinatenachsen einzeichnen
            g.setColor(Color.red);
            g.drawLine(0,-150,0,150);
            g.drawLine(-150,0,150,0);
            g.drawString("-3",-150,12);
            g.drawString("-3",4,147);
            g.drawString("+3", 135,12);
            g.drawString("+3",4,-140);

            // Farbe zum Zeichnen der Funktion
            g.setColor(new Color(255,255,0));

            // Wenn keine Funktion ausgewählt ist, nichts tun
            if (aktFunktion == 0)
                return;

            for (x = -3.0; x<=3; x += 0.005) {
                if (aktFunktion == 1)
                    y = Math.tan(x);
                else
                    y = Math.pow(x,3);

                xpos = (int)  (x*50);
                ypos = (int) (-y*50);

                g.fillOval(xpos,ypos,3,3);
            }
        }

        // Diese Methode liefert die minimale Größer der anvas
        public Dimension getMinimumSize() {
            return new Dimension(300,300);
        }
        // Die Lieblingsgröße setzen wir auf die Minimalgröße
        public Dimension getPreferredSize() {
            return getMinimumSize();
        }
    }
}
