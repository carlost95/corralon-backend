package exceptions;

public class BancoNoExisteException extends Exception{
    public BancoNoExisteException(String msg) {
        super(msg);
    }
}
