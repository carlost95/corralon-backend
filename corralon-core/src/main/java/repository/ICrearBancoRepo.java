package repository;

import model.Banco;

public interface ICrearBancoRepo {

    Banco save(Banco banco);

    Banco findByNombre(String nombreBanco);

}
