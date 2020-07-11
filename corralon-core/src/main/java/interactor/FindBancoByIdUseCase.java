package interactor;

import exceptions.BancoNoExisteException;
import input.IFindByIdBancoInput;
import model.Banco;
import repository.IFindBancoByIdRepo;

public class FindBancoByIdUseCase implements IFindByIdBancoInput {
    private IFindBancoByIdRepo findBancoByIdRepo;

    public FindBancoByIdUseCase(IFindBancoByIdRepo findBancoByIdRepo) {
        this.findBancoByIdRepo = findBancoByIdRepo;

    }

    public Banco findById(Integer id) throws BancoNoExisteException {
        Banco finded = this.findBancoByIdRepo.findById(id);
        if ( finded == null){
            throw new BancoNoExisteException("Error al buscar banco. No existe");
        }
        return finded;
    }

}
