package io.carolynn.tipCalculator;

public class TipCalculator {

    double subtotal;

    public TipCalculator(double subtotal){
        this.subtotal = subtotal;
    }

    public double calculate(String command, double tips){
        double total = 0.0;
        if(command.equals("tip")){ total = calculateTip(subtotal,tips);
        } else { total = tips;}
        return total;
    }

    private double calculateTip(double sub, double tip){
        return (sub + (sub*(tip/100)));
    }

}
