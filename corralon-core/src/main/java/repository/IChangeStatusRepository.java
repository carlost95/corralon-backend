package repository;

import model.Banco;

public interface IChangeStatusRepository {
    Banco save(Banco banco);

    Banco findBancoById(Integer id);
}
