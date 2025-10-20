package at.itkolleg.andere.ChainOfResponsibility2;

public class DivideNumbers implements Chain {
    private Chain nextInChain;

    @Override
    public void setNext(Chain next) {
        this.nextInChain = next;
    }

    @Override
    public void calculate(Numbers request) {
        if(request.getCalculationWanted().equals("div")) {
            System.out.println(request.getNumber1() + " / " + request.getNumber2() + " = "
                    + ((double)request.getNumber1() / request.getNumber2()));
        } else {
            System.out.println("Only works for add, sub, mult and div.");
        }
    }
}
