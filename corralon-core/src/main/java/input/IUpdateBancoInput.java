package input;

import exceptions.BancoExisteException;
import exceptions.BancoNoExisteException;
import model.Banco;

public interface IUpdateBancoInput {
    Banco update(Banco updated) throws BancoNoExisteException, BancoExisteException;
}
