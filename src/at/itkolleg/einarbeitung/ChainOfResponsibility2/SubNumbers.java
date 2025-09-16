package at.itkolleg.einarbeitung.ChainOfResponsibility2;

public class SubNumbers implements Chain {
    private Chain nextInChain;

    @Override
    public void setNext(Chain next) {
        this.nextInChain = next;
    }

    @Override
    public void calculate(Numbers request) {
        if(request.getCalculationWanted().equals("sub")) {
            System.out.println(request.getNumber1() + " - " + request.getNumber2() + " = "
                    + (request.getNumber1() - request.getNumber2()));
        } else {
            nextInChain.calculate(request);
        }

    }
}
