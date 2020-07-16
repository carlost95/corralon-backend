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

    public Banco crearBanco(Banco banco) throws BancoExisteException {
        if (existeBanco(banco.getNombre())){
            throw  new BancoExisteException("Core - BancoExisteException: El banco existe");
        }
        banco.setHabilitado(true);
        return this.crearBancoRepo.save(banco);
    }

    private boolean existeBanco(String nombreBanco){
        return  this.crearBancoRepo.findByNombre(nombreBanco) != null;
    }


}
