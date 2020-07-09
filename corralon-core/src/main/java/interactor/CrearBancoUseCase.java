package interactor;

import exceptions.BancoExisteException;
import input.ICrearBancoInput;
import model.Banco;
import repository.ICrearBancoRepo;

public class CrearBancoUseCase implements ICrearBancoInput {

    private ICrearBancoRepo crearBancoRepo;

    public CrearBancoUseCase(ICrearBancoRepo crearBancoRepo) {
        this.crearBancoRepo = crearBancoRepo;
    }

    public boolean crearBanco(Banco banco) throws BancoExisteException {
        banco.setHabilitado(true);
        if (existeBanco(banco.getNombre())){
            throw  new BancoExisteException();
        }
        return this.crearBancoRepo.save(banco);
    }

    private boolean existeBanco(String nombreBanco){
        return  this.crearBancoRepo.findByNombre(nombreBanco) != null;
    }


}
