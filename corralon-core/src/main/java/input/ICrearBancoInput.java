package input;

import exceptions.BancoExisteException;
import model.Banco;

public interface ICrearBancoInput {

    boolean crearBanco(Banco banco) throws BancoExisteException;

}
