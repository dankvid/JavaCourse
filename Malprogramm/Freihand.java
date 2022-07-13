import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Freihand extends JFrame {
    ButtonGroup m_formauswahl; // aktuelle Form

    Leinwand m_malfläche; // Hier wird gezeichnet

    int m_Xpos, m_Ypos; // aktuelle Mausposition

    public static void main(String[] args) {
        Freihand fenster = new Freihand("Malprogramm mit Freihand");
        fenster.pack();
        fenster.setSize(450,450);
        fenster.setResizable(false);
        fenster.setVisible(true);
    }

    Freihand(String titel) {
        super(titel);

        setLayout(new FlowLayout());

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Malfläche hinzufügen
        m_malfläche = new Leinwand();
        add(m_malfläche);

        // Panel-Container für Schaltflächen anlegen
        JPanel panel = new JPanel();
        // Gitter mit 4 Zeilen, 1 Spalte
        panel.setLayout(new GridLayout(4,1,20,20));

        // Optionsfelder zur Auswahl der Formen
        m_formauswahl = new ButtonGroup();

        // 1. Optionsfelder erzeugen
        JRadioButton opt1 = new JRadioButton("Kreis", false);
        JRadioButton opt2 = new JRadioButton("Scheibe", false);
        JRadioButton opt3 = new JRadioButton("Rechteck", false);
        JRadioButton opt4 = new JRadioButton("Freihand", false);

        // 2. Befehlsnamen für Optionsfelder
        opt1.setActionCommand("Kreis");
        opt2.setActionCommand("Scheibe");
        opt3.setActionCommand("Rechteck");
        opt4.setActionCommand("Freihand");

        // 3. Optionsfelder in ButtonGroup aufnehmen
        m_formauswahl.add(opt1);
        m_formauswahl.add(opt2);
        m_formauswahl.add(opt3);
        m_formauswahl.add(opt4);

        // 4. Optionsfelder in Panel aufnehmen
        panel.add(opt1);
        panel.add(opt2);
        panel.add(opt3);
        panel.add(opt4);

        add(panel);
    }
    class Leinwand extends JPanel {
        class MeinMausAdapter extends MouseAdapter {
            @Override
            public void mousePressed(MouseEvent e) {
                // Die aktuelle position der Maus merken
                m_Xpos = e.getX();
                m_Ypos = e.getY();

                // Malfläche aktualisieren
                repaint();
            }
        }

        Leinwand() {
            addMouseListener(new MeinMausAdapter());
            addMouseMotionListener(new MeinMausMotionAdapter());

            setBackground(Color.black);
            setForeground(Color.orange);
        }



        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            String label;
            ButtonModel aktuell = null;

            // Welche Form ist gerade ausgewählt?
            aktuell = m_formauswahl.getSelection();

            // entsprechend handeln
            if(aktuell == null)
                return;

            int w = (int) (Math.random()*300);
            int h = (int) (Math.random()*300);
            label = aktuell.getActionCommand();

            if (label.equals("Kreis"))
                g.drawOval(m_Xpos, m_Ypos,w,w);

            if (label.equals("Scheibe"))
                g.fillOval(m_Xpos,m_Ypos,w,h);

            if (label.equals("Rechteck"))
                g.drawRect(m_Xpos,m_Ypos,w,h);
        }
        class MeinMausMotionAdapter extends MouseMotionAdapter {
            @Override
            public void mouseDragged(MouseEvent e) {
                ButtonModel aktuell;
                String label;

                // Herausfinden, welche Box gerade aktiviert ist
                aktuell = m_formauswahl.getSelection();

                // Da nach dem Programmstart keine Box aktiviert ist,
                // muss dies getestet werden. Dann wird kein Objekt zurückgegeben,
                // sondern ein null-Wert

                if (aktuell == null)
                    return;

                label = aktuell.getActionCommand();

                // Nur wenn die Freihandfunktion ausgewählt ist, die
                // Mausposition merken und neuzeichen
                if (label.equals("Freihand")) {
                    Graphics tmp = m_malfläche.getGraphics();
                    m_Xpos = e.getX();
                    m_Ypos = e.getY();
                    tmp.setColor(Color.orange);
                    tmp.drawOval(m_Xpos, m_Ypos, 2, 2);
                    tmp.dispose();
                }
            }
        }
        public Dimension getMinimumSize() {
            return new Dimension(300,300);
        }
        // Die Lieblingsgröße setzen wir auf die Minimalgröße
        public Dimension getPreferredSize() {
            return getMinimumSize();
        }
    }
}
