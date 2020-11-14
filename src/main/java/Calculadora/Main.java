package Calculadora;
import javax.swing.*;

import Calculadora.Calculadora;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.*;
public class Main{
    private static Calculadora ventanaPrincipal;
    public static void main(String[] args) {
        try{
            establecerColor(Integer.parseInt(args[1]));
        }
        catch(Exception ex) {
            establecerColor(1);
        }
        ventanaPrincipal = new Calculadora();
        ventanaPrincipal.setUndecorated(true);
        ventanaPrincipal.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        ventanaPrincipal.setTitle("Calculadora");
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(300, 400);
        ventanaPrincipal.setVisible(true);
    }
    public static void establecerColor(int i){
        try {
            switch(i) {
                case 1:
                    UIManager.setLookAndFeel(new FlatDarculaLaf());
                    break;
                case 2:
                    UIManager.setLookAndFeel(new FlatIntelliJLaf());
                    break;
                case 3:
                    UIManager.setLookAndFeel(new FlatGradiantoDarkFuchsiaIJTheme());
                    break;
            }
        } catch( Exception ex ) {
            JOptionPane.showMessageDialog(null,
                    "No se ha detectado FlatLaf, instalatelo añadiendo la siguentes lineas a build.gradle:\n" +
                            "implementation 'com.formdev:flatlaf:0.43'\n" +
                            "implementation 'com.formdev:flatlaf-intellij-themes:0.43' ",
                    "Tema no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }

}