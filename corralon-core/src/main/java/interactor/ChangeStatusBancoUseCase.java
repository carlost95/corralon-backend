package interactor;

import exceptions.BancoNoExisteException;
import input.IChangeStatusInput;
import model.Banco;
import repository.IChangeStatusRepository;

public class ChangeStatusBancoUseCase implements IChangeStatusInput {

    private IChangeStatusRepository iChangeStatusRepository;

    public ChangeStatusBancoUseCase(IChangeStatusRepository iChangeStatusRepository) {
        this.iChangeStatusRepository = iChangeStatusRepository;
    }

    public Banco changeStatus(Banco banco) throws BancoNoExisteException {

        Banco toUpdate = findBancoById(banco);

        if (existBank(toUpdate)) {
            throw new BancoNoExisteException("ChangeStatusBancoUseCase: El banco no existe");
        }

        toUpdate.setHabilitado(!toUpdate.getHabilitado());

        return iChangeStatusRepository.save(toUpdate);
    }

    private boolean existBank(Banco toUpdate) {
        return toUpdate == null;
    }

    private Banco findBancoById(Banco banco) {
        return this.iChangeStatusRepository.findBancoById(banco.getId());
    }
}
