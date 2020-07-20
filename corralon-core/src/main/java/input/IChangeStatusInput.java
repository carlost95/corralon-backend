package input;

import exceptions.BancoNoExisteException;
import model.Banco;

public interface IChangeStatusInput {
    Banco changeStatus(Banco banco) throws BancoNoExisteException;
}
