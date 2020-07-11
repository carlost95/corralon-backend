package input;

import exceptions.BancoNoExisteException;
import model.Banco;

public interface IFindByIdBancoInput {
    Banco findById(Integer id) throws BancoNoExisteException;
}
