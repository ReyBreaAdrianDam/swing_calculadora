import com.formdev.flatlaf.intellijthemes.*;
import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatArcOrangeIJTheme());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        Calculadora ventanaPrincipal = new Calculadora();
        ventanaPrincipal.setTitle("Calculadora");
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(300, 400);
        ventanaPrincipal.setVisible(true);
    }
}