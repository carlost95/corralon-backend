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
        Banco toUpdate = getById(updated);

        if ( toUpdate == null ) {
            throw new BancoNoExisteException("No se encontro el updated");
        }
        updateData(updated, toUpdate);
        return this.iUpdateBancoRepo.update(toUpdate);
    }

    private void updateData(Banco updated, Banco toUpdate) {
        toUpdate.setId(updated.getId());
        toUpdate.setNombre(updated.getNombre());
        toUpdate.setAbreviatura(updated.getAbreviatura());
        toUpdate.setHabilitado(updated.getHabilitado());
    }

    private Banco getById(Banco updated) {
        return this.iUpdateBancoRepo.findById(updated.getId());
    }

}
