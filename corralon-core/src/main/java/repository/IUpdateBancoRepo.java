package repository;

import model.Banco;

public interface IUpdateBancoRepo {

    Banco findById(Integer id);

    Banco update(Banco banco);

    Banco findBancoByName(String nombre);
}
