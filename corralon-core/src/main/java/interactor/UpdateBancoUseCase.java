package interactor;

import exceptions.BancoExisteException;
import exceptions.BancoNoExisteException;
import input.IUpdateBancoInput;
import model.Banco;
import repository.IUpdateBancoRepo;

import java.util.logging.Logger;

public class UpdateBancoUseCase implements IUpdateBancoInput {


    private static final Logger LOGGER = Logger.getLogger(UpdateBancoUseCase.class.getName());

    private IUpdateBancoRepo iUpdateBancoRepo;

    public UpdateBancoUseCase(IUpdateBancoRepo iUpdateBancoRepo) {
        this.iUpdateBancoRepo = iUpdateBancoRepo;
    }

    public Banco update(Banco updated) throws BancoNoExisteException, BancoExisteException {
        LOGGER.info("UpdateBancoUseCase");

        Banco toUpdate = getById(updated);

        if ( toUpdate == null ) {
            throw new BancoNoExisteException("UpdateBancoUseCase: el banco no existe");
        }

        if (isExitentBank(updated)){
            throw new BancoExisteException("UpdateBancoUseCase: el banco existe");
        }
        updateData(updated, toUpdate);
        return this.iUpdateBancoRepo.update(toUpdate);
    }

    private Boolean isExitentBank(Banco updated) {
        LOGGER.info("isExitentBank");
        return iUpdateBancoRepo.findBancoByName(updated.getNombre()) != null;
    }

    private void updateData(Banco updated, Banco toUpdate) {
        LOGGER.info("updateData");
        toUpdate.setId(updated.getId());
        toUpdate.setNombre(updated.getNombre());
        toUpdate.setAbreviatura(updated.getAbreviatura());
        toUpdate.setHabilitado(updated.getHabilitado());
    }

    private Banco getById(Banco updated) {
        LOGGER.info("getById");
        return this.iUpdateBancoRepo.findById(updated.getId());
    }

}
