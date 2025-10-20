package at.itkolleg.andere.ChainOfResponsibility2;

public class TestCalcChain {
    public static void main(String[] args) {
        Chain chainCalc1 = new AddNumbers();
        Chain chainCalc2 = new SubNumbers();
        Chain chainCalc3 = new MultNumbers();
        Chain chainCalc4 = new DivideNumbers();

        chainCalc1.setNext(chainCalc2);
        chainCalc2.setNext(chainCalc3);
        chainCalc3.setNext(chainCalc4);

        Numbers request = new Numbers(4, 2, "add");
        chainCalc1.calculate(request);

        request = new Numbers(4, 2, "sub");
        chainCalc1.calculate(request);

        request = new Numbers(4, 2, "mult");
        chainCalc1.calculate(request);

        request = new Numbers(7, 2, "div");
        chainCalc1.calculate(request);

        request = new Numbers(7, 2, "integrate");
        chainCalc1.calculate(request);

    }
}
