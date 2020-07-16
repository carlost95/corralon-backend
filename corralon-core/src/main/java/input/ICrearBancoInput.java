package input;

import exceptions.BancoExisteException;
import model.Banco;

public interface ICrearBancoInput {

    Banco crearBanco(Banco banco) throws BancoExisteException;

}
