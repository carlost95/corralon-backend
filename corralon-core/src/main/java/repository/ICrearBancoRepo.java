package repository;

import model.Banco;

public interface ICrearBancoRepo {

    Boolean save(Banco banco);

    Banco findByNombre(String nombreBanco);

}
