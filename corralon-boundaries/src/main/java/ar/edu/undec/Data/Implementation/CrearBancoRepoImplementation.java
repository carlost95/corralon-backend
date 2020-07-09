package ar.edu.undec.Data.Implementation;

import ar.edu.undec.Data.EntityMapper.BancoEntityMapper;
import ar.edu.undec.Data.ModelEntity.BancoEntity;
import ar.edu.undec.Data.Repository.IBuscarBancoPorNombreCRUD;
import ar.edu.undec.Data.Repository.ICrearBancoCRUD;
import model.Banco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ICrearBancoRepo;

@Service
public class CrearBancoRepoImplementation implements ICrearBancoRepo {

    @Autowired
    ICrearBancoCRUD iCrearBancoData;
    @Autowired
    IBuscarBancoPorNombreCRUD iBuscarBancoPorNombreCRUD;

    @Override
    public Boolean save(Banco banco) {
        BancoEntity bancoEntity = new BancoEntityMapper().mapeoCoreData(banco);
        return iCrearBancoData.save(bancoEntity) != null;
    }

    @Override
    public Banco findByNombre(String nombreBanco) {
        BancoEntity bancoEntity = iBuscarBancoPorNombreCRUD.findByNombre(nombreBanco);
        Banco banco = new BancoEntityMapper().mapeoDataCore(bancoEntity);
        return banco;
    }
}
