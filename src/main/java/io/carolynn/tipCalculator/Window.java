package io.carolynn.tipCalculator;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private JPanel tipCalculatorPanel;
    private JLabel jLabel;

    public Window(){
        setSize(425, 425);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.jLabel = new JLabel();
        jLabel.setVisible(true);
        jLabel.setBackground(Color.WHITE);

        this.tipCalculatorPanel = new TipCalculatorPanel();
        tipCalculatorPanel.setBounds(25,25, 350, 350);

        Container container = getContentPane();
        container.add(jLabel);
        container.add(tipCalculatorPanel);
        container.setVisible(true);
        jLabel.setVisible(true);
        tipCalculatorPanel.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            Window window = new Window();
            window.setTitle("Tip Calculator");
            window.setBackground(Color.WHITE);
        });
    }
}
