package interactor;

import exceptions.BancoNoExisteException;
import input.IUpdateBancoInput;
import model.Banco;
import repository.IUpdateBancoRepo;

public class UpdateBancoUseCase implements IUpdateBancoInput {

    private IUpdateBancoRepo iUpdateBancoRepo;

    public UpdateBancoUseCase(IUpdateBancoRepo iUpdateBancoRepo) {
        this.iUpdateBancoRepo = iUpdateBancoRepo;
    }

    public Banco update(Banco updated) throws BancoNoExisteException {

        if ( noExisteBanco(updated)) {
            throw new BancoNoExisteException("No se encontro el updated");
        }
        return this.iUpdateBancoRepo.update(updated);
    }

    private boolean noExisteBanco(Banco toUpdate){
        return this.iUpdateBancoRepo.findById(toUpdate.getId()) == null;
    }
}
