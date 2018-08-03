package io.carolynn.tipCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipCalculatorPanel extends JPanel {

    private JButton display;
    private JPanel panel;
    private String previousCommand;
    private Double total;
    private boolean start;

    public TipCalculatorPanel(){
        setVisible(true);
        setSize(450,250);
        setLayout(new BorderLayout());
        this.total = 0.0;
        this.start = true;
        this.previousCommand = "total";

        display = new JButton("0");
        display.setEnabled(false);
        add(display,BorderLayout.NORTH);
        ActionListener numbers = new NumberListener();
        ActionListener commands = new CommandListener();

        this.panel = new JPanel();
        panel.setLayout(new GridLayout(3,5));
        addButton("1",numbers);
        addButton("2",numbers);
        addButton("3",numbers);
        addButton("4", numbers);
        addButton("5", numbers);
        addButton("6", numbers);
        addButton("7", numbers);
        addButton("8", numbers);
        addButton("9", numbers);
        addButton("0", numbers);
        addButton("tip", commands);
        addButton("total", commands);

        add(panel,BorderLayout.CENTER);
    }

    private void addButton(String text, ActionListener listener){
        JButton button = new JButton(text);
        button.addActionListener(listener);
        panel.add(button);
    }

    private class NumberListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String input = e.getActionCommand();
            if(start){
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }

    private class CommandListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            String command = e.getActionCommand();
            TipCalculator calculator = new TipCalculator(total);

            double tip = Double.parseDouble(display.getText());
            total = calculator.calculate(previousCommand, tip);

            previousCommand = command;
            display.setText("" + total);
            start = true;
        }
    }


}
