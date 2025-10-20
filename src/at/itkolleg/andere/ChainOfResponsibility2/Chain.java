package at.itkolleg.andere.ChainOfResponsibility2;

public interface Chain {

    void setNext(Chain next);

    void calculate(Numbers request);

}
