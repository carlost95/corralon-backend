package repository;

import model.Banco;

public interface IFindBancoByIdRepo {
    Banco findById(Integer id);
}
