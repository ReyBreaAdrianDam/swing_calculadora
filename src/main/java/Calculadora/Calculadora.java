package Calculadora;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame{
    private String numCalc = "0";
    private double numGuardado = 0;
    private final static String[] TECLAS = {
            "Del","CE","C","/",
            "7","8","9","*",
            "4","5","6","-",
            "1","2","3","+",
            ".","0","%","="
    };
    private Operacion estado;
    private final JPanel PANEL_PRINCIPAL = new JPanel(new BorderLayout());
    private final JPanel PANEL_TEXTO = new JPanel(new BorderLayout());
    private final JPanel PANEL_BOTON = new JPanel(new GridLayout(TECLAS.length / 4,4));
    private final JLabel TEXTO;
    public Calculadora() {
        this.add(PANEL_PRINCIPAL);
        PANEL_PRINCIPAL.add(PANEL_TEXTO, BorderLayout.NORTH);
        PANEL_PRINCIPAL.add(PANEL_BOTON, BorderLayout.CENTER);
        TEXTO = new JLabel(numCalc, SwingConstants.RIGHT);
        TEXTO.setFont(new Font("SansSerif",Font.BOLD,40));
        PANEL_TEXTO.add(TEXTO);
        generarBotones(TECLAS);
    }
    /**
     * Este metodo genera los botones de la calculadora
     */
    public void generarBotones(String... tecla){
        for(String x : tecla) {
            JButton boton = new JButton(x);
            boton.setFont(new Font("SansSerif",Font.PLAIN,20));
            PANEL_BOTON.add(boton);
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        switch (boton.getText()) {
                            case "+":
                                if (!numCalc.equals("-0")) {
                                    estado = Operacion.SUMA;
                                    numGuardado = Double.parseDouble(numCalc);
                                }
                                numCalc = "0";
                                break;
                            case "-":
                                if (!numCalc.equals("0")) {
                                    estado = Operacion.RESTA;
                                    numGuardado = Double.parseDouble(numCalc);
                                    numCalc = "0";
                                } else
                                    numCalc = "-0";
                                break;
                            case "*":
                                estado = Operacion.MULTIPLICACION;
                                numGuardado = Double.parseDouble(numCalc);
                                numCalc = "0";
                                break;
                            case "/":
                                estado = Operacion.DIVISION;
                                numGuardado = Double.parseDouble(numCalc);
                                numCalc = "0";
                                break;
                            case "=":
                                //Estado de la operación
                                switch (estado) {
                                    case SUMA:
                                        numCalc = String.valueOf(numGuardado + Double.parseDouble(numCalc));
                                        estado = null;
                                        break;
                                    case RESTA:
                                        numCalc = String.valueOf(numGuardado - Double.parseDouble(numCalc));
                                        estado = null;
                                        break;
                                    case MULTIPLICACION:
                                        numCalc = String.valueOf(numGuardado * Double.parseDouble(numCalc));
                                        estado = null;
                                        break;
                                    case DIVISION:
                                        numCalc = String.valueOf(numGuardado / Double.parseDouble(numCalc));
                                        estado = null;
                                        break;
                                }
                                break;
                            case "%":
                                switch (estado) {
                                    case SUMA:
                                        numCalc = String.valueOf((numGuardado + Double.parseDouble(numCalc)) / 100);
                                        estado = null;
                                        break;
                                    case RESTA:
                                        numCalc = String.valueOf((numGuardado - Double.parseDouble(numCalc)) / 100);
                                        estado = null;
                                        break;
                                    case MULTIPLICACION:
                                        numCalc = String.valueOf((numGuardado * Double.parseDouble(numCalc)) / 100);
                                        estado = null;
                                        break;
                                    case DIVISION:
                                        numCalc = String.valueOf((numGuardado / Double.parseDouble(numCalc)) / 100);
                                        estado = null;
                                        break;
                                }
                                break;
                            case "C":
                                estado = null;
                                numCalc = "0";
                                numGuardado = 0;
                                break;
                            case "CE":
                                numCalc = "0";
                                break;
                            case "Del":
                                if (!numCalc.equals(""))
                                    numCalc = numCalc.substring(0, numCalc.length() - 1);
                                if (numCalc.equals(""))
                                    numCalc = "0";
                                break;
                            case ".":
                                numCalc += boton.getText();
                                break;
                            default:
                                if (numCalc.equals("0"))
                                    numCalc = boton.getText();
                                else if (numCalc.equals("-0"))
                                    numCalc = "-" + boton.getText();
                                else
                                    numCalc += boton.getText();
                                break;
                        }
                        TEXTO.setText(numCalc);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Pero seras tonto", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }
    }

    }
