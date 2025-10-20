package at.itkolleg.andere.ChainOfResponsibility1;

/**
 * Abstrakter Handler
 */
abstract public class SupportHandler {
    protected SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(int difficulty);
}
