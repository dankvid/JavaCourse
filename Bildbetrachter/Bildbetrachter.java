import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bildbetrachter extends JFrame {
    static Bildbetrachter m_fenster;
    String m_dateiname;                       // Name der Datei
    Image m_aktBild;                          // Referenz auf das aktuelle Bild
    BildLeinwand m_bildanzeige;               // JPanel zum Anzeigen des Bildes
    int m_Xpos, m_Ypos;                       // neue Position, an der die
                                              // linke obere Ecke des Bildes
                                              // angezeigt wird
    int m_bild_x1, m_bild_y1;                 // die aktuelle Begrenzung des
    int m_bild_x2, m_bild_y2;                 // Bildes
    int m_bildHoehe, m_bildBreite;            // Höhe und Breite in Pixeln

    // Ereignisbehandlung
    class MeinAktionsLauscher implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String Label;

            Label = e.getActionCommand();

            if (Label.equals("Programm beenden"))
                System.exit(0);

            if (Label.equals("Bild laden"))
                bildLaden();
        }
    }

    // Im Konstruktor wird ein Panel (als Zeichenfläche)
    // und eine Menüleiste angelegt
    Bildbetrachter(String titel) {
        super(titel);

        m_Xpos = m_Ypos = 0; // Startposition : links oben
        m_bild_x1 = m_bild_x2 = m_bild_y1 = m_bild_y2 = 0;

        // Zu Beginn kein Bild geladen
        m_dateiname = null;
        m_aktBild = null;

        // einen Layout-Manager anlegen
        setLayout(new FlowLayout());

        // Eine Leinwand anlegen (von JPanel abgeleitet)
        m_bildanzeige = new BildLeinwand();
        add(m_bildanzeige);

        // Das Fenster mit einer Menüleiste versehen
        JMenuBar menueleiste = new JMenuBar();
        setJMenuBar(menueleiste);

        // Die PopupMenüs der Menüleiste erstellen
        JMenu menu1 = new JMenu("Datei");
        JMenuItem item1 = new JMenuItem("Bild laden");
        item1.addActionListener(new MeinAktionsLauscher());

        JMenuItem item2 = new JMenuItem("Programm beenden");
        item2.addActionListener(new MeinAktionsLauscher());
        menu1.add(item1);
        menu1.add(item2);
        menueleiste.add(menu1);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // Eine Bilddatei laden

    public void bildLaden() {
        JFileChooser dlg = new JFileChooser(".");
        int dialogRueckgabe = dlg.showOpenDialog(this);

        if (dialogRueckgabe == JFileChooser.APPROVE_OPTION) {
            // Benutzer hat den Dialog mit OK verlassen
            // -> Eingabe auswerten
            m_dateiname = dlg.getSelectedFile().getName();

            // Bild laden
            ImageIcon tmp = new ImageIcon(m_dateiname);
            m_aktBild = tmp.getImage();

            // Die Begrenzungskoordinaten des Bildes ermitteln
            m_bildBreite = m_aktBild.getWidth(m_bildanzeige);
            m_bildHoehe = m_aktBild.getHeight(m_bildanzeige);

            m_bild_x1 = m_Xpos;
            m_bild_y1 = m_Ypos;
            m_bild_x2 = m_bild_x1 + m_bildBreite;
            m_bild_y2 =m_bild_y1 + m_bildHoehe;

            m_bildanzeige.repaint();
        }
    }

    public static void main(String[] args) {
        m_fenster = new Bildbetrachter("JimageViewer");
        m_fenster.setSize(800,700);
        m_fenster.pack();
        m_fenster.setVisible(true);
    }

    // Diese Klasse dient zum Anzeigen und Manipulieren des Bildes
    class BildLeinwand extends JPanel {
        // Panel neu zeichnen
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Falls ein Bild geladen ist, das Bild anzeigen
            if (m_aktBild != null)
                g.drawImage(m_aktBild,m_Xpos,m_Ypos,this);
        }

        public Dimension getMinimumSize() {
            return m_fenster.getSize();
        }
        public Dimension getPreferredSize() {
            return getMinimumSize();
        }
    }
}
