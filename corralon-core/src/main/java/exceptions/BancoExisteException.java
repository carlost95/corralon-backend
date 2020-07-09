package exceptions;

public class BancoExisteException extends Exception{
    public BancoExisteException() {
    }

    public BancoExisteException(String msg) {
        super(msg);
    }
}
