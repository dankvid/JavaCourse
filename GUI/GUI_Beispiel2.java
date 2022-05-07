// Das erste GUI-Programm mit Ereignisbehandlung
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Beispiel2 extends JFrame {
    // Die eigenen Adapter- und Listener-Klassen als 
    // innere Klassen innerhalb der Klasse 
    // GUI_Beispiel2 definieren
    class MeinWindowLauscher extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            // Das Programm beendet
            System.exit(0);
        }
    }
    
    class MeinActionLauscher implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // einmal piepen
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }
    
    // Der Konstruktor legt drei Schaltflächen an
    GUI_Beispiel2(String titel) {
        super(titel);
        
        // Schaltflächen erzeugen
        JButton hänsel = new JButton("Hänsel");
        JButton und = new JButton("und");
        JButton gretel = new JButton("Gretel");
        
        // Einen Layout-Manager hinzufügen
        setLayout(new FlowLayout());
        
        // Schaltflächen zum Frame hinzufügen
        add(hänsel);
        add(und);
        add(gretel);
        
        // Den Frame bei einem WindowListener anmelden
        addWindowListener(new MeinWindowLauscher());
        
        // ActionListener für die Schaltflächen registrieren
        // Es wird jedes mal eine neue Instanz angelegt.
        // Man kann aber auch eine Instanz mehrfach verwenden
        hänsel.addActionListener(new MeinActionLauscher());
        und.addActionListener(new MeinActionLauscher());
        gretel.addActionListener(new MeinActionLauscher());
    }
    
    public static void main(String[] args) {
        // Eine Instanz der Klasse anlegen und anzeigen
        GUI_Beispiel2 fenster = new GUI_Beispiel2("GUI mit Ereignisbehandlung");
        fenster.pack();
        fenster.setVisible(true);
    }
}
